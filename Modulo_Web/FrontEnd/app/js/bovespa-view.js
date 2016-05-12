/* 
 
 */
bovespa.object.extend(bovespa, {
    view: {
        init: function () {

        },
        main: bovespa.$('.bovespa'),
        body: bovespa.$('.bovespa'),
        pages: {
            'Home': function (view, control) {
                control.pages.Home.call(this, view ? view : bovespa.view);
            },
            'Company': function (view, control) {
                control.pages.Company.call(this, view ? view : bovespa.view);
            }
        }
    }
});

bovespa.object.extend(bovespa.view, {
    menu: {
        'bovespa-company': bovespa.menu([{
                name: 'bovespa-company',
                attach: bovespa.view.main,
                action: function (e) {
                    bovespa.control.menu[this.name].action.call(this, e);
                }
            }]),
        'bovespa-home': bovespa.menu([{
                name: 'bovespa-home',
                attach: bovespa.view.main,
                action: function (e) {
                    bovespa.control.menu[this.name].action.call(this, e);
                }
            }])
    }

});


