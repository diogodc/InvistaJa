bovespa.object.extend(bovespa, {
    config: {
        responsive: {
            'min-width': 367,
            'med-width': 689
        },
        chart: {
            theme: {
                Cyan: {
                    line: {
                        scaleShowGridLines: true, ///Boolean - Whether grid lines are shown across the chart
                        scaleGridLineColor: "rgba(255,255,255,0.4)", //String - Colour of the grid lines
                        scaleGridLineWidth: 1, //Number - Width of the grid lines
                        scaleShowHorizontalLines: true, //Boolean - Whether to show horizontal lines (except X axis)
                        scaleShowVerticalLines: false, //Boolean - Whether to show vertical lines (except Y axis)
                        bezierCurve: true, //Boolean - Whether the line is curved between points
                        bezierCurveTension: 0.4, //Number - Tension of the bezier curve between points
                        pointDot: true, //Boolean - Whether to show a dot for each point
                        pointDotRadius: 5, //Number - Radius of each point dot in pixels
                        pointDotStrokeWidth: 2, //Number - Pixel width of point dot stroke
                        pointHitDetectionRadius: 20, //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                        datasetStroke: true, //Boolean - Whether to show a stroke for datasets
                        datasetStrokeWidth: 3, //Number - Pixel width of dataset stroke
                        datasetFill: true, //Boolean - Whether to fill the dataset with a colour
                        animationSteps: 15, // Number - Number of animation steps
                        animationEasing: "easeOutQuart", // String - Animation easing effect
                        tooltipTitleFontFamily: "'Roboto','Helvetica Neue', 'Helvetica', 'Arial', sans-serif", // String - Tooltip title font declaration for the scale label
                        scaleFontSize: 12, // Number - Scale label font size in pixels
                        scaleFontStyle: "normal", // String - Scale label font weight style
                        scaleFontColor: "#fff", // String - Scale label font colour
                        tooltipEvents: ["mousemove", "touchstart", "touchmove"], // Array - Array of string names to attach tooltip events
                        tooltipFillColor: "rgba(255,255,255,0.8)", // String - Tooltip background colour
                        tooltipFontSize: 12, // Number - Tooltip label font size in pixels
                        tooltipFontColor: "#000", // String - Tooltip label font colour
                        tooltipTitleFontSize: 14, // Number - Tooltip title font size in pixels
                        tooltipTitleFontStyle: "bold", // String - Tooltip title font weight style
                        tooltipTitleFontColor: "#000", // String - Tooltip title font colour
                        tooltipYPadding: 8, // Number - pixel width of padding around tooltip text
                        tooltipXPadding: 16, // Number - pixel width of padding around tooltip text
                        tooltipCaretSize: 10, // Number - Size of the caret on the tooltip
                        tooltipCornerRadius: 6, // Number - Pixel radius of the tooltip border
                        tooltipXOffset: 10, // Number - Pixel offset from point x to tooltip edge
                        responsive: true
                    }
                },
                Green: {
                    line: {
                        scaleShowGridLines: true, ///Boolean - Whether grid lines are shown across the chart
                        scaleGridLineColor: "rgba(255,255,255,0.4)", //String - Colour of the grid lines
                        scaleGridLineWidth: 1, //Number - Width of the grid lines
                        scaleShowHorizontalLines: true, //Boolean - Whether to show horizontal lines (except X axis)
                        scaleShowVerticalLines: false, //Boolean - Whether to show vertical lines (except Y axis)
                        bezierCurve: true, //Boolean - Whether the line is curved between points
                        bezierCurveTension: 0.4, //Number - Tension of the bezier curve between points
                        pointDot: true, //Boolean - Whether to show a dot for each point
                        pointDotRadius: 5, //Number - Radius of each point dot in pixels
                        pointDotStrokeWidth: 2, //Number - Pixel width of point dot stroke
                        pointHitDetectionRadius: 20, //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                        datasetStroke: true, //Boolean - Whether to show a stroke for datasets
                        datasetStrokeWidth: 3, //Number - Pixel width of dataset stroke
                        datasetFill: true, //Boolean - Whether to fill the dataset with a colour
                        animationSteps: 15, // Number - Number of animation steps
                        animationEasing: "easeOutQuart", // String - Animation easing effect
                        tooltipTitleFontFamily: "'Roboto','Helvetica Neue', 'Helvetica', 'Arial', sans-serif", // String - Tooltip title font declaration for the scale label
                        scaleFontSize: 12, // Number - Scale label font size in pixels
                        scaleFontStyle: "normal", // String - Scale label font weight style
                        scaleFontColor: "#fff", // String - Scale label font colour
                        tooltipEvents: ["mousemove", "touchstart", "touchmove"], // Array - Array of string names to attach tooltip events
                        tooltipFillColor: "rgba(255,255,255,0.8)", // String - Tooltip background colour
                        tooltipFontSize: 12, // Number - Tooltip label font size in pixels
                        tooltipFontColor: "#000", // String - Tooltip label font colour
                        tooltipTitleFontSize: 14, // Number - Tooltip title font size in pixels
                        tooltipTitleFontStyle: "bold", // String - Tooltip title font weight style
                        tooltipTitleFontColor: "#000", // String - Tooltip title font colour
                        tooltipYPadding: 8, // Number - pixel width of padding around tooltip text
                        tooltipXPadding: 16, // Number - pixel width of padding around tooltip text
                        tooltipCaretSize: 10, // Number - Size of the caret on the tooltip
                        tooltipCornerRadius: 6, // Number - Pixel radius of the tooltip border
                        tooltipXOffset: 10, // Number - Pixel offset from point x to tooltip edge
                        responsive: true
                    },
                    bar: {
                    }
                },
                Orange: {
                    line: {
                        scaleShowGridLines: true, ///Boolean - Whether grid lines are shown across the chart
                        scaleGridLineColor: "rgba(255,255,255,0.4)", //String - Colour of the grid lines
                        scaleGridLineWidth: 1, //Number - Width of the grid lines
                        scaleShowHorizontalLines: true, //Boolean - Whether to show horizontal lines (except X axis)
                        scaleShowVerticalLines: false, //Boolean - Whether to show vertical lines (except Y axis)
                        bezierCurve: true, //Boolean - Whether the line is curved between points
                        bezierCurveTension: 0.4, //Number - Tension of the bezier curve between points
                        pointDot: true, //Boolean - Whether to show a dot for each point
                        pointDotRadius: 5, //Number - Radius of each point dot in pixels
                        pointDotStrokeWidth: 2, //Number - Pixel width of point dot stroke
                        pointHitDetectionRadius: 20, //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                        datasetStroke: true, //Boolean - Whether to show a stroke for datasets
                        datasetStrokeWidth: 3, //Number - Pixel width of dataset stroke
                        datasetFill: true, //Boolean - Whether to fill the dataset with a colour
                        animationSteps: 15, // Number - Number of animation steps
                        animationEasing: "easeOutQuart", // String - Animation easing effect
                        tooltipTitleFontFamily: "'Roboto','Helvetica Neue', 'Helvetica', 'Arial', sans-serif", // String - Tooltip title font declaration for the scale label
                        scaleFontSize: 12, // Number - Scale label font size in pixels
                        scaleFontStyle: "normal", // String - Scale label font weight style
                        scaleFontColor: "#fff", // String - Scale label font colour
                        tooltipEvents: ["mousemove", "touchstart", "touchmove"], // Array - Array of string names to attach tooltip events
                        tooltipFillColor: "rgba(255,255,255,0.8)", // String - Tooltip background colour
                        tooltipFontSize: 12, // Number - Tooltip label font size in pixels
                        tooltipFontColor: "#000", // String - Tooltip label font colour
                        tooltipTitleFontSize: 14, // Number - Tooltip title font size in pixels
                        tooltipTitleFontStyle: "bold", // String - Tooltip title font weight style
                        tooltipTitleFontColor: "#000", // String - Tooltip title font colour
                        tooltipYPadding: 8, // Number - pixel width of padding around tooltip text
                        tooltipXPadding: 16, // Number - pixel width of padding around tooltip text
                        tooltipCaretSize: 10, // Number - Size of the caret on the tooltip
                        tooltipCornerRadius: 6, // Number - Pixel radius of the tooltip border
                        tooltipXOffset: 10, // Number - Pixel offset from point x to tooltip edge
                        responsive: true
                    },
                    bar: {
                        colors: ["red", "red", "red", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
                            "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
                        chart: {
                            backgroundColor: {
                                linearGradient: [],
                                stops: [
                                    [0, 'rgb(255, 255, 255)'],
                                    [1, 'rgb(0, 0, 0)']
                                ]
                            },
                            borderColor: '#000000',
                            borderWidth: 2,
                            className: 'dark-container',
                            plotBackgroundColor: 'rgba(255, 255, 255, .1)',
                            plotBorderColor: '#CCCCCC',
                            plotBorderWidth: 1
                        },
                        title: {
                            style: {
                                color: '#C0C0C0',
                                font: 'bold 16px "Trebuchet MS", Verdana, sans-serif'
                            }
                        },
                        subtitle: {
                            style: {
                                color: '#666666',
                                font: 'bold 12px "Trebuchet MS", Verdana, sans-serif'
                            }
                        },
                        xAxis: {
                            gridLineColor: '#333333',
                            gridLineWidth: 1,
                            labels: {
                                style: {
                                    color: '#A0A0A0'
                                }
                            },
                            lineColor: '#A0A0A0',
                            tickColor: '#A0A0A0',
                            title: {
                                style: {
                                    color: '#CCC',
                                    fontWeight: 'bold',
                                    fontSize: '12px',
                                    fontFamily: 'Trebuchet MS, Verdana, sans-serif'

                                }
                            }
                        },
                        yAxis: {
                            gridLineColor: '#333333',
                            labels: {
                                style: {
                                    color: '#A0A0A0'
                                }
                            },
                            lineColor: '#A0A0A0',
                            minorTickInterval: null,
                            tickColor: '#A0A0A0',
                            tickWidth: 1,
                            title: {
                                style: {
                                    color: '#CCC',
                                    fontWeight: 'bold',
                                    fontSize: '12px',
                                    fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                                }
                            }
                        },
                        tooltip: {
                            backgroundColor: 'rgba(0, 0, 0, 0.75)',
                            style: {
                                color: '#F0F0F0'
                            }
                        },
                        toolbar: {
                            itemStyle: {
                                color: 'silver'
                            }
                        },
                        plotOptions: {
                            line: {
                                dataLabels: {
                                    color: '#CCC'
                                },
                                marker: {
                                    lineColor: '#333'
                                }
                            },
                            spline: {
                                marker: {
                                    lineColor: '#333'
                                }
                            },
                            scatter: {
                                marker: {
                                    lineColor: '#333'
                                }
                            },
                            candlestick: {
                                lineColor: 'white'
                            }
                        },
                        legend: {
                            itemStyle: {
                                font: '9pt Trebuchet MS, Verdana, sans-serif',
                                color: '#A0A0A0'
                            },
                            itemHoverStyle: {
                                color: '#FFF'
                            },
                            itemHiddenStyle: {
                                color: '#444'
                            }
                        },
                        credits: {
                            style: {
                                color: '#666'
                            }
                        },
                        labels: {
                            style: {
                                color: '#CCC'
                            }
                        },
                        navigation: {
                            buttonOptions: {
                                symbolStroke: '#DDDDDD',
                                hoverSymbolStroke: '#FFFFFF',
                                theme: {
                                    fill: {
                                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                        stops: [
                                            [0.4, '#606060'],
                                            [0.6, '#333333']
                                        ]
                                    },
                                    stroke: '#000000'
                                }
                            }
                        },
                        // scroll charts
                        rangeSelector: {
                            buttonTheme: {
                                fill: {
                                    linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                    stops: [
                                        [0.4, '#888'],
                                        [0.6, '#555']
                                    ]
                                },
                                stroke: '#000000',
                                style: {
                                    color: '#CCC',
                                    fontWeight: 'bold'
                                },
                                states: {
                                    hover: {
                                        fill: {
                                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                            stops: [
                                                [0.4, '#BBB'],
                                                [0.6, '#888']
                                            ]
                                        },
                                        stroke: '#000000',
                                        style: {
                                            color: 'white'
                                        }
                                    },
                                    select: {
                                        fill: {
                                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                            stops: [
                                                [0.1, '#000'],
                                                [0.3, '#333']
                                            ]
                                        },
                                        stroke: '#000000',
                                        style: {
                                            color: 'yellow'
                                        }
                                    }
                                }
                            },
                            inputStyle: {
                                backgroundColor: '#333',
                                color: 'silver'
                            },
                            labelStyle: {
                                color: 'silver'
                            }
                        },
                        navigator: {
                            handles: {
                                backgroundColor: '#666',
                                borderColor: '#AAA'
                            },
                            outlineColor: '#CCC',
                            maskFill: 'rgba(16, 16, 16, 0.5)',
                            series: {
                                color: '#7798BF',
                                lineColor: '#A6C7ED'
                            }
                        },
                        scrollbar: {
                            barBackgroundColor: {
                                linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                stops: [
                                    [0.4, '#888'],
                                    [0.6, '#555']
                                ]
                            },
                            barBorderColor: '#CCC',
                            buttonArrowColor: '#CCC',
                            buttonBackgroundColor: {
                                linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                stops: [
                                    [0.4, '#888'],
                                    [0.6, '#555']
                                ]
                            },
                            buttonBorderColor: '#CCC',
                            rifleColor: '#FFF',
                            trackBackgroundColor: {
                                linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                                stops: [
                                    [0, '#000'],
                                    [1, '#333']
                                ]
                            },
                            trackBorderColor: '#666'
                        },
                        // special colors for some of the
                        legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
                        background2: 'rgb(35, 35, 70)',
                        dataLabelsColor: '#444',
                        textColor: '#C0C0C0',
                        maskColor: 'rgba(255,255,255,0.3)'
                    }
                }
            },
            themes: function () {
                return {
                    Profitability: function () {
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
                            colors: ["#8d4654", "#8d4654", "#8d4654"], // "#"
                            chart: {
                                backgroundColor: '#81C784',
                                style: {
                                    fontFamily: "Signika, serif"
                                }
                            },
                            title: {
                                style: {
                                    color: 'white',
                                    fontSize: '16px',
                                    fontWeight: 'bold'
                                }
                            },
                            subtitle: {
                                style: {
                                    color: 'white'
                                }
                            },
                            tooltip: {
                                borderWidth: 0
                            },
                            legend: {
                                itemStyle: {
                                    fontWeight: 'bold',
                                    fontSize: '13px',
                                    color: 'white'
                                }
                            },
                            xAxis: {
                                labels: {
                                    style: {
                                        color: 'white',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            yAxis: {
                                labels: {
                                    style: {
                                        color: 'white',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            plotOptions: {
                                series: {
                                    shadow: true
                                },
                                candlestick: {
                                    lineColor: 'white'
                                },
                                map: {
                                    shadow: false
                                }
                            },
                            // Highstock specific
                            navigator: {
                                xAxis: {
                                    gridLineColor: 'white'
                                }
                            },
                            rangeSelector: {
                                buttonTheme: {
                                    fill: 'white',
                                    stroke: 'white',
                                    'stroke-width': 1,
                                    states: {
                                        select: {
                                            fill: 'white'
                                        }
                                    }
                                }
                            },
                            scrollbar: {
                                trackBorderColor: 'white'
                            },
                            // General
                            background2: 'white'
                        };
                        bovespa._plugin_.Highcharts.setOptions(bovespa._plugin_.Highcharts.theme);
                    },
                    Midterm: function () {
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
                                    fontSize: '13px',
                                    color: 'black'
                                }
                            },
                            xAxis: {
                                labels: {
                                    style: {
                                        color: 'black',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            yAxis: {
                                labels: {
                                    style: {
                                        color: 'black',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            plotOptions: {
                                series: {
                                    shadow: true
                                },
                                candlestick: {
                                    lineColor: 'black'
                                },
                                map: {
                                    shadow: false
                                }
                            },
                            // Highstock specific
                            navigator: {
                                xAxis: {
                                    gridLineColor: 'black'
                                }
                            },
                            rangeSelector: {
                                buttonTheme: {
                                    fill: 'black',
                                    stroke: 'black',
                                    'stroke-width': 1,
                                    states: {
                                        select: {
                                            fill: 'black'
                                        }
                                    }
                                }
                            },
                            scrollbar: {
                                trackBorderColor: 'black'
                            },
                            // General
                            background2: 'black'

                        };
                        bovespa._plugin_.Highcharts.setOptions(bovespa._plugin_.Highcharts.theme);
                    },
                    Liquidity: function () {
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
                    },
                    Indebtedness: function () {
                        return {
                            Pct: function () {
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
                                    colors: ["rgba(128, 222, 234, 0.6)", "rgba(128, 222, 234, 0.3)"],
                                    chart: {
                                        backgroundColor: '#0097A7',
                                        style: {
                                            fontFamily: "'Unica One', sans-serif"
                                        },
                                        plotBorderColor: '#606063'
                                    }, title: {
                                        style: {
                                            color: 'white',
                                            fontSize: '16px',
                                            fontWeight: 'bold'
                                        }
                                    },
                                    subtitle: {
                                        style: {
                                            color: 'white'
                                        }
                                    },
                                    tooltip: {
                                        borderWidth: 0
                                    },
                                    legend: {
                                        itemStyle: {
                                            fontWeight: 'bold',
                                            fontSize: '13px',
                                            color: 'white'
                                        }
                                    },
                                    xAxis: {
                                        labels: {
                                            style: {
                                                color: 'white',
                                                fontWeight: 'bold'
                                            }
                                        }
                                    },
                                    yAxis: {
                                        labels: {
                                            style: {
                                                color: 'white',
                                                fontWeight: 'bold'
                                            }
                                        }
                                    },
                                    plotOptions: {
                                        series: {
                                            shadow: true
                                        },
                                        candlestick: {
                                            lineColor: 'white'
                                        },
                                        map: {
                                            shadow: false
                                        }
                                    },
                                    // Highstock specific
                                    navigator: {
                                        xAxis: {
                                            gridLineColor: 'white'
                                        }
                                    },
                                    rangeSelector: {
                                        buttonTheme: {
                                            fill: 'white',
                                            stroke: 'white',
                                            'stroke-width': 1,
                                            states: {
                                                select: {
                                                    fill: 'white'
                                                }
                                            }
                                        }
                                    },
                                    scrollbar: {
                                        trackBorderColor: 'white'
                                    },
                                    // General
                                    background2: 'white'

                                };
                                bovespa._plugin_.Highcharts.setOptions(bovespa._plugin_.Highcharts.theme);
                            },
                             Ce: function () {
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
                                    colors: ["rgba(234, 208, 128, 0.6)", "rgba(234, 208, 128, 0.3)"],
                                    chart: {
                                        backgroundColor: '#F57C00',
                                        style: {
                                            fontFamily: "'Unica One', sans-serif"
                                        },
                                        plotBorderColor: '#606063'
                                    }, title: {
                                        style: {
                                            color: 'white',
                                            fontSize: '16px',
                                            fontWeight: 'bold'
                                        }
                                    },
                                    subtitle: {
                                        style: {
                                            color: 'white'
                                        }
                                    },
                                    tooltip: {
                                        borderWidth: 0
                                    },
                                    legend: {
                                        itemStyle: {
                                            fontWeight: 'bold',
                                            fontSize: '13px',
                                            color: 'white'
                                        }
                                    },
                                    xAxis: {
                                        labels: {
                                            style: {
                                                color: 'white',
                                                fontWeight: 'bold'
                                            }
                                        }
                                    },
                                    yAxis: {
                                        labels: {
                                            style: {
                                                color: 'white',
                                                fontWeight: 'bold'
                                            }
                                        }
                                    },
                                    plotOptions: {
                                        series: {
                                            shadow: true
                                        },
                                        candlestick: {
                                            lineColor: 'white'
                                        },
                                        map: {
                                            shadow: false
                                        }
                                    },
                                    // Highstock specific
                                    navigator: {
                                        xAxis: {
                                            gridLineColor: 'white'
                                        }
                                    },
                                    rangeSelector: {
                                        buttonTheme: {
                                            fill: 'white',
                                            stroke: 'white',
                                            'stroke-width': 1,
                                            states: {
                                                select: {
                                                    fill: 'white'
                                                }
                                            }
                                        }
                                    },
                                    scrollbar: {
                                        trackBorderColor: 'white'
                                    },
                                    // General
                                    background2: 'white'

                                };
                                bovespa._plugin_.Highcharts.setOptions(bovespa._plugin_.Highcharts.theme);
                            },
                            Ipl:function(){
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
                                    colors: ["rgba(255, 255, 255, 0.6)", "rgba(234, 208, 128, 0.3)"],
                                    chart: {
                                        backgroundColor: '#7B1FA2',
                                        style: {
                                            fontFamily: "'Unica One', sans-serif"
                                        },
                                        plotBorderColor: '#606063'
                                    }, title: {
                                        style: {
                                            color: 'white',
                                            fontSize: '16px',
                                            fontWeight: 'bold'
                                        }
                                    },
                                    subtitle: {
                                        style: {
                                            color: 'white'
                                        }
                                    },
                                    tooltip: {
                                        borderWidth: 0
                                    },
                                    legend: {
                                        itemStyle: {
                                            fontWeight: 'bold',
                                            fontSize: '13px',
                                            color: 'white'
                                        }
                                    },
                                    xAxis: {
                                        labels: {
                                            style: {
                                                color: 'white',
                                                fontWeight: 'bold'
                                            }
                                        }
                                    },
                                    yAxis: {
                                        labels: {
                                            style: {
                                                color: 'white',
                                                fontWeight: 'bold'
                                            }
                                        }
                                    },
                                    plotOptions: {
                                        series: {
                                            shadow: true
                                        },
                                        candlestick: {
                                            lineColor: 'white'
                                        },
                                        map: {
                                            shadow: false
                                        }
                                    },
                                    // Highstock specific
                                    navigator: {
                                        xAxis: {
                                            gridLineColor: 'white'
                                        }
                                    },
                                    rangeSelector: {
                                        buttonTheme: {
                                            fill: 'white',
                                            stroke: 'white',
                                            'stroke-width': 1,
                                            states: {
                                                select: {
                                                    fill: 'white'
                                                }
                                            }
                                        }
                                    },
                                    scrollbar: {
                                        trackBorderColor: 'white'
                                    },
                                    // General
                                    background2: 'white'

                                };
                                bovespa._plugin_.Highcharts.setOptions(bovespa._plugin_.Highcharts.theme);
                            }
                        };
                    }
                };
            }
        }
    }
});
