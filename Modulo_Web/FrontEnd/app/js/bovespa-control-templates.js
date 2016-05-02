/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



bovespa.template.register([
    {
        'name': 'bovespa-main',
        view: {
            self: '.s-body-content',
            html: {
                items: [
                    {
                        view: {
                            settings: {
                                class: 's-md-row s-md-back-Red-A100'
                            },
                            items: [
                                {
                                    view: {
                                        settings: {
                                            class: 's-body-menu-top s-columns-6 s-md-font-White s-center'
                                        },
                                        items: {
                                            table: {
                                                columns: [
                                                    {
                                                        'col-title': {
                                                            text: 'R$ 45,89',
                                                            subText: 'custos'
                                                        }
                                                    },
                                                    {
                                                        'col-title': {
                                                            text: 'R$ 45,89',
                                                            subText: 'Cuustossss'
                                                        }
                                                    },
                                                    {
                                                        'col-title': {
                                                            text: 'R$ 45,89',
                                                            subText: 'custos'
                                                        }
                                                    }
                                                ]
                                            }
                                        }
                                    }
                                }
                            ]
                        }
                    },
                    {
                        view: {
                            settings: {
                                class: "s-md-row"
                            }
                        }
                    },
                    {
                        view: {
                            settings: {
                                class: "s-md-row s-columns-5 s-md-font-GrayCyan margin-left-1 margin-top-1"
                            },
                            items: [
                                {
                                    'view': {
                                        settings: {
                                            class: "s-card-relative s-md-back-White"
                                        },
                                        items: [
                                            {
                                                'view': {
                                                    settings: {
                                                        class: "s-md-back-Blue s-card-head s-card-content-25"
                                                    },
                                                    items: [
                                                        {
                                                            title: {
                                                                settings: {
                                                                    class: "s-center s-uppercase s-size s-md-font-GrayCyan"
                                                                },
                                                                text: 'Custos'
                                                            }
                                                        }
                                                    ]
                                                }
                                            },
                                            {
                                                'view': {
                                                    settings: {
                                                        class: "s-md-back-White s-card-body s-card-content-75",
                                                        id: ''
                                                    }
                                                }
                                            }
                                        ]

                                    }
                                }
                            ]
                        }
                    },
                    {
                        view: {
                            settings: {
                                class: 's-md-row s-md-font-GrayCyan margin-left-1 margin-top-1',
                                id: ''
                            },
                            items: [
                                {
                                    view: {
                                        settings: {
                                            class: 's-md-col-12 s-card-relative s-md-back-White',
                                            id: 'card-bovespa'
                                        },
                                        items: [
                                            {
                                                view: {
                                                    settings: {
                                                        class: 's-md-back-White s-card-head s-card-content-25'
                                                    },
                                                    items: [
                                                        {
                                                            title: {
                                                                settings: {
                                                                    class: "s-center s-uppercase s-size s-md-font-GrayCyan"
                                                                },
                                                                text: 'TABLE'
                                                            }
                                                        }
                                                    ]
                                                }
                                            },
                                            {
                                                view: {
                                                    settings: {
                                                        class: 's-md-back-White s-card-body s-card-content-75'
                                                    },
                                                    items: {
                                                        view: {
                                                            settings: {
                                                                class: 's-table'
                                                            },
                                                            items: {
                                                                view: {
                                                                    settings: {
                                                                        class: 's-table-body s-columns-5'
                                                                    },
                                                                    items: {
                                                                        table: {
                                                                            columns: [
                                                                                {
                                                                                    'title': {
                                                                                        text: 'CUSTOS'
                                                                                    }
                                                                                },
                                                                                {
                                                                                    'title': {
                                                                                        text: 'DESPESAS'
                                                                                    }
                                                                                },
                                                                                {
                                                                                    'title': {
                                                                                        text: ''
                                                                                    }
                                                                                }
                                                                            ]
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        ]
                                    }
                                }
                            ]
                        }
                    }
                ]
            }
        },
        control: {
            url: 'app/views/main.html',
            render_page: function (view, model) {


            },
            init: function (view, model, callback) {
                this.render(view, this, model, this.render_page);
            }
        }
    }
]);
