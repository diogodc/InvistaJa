/**
 * Created by Rafael on 23/03/2016.
 */
var bovespa = core.instance({
    'Api-Version': '1.08',
    'Core-Version': '1.08'
});

bovespa.require.register(
        [
            ['bovespa.JQuery', 'app/plugins/jquery/1.8.2/jquery.min.js'],
            ['bovespa.HighChart', 'app/plugins/HighChart/js/highcharts.js'],
            ['bovespa.HighStock', 'app/plugins/HighStock/highstock.js'],
            ['bovespa.ChartJS', 'app/plugins/chartjs/dist/Chart.min.js'],
            ['bovespa.view', 'app/js/bovespa-view.js'],
            ['bovespa.config', 'app/js/bovespa-config.js'],
            ['bovespa.control', 'app/js/bovespa-control.js'],
            ['bovespa.model', 'app/js/bovespa-model.js']
        ]
        );

bovespa.object.extend(bovespa, {
    name: 'bovespa',
    'render': function () {
        var _control = bovespa.control,
                _view = bovespa.view,
                _model = bovespa.model;
        _control.render(_view, _model);
    }
});

bovespa.onReady(function () {
    bovespa.require([
        'bovespa.JQuery',
//        'bovespa.HighChart',
        'bovespa.HighStock',
        'bovespa.ChartJS',
        'bovespa.config',
        'bovespa.control',
        'bovespa.model',
        'bovespa.view',
        'bovespa.control.template'], function () {
        bovespa.render();
    });
});
