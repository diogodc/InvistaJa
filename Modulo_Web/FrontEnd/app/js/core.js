/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (_object) {
    var _core = _object.core = {};

    _core['instance'] = function () {
        var sys_core;
        var sys = function object() {
        };

        String.prototype.contains = function (text) {
            return this.toString().indexOf(text) > -1;
        };

        sys_core = {};
        sys_core = {
            object: {
                create: function create(prototypes) {
                    function object() {
                    }
                    ;


                    object.prototype['component-name'] = 'object';

                    var self = new object();
                    sys_core.object.extend(self, prototypes);
                    return self;
                },
                extend: function extend(self, prototypes, namespace) {
                    this.extend_by_namespace = function extend_by_namespace(nodes, self, prototypes) {
                        nodes = nodes.replace(/-/g, '_');
                        var parts = nodes.split('.');
                        var ns = self;
                        for (var i = 0; i < parts.length; i++) {
                            if (ns[parts[i]] === undefined) {
                                ns[parts[i]] = {};
                            }

                            if ((i + 1) === parts.length) {
                                var self = ns[parts[i]];
                                for (var proto in prototypes) {
                                    if (prototypes.hasOwnProperty(proto)) {
                                        self[proto] = prototypes[proto];
                                    }
                                }
                            } else {
                                ns = ns[parts[i]];
                            }
                        }
                    };
                    this.extend_simple = function extend_simple(self, prototypes) {
                        for (var proto in prototypes) {
                            if (prototypes.hasOwnProperty(proto)) {
                                self[proto] = prototypes[proto];
                            }
                        }
                    }
                    ;
                    if (namespace)
                        this.extend_by_namespace(namespace, self, prototypes);
                    else
                        this.extend_simple(self, prototypes);
                    return self;
                }
            }
        };

        sys_core.object.extend(sys_core, {
            onReady: function (callback) {
                window.addEventListener('load', callback, false);
            },
            eachProto: function (ary, callback) {
                for (var key in ary) {
                    if (ary.hasOwnProperty(key)) {
                        if (ary[key] && callback(ary[key], key, ary)) {
                            break;
                        }
                    }
                }
            },
            each: function (ary, callback) {
                if (ary) {
                    var i;
                    for (i = 0; i < ary.length; i += 1) {
                        if (ary[i] && callback(ary[i], i, ary, i === ary.length - 1)) {
                            break;
                        }
                    }
                }
            },
            eachReverse: function eachReverse(ary, callback) {
                if (ary) {
                    var i;
                    for (i = ary.length - 1; i > -1; i -= 1) {
                        if (ary[i] && callback(ary[i], i, ary, i === 0)) {
                            break;
                        }
                    }
                }
            },
            generateUUID: function generateUUID() {
                var d = new Date().getTime();
                if (window.performance && typeof window.performance.now === "function") {
                    d += performance.now();
                    ; //use high-precision timer if available
                }
                var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                    var r = (d + Math.random() * 16) % 16 | 0;
                    d = Math.floor(d / 16);
                    return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
                });
                return uuid;
            },
            width: function width() {
                return window.innerWidth
                        || document.documentElement.clientWidth
                        || document.body.clientWidth;
            },
            height: function height() {
                return window.innerHeight
                        || document.documentElement.clientHeight
                        || document.body.clientHeight;
            },
            isDefined: function (o) {
                if (o == undefined) {
                    return false;
                }

                if (o == null) {
                    return false;
                }

                return true;
            }
        });

        sys_core.object.extend(sys_core, {
            type: {},
            router: {},
            request: {},
            template: {},
            $: {}
        });

        sys_core.object.extend(sys_core.type, {
            _toString: sys.prototype.toString,
            NULL_TYPE: 'Null',
            UNDEFINED_TYPE: 'Undefined',
            BOOLEAN_TYPE: 'Boolean',
            NUMBER_TYPE: 'Number',
            STRING_TYPE: 'String',
            OBJECT_TYPE: 'Object',
            FUNCTION_CLASS: '[object Function]',
            BOOLEAN_CLASS: '[object Boolean]',
            NUMBER_CLASS: '[object Number]',
            STRING_CLASS: '[object String]',
            ARRAY_CLASS: '[object Array]',
            DATE_CLASS: '[object Date]',
            isHash: function isHash(object) {
                return object instanceof Hash;
            },
            isFunction: function isFunction(object) {
                return sys_core.type._toString.call(object) === sys_core.type.FUNCTION_CLASS;
            },
            isString: function isString(object) {
                return sys_core.type._toString.call(object) === sys_core.type.STRING_CLASS;
            },
            isNumber: function isNumber(object) {
                return sys_core.type._toString.call(object) === sys_core.type.NUMBER_CLASS;
            },
            isDate: function isDate(object) {
                return sys_core.type._toString.call(object) === sys_core.type.DATE_CLASS;
            },
            isUndefined: function isUndefined(object) {
                return typeof object === "undefined";
            },
            isElement: function isElement(object) {
                return !!(object && object.nodeType == 1);
            },
            isArray: function isArray(object) {
                return sys_core.type._toString.call(object) === sys_core.type.ARRAY_CLASS;
            },
            isObject: function isObject(object) {
                return sys_core.type._toString.call(object) === '[object Object]';
            }

        });

        sys_core.object.extend(sys_core, {$: function $(prototype) {
                var _element;
                sys_core.object.extend(this, {
                    query: function (qr) {
                        var nodeList = document.getElementsByTagName('*');
                        var nodeArray = [];
                        var iterator = 0;
                        var node = null;
                        var query = qr.substring(0, 1) == "." ? 'class' : qr.substring(0, 1) == "#" ? 'id' : '';
                        var queryValue = qr.substring(1);
                        while (node = nodeList[iterator++]) {
                            if (node.getAttribute(query) == queryValue)
                                nodeArray.push(node);
                        }

                        return nodeArray;
                    }
                });

                sys_core.object.extend(this, {
                    dom: function dom() {
                        var instance = sys_core.object.create({
                            component: 'dom-element'
                        });
                        sys_core.object.extend(instance, {
                            class: function () {
                                var _class = sys_core.object.create({
                                    component: 'class-element'
                                });

                                sys_core.object.extend(_class, {
                                    remove: function (name_class) {
                                        if (_element.el.classList) {
                                            _element.el.classList.remove(name_class);
                                        } else {
                                            var _class = _element.get('class').trim();
                                            this.attr('class', _class.replace(name_class, ""));
                                        }
                                    },
                                    add: function (name_class) {
                                        if (_element.el.classList) {
                                            _element.el.classList.add(name_class);
                                        } else {
                                            var _class = _element.get('class').trim();
                                            this.attr('class', _class + " " + name_class);
                                        }
                                    },
                                    contains: function (name_class) {
                                        if (_element.el.classList)
                                            return  _element.el.classList.contains(name_class);


                                        var _class = _element.get('class').trim();
                                        return _class.contains(name_class);
                                    }

                                });

                                return _class;
                            },
                            create_id: function create_id(previous) {
                                this.each(function (e) {
                                    var _id, attr;
                                    _id = (previous == undefined ? '' : previous + '-') + sys_core.generateUUID();
                                    attr = document.createAttribute("id");
                                    attr.value = _id;
                                    e.setAttributeNode(attr);
                                });
                                return this;
                            },
                            get_id: function get_id() {

                                return this.el.getAttribute('id');
                            },
                            get: function get(get) {
                                return this.el.getAttribute(get);
                            },
                            create_element: function create_element(element_type, element_html5) {
                                var _element;
                                if (element_html5 != undefined)
                                    _element = document.createElementNS(element_html5, element_type);
                                else
                                    _element = document.createElement(element_type);
                                _element = sys_core.$(_element);
                                sys_core.object.extend(_element, {
                                    isHtml5: element_html5 != undefined
                                });
                                this.each(function (e) {
                                    e.appendChild(_element.el);
                                });
                                return _element;
                            },
                            css: function css(_css, _style) {
                                switch (_css) {
                                    case 'background-Color' :
                                        _css = 'backgroundColor';
                                        break;
                                }

                                this.each(function (e) {
                                    e.style[_css] = _style;
                                });
                                return this;
                            },
                            attr: function attr(_attr, _value) {

                                this.each(function (e) {
                                    var attr;
                                    if (this.isHtml5 === true)
                                        e.setAttributeNS(null, _attr, _value);
                                    else {
                                        attr = document.createAttribute(_attr);
                                        attr.value = _value;
                                        e.setAttributeNode(attr);
                                    }
                                });
                                return this;
                            },
                            content: function content(content) {
                                this.each(function (e) {
                                    e.innerHTML = content;
                                });
                                return this;
                            },
                            mark_component: function (comp) {
                                this.each(function (e) {
                                    var _comp
                                            , comp_name
                                            , comp_id;
                                    comp_name = sys_core.name + '-' + comp[0];
                                    _comp = document.createAttribute("component-name");
                                    _comp.value = comp_name;
                                    e.setAttributeNode(_comp);
                                    comp_id = sys_core.name + '-' + comp[1];
                                    _comp = document.createAttribute("component-id");
                                    _comp.value = comp_id;
                                    e.setAttributeNode(_comp);
                                });
                                return this;
                            },
                            query_selector_Attribute: function query_selector_Attribute(attribute, context) {
                                var nodeList = (context || this.el).getElementsByTagName('*');
                                var nodeArray = [];
                                var iterator = 0;
                                var node = null;
                                while (node = nodeList[iterator++]) {
                                    if (node.getAttribute(attribute))
                                        nodeArray.push(node);
                                }

                                return nodeArray;
                            },
                            query_selector_Attribute_value: function query_selector_Attribute_value(attribute, value, context) {
                                var nodeList = (context || this.el).getElementsByTagName('*');
                                var nodeArray = [];
                                var iterator = 0;
                                var node = null;
                                while (node = nodeList[iterator++]) {
                                    if (node.getAttribute(attribute))
                                        if (node.getAttribute(attribute) == value) {
                                            nodeArray.push(sys_core.$(node));
                                        }

                                }

                                return nodeArray;
                            }
                        });
                        return instance;
                    }
                });

                _element = this.dom();
                sys_core.object.extend(_element, {
                    event: function event(_name, _function, _remove) {
                        this.each(function (e) {
                            if (_remove)
                                e.removeEventListener(_name, _function, false);
                            e.addEventListener(_name, _function, false);
                        });
                    }
                });

                sys_core.object.extend(_element, {
                    each: function each(fn) {
                        var x;
                        if (this.type == 'id') {
                            fn.call(this, this.el);
                        } else if (this.type == 'name') {
                            for (x in this.el) {
                                if (this.el[x] instanceof Element) {
                                    fn.call(this, this.el[x]);
                                }
                            }
                        } else {
                            for (x in this.el) {
                                if (this.el [x] instanceof Element) {
                                    fn.call(this, this.el[x]);
                                }
                            }
                        }
                    }
                });

                sys_core.object.extend(_element, {
                    getElement: function getElement() {
                        return this.el;
                    },
                    include: function include(el) {
                        this.each(function (e) {
                            e.appendChild(el instanceof Element ? el : el.getElement());
                        });

                    }
                });

                if (prototype instanceof Element) {
                    sys_core.object.extend(_element, {
                        type: 'id',
                        el: prototype
                    });
                } else {
                    if (document.getElementById(prototype) != undefined) {
                        sys_core.object.extend(_element, {
                            type: 'id',
                            el: document.getElementById(prototype)
                        });
                    } else if (document.getElementsByName(prototype) != undefined && document.getElementsByName(prototype).length != 0) {
                        sys_core.object.extend(_element, {
                            type: 'name',
                            el: document.getElementsByName(prototype)
                        });
                    } else if (document.getElementsByTagName(prototype) != undefined && document.getElementsByTagName(prototype).length != 0) {
                        sys_core.object.extend(_element, {
                            type: 'tag',
                            el: document.getElementsByTagName(prototype)
                        });
                    } else {
                        sys_core.object.extend(_element, {
                            type: 'query',
                            el: this.query(prototype)
                        });
                    }
                }

                return _element;
            }});

        /* ################### STRUCTURE #################### */
        sys_core.object.extend(sys_core, {structure: function structure(_structure) {
                var _rendered,
                        _rendered_ele,
                        structure = sys_core.structure;


                if (sys_core.type.isObject(_structure)) {
                    _rendered = structure.create_element(_structure);
                    _rendered_ele = _rendered.me();


                    if (sys_core.isDefined(_structure.sclass)) {
                        _rendered_ele.attr('class', _rendered_ele.get('class') ? _rendered_ele.get('class') + ' ' + _structure.sclass : _structure.sclass);
                    }

                    if (sys_core.isDefined(_structure.id)) {
                        _rendered_ele.attr('id', _structure.id);
                    } else {
                        if (_rendered.compiled())
                            _rendered_ele.create_id(_rendered.stype);
                    }

                    if (sys_core.isDefined(_structure.style)) {
                        _rendered_ele.attr('style', _structure.style);
                    }


                    if (sys_core.isDefined(_structure.name)) {
                        _rendered_ele.attr('name', _structure.name);
                    }


                } else if (sys_core.type.isArray(_structure)) {
                    _rendered = [];
                    sys_core.each(_structure, function (it, t, its) {
                        _rendered.push(structure(it));
                    });
                }

                return _rendered;
            }});
        sys_core.object.extend(sys_core.structure, {
            type: {
                altTitle: 'alt-title',
                minCardTop: 'min-card-top',
                cardBodyTop: 'card-body-top',
                cardHeadTop: 'card-head-top',
                minCardBottom: 'min-card-bottom',
                cardBodyBottom: 'card-body-bottom',
                cardHeadBottom: 'card-head-bottom',
                script: 'script'
            },
            implode_element: function (st, e, includes) {

                if (sys_core.type.isArray(includes)) {
                    sys_core.each(includes, function (it, t, its) {
                        st.add(it);
                        e.include(it.me());
                    });
                } else {
                    st.add(includes);
                    e.include(includes.me());
                }
            },
            construct_element: function (e, config) {
                var structure = sys_core.structure;
                var stElement = sys_core.object.create({});

                sys_core.object.extend(stElement, {
                    stype: config.stype,
                    me: function () {
                        return e;
                    },
                    add: function (it) {
                        var items = this['items'] || [];
                        items.push(it);
                        this['items'] = items;
                    },
                    compiled: function () {
                        return sys_core.isDefined(this.stype) ? true : false;
                    }
                });

                switch (config.stype) {
                    case structure.type.altTitle:
                        e.attr('class', 's-title-text');
                        e.content(config.title ? config.title : '');
                        break;
                    case structure.type.cardBodyTop:
                        e.attr('class', 's-md-card-body s-md-card-body-top');
                        break;
                    case structure.type.cardHeadTop:
                        e.attr('class', 's-md-card-heading');
                        break;
                    case structure.type.minCardTop:
                        var body, head;

                        e.attr('class', 's-md-card s-md-card-r s-md-min-card');

                        sys_core.object.extend(stElement, {
                            head: structure({
                                stype: structure.type.cardHeadTop
                            }),
                            body: head = structure({
                                stype: structure.type.cardBodyTop
                            })
                        });

                        e.include(stElement.head.me());
                        e.include(stElement.body.me());


                        break;
                }

                if (sys_core.isDefined(config.items)) {
                    var items = structure(config.items);

                    switch (config.stype) {
                        case structure.type.minCardTop:
                            structure.implode_element(stElement, stElement.body.me(), items);
                            break;
                        default:
                            structure.implode_element(stElement, e, items);
                            break;
                    }

                }

                if (sys_core.isDefined(config.head)) {
                    var items = structure(config.head);

                    switch (config.stype) {
                        case structure.type.minCardTop:
                            structure.implode_element(stElement, stElement.head.me(), items);
                            break;
                        default:
                            structure.implode_element(stElement, e, items);
                            break;
                    }

                }

                if (sys_core.isDefined(config.libs)) {
                    sys_core.eachProto(config.libs, function (proto_value, protoName) {
                        e.attr(protoName, proto_value);
                    });
                }
                return stElement;
            },
            create_element: function (config) {
                var comp_structure = sys_core.structure;
                var ele, eType, eClass;

                switch (config.stype) {
                    case 'section':
                        eType = 'section';
                        eClass = '';
                        break;
                    case 'script':
                        eType = 'script';
                        eClass = 'script-element';
                        break;
                    case 'row':
                        eType = 'div';
                        eClass = 's-md-row';
                        break;
                    case 'col':
                        eType = 'div';
                        eClass = 's-md-col-' + (config.colspan ? config.colspan : '12');
                        break;
                    default:
                        eType = 'div';
                        eClass = '';
                        break;
                }


                ele = sys_core.$(document.createElement(eType));
                ele.attr('class', eClass);

                return comp_structure.construct_element(ele, config);
            }
        });
        /* ################### STRUCTURE #################### */

        /* ###################REQUEST-AJAX #################### */
        sys_core.object.extend(sys_core, {request: function request(_parameter_settings) {
                function createRequest() {
                    var xhr;
                    try {
                        xhr = new XMLHttpRequest();
                    } catch (e) {
                        try {
                            xhr = new ActiveXObject("Msxml2.XMLHTTP.6.0");
                        } catch (e2) {
                            try {
                                xhr = new ActiveXObject("Msxml2.XMLHTTP.3.0");
                            } catch (e3) {
                                try {
                                    xhr = new ActiveXObject("Msxml2.XMLHTTP");
                                } catch (e4) {
                                    try {
                                        xhr = new ActiveXObject("Microsoft.XMLHTTP");
                                    } catch (e5) {
                                        throw new Error("This browser does not support XMLHttpRequest.");
                                    }
                                }
                            }
                        }
                    }
                    return xhr;
                }

                var ajax = sys_core.object.create({
                    success: function () {
                    },
                    failure: function () {
                    },
                    url: '',
                    asynchronous: true,
                    request: createRequest(),
                    response: '',
                    method: 'GET',
                    root: '/'
                });
                sys_core.object.extend(ajax, _parameter_settings);
                ajax.request.addEventListener('progress', function (e) {
                }, false);
                ajax.request.onreadystatechange = function (e) {
                    if (4 == this.readyState) {
                        if (this.status === 200) {
                            ajax.success.call(this);
                        } else {
                            ajax.failure.call(this);
                        }
                    }
                };
                sys_core.object.extend(ajax, {
                    clearSlashes: function (path) {
                        return path.toString().replace(/\/$/, '').replace(/^\//, '');
                    },
                    getUrl: function () {
                        return this.root + this.clearSlashes(location.pathname) + '/' + this['url'];
                    }
                });
                ajax.request.open(ajax['method'] == "" ? 'GET' : ajax['method'], ajax['getUrl'](), ajax.asynchronous);
                ajax.request.setRequestHeader("Content-Type", "multipart/form-data");
                ajax.request.setRequestHeader("component-name", "s-request");
                ajax.request.send();
                return ajax.asynchronous ? '' : ajax.request.responseText;
            }});
        /* ###################REQUEST-AJAX #################### */

        /* ################### REQUIRE #####################*/
        sys_core.object.extend(sys_core, {
            require: function (requires, callback) {
                var _require = sys_core.require;

                if (!sys_core.isDefined(_require.require_complete)) {
                    _require.require_complete = new Event('require_complete');
                    window.addEventListener('require_complete', function (e) {
                        callback ? callback() : function () {
                        };
                    }, false);
                }

                sys_core.each(requires, function (modulo, x, modulos, last) {
                    var module = _require.get(modulo);
                    if (last) {
                        window.dispatchEvent(_require.require_complete);
                    }
                });
            }
        });
        sys_core.object.extend(sys_core.require, {
            'modulos': {},
            register: function (req) {
                var _require = this;
                sys_core.each(req, function (modulo) {
                    _require.modulos[modulo[0]] = {};
                    sys_core.object.extend(_require.modulos[modulo[0]], {
                        name: modulo[0],
                        path: modulo[1]
                    });
                });
            },
            readModule: function (src) {
                var code = sys_core.request({
                    asynchronous: false,
                    url: src
                });
                return code;
            },
            get: function (modName) {
                var _require = this,
                        module = null;

                module = _require.modulos[modName];
                if (!sys_core.isDefined(module) && sys_core.isDefined(module.complete))
                    return false;

                module.load = 'complete';
                module.id = 'require-' + sys_core.generateUUID();
                new Function('', _require.readModule(module.path + '?' + module.class))();

                sys_core.$('head').include(sys_core.structure({
                    stype: 'script',
                    libs: module
                }).me());


                return module;
            }
        });
        /* ################### REQUIRE #####################*/

        /* ################### ROUTES #####################*/
        sys_core.object.extend(sys_core, {router: function router(config) {
                var router = sys_core.object.create({
                    init: function () {
                        if (this['auto'] === true) {
                            this.navigate();
                        }
                    },
                    route: '',
                    root: '/',
                    auto: false
                });

                sys_core.object.extend(router, config[0]);

                router['route'] = router['route'].replace(/#(.*)$/, '');

                if (typeof config[1] == 'function') { //callback
                    router['callback'] = config[1];
                } else {
                    router['callback'] = function () {
                    };
                }

                sys_core.object.extend(router, {
                    navigate: function (callback) {
                        window.location.href = window.location.href.replace(/#(.*)$/, '') + '#' + this['route'] + "?" + sys_core.generateUUID().substring(1, 8).toUpperCase();
                        (callback ? callback : this.callback).call(this, true);
                        return this;
                    }
                });
                router.init();
                return router;
            }});
        sys_core.object.extend(sys_core.router, {
            routes: {},
            register: function register(config) {
                var route = this(config);
                this.routes[route.name] = route;
                return this;
            },
            get: function get(name) {
                return this.routes[name];
            }
        });
        /* ################### ROUTES #####################*/

        /* ################### MENUS #####################*/
        sys_core.object.extend(sys_core, {
            menu: function (config) {
                var menu = this.object.create({name: ''});
                menu.name = config[0].name;
                this.object.extend(menu, config[0]);
                menu.attach.each(function (e) {
                    var mnu = this.query_selector_Attribute_value('mnu-name', menu.name, e);
                    for (var x in mnu) {
                        mnu[x].event('click', function () {
                            menu.action.call(menu, mnu[x]);
                        }, true);
                    }
                });
                return menu;
            }
        });
        sys_core.object.extend(sys_core.menu, {
            mnus: {},
            register: function register(config) {
                var menu = this(config);
                this.mnus[menu.name] = menu;
                return this;
            },
            get: function get(name) {
                return this.mnus[name];
            }
        });
        /* ################### MENUS #####################*/

        /* ################### TEMPLATE #####################*/
        sys_core.object.extend(sys_core, {template: function template(config) {
                var _template = sys_core.object.create({}),
                        main = sys_core;

                _template = main.object.extend({
                    name: '',
                    load: function (callback) {
                        this.view.init.call(this.view);
                        this.control.init.call(this.control, this.view, this.model, callback);
                    }
                });
                main.object.extend(_template, {
                    view: {
                        init: function () {

                        },
                        self: '',
                        pattern: /\@\{(\w*)\}/g,
                        'view-text': '',
                        'inject-json': function (json) {
                            var html = this['view-text'].replace(this.pattern, function (key) {
                                if (json[key.slice(2, -1)])
                                    return json[key.slice(2, -1)];
                                else
                                    return '';
                            });
                            this['view-text'] = html;
                        },
                        'render': function (text, data) {
                            this['view-text'] = text;
                            if (data)
                                this['inject-json'](data);
                            main.$(this.self).mark_component(['view-template', '000']);

                            if (sys_core.isDefined(this.html)) {
                                main.Rendering(main.$(this.self), this.html);
                            } else {
                                main.$(this.self).content(this['view-text']);
                            }
                        }
                    }
                });
                main.object.extend(_template, {
                    control: {
                        url: '',
                        init: function (view, model, callback) {
                            this.render(view, this, model, callback);
                        },
                        'render': function (view, control, model, callback) {
                            main.request({
                                url: this.url + '?getTemplate',
                                success: function () {
                                    var view_text = this.responseText;
                                    if (model.complete)
                                        control['render-view'](view_text, view, model, callback);
                                    else
                                        return false;
                                },
                                failure: function () {
                                    view.render('', model, {});
                                }
                            });
                            return this;
                        },
                        'render-view': function (view_text, view, model, callback) {
                            _template.view.render(view_text, model.data);
                            (callback ? callback.call(this, view, model) : false);
                        }
                    }
                });
                main.object.extend(_template, {
                    model: {
                        complete: true,
                        data: {},
                        load: function (callback) {

                        }
                    }
                });

                _template.name = config[0].name;
                main.object.extend(_template.view, config[0].view);
                main.object.extend(_template.control, config[0].control);
                main.object.extend(_template.model, config[0].model);
                return _template;
            }});
        sys_core.object.extend(sys_core.template, {
            templates: {},
            register: function register(config) {
                var template = this(config);
                this.templates[template.name] = template;
                return this;
            },
            get: function get(name) {
                return this.templates[name];
            }
        });
        /* ################### TEMPLATE #####################*/

        /* ################### COMPONENT #####################*/
        sys_core.object.extend(sys_core, {component: function (_self) {
                return this;
            }});
        sys_core.object.extend(sys_core.component, {
        });
        /* ################### COMPONENT #####################*/

        sys_core.object.extend(sys_core, {
            Rendering: function (_self, _object) {
                var _render = null;
                sys_core.eachProto(_object, function (proto_value, protoName) {

                    if (protoName === "view") {
                        _render = sys_core.Rendering.view(proto_value);
                    } else if (protoName === "table") {
                        _render = sys_core.Rendering.table(proto_value);
                    } else if (protoName === "title") {
                        _render = sys_core.Rendering.title(proto_value);
                    } else if (protoName === "literal") {
                        _render = sys_core.Rendering.literal({'rendering-literal': proto_value});
                    } else {
                        _render = _self;
                    }

                    if (sys_core.isDefined(proto_value.settings)) {
                        sys_core.eachProto(proto_value.settings, function (proto_value, protoName) {
                            _render.attr(protoName, proto_value);
                        });
                    }
                    if (sys_core.isDefined(proto_value.items)) {
                        if (sys_core.type.isArray(proto_value.items)) {
                            sys_core.each(proto_value.items, function (it) {
                                _render.include(sys_core.Rendering(null, it));
                            });
                        } else {
                            _render.include(sys_core.Rendering(null, proto_value.items));
                        }
                    }
                    if (sys_core.type.isArray(proto_value)) {
                        sys_core.each(proto_value, function (it) {
                            _render.include(sys_core.Rendering(null, it));
                        });
                    }
                });
                return _render;
            }
        });

        sys_core.object.extend(sys_core.Rendering, {
            'columns': function (_colRow, _columns) {
                sys_core.each(_columns, function (it) {
                    sys_core.eachProto(it, function (proto_value, protoName) {
                        if (protoName === "col-title") {
                            var _title = _colRow
                                    .create_element('th')
                                    .create_element('span');


                            _title.create_element('div').create_element('text').content(proto_value.text ? proto_value.text : '');
                            _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                        } else if (protoName === "title") {
                            var _title = _colRow
                                    .create_element('th')
                                    .create_element('span');
                            _title.create_element('text').content(proto_value.text ? proto_value.text : '');
                            _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                        }
                    });
                });
            },
            'table': function (s_table) {
                var _table = sys_core.$(document.createElement('table'));

                if (sys_core.isDefined(s_table.columns)) {
                    if (sys_core.type.isArray(s_table.columns)) {
                        var _columns = _table.create_element('thead').create_element('tr');
                        sys_core.Rendering.columns(_columns, s_table.columns);
                    }
                }

                return _table;
            },
            'view': function (s_view) {
                return  sys_core.$(document.createElement('div'));
            },
            'title': function (s_title) {
                var _title = sys_core.$(document.createElement('div'));

                _title.create_element('span')
                        .create_element('text')
                        .content(s_title.text ? s_title.text : '');
                return _title;
            },
            'literal': function (s_literal) {
                var _literal = sys_core.$(document.createElement('literal-child'));
                sys_core.eachProto(s_literal, function (proto_value, protoName) {
                    if (protoName === 'settings') {
                        sys_core.eachProto(proto_value, function (proto_value, protoName) {
                            _literal.attr(protoName, proto_value);
                        });
                    } else {
                        var child_literal = sys_core.$(document.createElement(protoName));

                        if (sys_core.type.isObject(proto_value)) {
                            child_literal.include(sys_core.Rendering.literal(proto_value));
                        } else {
                            child_literal.content(proto_value);
                        }

                        _literal.include(child_literal);
                    }

                });

                return _literal;
            }
        });

        return sys_core;
    };

    return _core;
})(window);
