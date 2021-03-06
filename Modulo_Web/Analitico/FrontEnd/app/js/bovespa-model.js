/*
 * DATA MODEL - BOVESPA
 * 1° NÃO PERMITIR ACESSO DIRETO AO JSON
 * 2° BUSCAR JSON
 * 3° TRATAR JSON  /* ALTERAR OS CAMPOS PRINCIPAIS DO JSON, O ADAPTANDO AO BOVESPA
 */
/* global bovespa */

bovespa.object.extend(bovespa, {
    model: {
        load: function (callback, scope, token) {
           scope.on();

            this._init(function () {
                scope.off();
                callback.call(scope, bovespa.model._data_._load, bovespa.model._data_._success);
            }, token);
        },
        _init: function (callback, token) {

            this._data_ = bovespa.object.create({
                _load: false,
                _base_: null
            });

            this._data_._company_ = bovespa.memory({/* DATA-MODEL DA LISTA DE EMPRESAS  */
                proxy: {
                    url: bovespa.config.stores.company + token,
                    root: 'data.modeloEmpresa'
                }
            });

            if (bovespa.storage.exists('empresa_ID')) {
                var _scope = this;
                this._data_._load = true;
                this._data_._success = false;

                this._data_._base_ = bovespa.memory({
                    proxy: {
                        url: bovespa.config.stores.indicators + bovespa.storage.get('empresa_ID') + '/' + token,
                        root: 'data.modeloIndmpresa'
                    }
                });



                this._init_data(function (data) {
                    _scope._data_._base_.loadData(data);
                    _scope._data_._base_.each(function () { /* INSTANCIANDO O MODEL DE CADA INDICADOR */

                        _scope._data_._success = true;

                        _scope._data_._indebtedness_ = bovespa.memory({
                            model: {
                                fields: [{
                                        name: 'pct'
                                    }, {
                                        name: 'ce'
                                    }, {
                                        name: 'ipl'
                                    }]
                            },
                            data: this.get('indebtedness')
                        });

                        _scope._data_._liquidity_ = bovespa.memory({
                            model: {
                                fields: [{
                                        name: 'pct'
                                    }, {
                                        name: 'ce'
                                    }, {
                                        name: 'ipl'
                                    }]
                            },
                            data: this.get('liquidity')
                        });

                        _scope._data_._profitability_ = bovespa.memory({
                            model: {
                                fields: [{
                                        name: 'pct'
                                    }, {
                                        name: 'ce'
                                    }, {
                                        name: 'ipl'
                                    }]
                            },
                            data: this.get('profitability')
                        });

                        _scope._data_._midterm_ = bovespa.memory({
                            model: {
                                fields: [{
                                        name: 'pct'
                                    }, {
                                        name: 'ce'
                                    }, {
                                        name: 'ipl'
                                    }]
                            },
                            data: this.get('midterm')
                        });
                    });

                    callback.call(_scope);
                });
            } else {
                this._data_._load = false;
                callback.call(this);
            }
        },
        _init_data: function (callback) {
            var scope = this;
            this._data_._base_.load(function (data) {
                var _dt = [],
                        me = this;

                me.each(function () {
                    var _dtCompany = {},
                            _change_model = function (_data, _fields) {

                                return  (function (_data_, _fields_) {
                                    var _alter = function (name) {
                                        return {
                                            'results': (function (_data) {
                                                var _results = [];
                                                _data.query(function () {
                                                    return this.get('indicador') === name;
                                                }).each(function () {

                                                    bovespa.each(this.get('lmResultado'), function (val) {
                                                        var _year = Number(val.ano),
                                                                _indicator = val.valor;
                                                        _results.push({
                                                            year: Number(_year),
                                                            indicator: _indicator == '' || _indicator == 0 ? Number(0.0000001) : Number(_indicator)
                                                        });
                                                    });
                                                });
                                                return _results;
                                            })(_data_)
                                        };
                                    };

                                    return (function () {
                                        var _dF = {};

                                        bovespa.each(_fields_, function (val) {
                                            _dF[val] = _alter(val);
                                        });

                                        return _dF;
                                    })();

                                })(_data, _fields);
                            },
                            _tData = bovespa.memory({
                                data: null
                            }),
                            me = this;



                    _tData.data = [];
                    _tData.loadData(me.get('lmGrupo'));
                    _dtCompany['company-id'] = me.get('empresa_ID');

                    _tData.each(function () {
                        var _grupo = this.get('grupo'),
                                _data = bovespa.memory({
                                    data: null
                                });

                        _data.data = [];
                        _data.loadData(this.get('lmIndicador'));

                        if (_grupo === "endividamento") {
                            _dtCompany['indebtedness'] = _change_model(_data, ['ce', 'ipl', 'pct']);
                        } else if (_grupo === "liquidez") {
                            _dtCompany['liquidity'] = _change_model(_data, ['lg', 'ilc', 'ils', 'ccl']);
                        } else if (_grupo === "rentabilidade") {
                            _dtCompany['profitability'] = _change_model(_data, ['ga', 'ml', 'ra', 'rpl']);
                        } else if (_grupo === "prazosmedios") {
                            _dtCompany['midterm'] = _change_model(_data, ['pme', 'pmr', 'pmp', 'co', 'cf']);
                        }

                    });


                    _dt.push(_dtCompany);
                });

                callback.call(scope, _dt);
            },
                    function (responseText) {
                        responseText = responseText.replaceAll("E", "");
                        responseText = responseText.replaceAll("impresa_ID", "iEmpresa_ID");
                        return responseText;
                    });
        },
        Company: function () {
            return this._data_._company_;
        },
        Indebtedness: function () {
            return this._data_._indebtedness_;
        },
        Liquidity: function () {
            return this._data_._liquidity_;
        },
        Profitability: function () {
            return this._data_._profitability_;
        },
        Midterm: function () {
            return this._data_._midterm_;
        }
    }
});
