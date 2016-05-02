/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
bovespa.object.extend(bovespa, {
    view: {
        init: function () {

        },
        main: bovespa.$('.bovespa'),
        body: bovespa.$('.s-md-body'),
        pages: {
            'Home': function (view, control) {
                control.pages.Home.call(this, view ? view : bovespa.view);
            }
        }
    }
});

bovespa.object.extend(bovespa.view, {
    'main-mnu': {
        'bovespa-mun-hidden': bovespa.menu([{
                name: 'bovespa-mun-hidden',
                attach: bovespa.view.main,
                checked: false,
                action: function (e) {
                    bovespa.control['main-mnu'][this.name].action.call(this, e);
                }
            }]),
        'bovespa-main': bovespa.menu([{
                name: 'bovespa-main',
                attach: bovespa.view.main,
                action: function (e) {
                    bovespa.control['main-mnu'][this.name].action.call(this, e);
                }
            }]),
        'bovespa-activities': bovespa.menu([{
                name: 'bovespa-activities',
                attach: bovespa.view.main,
                action: function (e) {
                    bovespa.control['main-mnu'][this.name].action.call(this, e);
                }

            }])
    }
});


