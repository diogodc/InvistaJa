/*
 
 */

bovespa.object.extend(bovespa, {
    control: {
        init: function () {
        },
        pages: {
            'Home': function (view) {
                view.menu['bovespa-home'].action();
            },
            'Company': function (view) {
                view.menu['bovespa-company'].action();
            }
        }
    }
});

bovespa.object.extend(bovespa.control, {
    menu: {
        'bovespa-company': {
            action: function (mnu, e) {
                var _mnu = this;
                bovespa.router.get(_mnu.name).navigate(function () {
                    bovespa.template.get(_mnu.name).load(function () {
                        bovespa.ripple(['.ripple', 'click']);
                    });
                });
            }
        },
        'bovespa-home': {
            action: function (mnu, e) {
                var _mnu = this;
                bovespa.router.get(_mnu.name).navigate(function () {
                    bovespa.template.get(_mnu.name).load(function () {
                        bovespa.ripple(['.ripple', 'click']);
                    });
                });
            }
        },
        'main': {
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
            'bovespa-indebtedness': {
                action: function (mnu, e) {
                    var _mnu = this;
                    bovespa.router.get(_mnu.name).navigate(function () {
                        bovespa.template.get(_mnu.name).load(function () {

                        });
                    });
                }
            },
            'bovespa-liquidity': {
                action: function (mnu, e) {
                    var _mnu = this;
                    bovespa.router.get(_mnu.name).navigate(function () {
                        bovespa.template.get(_mnu.name).load(function () {

                        });
                    });
                }
            },
            'bovespa-profitability': {
                action: function (mnu, e) {
                    var _mnu = this;
                    bovespa.router.get(_mnu.name).navigate(function () {
                        bovespa.template.get(_mnu.name).load(function () {

                        });
                    });
                }
            },
            'bovespa-midterm': {
                action: function (mnu, e) {
                    var _mnu = this;
                    bovespa.router.get(_mnu.name).navigate(function () {
                        bovespa.template.get(_mnu.name).load(function () {

                        });
                    });
                }
            }
        }
    }

});

bovespa.ripple(['.ripple', 'click'])
        .register({
            'name': 'bovespa-main',
            'color': '#878ea2'
        });

bovespa.object.extend(bovespa.control, {
    'mnu-show': function (mnuc, mnu) {
        mnu.each(function (e) {
            var mnus = this.query_selector_Attribute_value('mnu-item-parent', mnuc.name, e);
            var mmu_ul = this.query('ul', e);
            var mmu_li = this.query('li', e);

            if (bovespa.width() <= bovespa.config.responsive['min-width']) {
                mnu.class().remove('wrapper');
                for (var x in mnus) {
                    var mnuItem = mnus[x];
                    mnuItem.class().remove('s-menu-nav');
                    mnuItem.class().remove('s-menu-nav-mnu-item');
                }
                for (var x in mmu_ul) {
                    var mnuItem = mmu_ul[x];
                    mnuItem.class().remove('s-menu-nav-hidden-none');
                    mnuItem.class().remove('s-menu-nav-hidden-option');
                }
            } else if (bovespa.width() <= bovespa.config.responsive['med-width']) {
                for (var x in mmu_li) {
                    var mnuItem = mmu_li[x];
                    mnuItem.css('min-height', 'calc(' + bovespa.config.mnu[mnuc.name]['min-heigt'] + ')');
                }
                for (var x in mmu_ul) {
                    var mnuItem = mmu_ul[x];
                    mnuItem.css("position", 'fixed')
                            .css('top', mnu.position().y + 'px')
                            .css("width", mnu.width() + 'px')
                            .css('right', mnu.width() + 'px')
                            .css('visibility', 'visible')
                            .css('border-radius', '0px')
                            .css('min-height', 'calc(' + bovespa.config.mnu[mnuc.name]['min-heigt'] +
                                    ' * ' + bovespa.config.mnu[mnuc.name].items + ')');
                }
                for (var x in mnus) {
                    var mnuItem = mnus[x];
                    mnuItem.class().add('wrapper');
                    mnuItem.css('min-height', 'calc(' + bovespa.config.mnu[mnuc.name]['min-heigt'] +
                            ' * ' + bovespa.config.mnu[mnuc.name].items + ')');
                }
            } else {
                for (var x in mnus) {
                    var mnuItem = mnus[x];

                    mnuItem.css("position", 'fixed')
//                            .css('overflow-y', 'scroll')
                            .css('top', mnu.position().y + 'px')
                            .css("width", mnu.width() + 'px')
                            .css('left', mnu.position().x + mnu.width() * 1.0010 + 'px')
                            .css('visibility', 'visible')
                            .css('min-height', 'calc(' +
                                    bovespa.config.mnu[mnuc.name]['min-heigt'] +
                                    ' * ' + bovespa.config.mnu[mnuc.name].items + ')');
                }
            }
        });
    },
    'mnu-hide': function (mnuc, mnu) {
        mnu.class().add('wrapper');
        mnu.each(function (e) {
            var mnus = this.query_selector_Attribute_value('mnu-item-parent', mnuc.name, e);
            for (var x in mnus) {
                var mnuItem = mnus[x];
                mnuItem.attr('style', '');
                mnuItem.class().add('s-menu-nav');
                mnuItem.class().add('s-menu-nav-mnu-item');
                mnuItem.class().remove('wrapper');
            }

            var mnus = this.query('ul', e);
            for (var x in mnus) {
                var mnuItem = mnus[x];
                mnuItem.attr('style', '');
                mnuItem.class().add('s-menu-nav-hidden-none');
                mnuItem.class().add('s-menu-nav-hidden-option');
            }
        });
    }
});

bovespa.onResize(function () {
    var sclass = 's-menu-nav-hidden-none';
    if (bovespa.width() >= bovespa.config.responsive['med-width']) {

        bovespa.$('.s-menu-nav').each(function (e) {
            var mnu = this.query_selector_Attribute_value('mnu-hidden', 'mnu-main', e);
            for (var x in mnu) {
                mnu[x].class().add(sclass);
            }
        });


        bovespa.$('.table-Sek s-columns').each(function (e) {
            if (bovespa.$(e).class().contains('s-columns-6')) {
                bovespa.$(e).css('height', 'calc(8.8125em)');
            }
        });
    }

    if (bovespa.width() < bovespa.config.responsive['med-width']) {
        bovespa.$('.table-Sek').each(function (e) {
            if (bovespa.$(e).class().contains('s-columns-6')) {
                bovespa.$(e).css('height', 'calc(8.8125em * 4.2)');
            }
            if (bovespa.$(e).class().contains('s-columns-4')) {
                bovespa.$(e).css('height', 'calc(8.8125em * 4.2)');
            }
        });
    }
});





