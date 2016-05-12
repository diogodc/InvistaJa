bovespa.object.extend(bovespa, {
    config: {
        responsive: {
            'min-width': 367,
            'med-width': 767
        },
        chart: {
            theme: {
                orange: {
                    name:'orange',
                    baseColor: 'white',
                    color: '#ffab40',
                    odd: {
                        opacity: 1,
                        fill: '#ffab40',
                        stroke: '#ffab40',
                        'stroke-width': 0.4
                    },
                    style: {
                        stroke: 'rgb(255, 255, 255)',
                        'stroke-width': 1,
                        fill: 'rgb(255, 255, 255)'
                    }
                },
                'orange-line': {
                    name:'orange',
                    baseColor: 'white',
                    color: '#ffab40',
                    odd: {
                        opacity: 2.5,
                        fill: '#ffab40',
                        stroke: '#ffab40',
                        'stroke-width': 1
                    },
                    style: {
                        stroke: 'rgb(255, 255, 255)',
                        'stroke-width': 2.2,
                        fill: 'rgb(255, 255, 255)'
                    }
                }
            }
        }
    }
});


Ext.define('Ext.chart.theme.orange', {
    extend: 'Ext.chart.theme.Base',
    constructor: function (config) {
        this.callParent([Ext.apply({
                baseColor: 'rgb(255,255,255,255)'
            }, config)]);
    }
});

Ext.define('Ext.chart.theme.orange', {
    extend: 'Ext.chart.theme.Base',
    constructor: function (config) {
        this.callParent([Ext.apply({
                colors: ["rgb(255,255,255,255)", "#0772A1", "#FFD200", "#D30068", "#7EB12C", "#225E79", "#BFA630", "#9E2862"]
            }, config)]);
    }
});

Ext.define('Ext.chart.theme.orange', {
    extend: 'Ext.chart.theme.Base',
    constructor: function (config) {
        this.callParent([Ext.apply({
                background: false,
                axis: {
                    stroke: bovespa.config.chart.theme.orange.baseColor,
                    'stroke-width': 1
                },
                axisLabelTop: {
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    font: '12px Arial, Helvetica, sans-serif',
                    spacing: 2,
                    padding: 5,
                    renderer: function (v) {
                        return v;
                    }
                },
                axisLabelRight: {
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    font: '12px Arial, Helvetica, sans-serif',
                    spacing: 2,
                    padding: 5,
                    renderer: function (v) {
                        return v;
                    }
                },
                axisLabelBottom: {
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    font: '12px Arial, Helvetica, sans-serif',
                    spacing: 2,
                    padding: 5,
                    renderer: function (v) {
                        return v;
                    }
                },
                axisLabelLeft: {
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    font: '12px Arial, Helvetica, sans-serif',
                    spacing: 2,
                    padding: 5,
                    renderer: function (v) {
                        return v;
                    }
                },
                axisTitleTop: {
                    font: 'bold 18px Arial',
                    fill: bovespa.config.chart.theme.orange.baseColor
                },
                axisTitleRight: {
                    font: 'bold 18px Arial',
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    rotate: {
                        x: 0, y: 0,
                        degrees: 270
                    }
                },
                axisTitleBottom: {
                    font: 'bold 18px Arial',
                    fill: bovespa.config.chart.theme.orange.baseColor
                },
                axisTitleLeft: {
                    font: 'bold 18px Arial',
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    rotate: {
                        x: 0, y: 0,
                        degrees: 270
                    }
                },
                series: {
                    'stroke-width': 0
                },
                seriesLabel: {
                    font: '12px Arial',
                    fill: bovespa.config.chart.theme.orange.baseColor
                },
                marker: {
                    stroke: bovespa.config.chart.theme.orange.baseColor,
                    fill: bovespa.config.chart.theme.orange.baseColor,
                    radius: 3,
                    size: 3
                },
                seriesThemes: [{
                        fill: bovespa.config.chart.theme.orange.baseColor
                    }],
                markerThemes: [{
                        fill: bovespa.config.chart.theme.orange.baseColor,
                        type: 'plus'
                    }, {
                        fill: bovespa.config.chart.theme.orange.baseColor,
                        type: 'cross'
                    }, {
                        fill: bovespa.config.chart.theme.orange.baseColor,
                        type: 'plus'
                    }]
            }, config)]);
    }
});

Ext.define('Ux.responsiveScreen', {
    alias: ['widget.responsiveScreen'],
    extend: 'Ext.Panel',
    plugins: 'responsive',
    anchor: '100% 100%',
    responsiveConfig: {
        landscape: {
            tabPosition: 'left'
        },
        portrait: {
            tabPosition: 'top'
        },
        'width < 768': {
            tabPosition: 'top'

        },
        'width >= 768': {
            tabPosition: 'left'

        }
    }
});

bovespa.object.extend(bovespa.config, {
    mnu: {
        'bovespa-liquidity': {
            items: 3,
            'min-heigt': '3.590em'
        },
        'bovespa-indebtedness': {
            items: 3,
            'min-heigt': '3.590em'
        },
        'bovespa-profitability': {
            items: 4,
            'min-heigt': '3.590em'
        },
        'bovespa-midterm': {
            items: 4,
            'min-heigt': '3.590em'            
        }
    }
});







