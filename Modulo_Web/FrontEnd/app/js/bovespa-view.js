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
                            'name': 'bovespa-company',
                            view: {
                                self: '.bovespa',
                                render: function () {
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
                                url: 'app/views/company.html'
                            }
                        }
                    ]);
                },
                Home: function () {
                    return bovespa.template([{
                            'name': 'bovespa-home',
                            view: {
                                self: '.bovespa'
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
                                            }
                                        }]);

                                    view._mnu_._liquidity_ = bovespa.menu([{
                                            name: 'bovespa-liquidity',
                                            attach: bovespa.view._main_,
                                            navigation: 'Liquidity',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                            }
                                        }]);

                                    view._mnu_._profitability_ = bovespa.menu([{
                                            name: 'bovespa-profitability',
                                            attach: bovespa.view._main_,
                                            navigation: 'Profitability',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
                                            }
                                        }]);

                                    view._mnu_._midterm_ = bovespa.menu([{
                                            name: 'bovespa-midterm',
                                            attach: bovespa.view._main_,
                                            navigation: 'Midterm',
                                            action: function (e) {
                                                bovespa.control._mnu_['bovespa-navigation'].call(this, e);
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
                },
                Indebtedness: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-indebtedness',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {
                                    bovespa.JLib(this.self).mask();

                                    this['inject-json']({
                                        bovespa: {
                                            'indebtedness': {
                                                pct: Number(model.pct().average()).formatMoney(2, ',', '.') + '%',
                                                ce: Number(model.ce().average()).formatMoney(2, ',', '.') + '%',
                                                ipl: Number(model.ipl().average()).formatMoney(2, ',', '.') + '%'
                                            }
                                        }
                                    });

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
                                    });

                                    bovespa.component({
                                        type: 'chart',
                                        tType: 'line',
                                        model: [model.pct().results(), model.pct().results_average()],
                                        label: 'year',
                                        values: 'indicator',
                                        renderTo: 'graphic-pct',
                                        theme: 'Cyan',
                                        configs: [{
                                                fillColor: "rgba(128, 222, 234, 0.6)",
                                                strokeColor: "#ffffff",
                                                pointColor: "#00bcd4",
                                                pointStrokeColor: "#ffffff",
                                                pointHighlightFill: "#ffffff",
                                                pointHighlightStroke: "#ffffff"
                                            }, {
                                                label: "Second dataset",
                                                fillColor: "rgba(128, 222, 234, 0.3)",
                                                strokeColor: "#80deea",
                                                pointColor: "#00bcd4",
                                                pointStrokeColor: "#80deea",
                                                pointHighlightFill: "#80deea",
                                                pointHighlightStroke: "#80deea"
                                            }]
                                    });
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
                                    });

                                    bovespa.component({
                                        type: 'chart',
                                        tType: 'line',
                                        model: [model.ce().results(), model.ce().results_average()],
                                        label: 'year',
                                        values: 'indicator',
                                        renderTo: 'graphic-ce',
                                        theme: 'Green',
                                        configs: [{
                                                fillColor: "rgba(142, 234, 128, 0.6)",
                                                strokeColor: "#ffffff",
                                                pointColor: "#3dd400",
                                                pointStrokeColor: "#ffffff",
                                                pointHighlightFill: "#ffffff",
                                                pointHighlightStroke: "#ffffff"
                                            }, {
                                                label: "Second dataset",
                                                fillColor: "rgba(142, 234, 128, 0.3)",
                                                strokeColor: "#80ea92",
                                                pointColor: "#3dd400",
                                                pointStrokeColor: "#b4ea80",
                                                pointHighlightFill: "#b4ea80",
                                                pointHighlightStroke: "#b4ea80"
                                            }]
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
                                    });

                                    bovespa.component({
                                        type: 'chart',
                                        tType: 'line',
                                        model: [model.ipl().results(), model.ipl().results_average()],
                                        label: 'year',
                                        values: 'indicator',
                                        renderTo: 'graphic-ipl',
                                        theme: 'Orange',
                                        configs: [{
                                                fillColor: "rgba(234, 208, 128, 0.6)",
                                                strokeColor: "#ffffff",
                                                pointColor: "#d4ab00",
                                                pointStrokeColor: "#ffffff",
                                                pointHighlightFill: "#ffffff",
                                                pointHighlightStroke: "#ffffff"
                                            }, {
                                                label: "Second dataset",
                                                fillColor: "rgba(234, 208, 128, 0.3)",
                                                strokeColor: "#ead080",
                                                pointColor: "#d4ab00",
                                                pointStrokeColor: "#ead680",
                                                pointHighlightFill: "#ead680",
                                                pointHighlightStroke: "#ead680"
                                            }]
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
                                    });


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
                                        }]);
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
                                        }]);
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
                                        }]);


                                    bovespa.menu.get('bovespa-indebtedness-pct').action();
                                    bovespa.menu.get('bovespa-indebtedness-ce').action();
                                    bovespa.menu.get('bovespa-indebtedness-ipl').action();

                                    bovespa.JLib(this.self).unmask();
                                    bovespa.JLib(this.self).tost({text: 'Endividamento calculado!'});
                                }
                            },
                            control: {
                                'render-before': function (view, model) {
                                    /* ALTERANDO O MODEL */
                                    bovespa.object.extend(model, {
                                        pct: function () {
                                            var _dt = bovespa.object.create({});
                                            this.each(function () {
                                                _dt._results_ = bovespa.memory({
                                                    model: {
                                                        fields: [{name: 'year'}, {name: 'indicator'}]
                                                    }
                                                });

                                                _dt._results_.data = [];
                                                _dt._results_.data = this.get('pct').results;
                                                _dt._analysis_ = this.get('pct').analysis;
                                            });

                                            bovespa.object.extend(_dt, {
                                                average: function () {
                                                    return  _dt._results_.sum("indicator") / _dt._results_.count();
                                                },
                                                total: function () {
                                                    return  _dt._results_.sum("indicator");
                                                },
                                                analysis: function () {
                                                    return  _dt._analysis_;
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
                                                }
                                            });

                                            return {
                                                average: _dt.average,
                                                total: _dt.total,
                                                analysis: _dt.analysis,
                                                results: _dt.results,
                                                results_average: _dt.results_average
                                            };
                                        },
                                        ce: function () {
                                            var _dt = bovespa.object.create({});
                                            this.each(function () {
                                                _dt._results_ = bovespa.memory({
                                                    model: {
                                                        fields: [{name: 'year'}, {name: 'indicator'}]
                                                    }
                                                });

                                                _dt._results_.data = [];
                                                _dt._results_.data = this.get('ce').results;
                                                _dt._analysis_ = this.get('ce').analysis;
                                            });

                                            bovespa.object.extend(_dt, {
                                                average: function () {
                                                    return  _dt._results_.sum("indicator") / _dt._results_.count();
                                                },
                                                total: function () {
                                                    return  _dt._results_.sum("indicator");
                                                },
                                                analysis: function () {
                                                    return  _dt._analysis_;
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
                                                }
                                            });

                                            return {
                                                average: _dt.average,
                                                total: _dt.total,
                                                analysis: _dt.analysis,
                                                results: _dt.results,
                                                results_average: _dt.results_average
                                            };
                                        },
                                        ipl: function () {
                                            var _dt = bovespa.object.create({});
                                            this.each(function () {
                                                _dt._results_ = bovespa.memory({
                                                    model: {
                                                        fields: [{name: 'year'}, {name: 'indicator'}]
                                                    }
                                                });

                                                _dt._results_.data = [];
                                                _dt._results_.data = this.get('ipl').results;
                                                _dt._analysis_ = this.get('ipl').analysis;
                                            });

                                            bovespa.object.extend(_dt, {
                                                average: function () {
                                                    return  _dt._results_.sum("indicator") / _dt._results_.count();
                                                },
                                                total: function () {
                                                    return  _dt._results_.sum("indicator");
                                                },
                                                analysis: function () {
                                                    return  _dt._analysis_;
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
                                                }
                                            });

                                            return {
                                                average: _dt.average,
                                                total: _dt.total,
                                                analysis: _dt.analysis,
                                                results: _dt.results,
                                                results_average: _dt.results_average
                                            };
                                        }
                                    });


                                },
                                url: 'app/views/indebtedness.html'
                            },
                            model: bovespa.model.Indebtedness()
                        }
                    ]);
                },
                Liquidity: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-liquidity',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {


                                    bovespa._plugin_.JQuery('#card-graphic-lg').highcharts({
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
                                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                                    '<td style="padding:0"><b> {point.y:.2f} </b></td></tr>',
                                            footerFormat: '</table>',
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
                                    });

                                    bovespa._plugin_.JQuery('#card-graphic-ilc').highcharts({
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
                                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                                    '<td style="padding:0"><b> {point.y:.2f} </b></td></tr>',
                                            footerFormat: '</table>',
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
                                    });

                                    bovespa._plugin_.JQuery('#card-graphic-ils').highcharts({
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
                                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                                    '<td style="padding:0"><b> {point.y:.2f} </b></td></tr>',
                                            footerFormat: '</table>',
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
                                    });

                                    bovespa._plugin_.JQuery('#card-graphic-ccl').highcharts({
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
                                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                                    '<td style="padding:0"><b> {point.y:.2f} </b></td></tr>',
                                            footerFormat: '</table>',
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
                                    });

                                    this['inject-json']({
                                        bovespa: {
                                            'liquidity': {
                                                lg: {
                                                    analysis: model.lg().analysis(),
                                                    results_average: Number(model.lg().average()).formatMoney(2, ',', '.')
                                                },
                                                ilc: {
                                                    analysis: model.ilc().analysis(),
                                                    results_average: Number(model.ilc().average()).formatMoney(2, ',', '.')
                                                },
                                                ils: {
                                                    analysis: model.ils().analysis(),
                                                    results_average: Number(model.ils().average()).formatMoney(2, ',', '.')
                                                },
                                                ccl: {
                                                    analysis: model.ccl().analysis(),
                                                    results_average: Number(model.ccl().average()).formatMoney(2, ',', '.')
                                                }
                                            }
                                        }
                                    });

                                    bovespa.JLib(this.self).tost({text: 'Liquidez calculada!'});
                                    bovespa.JLib(this.self).replace({
                                        tag: "text",
                                        to: '',
                                        from: "Highcharts.com"
                                    });
                                }
                            },
                            control: {
                                'model_change': function (name, model) {
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
                                                return  _dt._analysis_;
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
                                    bovespa.object.extend(model, this.model_change("lg", model));
                                    bovespa.object.extend(model, this.model_change("ilc", model));
                                    bovespa.object.extend(model, this.model_change("ils", model));
                                    bovespa.object.extend(model, this.model_change("ccl", model));
                                },
                                url: 'app/views/liquidity.html'
                            },
                            model: bovespa.model.Liquidity()
                        }
                    ]);
                },
                Profitability: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-profitability',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {

                                    bovespa.config.chart.themes().Profitability();

                                    bovespa._plugin_.JQuery('#card-graphic-ga').highcharts({
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
                                        yAxis: {
                                            title: {
                                                text: ''
                                            }
                                        },
                                        series: model.ga().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-ml').highcharts({
                                        chart: {
                                            type: 'bar'
                                        },
                                        xAxis: {
                                            categories: model.ml().categories(),
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
                                        yAxis: {
                                            title: {
                                                text: ''
                                            }
                                        },
                                        series: model.ml().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-ra').highcharts({
                                        chart: {
                                            type: 'bar'
                                        },
                                        xAxis: {
                                            categories: model.ra().categories(),
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
                                        yAxis: {
                                            title: {
                                                text: ''
                                            }
                                        },
                                        series: model.ra().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-rpl').highcharts({
                                        chart: {
                                            type: 'bar'
                                        },
                                        xAxis: {
                                            categories: model.rpl().categories(),
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
                                        yAxis: {
                                            title: {
                                                text: ''
                                            }
                                        },
                                        series: model.rpl().results()
                                    });

                                    bovespa.JLib(".highcharts-legend-item").remove();
                                    bovespa.JLib(this.self).replace({
                                        tag: "text",
                                        to: '',
                                        from: "Highcharts.com"
                                    });

                                    this['inject-json']({
                                        bovespa: {
                                            'profitability': {
                                                ga: {
                                                    analysis: model.ga().analysis(),
                                                    results_average: Number(model.ga().average()).formatMoney(2, ',', '.')
                                                }
                                            }
                                        }
                                    });

                                    bovespa.JLib(this.self).tost({text: 'Rentabilidade calculada!'});
                                }
                            },
                            control: {
                                'model_change': function (name, model) {
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
                                                return  _dt._analysis_;
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
                                    bovespa.object.extend(model, this.model_change("ga", model));
                                    bovespa.object.extend(model, this.model_change("ml", model));
                                    bovespa.object.extend(model, this.model_change("ra", model));
                                    bovespa.object.extend(model, this.model_change("rpl", model));
                                },
                                url: 'app/views/profitability.html'
                            },
                            model: bovespa.model.Profitability()
                        }
                    ]);
                },
                Midterm: function () {
                    return bovespa.template([
                        {
                            'name': 'bovespa-midterm',
                            view: {
                                self: '.s-body-content',
                                render: function (model) {
                                    bovespa._plugin_.Highcharts.createElement('link', {
                                        href: 'https://fonts.googleapis.com/css?family=Signika:400,700',
                                        rel: 'stylesheet',
                                        type: 'text/css'
                                    }, null, document.getElementsByTagName('head')[0]);
                                    bovespa._plugin_.Highcharts.wrap(bovespa._plugin_.Highcharts.Chart.prototype, 'getContainer', function (proceed) {
                                        proceed.call(this);
                                        this.container.style.background = 'url(http://www.highcharts.com/samples/graphics/sand.png)';
                                    });
                                    bovespa._plugin_.Highcharts.theme = {
                                        colors: ["black", "#8085e9", "#8d4654", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
                                            "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
                                        chart: {
                                            backgroundColor: 'white',
                                            style: {
                                                fontFamily: "Signika, serif"
                                            }
                                        },
                                        title: {
                                            style: {
                                                color: 'black',
                                                fontSize: '16px',
                                                fontWeight: 'bold'
                                            }
                                        },
                                        subtitle: {
                                            style: {
                                                color: 'black'
                                            }
                                        },
                                        tooltip: {
                                            borderWidth: 0
                                        },
                                        legend: {
                                            itemStyle: {
                                                fontWeight: 'bold',
                                                fontSize: '13px'
                                            }
                                        },
                                        xAxis: {
                                            labels: {
                                                style: {
                                                    color: '#6e6e70'
                                                }
                                            }
                                        },
                                        yAxis: {
                                            labels: {
                                                style: {
                                                    color: '#6e6e70'
                                                }
                                            }
                                        },
                                        plotOptions: {
                                            series: {
                                                shadow: true
                                            },
                                            candlestick: {
                                                lineColor: '#404048'
                                            },
                                            map: {
                                                shadow: false
                                            }
                                        },
                                        // Highstock specific
                                        navigator: {
                                            xAxis: {
                                                gridLineColor: '#D0D0D8'
                                            }
                                        },
                                        rangeSelector: {
                                            buttonTheme: {
                                                fill: 'white',
                                                stroke: '#C0C0C8',
                                                'stroke-width': 1,
                                                states: {
                                                    select: {
                                                        fill: '#D0D0D8'
                                                    }
                                                }
                                            }
                                        },
                                        scrollbar: {
                                            trackBorderColor: '#C0C0C8'
                                        },
                                        // General
                                        background2: '#E0E0E8'

                                    };
                                    bovespa._plugin_.Highcharts.setOptions(bovespa._plugin_.Highcharts.theme);

                                    bovespa._plugin_.JQuery('#card-graphic-pme').highcharts({
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
                                            plotLines: model.pme().plotLines()
                                        },
                                        series: model.pme().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-pmr').highcharts({
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
                                            plotLines: model.pmr().plotLines()
                                        },
                                        series: model.pmr().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-pmp').highcharts({
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
                                            plotLines: model.pmp().plotLines()
                                        },
                                        series: model.pmp().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-cf').highcharts({
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
                                            plotLines: model.cf().plotLines()
                                        },
                                        series: model.cf().results()
                                    });
                                    bovespa._plugin_.JQuery('#card-graphic-co').highcharts({
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
                                            plotLines: model.co().plotLines()
                                        },
                                        series: model.co().results()
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

                                    bovespa.JLib(this.self).tost({text: 'Prazos médios calculados!'});
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




                                                    if (_analysis.max.value < _indicator) {
                                                        _analysis.max.value = _indicator;
                                                        _analysis.max.year = _year;
                                                    }
                                                    if (_analysis.min.value > _indicator) {
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
                                                _situation = " <p style='display: block;'>A situação melhouro " + _analysis.max.year + "/" + _analysis.min.year + ". Pois em " + _analysis.min.year + " a empresa conseguiu vender os produtos estocados em até " + _analysis.min.value + " dias e " + (_analysis.max.value - _analysis.min.value) + " dias antes do ano anterior. </p> ";
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
                                                _situation = " <p style='display: block;'>A situação melhouro " + _analysis.max.year + "/" + _analysis.min.year + ". Pois em " + _analysis.min.year + " a empresa conseguiu receber as vendas a prazo de clientes " + _analysis.min.value + " dias e " + (_analysis.max.value - _analysis.min.value) + " dias antes do ano anterior. </p> ";
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
                                                _situation = " <p style='display: block;'>A situação melhouro " + _analysis.max.year + "/" + _analysis.min.year + ". Pois em " + _analysis.min.year + " a empresa conseguia receber as vendas a prazo de clientes " + (_analysis.max.value - _analysis.min.value) + " dias antes. </p> ";
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
                                            if (_analysis.min.year < _analysis.max.year) {
                                                _situation = " <p >A situação piorou " + _analysis.min.year + "/" + _analysis.max.year + ". <br> Pois em " + _analysis.min.year + " a empresa conseguia receber as vendas a prazo de clientes em até " + (_analysis.min.value < 0 ? (_analysis.min.value * -1) + " dias antes" : _analysis.min.value + " dias depois") + " que as dividas com fornecedores vencecem. </p> ";
                                            } else {
                                                _situation = "<p>";
                                                _situation += " A situação melhouro " + _analysis.max.year + "/" + _analysis.min.year + ".";
                                                _situation += " <br>No ano de " + _analysis.min.year + " a empresa conseguiu receber as vendas a prazo de clientes " + (_analysis.min.value < 0 ? (_analysis.min.value * -1) + " dias antes" : _analysis.min.value + " dias depois") + " que as dividas com fornecedores vencecem.";
                                                _situation += " <br>No ano de " + _analysis.max.year + " recebia " + (_analysis.max.value - _analysis.min.value) + " dias depois se comparado a " + _analysis.min.year + ". </p> ";
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
                }
            });
        }
    }
});
