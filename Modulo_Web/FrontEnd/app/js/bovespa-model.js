/*
 * DATA MODEL - BOVESPA
 * 1° NÃO PERMITIR ACESSO DIRETO AO JSON
 * 2° BUSCAR JSON
 * 3° TRATAR JSON  /* ALTERAR OS CAMPOS PRINCIPAIS DO JSON, O ADAPTANDO AO BOVESPA
 */
bovespa.object.extend(bovespa, {
    model: {
        load: function (callback, scope) {
            this._init(function () {
                callback.call(scope, bovespa.model._data_._load ,  bovespa.model._data_._success);
            });
        },
        _init: function (callback) {
            this._data_ = bovespa.object.create({
                _load: false,
                _base_: null
            });

            this._data_._company_ = bovespa.memory({  /* DATA-MODEL DA LISTA DE EMPRESAS  */
                proxy: {
                    url: 'app/json/json_Empresa.json',
                    root: ''
                }
            });

            this._data_._base_ = bovespa.memory({ /* DATA-MODEL DO JSON  PRINCIPAL */ 
                proxy: {
                    url: 'app/json/json_Bovespa.json',
                    root: ''
                }
            });

            if (bovespa.storage.exists('iEmpresa_ID')) {
                this._data_._load = true;
                this._data_._success = false;
                var _scope = this;
                this._init_data(function (data) {
                    var _dtCompany;

                    _scope._data_._base_.loadData(data);
                    _dtCompany = _scope._data_._base_.query(function () {
                        return this.get('company-id') == bovespa.storage.get('iEmpresa_ID');
                    });
                    _dtCompany.each(function () {
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
            this._data_._base_.load(function () {
                var _dt = [];

                this.each(function () {
                    var _dtCompany = {};

                    _dtCompany['company-id'] = this.get('iEmpresa_ID');
                    _dtCompany['indebtedness'] = (function (_indebtedness_, _fields) {
                        var _alter = function (name) {
                            return {
                                'results': (function (_data) {
                                    var _results = [];

                                    bovespa.each(_data[name]['resultados'], function (val) {
                                        _results.push({
                                            year: val.ano,
                                            indicator: val.indicador,
                                        });
                                    });

                                    return _results;
                                })(_indebtedness_)
                            };
                        };

                        return (function () {
                            var _dF = {};

                            bovespa.each(_fields, function (val) {
                                _dF[val] = _alter(val);
                            });

                            return _dF;
                        })();

                    })(this.get('endividamento'), ['ce', 'ipl', 'pct']);
                    _dtCompany['liquidity'] = (function (_indebtedness_, _fields) {
                        var _alter = function (name) {
                            return {
                                'results': (function (_data) {
                                    var _results = [];
                                    bovespa.each(_data[name]['resultados'], function (val) {
                                        _results.push({
                                            year: val.ano,
                                            indicator: val.indicador
                                        });
                                    });

                                    return _results;
                                })(_indebtedness_)
                            };
                        };

                        return (function () {
                            var _dF = {};

                            bovespa.each(_fields, function (val) {
                                _dF[val] = _alter(val);
                            });

                            return _dF;
                        })();

                    })(this.get('liquidez'), ['lg', 'ilc', 'ils', 'ccl']);
                    _dtCompany['profitability'] = (function (_indebtedness_, _fields) {
                        var _alter = function (name) {
                            return {
                                'results': (function (_data) {
                                    var _results = [];

                                    bovespa.each(_data[name]['resultados'], function (val) {
                                        _results.push({
                                            year: val.ano,
                                            indicator: val.indicador,
                                        });
                                    });

                                    return _results;
                                })(_indebtedness_)
                            };
                        };

                        return (function () {
                            var _dF = {};

                            bovespa.each(_fields, function (val) {
                                _dF[val] = _alter(val);
                            });

                            return _dF;
                        })();

                    })(this.get('rentabilidade'), ['ga', 'ml', 'ra', 'rpl']);
                    _dtCompany['midterm'] = (function (_indebtedness_, _fields) {
                        var _alter = function (name) {
                            return {
                                'results': (function (_data) {
                                    var _results = [];

                                    bovespa.each(_data[name]['resultados'], function (val) {
                                        _results.push({
                                            year: val.ano,
                                            indicator: val.indicador,
                                        });
                                    });

                                    return _results;
                                })(_indebtedness_)
                            };
                        };

                        return (function () {
                            var _dF = {};

                            bovespa.each(_fields, function (val) {
                                _dF[val] = _alter(val);
                            });

                            return _dF;
                        })();

                    })(this.get('prazosmedios'), ['pme', 'pmr', 'pmp', 'co', 'cf']);

                    _dt.push(_dtCompany);
                });

                callback.call(scope, _dt);
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
