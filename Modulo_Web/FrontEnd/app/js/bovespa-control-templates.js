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
                    class: ['s-uppercase', 's-size'],
                    data: bovespa.memory({
                        proxy: {
                            url: 'app/json/company.json',
                            root: 'data'
                        }
                    }),
                    displayMember: 'company-name',
                    valueMember: 'company-id',
                    classMember: ['s-uppercase', 's-size-14']
                });
                bovespa.menu.register([{
                        name: 'bovespa-company-proceed',
                        attach: bovespa.$('.bovespa'),
                        action: function (e) {
                            bovespa.cookie(bovespa.component.get('select-company').selectedItem());
                            if (bovespa.cookie.exists('company-name')) {
                                bovespa.view.pages.Home(bovespa.view, bovespa.control);
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
                Ext.define('Account_model', {
                    extend: 'Ext.data.Model',
                    fields: [
                        {name: 'year', type: 'string'},
                        {name: 'result', type: 'float'}
                    ]
                });
                var Account_model;
                model.each(function () {
                    var data = this;
                    Account_model = Ext.create('Ext.data.Store', {
                        id: "Account_store",
                        model: "Account_model",
                        autoLoad: false,
                        data: data.get('PCT')
                    });
                });
                bovespa.component({
                    type: 'chart',
                    renderTo: 'graphic-pct',
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
                                fields: ['result'],
                                animate: true,
                                label: {
                                    renderer: Ext.util.Format.numberRenderer('0.00,0')
                                },
                                grid: true
                            }, {
                                type: 'Category',
                                position: 'bottom',
                                fields: ['year'],
                                label: {
                                    rotate: {
                                        degrees: -45
                                    }
                                }
                            }],
                        series: [{
                                type: 'column',
                                axis: 'left',
                                highlight: true,
                                label: {
                                    display: 'insideEnd',
                                    'text-anchor': 'middle',
                                    field: 'size',
                                    renderer: Ext.util.Format.numberRenderer('0,0'),
                                    orientation: 'vertical',
                                    color: 'orange'
                                },
                                xField: 'year',
                                yField: 'result',
                                fill: true,
                                style: {
                                    stroke: 'rgb(255, 255, 255)',
                                    'stroke-width': 1,
                                    fill: 'rgb(255, 255, 255)'
                                },
                                tips: {
                                    trackMouse: true,
                                    width: 140,
                                    height: 50,
                                    layout: 'fit',
                                    renderer: function (storeItem, item) {

                                        // calculate and display percentage on hover
                                        var total = 0;
                                        Account_model.each(function (rec) {
                                            total += rec.get('result');
                                        });

                                        // change panel header
                                        this.setTitle(storeItem.get('year'));

                                        // change panel body              
                                        this.update(
                                                Math.round(storeItem.get('result') / total * 100) + '%'
                                                );

                                        this.update('<div  class="s-card-400 s-md-col-12">' +
                                                '<div  class="s-card-vertical ">' +
                                                '<div class="s-card-body s-card-content-100 s-md-back-Orange-400" id="graphic-ipl">   ffffff'  +
                                                '</div>' +
                                                '</div>' +
                                                '</div>');
                                    }
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
                    type: 'chart',
                    tType: 'line',
                    renderTo: 'graphic-ce',
                    Ext: {
                        animate: true,
                        shadow: false,
                        height: 280,
                        width: 370,
                        store: Account_model,
                        axes: [{
                                type: 'Numeric',
                                minimum: 0,
                                position: 'left',
                                fields: ['result'],
                                minorTickSteps: 2,
                                grid: true,
                                animate: true
                            }, {
                                type: 'Category',
                                position: 'bottom',
                                fields: ['year'],
                                label: {
                                    rotate: {
                                        degrees: -45
                                    }
                                }
                            }],
                        series: [{
                                type: 'line',
                                axis: 'left',
                                highlight: true,
                                label: {
                                    display: 'insideEnd',
                                    'text-anchor': 'middle',
                                    field: 'size',
                                    renderer: Ext.util.Format.numberRenderer('0,0'),
                                    orientation: 'vertical',
                                    color: 'orange'
                                },
                                xField: 'year',
                                yField: 'result',
                                fill: true,
                                markerConfig: {
                                    radius: 5,
                                    size: 5,
                                    type: 'square',
                                    fx: {
                                        duration: 200,
                                        easing: 'backOut'
                                    }
                                },
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



            }
        },
        control: {
            url: 'app/views/indebtedness.html'
        },
        model: bovespa.memory({
            proxy: {
                url: 'app/json/bovespa.json?vr00',
                root: 'data.0'
            }
        })
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
