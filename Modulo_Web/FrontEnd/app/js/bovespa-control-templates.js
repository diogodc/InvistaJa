/*
 *
 */
bovespa.template.register([
    {
        'name': 'bovespa-home',
        view: {
            self: '.bovespa'
        },
        control: {
            url: 'app/views/main.html',
            dependencies: function (view, model, callback) {
                bovespa.menu.register([{
                        name: 'bovespa-mun-hidden',
                        attach: bovespa.view.main,
                        checked: false,
                        action: function (e) {
                            bovespa.control.menu.main[this.name].action.call(this, e);
                        }
                    }]).register([{
                        name: 'bovespa-indebtedness',
                        attach: bovespa.view.main,
                        action: function (e) {
                            bovespa.control.menu.main[this.name].action.call(this, e);
                        }
                    }]).register([{
                        name: 'bovespa-liquidity',
                        attach: bovespa.view.main,
                        action: function (e) {
                            bovespa.control.menu.main[this.name].action.call(this, e);
                        }
                    }]).register([{
                        name: 'bovespa-profitability',
                        attach: bovespa.view.main,
                        action: function (e) {
                            bovespa.control.menu.main[this.name].action.call(this, e);
                        }
                    }]).register([{
                        name: 'bovespa-midterm',
                        attach: bovespa.view.main,
                        action: function (e) {
                            bovespa.control.menu.main[this.name].action.call(this, e);
                        }
                    }]);

                bovespa.menu.get('bovespa-indebtedness').action();
            },
            init: function (view, model, callback) {
                this.render(view, this, model, function () {
                    this.dependencies.call(this, view, model);
                    callback.call(this, view, model);
                });
            }
        }
    }
]).register([
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
                    data: bovespa.memory({
                        proxy: {
                            url: 'app/json/company.json',
                            root: 'data'
                        }
                    }),
                    searchSensitive: false,
                    displayMember: 'company-name',
                    classMember: ['', 's-size-15']
                });
                bovespa.menu.register([{
                        name: 'bovespa-company-proceed',
                        attach: bovespa.$('.bovespa'),
                        action: function (e) {
                            var dt = bovespa.component.get('select-company').selectedItem();
                            if (dt !== null) {
                                bovespa.cookie(dt);
                                if (bovespa.cookie.exists('company-name')) {
                                    bovespa.view.pages.Home(bovespa.view, bovespa.control);
                                }
                            }
                        }
                    }]);
            }
        },
        control: {
            url: 'app/views/company.html'
        }

    }
]).register([
    {
        'name': 'bovespa-indebtedness',
        view: {
            self: '.s-body-content',
            render: function (model) {

                bovespa.$(this.self).mask();
                var dataModelPCT
                        , dataModelMPCT
                        , mPCT;

                dataModelPCT = bovespa.memory({
                    model: {
                        fields: [{name: 'year'}, {name: 'result'}]
                    },
                    data: model.toArray().get('PCT')[0]
                });
                dataModelMPCT = bovespa.memory({
                    model: dataModelPCT.model,
                    data: []
                });
                mPCT = dataModelPCT.sum('result') / dataModelPCT.count();

                dataModelMPCT.data = [];
                dataModelPCT.each(function () {
                    var data = this;
                    dataModelMPCT.data.push({'year': data.get('year'), 'result': mPCT, 'result-year': data.get('result')});
                });

                var dataModelCE
                        , dataModelMCE
                        , mCE;

                dataModelCE = bovespa.memory({
                    model: {
                        fields: [{name: 'year'}, {name: 'result'}]
                    },
                    data: model.toArray().get('CE')[0]
                });
                dataModelMCE = bovespa.memory({
                    model: dataModelCE.model,
                    data: []
                });
                mCE = dataModelCE.sum('result') / dataModelCE.count();
                dataModelMCE.data = [];
                dataModelCE.each(function () {
                    var data = this;
                    dataModelMCE.data.push({'year': data.get('year'), 'result': mCE, 'result-year': data.get('result')});
                });

                this['inject-json']({
                    bovespa: {
                        'indebtedness': {
                            pct: Number(mPCT).formatMoney(2, ',', '.') + '%',
                            ce: Number(mCE).formatMoney(2, ',', '.') + '%',
                            ipl: Number(mCE).formatMoney(2, ',', '.') + '%'
                        }
                    }
                });


                bovespa.component({
                    type: 'chart',
                    tType: 'line',
                    model: [dataModelPCT, dataModelMPCT],
                    label: 'year',
                    values: 'result',
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
                bovespa.component({
                    type: 'table',
                    renderTo: 'table-pct',
                    columns: [
                        {
                            'data-name': 'year',
                            title: {
                                text: 'Ano'
                            }
                        },
                        {
                            'data-name': 'result-year',
                            title: {
                                text: 'Indice'
                            },
                            render: function (val) {
                                return Number(val).formatMoney(3, ',', '.') + '%';
                            }
                        },
                        {
                            'data-name': 'result',
                            title: {
                                text: 'Indice Médio'
                            },
                            render: function (val) {
                                return Number(val).formatMoney(3, ',', '.') + '%';
                            }
                        }
                    ],
                    model: dataModelMPCT
                });

                bovespa.component({
                    type: 'chart',
                    tType: 'bar',
                    model: [dataModelCE, dataModelMCE],
                    label: 'year',
                    values: 'result',
                    renderTo: '#graphic-ce',
                    configs: {
                        options: {
                            seriesBarDistance: 10
                        },
                        responsiveOptions: [
                            ['screen and (max-width: 640px)', {
                                    seriesBarDistance: 12,
                                    axisX: {
                                        labelInterpolationFnc: function (value) {
                                            return value[0];
                                        }
                                    }
                                }]
                        ]

                    }

                });
                bovespa.component({
                    type: 'table',
                    renderTo: 'table-ce',
                    columns: [
                        {
                            'data-name': 'year',
                            title: {
                                text: 'Ano'
                            }
                        },
                        {
                            'data-name': 'result-year',
                            title: {
                                text: 'Indice'
                            },
                            render: function (val) {
                                return Number(val).formatMoney(3, ',', '.') + '%';
                            }
                        },
                        {
                            'data-name': 'result',
                            title: {
                                text: 'Indice Médio'
                            },
                            render: function (val) {
                                return Number(val).formatMoney(3, ',', '.') + '%';
                            }
                        }
                    ],
                    model: dataModelMCE
                });
                bovespa.component({
                    type: 'table',
                    renderTo: 'table-ipl',
                    columns: [
                        {
                            'data-name': 'year',
                            title: {
                                text: 'Ano'
                            }
                        },
                        {
                            'data-name': 'result-year',
                            title: {
                                text: 'Indice'
                            },
                            render: function (val) {
                                return Number(val).formatMoney(3, ',', '.') + '%';
                            }
                        },
                        {
                            'data-name': 'result',
                            title: {
                                text: 'Indice Médio'
                            },
                            render: function (val) {
                                return Number(val).formatMoney(3, ',', '.') + '%';
                            }
                        }
                    ],
                    model: dataModelMCE
                });

                bovespa.menu.register([{
                        name: 'bovespa-indebtedness-pct',
                        attach: bovespa.$('.bovespa'),
                        hidden: false,
                        action: function (e) {
                            var css = 'position:fixed;visibility: hidden;top:-1px;';
                            if (this.hidden) {
                                this.hidden = false;
                                bovespa.$('#card-graphic-pct').attr('style', css);
                                bovespa.$('#card-table-pct').attr('style', '');
                            } else {
                                this.hidden = true;
                                bovespa.$('#card-table-pct').attr('style', css);
                                bovespa.$('#card-graphic-pct').attr('style', '');
                            }
                        }
                    }]);
                bovespa.menu.register([{
                        name: 'bovespa-indebtedness-ce',
                        attach: bovespa.$('.bovespa'),
                        hidden: false,
                        action: function (e) {
                            var css = 'position:fixed;visibility: hidden;top:-1px;';
                            if (this.hidden) {
                                this.hidden = false;
                                bovespa.$('#card-graphic-ce').attr('style', css);
                                bovespa.$('#card-table-ce').attr('style', '');
                            } else {
                                this.hidden = true;
                                bovespa.$('#card-table-ce').attr('style', css);
                                bovespa.$('#card-graphic-ce').attr('style', '');
                            }
                        }
                    }]);
                bovespa.menu.register([{
                        name: 'bovespa-indebtedness-ipl',
                        attach: bovespa.$('.bovespa'),
                        hidden: false,
                        action: function (e) {
                            var css = 'position:fixed;visibility: hidden;top:-1px;';
                            if (this.hidden) {
                                this.hidden = false;
                                bovespa.$('#card-graphic-ipl').attr('style', css);
                                bovespa.$('#card-table-ipl').attr('style', '');
                            } else {
                                this.hidden = true;
                                bovespa.$('#card-table-ipl').attr('style', css);
                                bovespa.$('#card-graphic-ipl').attr('style', '');
                            }
                        }
                    }]);


                bovespa.menu.get('bovespa-indebtedness-pct').action();
                bovespa.menu.get('bovespa-indebtedness-ce').action();
                bovespa.menu.get('bovespa-indebtedness-ipl').action();

                var day_data = [
                    {"period": "2012-10-01", "licensed": 3407, "sorned": 660},
                    {"period": "2012-09-30", "licensed": 3351, "sorned": 629},
                    {"period": "2012-09-29", "licensed": 3269, "sorned": 618},
                    {"period": "2012-09-20", "licensed": 3246, "sorned": 661},
                    {"period": "2012-09-19", "licensed": 3257, "sorned": 667},
                    {"period": "2012-09-18", "licensed": 3248, "sorned": 627},
                    {"period": "2012-09-17", "licensed": 3171, "sorned": 660},
                    {"period": "2012-09-16", "licensed": 3171, "sorned": 676},
                    {"period": "2012-09-15", "licensed": 3201, "sorned": 656},
                    {"period": "2012-09-10", "licensed": 3215, "sorned": 622}
                ];
                Morris.Bar({
                    element: 'graphic-ipl',
                    data: day_data,
                    xkey: 'period',
                    ykeys: ['licensed', 'sorned'],
                    labels: ['Licensed', 'SORN'],
                    resize: true,
                    barColors: function (row, series, type) {
                        if (type === 'bar') {
                            var red = Math.ceil(255 * row.y / this.ymax);
                            return 'white';
                        } else {
                            return 'white';
                        }
                    }
                });



                bovespa.$(this.self).unmask();
            }
        },
        control: {
            url: 'app/views/indebtedness.html',
            'render-after': function (view, control, model, callback) {

            }
        },
        model: bovespa.memory({
            model: {
                fields: [{name: 'PCT'}, {name: 'CE'}]
            },
            proxy: {
                url: 'app/json/bovespa.json',
                root: 'data.0'
            }
        })
    }
]).register([
    {
        'name': 'bovespa-liquidity',
        view: {
            self: '.s-body-content',
            render: function (model) {

            }
        },
        control: {
            url: 'app/views/liquidity.html',
            'render-after': function (view, control, model, callback) {

            }
        },
        model: bovespa.memory({
            model: {
                fields: [{name: 'PCT'}, {name: 'CE'}]
            },
            proxy: {
                url: 'app/json/bovespa.json',
                root: 'data.0'
            }
        })
    }
]).register([
    {
        'name': 'bovespa-load-json',
        view: {
            self: '.bovespa',
            render: function () {
                bovespa.menu.register([{
                        name: 'bovespa-proceed',
                        attach: bovespa.$('.bovespa'),
                        _json: false,
                        action: function (e) {
                           if(this._json){
                               
                           }else{
                               e.tost({
                                   attr:{
                                      style:'background:white;',
                                      class:'s-size'
                                   },
                                   text:'Arraste ou clique para selecionar um Json!'
                               });
                           }
                        }
                }]);

                bovespa.$("#json-FileFrame").fileFrame({
                    validator: function (File, FileText) {
                        return bovespa.type.isJson(FileText);
                    },
                    load: function (File, FileText) {
                        bovespa.menu.get("bovespa-proceed")._json = true;
                        bovespa.menu.get("bovespa-proceed")._json_text = FileText;
                    },
                    error: function () {
                        bovespa.menu.get("bovespa-proceed")._json = false;
                    },
                    init: function () {   
                        bovespa.menu.get("bovespa-proceed")._json = false;                      
                    }
                });
            }
        },
        control: {
            url: 'app/views/load-json.html'
        }

    }
]).register([
    {
        'name': 'bovespa-main',
        view: {
            self: '.s-body-content'
        },
        control: {
            url: 'app/views/company.html',
            render_page: function (view, model) {
                Ext.define('Account_model', {
                    extend: 'Ext.data.Model',
                    fields: [
                        {name: 'name', type: 'string'},
                        {name: 'min', type: 'string'},
                        {name: 'size', type: 'float'}
                    ]
                });
                var Account_model = Ext.create('Ext.data.Store', {
                    id: "Account_store",
                    model: "Account_model",
                    autoLoad: false,
                    data: [
                        {"name": "ESTOQUE", "size": "35000.89"},
                        {"name": "EDIFICIOS", "size": "46000.0"},
                        {"name": "PATENTES", "size": "40000.0"},
                        {"name": "VEICULOS", "size": "48000.0"}
                    ]

                });

                bovespa.component({
                    type: 'chart',
                    renderTo: 'gra-boop',
                    theme: 'orange',
                    Ext: {
                        animate: true,
                        shadow: false,
                        height: 280,
                        width: 370,
                        store: Account_model,
                        axes: [
                            {
                                type: 'Numeric',
                                position: 'left',
                                fields: ['size'],
                                label: {
                                    renderer: Ext.util.Format.numberRenderer('0,0')
                                },
                                grid: true
                            }, {
                                type: 'Category',
                                position: 'bottom',
                                fields: ['name']
                            }],
                        series: [{
                                type: 'column',
                                axis: 'left',
                                highlight: true,
                                label: {
                                    display: 'insideEnd',
                                    'text-anchor': 'middle',
                                    field: 'size',
                                    renderer: Ext.util.Format.numberRenderer('0.0'),
                                    orientation: 'vertical',
                                    color: 'orange'
                                },
                                xField: 'name',
                                yField: 'size',
                                fill: true,
                                style: {
                                    stroke: 'rgb(255, 255, 255)',
                                    'stroke-width': 1,
                                    fill: 'rgb(255, 255, 255)'
                                },
                                renderer: function (sprite, record, attr, index, store) {
                                    var color = 'rgb(255, 255, 255)';
                                    return Ext.apply(attr, {
                                        fill: color
                                    });
                                }
                            }]
                    }
                });
                bovespa.component({
                    type: 'table',
                    renderTo: 'table',
                    data: {
                        Ext: Account_model
                    },
                    columns: [
                        {
                            'data-name': 'name',
                            title: {
                                text: 'CONTAS'
                            }
                        },
                        {
                            'data-name': 'size',
                            title: {
                                text: 'SALDO'
                            }
                        },
                        {
                            'data-name': 'size',
                            title: {
                                text: 'CATEGORIA'
                            }
                        }
                    ]
                });

            },
            init: function (view, model, callback) {
                this.render(view, this, model, function () {
                    this.render_page.call(this, view, model);
                    callback.call(this, view, model);
                });
            }
        }
    }
]);
