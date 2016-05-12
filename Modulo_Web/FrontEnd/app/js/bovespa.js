/**
 * Created by Rafael on 23/03/2016.
 */
var bovespa = core.instance();

bovespa.require.register(
        [
            ['bovespa.view', './app/js/bovespa-view.js']
                    , ['bovespa.config', './app/js/bovespa-config.js']
                    , ['bovespa.control', './app/js/bovespa-control.js']
                    , ['bovespa.control.template', './app/js/bovespa-control-templates.js']
                    , ['bovespa.control.route', './app/js/bovespa-control-routes.js']

        ]);

bovespa.object.extend(bovespa, {
    name: 'bovespa',
    'render': function () {
        bovespa.control.init();
        bovespa.view.init();

        if (!bovespa.cookie.exists('company-id')) {
            bovespa.view.pages.Company(bovespa.view, bovespa.control);           
        } else {
            bovespa.view.pages.Home(bovespa.view, bovespa.control);
        }
    }
});

bovespa.onReady(function () {
    bovespa.require(['bovespa.config',
        'bovespa.control',
        'bovespa.view',
        'bovespa.control.template',
        'bovespa.control.route'], function () {
        bovespa.render();
    });
});

