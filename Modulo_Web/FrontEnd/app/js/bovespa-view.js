/*
 * VIEW - BOVESPA
 * 1° CONTROLAR A VISUALIZAÇÃO DA PAGINA
 */
bovespa.object.extend(bovespa, {
    view: {
        render: function () {
            this._init();
        },
        _init: function () {
            this._main_ = bovespa.JLib('.bovespa');
            this._init_views.call(this);
        },
        _init_views: function () {
            this._view_ = bovespa.object.create({});
            bovespa.object.extend(this._view_, {
                Company: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-company', /* NOME DO TEMPLATE */
                            view: {
                                self: '.bovespa', /* FOCO DA RENDERIZAÇÃO */
                                render: function () {
                                    if (bovespa.storage.exists('tost')) {
                                        bovespa.JLib(this.self).tost({text: 'Empresa sem detalhamento!'});
                                        bovespa.storage.removeAll();
                                    }
                                    bovespa.component({
                                        type: 'select',
                                        renderTo: '#select-company',
                                        id: 'select-company',
                                        class: ['', 's-size'],
                                        data: bovespa.model.Company(),
                                        searchSensitive: false,
                                        displayMember: 'sRazao_Social',
                                        classMember: ['', 's-size-15']
                                    });
                                    bovespa.menu([{
                                            name: 'bovespa-company-proceed',
                                            attach: bovespa.JLib('.bovespa'),
                                            action: function (e) {
                                                var dt = bovespa.component.get('select-company').selectedItem();
                                                if (dt !== null) {
                                                    bovespa.storage(dt);
                                                    bovespa.render();
                                                }
                                            }
                                        }]);
                                }
                            },
                            control: {
                                url: 'app/views/company.html' /* VIEW HTML DA RENDERIZAÇÃO */
                            }
                        }
                    ]);
                }, /* VIEW DE SELEÇÃO DE EMPRESAS */
                Home: function () {
                    return bovespa.template([{
                            'name': 'bovespa-home',
                            view: {
                                self: '.bovespa',
                                render: function () {
                                    this['inject-json']({
                                        bovespa: {
                                            'company': {
                                                name: bovespa.storage.get('sRazao_Social'),
                                                cnpj: bovespa.format(bovespa.storage.get('sCNPJ'), '00.000.000/0000-00', this)
                                            }
                                        }
                                    });
                                }
                            },
                            control: {
                                url: 'app/views/main.html',
                                "render-after": function (view) {
                                    view._mnu_ = bovespa.object.create({});

                                    view._mnu_._mnu_hidden_ = bovespa.menu([{
                                            name: 'bovespa-mun-hidden',
                                            attach: bovespa.view._main_,
                                            action: function (e) {
                                                bovespa.control._mnu_[this.name].call(this, e);
                                            }
                                        }]);

                                    view._mnu_._indebtedness_ = bovespa.menu([{
                                            name: 'bovespa-indebtedness',
                                            attach: bovespa.view._main_,
                                            navigation: 'Indebtedness',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                                bovespa.control._mnu_select(e);
                                            }
                                        }]);

                                    view._mnu_._liquidity_ = bovespa.menu([{
                                            name: 'bovespa-liquidity',
                                            attach: bovespa.view._main_,
                                            navigation: 'Liquidity',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                                bovespa.control._mnu_select(e);
                                            }
                                        }]);

                                    view._mnu_._profitability_ = bovespa.menu([{
                                            name: 'bovespa-profitability',
                                            attach: bovespa.view._main_,
                                            navigation: 'Profitability',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                                bovespa.control._mnu_select(e);
                                            }
                                        }]);

                                    view._mnu_._midterm_ = bovespa.menu([{
                                            name: 'bovespa-midterm',
                                            attach: bovespa.view._main_,
                                            navigation: 'Midterm',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                                bovespa.control._mnu_select(e);
                                            }
                                        }]);

                                    view._mnu_._exit_ = bovespa.menu([{
                                            name: 'bovespa-exit',
                                            attach: bovespa.view._main_,
                                            navigation: 'Exit',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                            }
                                        }]);
                                }
                            }
                        }]);
                }, /* VIEW DO ESQUELETO DA PAGINA  */
                Indebtedness: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-indebtedness',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {
                                    bovespa.JLib(this.self).mask(); /* HABILITA A MASK */

                                    this['inject-json']({
                                        bovespa: {
                                            'indebtedness': {
                                                pct: Number(model.pct().average()).formatMoney(2, ',', '.') + '%',
                                                ce: Number(model.ce().average()).formatMoney(2, ',', '.') + '%',
                                                ipl: Number(model.ipl().average()).formatMoney(2, ',', '.') + '%'
                                            }
                                        }
                                    });  /* LER OBJETO É SUBSTITUI NO HTML, COM NAMESPACE CORREPONDENTE DO OBJETO NO HTML */
                                    this['inject-json']({
                                        bovespa: {
                                            'indebtedness': {
                                                pct: {
                                                    analysis: model.pct().analysis()
                                                },
                                                ce: {
                                                    analysis: model.ce().analysis()
                                                },
                                                ipl: {
                                                    analysis: model.ipl().analysis()
                                                }
                                            }
                                        }
                                    }); /* LER OBJETO É SUBSTITUI NO HTML, COM NAMESPACE CORREPONDENTE DO OBJETO NO HTML */


                                    bovespa.JLib("table-pct").table({
                                        columns: [
                                            {
                                                'data-name': 'year',
                                                title: {
                                                    text: 'Ano'
                                                }
                                            },
                                            {
                                                'data-name': 'indicator',
                                                title: {
                                                    text: 'Indice'
                                                },
                                                render: function (val) {
                                                    return Number(val).formatMoney(3, ',', '.') + '%';
                                                }
                                            },
                                            {
                                                'data-name': 'indicator',
                                                title: {
                                                    text: 'Indice Médio'
                                                },
                                                render: function (val) {
                                                    return Number(val).formatMoney(3, ',', '.') + '%';
                                                }
                                            }
                                        ],
                                        model: model.pct().results()
                                    }); /* CONSTRUÇÃO DA TABLE */
                                    bovespa.JLib("card-graphic-pct").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa.config.chart.themes().Indebtedness().Pct();/* TEMA DO CHART */
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'area'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    allowDecimals: false,
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value; // clean, unformatted number for year
                                                        }
                                                    }
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + '%';
                                                        }
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:black;padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    area: {
                                                        pointStart: model.pct().year(),
                                                        marker: {
                                                            enabled: false,
                                                            symbol: 'circle',
                                                            radius: 2,
                                                            states: {
                                                                hover: {
                                                                    enabled: true
                                                                }
                                                            }
                                                        }
                                                    }
                                                },
                                                series: model.pct().results_data()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */
                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('body', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-ce").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa.config.chart.themes().Indebtedness().Ce();/* TEMA DO CHART */
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'area'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    allowDecimals: false,
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value; // clean, unformatted number for year
                                                        }
                                                    }
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + '%';
                                                        }
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:black;padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    area: {
                                                        pointStart: model.ce().year(),
                                                        marker: {
                                                            enabled: false,
                                                            symbol: 'circle',
                                                            radius: 2,
                                                            states: {
                                                                hover: {
                                                                    enabled: true
                                                                }
                                                            }
                                                        }
                                                    }
                                                },
                                                series: model.ce().results_data()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */
                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });
                                    bovespa.JLib("table-ce").table({
                                        columns: [
                                            {
                                                'data-name': 'year',
                                                title: {
                                                    text: 'Ano'
                                                }
                                            },
                                            {
                                                'data-name': 'indicator',
                                                title: {
                                                    text: 'Indice'
                                                },
                                                render: function (val) {
                                                    return Number(val).formatMoney(3, ',', '.') + '%';
                                                }
                                            },
                                            {
                                                'data-name': 'indicator',
                                                title: {
                                                    text: 'Indice Médio'
                                                },
                                                render: function (val) {
                                                    return Number(val).formatMoney(3, ',', '.') + '%';
                                                }
                                            }
                                        ],
                                        model: model.ce().results()
                                    });/* CONSTRUÇÃO DA TABLE */

                                    bovespa.JLib("card-graphic-ipl").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa.config.chart.themes().Indebtedness().Ipl();/* TEMA DO CHART */
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'bar'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    allowDecimals: false,
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value; // clean, unformatted number for year
                                                        }
                                                    }
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + '%';
                                                        }
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:black;padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    bar: {
                                                        pointStart: model.ipl().year(),
                                                        marker: {
                                                            enabled: false,
                                                            symbol: 'circle',
                                                            radius: 2,
                                                            states: {
                                                                hover: {
                                                                    enabled: true
                                                                }
                                                            }
                                                        }
                                                    }
                                                },
                                                series: model.ipl().results_data()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */
                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });
                                    bovespa.JLib("table-ipl").table({
                                        columns: [
                                            {
                                                'data-name': 'year',
                                                title: {
                                                    text: 'Ano'
                                                }
                                            },
                                            {
                                                'data-name': 'indicator',
                                                title: {
                                                    text: 'Indice'
                                                },
                                                render: function (val) {
                                                    return Number(val).formatMoney(3, ',', '.') + '%';
                                                }
                                            },
                                            {
                                                'data-name': 'indicator',
                                                title: {
                                                    text: 'Indice Médio'
                                                },
                                                render: function (val) {
                                                    return Number(val).formatMoney(3, ',', '.') + '%';
                                                }
                                            }
                                        ],
                                        model: model.ipl().results()
                                    });/* CONSTRUÇÃO DA TABLE */

                                    bovespa.menu.register([{
                                            name: 'bovespa-indebtedness-pct',
                                            attach: bovespa.JLib('.bovespa'),
                                            hidden: false,
                                            action: function (e) {
                                                var css = 'position:fixed;visibility: hidden;top:-1px;';
                                                if (this.hidden) {
                                                    this.hidden = false;
                                                    bovespa.JLib('#card-graphic-pct').attr('style', css);
                                                    bovespa.JLib('#card-table-pct').attr('style', '');
                                                } else {
                                                    this.hidden = true;
                                                    bovespa.JLib('#card-table-pct').attr('style', css);
                                                    bovespa.JLib('#card-graphic-pct').attr('style', '');
                                                }
                                            }
                                        }]); /* BOTÃO QUEN CONTROLA A VISUALIZAÇÃO DA TABLE */
                                    bovespa.menu.register([{
                                            name: 'bovespa-indebtedness-ce',
                                            attach: bovespa.JLib('.bovespa'),
                                            hidden: false,
                                            action: function (e) {
                                                var css = 'position:fixed;visibility: hidden;top:-1px;';
                                                if (this.hidden) {
                                                    this.hidden = false;
                                                    bovespa.JLib('#card-graphic-ce').attr('style', css);
                                                    bovespa.JLib('#card-table-ce').attr('style', '');
                                                } else {
                                                    this.hidden = true;
                                                    bovespa.JLib('#card-table-ce').attr('style', css);
                                                    bovespa.JLib('#card-graphic-ce').attr('style', '');
                                                }
                                            }
                                        }]); /* BOTÃO QUEN CONTROLA A VISUALIZAÇÃO DA TABLE */
                                    bovespa.menu.register([{
                                            name: 'bovespa-indebtedness-ipl',
                                            attach: bovespa.JLib('.bovespa'),
                                            hidden: false,
                                            action: function (e) {
                                                var css = 'position:fixed;visibility: hidden;top:-1px;';
                                                if (this.hidden) {
                                                    this.hidden = false;
                                                    bovespa.JLib('#card-graphic-ipl').attr('style', css);
                                                    bovespa.JLib('#card-table-ipl').attr('style', '');
                                                } else {
                                                    this.hidden = true;
                                                    bovespa.JLib('#card-table-ipl').attr('style', css);
                                                    bovespa.JLib('#card-graphic-ipl').attr('style', '');
                                                }
                                            }
                                        }]); /* BOTÃO QUEN CONTROLA A VISUALIZAÇÃO DA TABLE */

                                    bovespa.menu.get('bovespa-indebtedness-pct').action();/* PRÉ-EXECUTANDO BOTÃO QUEN CONTROLA A VISUALIZAÇÃO DA TABLE */
                                    bovespa.menu.get('bovespa-indebtedness-ce').action(); /* PRÉ-EXECUTANDO BOTÃO QUEN CONTROLA A VISUALIZAÇÃO DA TABLE */
                                    bovespa.menu.get('bovespa-indebtedness-ipl').action();/* PRÉ-EXECUTANDO BOTÃO QUEN CONTROLA A VISUALIZAÇÃO DA TABLE */

                                    bovespa.JLib(".highcharts-legend-item").remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                    bovespa.JLib(this.self).replace({
                                        tag: "text",
                                        to: '',
                                        from: "Highcharts.com"
                                    });

                                    bovespa.JLib(this.self).unmask(); /* DESABILITA A MASK */
                                    bovespa.JLib(this.self).tost({text: 'Endividamento calculado!'}); /* MOSTRA POP-UP */
                                }
                            },
                            control: {
                                'model_change': function (name, model, libs) {
                                    var mc = bovespa.object.create({});

                                    mc[name] = function () {
                                        var _dt = bovespa.object.create({});
                                        model.each(function () {
                                            _dt._results_ = bovespa.memory({
                                                model: {
                                                    fields: [{name: 'year'}, {name: 'indicator'}]
                                                }
                                            });

                                            _dt._results_.data = [];
                                            _dt._results_.name = name;
                                            _dt._results_.data = this.get(name).results;
                                            _dt._analysis_ = this.get(name).analysis;
                                        });

                                        bovespa.object.extend(_dt, {
                                            average: function () {
                                                return  _dt._results_.sum("indicator") / _dt._results_.count();
                                            },
                                            total: function () {
                                                return  _dt._results_.sum("indicator");
                                            },
                                            analysis: function () {
                                                var _analysis = {
                                                    min: {
                                                        value: null,
                                                        year: null
                                                    },
                                                    max: {
                                                        value: null,
                                                        year: null
                                                    }
                                                },
                                                _l = false,
                                                        _situation;

                                                _dt._results_.each(function () {
                                                    var _indicator = Number(this.get('indicator')),
                                                            _year = this.get('year');

                                                    if (_l === false) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;

                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                        _l = true;
                                                    }


                                                    if (_analysis.max.year < _year) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.year > _year) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;
                                                    }


                                                });

                                                return libs.preAnalysis(_analysis);
                                            },
                                            results: function () {
                                                return  _dt._results_;
                                            },
                                            results_average: function () {
                                                var _average,
                                                        _memory = bovespa.memory({
                                                            model: _dt._results_.model,
                                                            data: []
                                                        });

                                                _memory.data = [];
                                                _average = _dt.average();

                                                _dt._results_.each(function () {
                                                    _memory.data.push({year: this.get('year'), indicator: _average});
                                                });

                                                return _memory;
                                            },
                                            results_data: function () {
                                                var _data = [],
                                                        _data_average = [];

                                                _dt._results_.each(function () {
                                                    _data.push(this.get('indicator'));
                                                    _data_average.push(_dt.average());
                                                });

                                                return  [{
                                                        name: 'Indice Anual',
                                                        data: _data
                                                    }, {
                                                        name: 'Indice Médio',
                                                        data: _data_average
                                                    }];
                                            },
                                            year: function () {
                                                var _analysis = {
                                                    min: {
                                                        value: null,
                                                        year: null
                                                    },
                                                    max: {
                                                        value: null,
                                                        year: null
                                                    }
                                                },
                                                _l = false,
                                                        _situation;

                                                _dt._results_.each(function () {
                                                    var _indicator = Number(this.get('indicator')),
                                                            _year = this.get('year');

                                                    if (_l === false) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;

                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                        _l = true;
                                                    }


                                                    if (_analysis.max.year < _year) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.year > _year) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;
                                                    }


                                                });

                                                return  _analysis.min.year;
                                            }
                                        });

                                        return {
                                            average: _dt.average,
                                            total: _dt.total,
                                            analysis: _dt.analysis,
                                            results: _dt.results,
                                            results_average: _dt.results_average,
                                            results_data: _dt.results_data,
                                            year: _dt.year
                                        };
                                    };

                                    return mc;
                                },
                                'render-before': function (view, model) {
                                    /* ALTERANDO O MODEL */
                                    bovespa.object.extend(model, this.model_change("pct", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;

                                            if (_analysis.min.value > _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }

                                            if (_analysis.min.value < _analysis.max.value) {
                                                _situation += " <p style='display: block;'>A empresa se tornou mais dependente de Capital de Terceiros tendo em vista que houve um aumento no índice Participação de Terceiros.</p> ";
                                            } else {
                                                _situation += " <p style='display: block;'>A empresa se tornou menos dependente de Capital de Terceiros tendo em vista que houve uma queda no índice Participação de Terceiros.</p> ";
                                            }

                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ce", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;

                                            if (_analysis.min.value > _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }


                                            _situation += " <p style='display: block;'>Em " + _analysis.max.year + " " + _analysis.max.value.formatMoney(2, ',', '.') + "% das dívidas da empresa venceram no curto Prazo.</p> ";

                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ipl", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;

                                            if (_analysis.min.value > _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }

                                            if (_analysis.max.value <= 100)
                                                _situation += " <p style='display: block;'>Em " + _analysis.max.year + " a empresa conseguiria financiar o seu Ativo Permanente ou Fixo com o Capital Próprio (PL) com um índice de " + _analysis.max.value.formatMoney(2, ',', '.') + "%.</p> ";
                                            else
                                                _situation += " <p style='display: block;'>Em " + _analysis.max.year + " a empresa não conseguiria financiar o seu Ativo Permanente ou Fixo com o Capital Próprio (PL) com um índice de " + _analysis.max.value.formatMoney(2, ',', '.') + "%, sendo necessário obter empréstimo.</p> ";

                                            return _situation;
                                        }
                                    }));
                                },
                                url: 'app/views/indebtedness.html'
                            },
                            model: bovespa.model.Indebtedness()
                        }
                    ]);
                }, /* VIEW DOS INDICADORES DE ENDIVIDAMENTO */
                Liquidity: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-liquidity',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {
                                    bovespa.config.chart.themes().Liquidity();/* TEMA DO CHART */

                                    bovespa.JLib("card-graphic-lg").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'column'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                subtitle: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    categories: [
                                                        'Liquidez Geral'
                                                    ],
                                                    crosshair: true
                                                },
                                                yAxis: {
                                                    min: 0,
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:{series.color};padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    column: {
                                                        pointPadding: 0.2,
                                                        borderWidth: 0
                                                    }
                                                },
                                                series: model.lg().results()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-lc").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'column'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                subtitle: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    categories: [
                                                        'Liquidez Geral'
                                                    ],
                                                    crosshair: true
                                                },
                                                yAxis: {
                                                    min: 0,
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:{series.color};padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    column: {
                                                        pointPadding: 0.2,
                                                        borderWidth: 0
                                                    }
                                                },
                                                series: model.ilc().results()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-ls").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'column'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                subtitle: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    categories: [
                                                        'Liquidez Geral'
                                                    ],
                                                    crosshair: true
                                                },
                                                yAxis: {
                                                    min: 0,
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:{series.color};padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    column: {
                                                        pointPadding: 0.2,
                                                        borderWidth: 0
                                                    }
                                                },
                                                series: model.ils().results()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-ccl").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'column'
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                subtitle: {
                                                    text: ''
                                                },
                                                xAxis: {
                                                    categories: [
                                                        'Liquidez Geral'
                                                    ],
                                                    crosshair: true
                                                },
                                                yAxis: {
                                                    min: 0,
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br>',
                                                    pointFormat: '<div style="color:{series.color};padding:0">{series.name}: <span style="padding:0"><b> {point.y:.2f} </b> </span></div>',
                                                    footerFormat: ' ',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                plotOptions: {
                                                    column: {
                                                        pointPadding: 0.2,
                                                        borderWidth: 0
                                                    }
                                                },
                                                series: model.ccl().results()
                                            }); /* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    this['inject-json']({
                                        bovespa: {
                                            'liquidity': {
                                                lg: {
                                                    analysis: model.lg().analysis(),
                                                    results_average: Number(model.lg().average()).formatMoney(2, ',', '.')
                                                },
                                                lc: {
                                                    analysis: model.ilc().analysis(),
                                                    results_average: Number(model.ilc().average()).formatMoney(2, ',', '.')
                                                },
                                                ls: {
                                                    analysis: model.ils().analysis(),
                                                    results_average: Number(model.ils().average()).formatMoney(2, ',', '.')
                                                },
                                                ccl: {
                                                    analysis: model.ccl().analysis(),
                                                    results_average: Number(model.ccl().average()).formatMoney(2, ',', '.')
                                                }
                                            }
                                        }
                                    }); /* LER OBJETO E O SUBSTITUI NO HTML, COM NAMESPACE CORREPONDENTE DO OBJETO NO HTML */

                                    bovespa.JLib(this.self).tost({text: 'Liquidez calculada!'}); /* MOSTRA MENSAGEM POP-UP */
                                }
                            },
                            control: {
                                'model_change': function (name, model, libs) {
                                    var mc = bovespa.object.create({});

                                    mc[name] = function () {
                                        var _dt = bovespa.object.create({});
                                        model.each(function () {
                                            _dt._results_ = bovespa.memory({
                                                model: {
                                                    fields: [{name: 'year'}, {name: 'indicator'}]
                                                }
                                            });

                                            _dt._results_.data = [];
                                            _dt._results_.data = this.get(name).results;
                                            _dt._analysis_ = this.get(name).analysis;
                                        });


                                        bovespa.object.extend(_dt, {
                                            average: function () {
                                                return  _dt._results_.sum("indicator") / _dt._results_.count();
                                            },
                                            total: function () {
                                                return  _dt._results_.sum("indicator");
                                            },
                                            analysis: function () {
                                                var _analysis = {
                                                    min: {
                                                        value: null,
                                                        year: null
                                                    },
                                                    max: {
                                                        value: null,
                                                        year: null
                                                    }
                                                },
                                                _l = false,
                                                        _situation;

                                                _dt._results_.each(function () {
                                                    var _indicator = Number(this.get('indicator')),
                                                            _year = this.get('year');

                                                    if (_l === false) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;

                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                        _l = true;
                                                    }




                                                    if (_analysis.max.year < _year) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.year > _year) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;
                                                    }


                                                });

                                                return libs.preAnalysis(_analysis);
                                            },
                                            results: function () {
                                                var _results = [];

                                                _dt._results_.each(function () {
                                                    _results.push({name: this.get('year'), data: [this.get('indicator')]});
                                                });

                                                return _results;
                                            },
                                            results_average: function () {
                                                var _average,
                                                        _memory = bovespa.memory({
                                                            model: _dt._results_.model,
                                                            data: []
                                                        });

                                                _memory.data = [];
                                                _average = _dt.average();

                                                _dt._results_.each(function () {
                                                    _memory.data.push({year: this.get('year'), indicator: _average});
                                                });

                                                return _memory;
                                            },
                                            categories: function () {
                                                var _categories = [];

                                                _categories.push(name);

                                                return _categories;
                                            }
                                        });

                                        return {
                                            average: _dt.average,
                                            total: _dt.total,
                                            analysis: _dt.analysis,
                                            results: _dt.results,
                                            results_average: _dt.results_average,
                                            categories: _dt.categories
                                        };
                                    };
                                    return mc;
                                },
                                'render-before': function (view, model) {
                                    /* ALTERANDO O MODEL */
                                    bovespa.object.extend(model, this.model_change("lg", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;

                                            if (_analysis.min.value < _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.min.year + " ";
                                            if (_analysis.min.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas com terceiros.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida total com terceiros.";
                                            }

                                            _situation += "</p>";

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.max.year + " ";
                                            if (_analysis.max.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas com terceiros.";
                                            } else {
                                                _situation += " a empresa possui capacidade de pagar a dívida total com terceiros.";
                                            }

                                            _situation += "</p>";

                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ilc", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;

                                            if (_analysis.min.value < _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.min.year + " ";
                                            if (_analysis.min.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas de curto prazo.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida de curto prazo com recursos de curto prazo.";
                                            }

                                            _situation += "</p>";

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.max.year + " ";
                                            if (_analysis.max.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas de curto prazo.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida de curto prazo com recursos de curto prazo.";
                                            }

                                            _situation += "</p>";
                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ils", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            var _situation;

                                            if (_analysis.min.value < _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.min.year + " ";
                                            if (_analysis.min.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas de curto prazo.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida de curto prazo com recursos de curto prazo.";
                                            }

                                            _situation += "</p>";

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.max.year + " ";
                                            if (_analysis.max.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas de curto prazo.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida de curto prazo com recursos de curto prazo.";
                                            }

                                            _situation += "</p>";
                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ccl", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            var _situation;

                                            if (_analysis.min.value < _analysis.max.value) {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                            }

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.min.year + " ";
                                            if (_analysis.min.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas de curto prazo.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida de curto prazo com recursos de curto prazo.";
                                            }

                                            _situation += "</p>";

                                            _situation += "<p style='display: block;'>";
                                            _situation += "Em " + _analysis.max.year + " ";
                                            if (_analysis.max.value < 1.0) {
                                                _situation += " faltava recursos para quitar as dívidas de curto prazo.";
                                            } else {
                                                _situation += " a empresa possuia capacidade de pagar a dívida de curto prazo com recursos de curto prazo.";
                                            }

                                            _situation += "</p>";
                                            return _situation;
                                        }
                                    }));
                                },
                                url: 'app/views/liquidity.html'
                            },
                            model: bovespa.model.Liquidity()
                        }
                    ]);
                }, /* VIEW DOS INDICADORES DE LIQUIDEZ */
                Profitability: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-profitability',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {
                                    bovespa.config.chart.themes().Profitability(); /* TEMA DO CHART */

                                    bovespa.JLib("card-graphic-ga").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'bar'
                                                },
                                                xAxis: {
                                                    categories: model.ga().categories(),
                                                    title: {
                                                        text: null
                                                    }
                                                },
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br><table>',
                                                    pointFormat: '<tr> <td style="color:{series.color};padding:0">Resultados: </td>' +
                                                            '          <td style="padding:0"><b> {point.y:.2f} </b> <br> </td></tr>',
                                                    footerFormat: '</table>',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                series: model.ga().results()
                                            });/* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-ml").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'bar'
                                                },
                                                xAxis: {
                                                    categories: model.ga().categories(),
                                                    title: {
                                                        text: null
                                                    }
                                                },
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br><table>',
                                                    pointFormat: '<tr> <td style="color:{series.color};padding:0">Resultados: </td>' +
                                                            '          <td style="padding:0"><b> {point.y:.2f} </b> <br> </td></tr>',
                                                    footerFormat: '</table>',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                series: model.ml().results()
                                            });/* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-ra").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'bar'
                                                },
                                                xAxis: {
                                                    categories: model.ga().categories(),
                                                    title: {
                                                        text: null
                                                    }
                                                },
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br><table>',
                                                    pointFormat: '<tr> <td style="color:{series.color};padding:0">Resultados: </td>' +
                                                            '          <td style="padding:0"><b> {point.y:.2f} </b> <br> </td></tr>',
                                                    footerFormat: '</table>',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                series: model.ra().results()
                                            });/* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-rpl").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                chart: {
                                                    type: 'bar'
                                                },
                                                xAxis: {
                                                    categories: model.ga().categories(),
                                                    title: {
                                                        text: null
                                                    }
                                                },
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                tooltip: {
                                                    headerFormat: '<span style="font-size:10px">{point.key}</span><br><table>',
                                                    pointFormat: '<tr> <td style="color:{series.color};padding:0">Resultados: </td>' +
                                                            '          <td style="padding:0"><b> {point.y:.2f} </b> <br> </td></tr>',
                                                    footerFormat: '</table>',
                                                    shared: true,
                                                    useHTML: true
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    }
                                                },
                                                series: model.rpl().results()
                                            });/* CONSTRUÇÃO DO HIGHCHARTS */

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    this['inject-json']({
                                        bovespa: {
                                            'profitability': {
                                                ga: {
                                                    analysis: model.ga().analysis()
                                                },
                                                ml: {
                                                    analysis: model.ml().analysis()
                                                },
                                                ra: {
                                                    analysis: model.ra().analysis()
                                                },
                                                rpl: {
                                                    analysis: model.rpl().analysis()
                                                }
                                            }
                                        }
                                    }); /* LER OBJETO E O SUBSTITUI NO HTML, COM NAMESPACE CORREPONDENTE DO OBJETO NO HTML */

                                    bovespa.JLib(this.self).tost({text: 'Rentabilidade calculada!'}); /* MOSTRA MENSAGEM POP-UP */
                                }
                            },
                            control: {
                                'model_change': function (name, model, libs) {
                                    var mc = bovespa.object.create({});

                                    mc[name] = function () {
                                        var _dt = bovespa.object.create({});
                                        model.each(function () {
                                            _dt._results_ = bovespa.memory({
                                                model: {
                                                    fields: [{name: 'year'}, {name: 'indicator'}]
                                                }
                                            });

                                            _dt._results_.data = [];
                                            _dt._results_.data = this.get(name).results;
                                            _dt._analysis_ = this.get(name).analysis;
                                        });


                                        bovespa.object.extend(_dt, {
                                            average: function () {
                                                return  _dt._results_.sum("indicator") / _dt._results_.count();
                                            },
                                            total: function () {
                                                return  _dt._results_.sum("indicator");
                                            },
                                            analysis: function () {
                                                var _analysis = {
                                                    min: {
                                                        value: null,
                                                        year: null
                                                    },
                                                    max: {
                                                        value: null,
                                                        year: null
                                                    }
                                                },
                                                _l = false,
                                                        _situation;

                                                _dt._results_.each(function () {
                                                    var _indicator = Number(this.get('indicator')),
                                                            _year = this.get('year');

                                                    if (_l === false) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;

                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                        _l = true;
                                                    }




                                                    if (_analysis.max.year < _year) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.year > _year) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;
                                                    }


                                                });

                                                return libs.preAnalysis(_analysis);
                                            },
                                            results: function () {
                                                var _results = [];

                                                _dt._results_.each(function () {
                                                    _results.push({name: this.get('year'), y: this.get('indicator')});
                                                });

                                                return [{
                                                        name: 'Results',
                                                        colorByPoint: true,
                                                        data: _results
                                                    }];
                                            },
                                            results_average: function () {
                                                var _average,
                                                        _memory = bovespa.memory({
                                                            model: _dt._results_.model,
                                                            data: []
                                                        });

                                                _memory.data = [];
                                                _average = _dt.average();

                                                _dt._results_.each(function () {
                                                    _memory.data.push({year: this.get('year'), indicator: _average});
                                                });

                                                return _memory;
                                            },
                                            categories: function () {
                                                var _categories = [];

                                                _dt._results_.each(function () {
                                                    _categories.push(this.get('year'));
                                                });

                                                return _categories;
                                            }
                                        });

                                        return {
                                            average: _dt.average,
                                            total: _dt.total,
                                            analysis: _dt.analysis,
                                            results: _dt.results,
                                            results_average: _dt.results_average,
                                            categories: _dt.categories
                                        };
                                    };
                                    return mc;
                                },
                                'render-before': function (view, model) {
                                    /* ALTERANDO O MODEL */
                                    bovespa.object.extend(model, this.model_change("ga", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.max.value < _analysis.min.value) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ".</p> A Empresa não conseguiu obter um retorno superior ao ano de " + _analysis.min.year + ".";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                                _situation += "A Empresa conseguiu obter um retorno superior ao investimento feito no Ativo. Ou seja, o investimento contribuiu para aumentar o volume de vendas de um ano para outro.";
                                            }


                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ml", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.max.value < _analysis.min.value) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ".</p> A Empresa não conseguiu obter um retorno sobre as vendas superior ao ano de " + _analysis.min.year + ".";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                                _situation += "A empresa apresentou um Retorno sobre as vendas em " + _analysis.max.year + ", passando de " + _analysis.min.value.formatMoney(2, ',', '.') + " para " + _analysis.max.value.formatMoney(2, ',', '.') + ". Ou seja, a lucratividade sobre as vendas foi " + Number(_analysis.min.value / _analysis.max.value * 100).formatMoney(2, ',', '.') + ' superior.';
                                            }
                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("ra", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.max.value < _analysis.min.value) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ".</p> A Empresa não conseguiu obter um retorno superior ao ano de " + _analysis.min.year + ".";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                                _situation += "O Retorno sobre o investimento total no ativo ´subiu " + Number(_analysis.min.value / _analysis.max.value * 100).formatMoney(2, ',', '.') + "%.";
                                            }


                                            return _situation;
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("rpl", model, {
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.max.value < _analysis.min.value) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ".</p> A Empresa não conseguiu obter um retorno sobre as vendas superior ao ano de " + _analysis.min.year + ".";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". </p> ";
                                                _situation += 'Em ' + _analysis.max.year + ' a empresa se tornou mais rentável para o acionista ou proprietário, pois em ' + _analysis.min.year + ' para cada R$ 100,00 aplicados na empresa, a empresa gerava R$ ' + _analysis.min.value.formatMoney(2, ',', '.') + ' de lucro e em ' + _analysis.max.year + ' passou a gerar R$ ' + _analysis.max.value.formatMoney(2, ',', '.') + ' de lucro.';
                                            }
                                            return _situation;
                                        }
                                    }));
                                },
                                url: 'app/views/profitability.html'
                            },
                            model: bovespa.model.Profitability()
                        }
                    ]);
                }, /* VIEW DOS INDICADORES DE RENTABILIDADE */
                Midterm: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-midterm',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {

                                    bovespa.config.chart.themes().Midterm();

                                    bovespa.JLib("card-graphic-pme").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + 'd';
                                                        }
                                                    },
                                                    plotLines: model.pme().plotLines()
                                                },
                                                series: model.pme().results()
                                            });

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-pmr").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + 'd';
                                                        }
                                                    },
                                                    plotLines: model.pmr().plotLines()
                                                },
                                                series: model.pmr().results()
                                            });

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-pmp").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + 'd';
                                                        }
                                                    },
                                                    plotLines: model.pmp().plotLines()
                                                },
                                                series: model.pmp().results()
                                            });

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-cf").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + 'd';
                                                        }
                                                    },
                                                    plotLines: model.cf().plotLines()
                                                },
                                                series: model.cf().results()
                                            });

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib("card-graphic-co").frame({
                                        src: 'app/views/charts.html',
                                        width: '100%',
                                        height: '500px',
                                        onReady: function (e) {
                                            bovespa._plugin_.JQuery(this.body).highcharts({
                                                rangeSelector: {
                                                    selected: 1
                                                },
                                                title: {
                                                    text: ''
                                                },
                                                yAxis: {
                                                    title: {
                                                        text: ''
                                                    },
                                                    labels: {
                                                        formatter: function () {
                                                            return this.value.formatMoney(2, ',', '.') + 'd';
                                                        }
                                                    },
                                                    plotLines: model.co().plotLines()
                                                },
                                                series: model.co().results()
                                            });

                                            bovespa.JLib(".highcharts-legend-item", this.doc).remove(); /* PEGA A CLASSE LEGENDA DO CHART E REMOVE */
                                            bovespa.JLib('html', this.doc).replace({
                                                tag: "text",
                                                to: '',
                                                from: "Highcharts.com"
                                            });
                                        }
                                    });

                                    bovespa.JLib(this.self).replace({
                                        tag: "text",
                                        to: '',
                                        from: "Highcharts.com"
                                    });

                                    this['inject-json']({
                                        bovespa: {
                                            'midterm': {
                                                pme: {
                                                    analysis: model.pme().analysis()
                                                },
                                                pmr: {
                                                    analysis: model.pmr().analysis()
                                                },
                                                pmp: {
                                                    analysis: model.pmp().analysis()
                                                },
                                                co: {
                                                    analysis: model.co().analysis()
                                                },
                                                cf: {
                                                    analysis: model.cf().analysis()
                                                }
                                            }
                                        }
                                    });

                                    bovespa.JLib(this.self).tost({text: 'Prazos médios calculados!'}); /* MOSTRA MENSAGEM POP-UP */
                                }
                            },
                            control: {
                                'model_change': function (name, model, libs) {
                                    var mc = bovespa.object.create({});

                                    mc[name] = function () {
                                        var _dt = bovespa.object.create({});
                                        model.each(function () {
                                            _dt._results_ = bovespa.memory({
                                                model: {
                                                    fields: [{name: 'year'}, {name: 'indicator'}]
                                                }
                                            });

                                            _dt._results_.data = [];
                                            _dt._results_.data = this.get(name).results;
                                            _dt._analysis_ = null;
                                        });


                                        bovespa.object.extend(_dt, {
                                            average: function () {
                                                return  _dt._results_.sum("indicator") / _dt._results_.count();
                                            },
                                            total: function () {
                                                return  _dt._results_.sum("indicator");
                                            },
                                            analysis: function () {
                                                var _analysis = {
                                                    min: {
                                                        value: null,
                                                        year: null
                                                    },
                                                    max: {
                                                        value: null,
                                                        year: null
                                                    }
                                                },
                                                _l = false,
                                                        _situation;

                                                _dt._results_.each(function () {
                                                    var _indicator = Number(this.get('indicator')),
                                                            _year = this.get('year');

                                                    if (_l === false) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;

                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                        _l = true;
                                                    }




                                                    if (_analysis.max.year < _year) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.year > _year) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;
                                                    }


                                                });

                                                return libs.preAnalysis(_analysis);
                                            },
                                            results: function () {
                                                var _results = [];
                                                var _name = "";

                                                _dt._results_.each(function () {
                                                    _results.push(this.get('indicator'));
                                                    _name += (_name !== "" ? " - " : "") + this.get('year');
                                                });

                                                return [{
                                                        name: _name,
                                                        data: _results,
                                                        tooltip: {
                                                            valueDecimals: 4
                                                        }
                                                    }];
                                            },
                                            results_average: function () {
                                                var _average,
                                                        _memory = bovespa.memory({
                                                            model: _dt._results_.model,
                                                            data: []
                                                        });

                                                _memory.data = [];
                                                _average = _dt.average();

                                                _dt._results_.each(function () {
                                                    _memory.data.push({year: this.get('year'), indicator: _average});
                                                });

                                                return _memory;
                                            },
                                            categories: function () {
                                                var _categories = [];

                                                _categories.push(name);

                                                return _categories;
                                            },
                                            name: function () {
                                                return name;
                                            },
                                            plotLines: function () {
                                                var _analysis = {
                                                    min: {
                                                        value: null,
                                                        year: null
                                                    },
                                                    max: {
                                                        value: null,
                                                        year: null
                                                    }
                                                },
                                                _l = false,
                                                        _situation;

                                                _dt._results_.each(function () {
                                                    var _indicator = Number(this.get('indicator')),
                                                            _year = this.get('year');

                                                    if (_l === false) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;

                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                        _l = true;
                                                    }




                                                    if (_analysis.max.value < _indicator) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.value > _indicator) {
                                                        _analysis.min.value = _indicator;
                                                        _analysis.min.year = _year;
                                                    }



                                                });

                                                return  libs.plotLines(_analysis);
                                            }
                                        });

                                        return {
                                            average: _dt.average,
                                            total: _dt.total,
                                            analysis: _dt.analysis,
                                            results: _dt.results,
                                            results_average: _dt.results_average,
                                            categories: _dt.categories,
                                            plotLines: _dt.plotLines
                                        };
                                    };
                                    return mc;
                                },
                                'render-before': function (view, model) {
                                    /* ALTERANDO O MODEL */
                                    bovespa.object.extend(model, this.model_change("pme", model, {
                                        ideal_value: 0,
                                        condition: "+",
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.min.year < _analysis.max.year) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". Pois em " + _analysis.min.year + " a empresa conseguia vender os produtos estocados em até " + _analysis.min.value + " dias. </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.max.year + "/" + _analysis.min.year + ". Pois em " + _analysis.min.year + " a empresa conseguiu vender os produtos estocados em até " + _analysis.min.value + " dias e " + (_analysis.max.value - _analysis.min.value) + " dias antes do ano anterior. </p> ";
                                            }

                                            return _situation;
                                        }
                                        , plotLines: function (_analysis) {
                                            return [
                                                {
                                                    value: _analysis.min.value,
                                                    color: (0 < _analysis.min.value ? 'yellow' : 'green'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }, {
                                                    value: _analysis.max.value,
                                                    color: (0 < _analysis.max.value ? 'red' : 'yellow'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }
                                            ];
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("pmr", model, {
                                        ideal_value: 0,
                                        condition: "+",
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.min.year < _analysis.max.year) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". Pois em " + _analysis.min.year + " a empresa conseguia receber as vendas a prazo de clientes em até " + _analysis.min.value + " dias. </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.max.year + "/" + _analysis.min.year + ". Pois em " + _analysis.min.year + " a empresa conseguiu receber as vendas a prazo de clientes " + _analysis.min.value + " dias e " + (_analysis.max.value - _analysis.min.value) + " dias antes do ano anterior. </p> ";
                                            }

                                            return _situation;
                                        },
                                        plotLines: function (_analysis) {
                                            return [
                                                {
                                                    value: _analysis.min.value,
                                                    color: (0 < _analysis.min.value ? 'yellow' : 'green'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }, {
                                                    value: _analysis.max.value,
                                                    color: (0 < _analysis.max.value ? 'red' : 'yellow'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }
                                            ];
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("pmp", model, {
                                        ideal_value: 0,
                                        condition: "-",
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.max.year < _analysis.min.year) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". Pois em " + _analysis.min.year + " a dividas com fornecedores venciam em até " + _analysis.min.value + " dias. </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.min.year + "/" + _analysis.max.year + ". Pois em " + _analysis.max.year + " a dividas com fornecedores venciam em até " + _analysis.max.value + " dias. </p> ";
                                            }

                                            return _situation;
                                        },
                                        plotLines: function (_analysis) {
                                            return [
                                                {
                                                    value: _analysis.max.value,
                                                    color: (_analysis.max.value < _analysis.max.value ? 'yellow' : 'green'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }, {
                                                    value: _analysis.min.value,
                                                    color: (0 < _analysis.min.value ? 'red' : 'yellow'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }
                                            ];
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("co", model, {
                                        ideal_value: 0,
                                        condition: "-",
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.min.year < _analysis.max.year) {
                                                _situation = " <p style='display: block;'>A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". Pois em " + _analysis.min.year + " a empresa conseguia receber as vendas a prazo de clientes em até " + _analysis.min.value + " dias. </p> ";
                                            } else {
                                                _situation = " <p style='display: block;'>A situação melhorou " + _analysis.max.year + "/" + _analysis.min.year + ". Pois em " + _analysis.min.year + " a empresa conseguia receber as vendas a prazo de clientes " + (_analysis.max.value - _analysis.min.value) + " dias antes. </p> ";
                                            }

                                            return _situation;
                                        },
                                        plotLines: function (_analysis) {
                                            return [
                                                {
                                                    value: _analysis.max.value,
                                                    color: (_analysis.max.value < _analysis.max.value ? 'yellow' : 'green'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }, {
                                                    value: _analysis.min.value,
                                                    color: (0 < _analysis.min.value ? 'red' : 'yellow'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }
                                            ];
                                        }
                                    }));
                                    bovespa.object.extend(model, this.model_change("cf", model, {
                                        ideal_value: 0,
                                        condition: "-",
                                        preAnalysis: function (_analysis) {
                                            var _situation;
                                            if (_analysis.min.value < _analysis.max.value) {
                                                _situation = " <p >A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". <br> Pois em " + _analysis.min.year + " a empresa conseguia receber as vendas a prazo de clientes em até " + (_analysis.min.value < 0 ? (_analysis.min.value * -1).formatMoney(2, ',', '.') + " dias antes" : _analysis.min.value.formatMoney(2, ',', '.') + " dias depois") + " que as dividas com fornecedores vencessem. </p> ";
                                            } else {
                                                _situation = "<p>";
                                                _situation += " A situação melhorou " + _analysis.max.year + "/" + _analysis.min.year + ".";
                                                _situation += " <br>No ano de " + _analysis.min.year + " a empresa conseguiu receber as vendas a prazo de clientes " + (_analysis.min.value < 0 ? (_analysis.min.value * -1).formatMoney(2, ',', '.') + " dias antes" : Number(_analysis.min.value).formatMoney(2, ',', '.') + " dias depois") + " que as dividas com fornecedores vencessem.";
                                                _situation += " <br>No ano de " + _analysis.max.year + " recebia " + (_analysis.max.value - _analysis.min.value).formatMoney(2, ',', '.') + " dias depois se comparado a " + _analysis.min.year + ". </p> ";
                                            }


                                            return _situation;
                                        },
                                        plotLines: function (_analysis) {
                                            return [
                                                {
                                                    value: _analysis.min.value,
                                                    color: (0 < _analysis.min.value ? 'yellow' : 'green'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }, {
                                                    value: _analysis.max.value,
                                                    color: (0 < _analysis.max.value ? 'red' : 'yellow'),
                                                    dashStyle: 'shortdash',
                                                    width: 2
                                                }
                                            ];
                                        }
                                    }));
                                },
                                url: 'app/views/midterm.html'
                            },
                            model: bovespa.model.Midterm()
                        }
                    ]);
                } /* VIEW DOS INDICADORES DE PRAZOS MEDIOS */
            });
        }
    }
});

