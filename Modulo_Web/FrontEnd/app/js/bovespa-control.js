/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

bovespa.object.extend(bovespa, {
    control: {
        init: function () {
        },
        pages: {
            'Home': function (view) {
                view['main-mnu']['bovespa-main'].action();
            }
        }
    }
});


bovespa.object.extend(bovespa.control, {
    'main-mnu': {
        'bovespa-mun-hidden': {
            action: function (mnu) {
                var sclass = 's-menu-nav-hidden-none';

                this.attach.each(function (e) {
                    var mnu = this.query_selector_Attribute_value('mnu-hidden', 'mnu-main', e);
                    for (var x in mnu) {
                        if (mnu[x].class().contains(sclass)) {
                            mnu[x].class().remove(sclass);
                        } else {
                            mnu[x].class().add(sclass);
                        }
                    }
                });
            }
        },
        'bovespa-main': {
            action: function () {
                var _mnu = this;
                bovespa.router.get(_mnu.name).navigate(function () {
                    bovespa.template.get(_mnu.name).load(function () {
                    });
                });
            }
        },
        'bovespa-activities': {
            action: function () {
                var _mnu = this;
                bovespa.router.get(_mnu.name).navigate(function () {
                    bovespa.template.get(_mnu.name).load(function () {

                    });
                });
            }
        }
    }
});
