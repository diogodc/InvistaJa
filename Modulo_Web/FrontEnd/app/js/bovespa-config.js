/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                            stroke: base_color,
                            'stroke-width': 1
                        },
                        axisLabelTop: {
                            fill: base_color,
                            font: '12px Arial, Helvetica, sans-serif',
                            spacing: 2,
                            padding: 5,
                            renderer: function (v) {
                                return v;
                            }
                        },
                        axisLabelRight: {
                            fill: base_color,
                            font: '12px Arial, Helvetica, sans-serif',
                            spacing: 2,
                            padding: 5,
                            renderer: function (v) {
                                return v;
                            }
                        },
                        axisLabelBottom: {
                            fill: base_color,
                            font: '12px Arial, Helvetica, sans-serif',
                            spacing: 2,
                            padding: 5,
                            renderer: function (v) {
                                return v;
                            }
                        },
                        axisLabelLeft: {
                            fill: base_color,
                            font: '12px Arial, Helvetica, sans-serif',
                            spacing: 2,
                            padding: 5,
                            renderer: function (v) {
                                return v;
                            }
                        },
                        axisTitleTop: {
                            font: 'bold 18px Arial',
                            fill: base_color
                        },
                        axisTitleRight: {
                            font: 'bold 18px Arial',
                            fill: base_color,
                            rotate: {
                                x: 0, y: 0,
                                degrees: 270
                            }
                        },
                        axisTitleBottom: {
                            font: 'bold 18px Arial',
                            fill: base_color
                        },
                        axisTitleLeft: {
                            font: 'bold 18px Arial',
                            fill: base_color,
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
                            fill: base_color
                        },
                        marker: {
                            stroke: base_color,
                            fill: base_color,
                            radius: 3,
                            size: 3
                        },
                        seriesThemes: [{
                                fill: base_color
                            }],
                        markerThemes: [{
                                fill: base_color,
                                type: 'plus'
                            }, {
                                fill: base_color,
                                type: 'cross'
                            }, {
                                fill: base_color,
                                type: 'plus'
                            }]
                    }, config)]);
            }
});