bovespa.onResize(function () {
    if (bovespa.width() >= bovespa.config.responsive['med-width']) {
        bovespa.JLib('svg').each(function (e) {
            var div_up = bovespa.JLib(e).up(),
                    node_up = div_up.up();


            if (div_up.class().contains('highcharts-container') === false)
                return;

            div_up.css('min-width', '100%');
            div_up.css('width', '100%');

            bovespa.JLib(e).css('min-width', '100%');
            bovespa.JLib(e).attr('width', '100%');
        });
    }
    if (bovespa.width() < bovespa.config.responsive['med-width']) {
        bovespa.JLib('svg').each(function (e) {
            var div_up = bovespa.JLib(e).up(),
                    node_up = div_up.up();


            if (div_up.class().contains('highcharts-container') === false)
                return;

            if (node_up.width() !== 0) {
                bovespa.JLib(e).css('min-width', node_up.width() + 'px');
                bovespa.JLib(e).css('width', node_up.width() + 'px');
                div_up.css('min-width', node_up.width() + 'px');
                div_up.css('width', node_up.width() + 'px');
            } else {
                bovespa.JLib(e).css('min-width', '100%');
                bovespa.JLib(e).css('width', '100%');
                div_up.css('min-width', '100%');
                div_up.css('width', '100%');
            }


        });
    }
});
