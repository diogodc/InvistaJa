/*
 * CONTROL - BOVESPA
 * 1° CONTROLAR A NAVEGAÇÃO DO SITE
 */
bovespa.object.extend(bovespa, {
    control: {
        render: function (view, model) {
            var me = this;
            me._init(view, model);
            if (!me._logged()) {
                view.render();
                me._navigation_.Restricted();
            } else {

                bovespa.object.extend(me, {
                    on: function () {
                        var modal = bovespa.JLib('html').modal({
                            style: {
                                background: 'transparent'
                            }
                        });

                        modal.body().class().add('s-center');
                        modal.body().include(bovespa.icon({
                            path: './app/resources/images/loading.gif'
                        }));

                        this['_modal_'] = modal;
                        return modal;
                    },
                    off: function () {
                        this['_modal_'].off();
                    }
                });

                model.load(function (load, sucess) {
                    view.render();
                    if (load && !sucess) { /* SE A EMPRESA SELECIONADA NÃO TEM INDICADORES */
                        bovespa.storage.removeAll();
                        bovespa.storage({tost: 'Empresa sem detalhamento!'});
                    }

                    if (load && sucess) {
                        me._navigation_.Home();
                    } else {  /* SE A EMPRESA SELECIONADA NÃO TEM INDICADORES */
                        me._navigation_.Company();
                    }
                }, me, me.token);
            }
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
            bovespa.object.extend(this._navigation_, {/* CONTROLES DE NAVEGAÇÃO PARA CADA PAGINA DO SITE */
                'Construction': function () {
                    view._view_.Construction().load(function () {

                    });
                },
                'Restricted': function () {
                    var _route = bovespa.router([{route: 'bovespa:RESTRICTED'}]); /* ALTERANDO A URL */
                    _route.navigate(function () { /* INSTANCIANDO A VIEW HTML NO CORPO DA PAGINA  */
                        view._view_.Restricted().load(function () {

                        });
                    });
                },
                'Home': function () {
                    view._view_.Home().load(function () {
                        view._view_.Indebtedness().load();
                    });
                },
                'Company': function () {
                    var _route = bovespa.router([{route: 'bovespa:EMPRESAS'}]); /* ALTERANDO A URL */
                    _route.navigate(function () { /* INSTANCIANDO A VIEW HTML NO CORPO DA PAGINA  */
                        view._view_.Company().load(function () {

                        });
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
                    bovespa.storage.removeAll();
                    bovespa.control._navigation_.Company();
                }
            });
        },
        _init_mnu: function () {
            this._mnu_ = bovespa.object.create({});
            bovespa.object.extend(this._mnu_, {/* CONTROLE DO MENU LATERAL */
                'bovespa-mun-hidden': function (mh) {
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
                'bovespa-navigation': function (e) { /* CONTROLE DO MENU NAVEGAÇÃO */
                    bovespa.control._mnu_['bovespa-mun-hidden'].call(this, e);
                    bovespa.control._navigation_[this.navigation].call(this, e);
                }
            });
        },
        _mnu_select: function (e) { /* CONTROLE DE SELEÇÃO DO MENU */
            e.each(function (e) {
                var _class = 's-menu-nav-mnu-select';
                var mnu = bovespa.JLib('.' + _class);
                mnu.each(function (e) {
                    if (bovespa.JLib(e).class().contains(_class)) {
                        bovespa.JLib(e).class().remove(_class);
                    }
                });
            });
            e.class().add('s-menu-nav-mnu-select');
        },
        _function_scroll_: function (mnu) {
            var _scroll = 74.8 - bovespa.scrollTop();

            if (_scroll > 0) {
                bovespa.JLib(mnu).css('top', _scroll + 'px');
            } else {
                bovespa.JLib(mnu).css('top', '-1000000' + 'px'); //1.7999999999999972
            }


//            if (bovespa.scrollTop() > 150)
//                bovespa.JLib(e).class().add('s-menu-nav-scroll-top');
//            else
//                bovespa.JLib(e).class().remove('s-menu-nav-scroll-top');

            bovespa.JLib('.s-menu-nav-hidden-option').css('top', (bovespa.JLib(mnu).height() / 2.0) + bovespa.JLib(mnu).position().y + 'px');
        },
        _function_expand_: function (e) {
            var btn = e,
                    panel = e.up().up(),
                    row = this.row || panel.up(),
                    contanier = row.up().up(),
                    modal = this.modal || contanier.modal({
                        style: {
                            'opacity': '0.5',
                            'background': 'transparent'
                        }
                    }),
                    frame = (function () {
                        var _iframe;
                        panel.each(function (e) {
                            _iframe = this.query('iframe', e);
                        });

                        return _iframe[0] || null;
                    })();

            this.expand = !this.expand;
            this.modal = this.modal || modal;
            this.row = this.row || row;

            if (this.expand) {
                this.width_old = panel.width();
                panel.attr('style', '');
                panel.css('width', row.up().width() + 'px');
                modal.body().include(panel.getElement());
                modal.on();
            } else {
                panel.attr('style', '');
                modal.off();
                row.include(panel.getElement());
                this.row = null;
                this.modal = null;
            }

            (function (expand) {
                btn.content(expand ? "FECHAR" : 'EXPANDIR');
            })(this.expand);

            if (frame)
                if (frame.getElement())
                    frame.getElement().src = frame.getElement().src;


            panel.getFocus();
            window.scrollTo(0, 0);
        },
        _logged: function () {
            var me = this;

            me['token'] = me['token'] || bovespa.JLib('token').get('val');

            if (me.token) {
                bovespa.JLib('token').remove();
            }

            return me.token;
        }

    }
});

