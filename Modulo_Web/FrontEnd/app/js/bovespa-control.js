bovespa.object.extend(bovespa, {
    control: {
        render: function (view, model) {
            this._init(view, model);

            model.load(function (load) {
                view.render();
                if (load) {
                    this._navigation_.Home();
                } else {
                    this._navigation_.Company();
                }
            }, this);
        },
        _init: function (view, model) {
            this._init_plugins();
            this._init_navigation(view);
            this._init_mnu();
        },
        _init_plugins: function () {
            bovespa._plugin_ = bovespa.object.create({});
            bovespa._plugin_['JQuery'] = $;
            bovespa._plugin_['Highcharts'] = Highcharts;
        },
        _init_navigation: function (view) {
            this._navigation_ = bovespa.object.create({});
            bovespa.object.extend(this._navigation_, {
                'Home': function () {
                    view._view_.Home().load();
                },
                'Company': function () {
                    var _route = bovespa.router([{route: 'bovespa:EMPRESAS'}]);
                    _route.navigate(function () {
                        view._view_.Company().load();
                    });
                },
                'Indebtedness': function (e) {
                    var _route = bovespa.router([{route: 'bovespa:ENDIVIDAMENTO'}]);
                    _route.navigate(function () {
                        view._view_.Indebtedness().load();
                    });
                },
                'Liquidity': function (e) {
                    var _route = bovespa.router([{route: 'bovespa:LIQUIDEZ'}]);
                    _route.navigate(function () {
                        view._view_.Liquidity().load();
                    });
                },
                'Profitability': function (e) {
                    var _route = bovespa.router([{route: 'bovespa:RENTABILIDADE'}]);
                    _route.navigate(function () {
                        view._view_.Profitability().load();
                    });
                },
                'Midterm': function (e) {
                    var _route = bovespa.router([{route: 'bovespa:PRAZOS-MÉDIOS'}]);
                    _route.navigate(function () {
                        view._view_.Midterm().load();
                    });
                },
                'Exit': function (e) {
                    bovespa.control._navigation_.Company();
                }
            });
        },
        _init_mnu: function () {
            this._mnu_ = bovespa.object.create({});
            bovespa.object.extend(this._mnu_, {
                'bovespa-mun-hidden': function (e) {
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
                },
                'bovespa-navigation': function (e) {
                    bovespa.control._navigation_[this.navigation].call(this, e);
                }
            });
        }
    }
});
