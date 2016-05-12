/*
 
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
            onResize: function (callback) {
//                document.getElementsByTagName("body")[0].onresize = callback;
                window.addEventListener('resize', callback);
                var observer = new MutationObserver(callback);
                observer.observe(document.body, {
                    attributes: true,
                    childList: true,
                    characterData: true,
                    subtree: true
                });
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
            },
            newID: function (previous) {
                return (previous == undefined ? '' : previous + '-') + sys_core.generateUUID();
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
            },
            isJson: function isJson(object) {
                try {
                    JSON.parse(object);
                    return true;
                }
                catch (error) {
                    return false;
                }
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
                            var _node = node.getAttribute(query);
                            if (sys_core.isDefined(_node)) {
                                if (_node.contains(queryValue))
                                    nodeArray.push(node);
                            }
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
                                return this.el.getAttribute('id') ? this.el.getAttribute('id') : '';
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
                            },
                            query: function (qr, context) {
                                var nodeArray = [];
                                var iterator = 0;
                                var node = null;
                                var query = qr.substring(0, 1) == "." ? 'class' : qr.substring(0, 1) == "#" ? 'id' : '';
                                var queryValue = qr.substring(1);
                                var nodeList = (query === "") ? (context || this.el).getElementsByTagName(qr) : (context || this.el).getElementsByTagName('*');
                                while (node = nodeList[iterator++]) {
                                    var _node = node.getAttribute(query);
                                    if (sys_core.isDefined(_node) && query !== "") {
                                        if (_node.contains(queryValue))
                                            nodeArray.push(sys_core.$(node));
                                    } else {
                                        if (query == "") {
                                            nodeArray.push(sys_core.$(node));
                                        }
                                    }
                                }

                                return nodeArray;
                            },
                            height: function height() {
                                var _height = 0;

                                this.each(function (elementPassed) {
                                    var DoOffset = true;

                                    if (!elementPassed) {
                                        return 0;
                                    }
                                    if (!elementPassed.style) {
                                        return 0;
                                    }


                                    var thisHeight = 0;
                                    var heightBase = parseInt(elementPassed.style.height);
                                    var heightOffset = parseInt(elementPassed.offsetHeight);
                                    var heightScroll = parseInt(elementPassed.scrollHeight);
                                    var heightClient = parseInt(elementPassed.clientHeight);
                                    var heightNode = 0;
                                    var heightRects = 0;
                                    //

                                    if (DoOffset) {
                                        if (heightOffset > thisHeight) {
                                            thisHeight = heightOffset;
                                        }
                                    }

                                    if (thisHeight == 0) {
                                        thisHeight = heightClient;
                                    }


                                    _height = thisHeight;
                                });


                                return _height;
                            },
                            width: function width() {
                                var _width = 0;

                                this.each(function (elementPassed) {
                                    var DoOffset = true;

                                    if (!elementPassed) {
                                        return 0;
                                    }
                                    if (!elementPassed.style) {
                                        return 0;
                                    }


                                    var thisWidth = 0;
                                    var widthBase = parseInt(elementPassed.style.width);
                                    var widthOffset = parseInt(elementPassed.offsetWidth);
                                    var widthScroll = parseInt(elementPassed.scrollWidth);
                                    var widthClient = parseInt(elementPassed.clientWidth);
                                    var widthNode = 0;
                                    var widthRects = 0;
                                    //

                                    if (DoOffset) {
                                        if (widthOffset > thisWidth) {
                                            thisWidth = widthOffset;
                                        }
                                    }

                                    if (thisWidth == 0) {
                                        thisWidth = widthClient;
                                    }


                                    _width = thisWidth;
                                });


                                return _width;
                            },
                            remove: function remove() {
                                this.each(function (e) {
                                    if (e.parentNode) {
                                        e.parentNode.removeChild(e);
                                    }
                                });
                            },
                            position: function position() {
                                var xPos = 0;
                                var yPos = 0;

                                this.each(function (e) {
                                    var el = e;
                                    while (el) {

                                        if (el.tagName == "BODY") {
                                            // deal with browser quirks with body/window/document and page scroll
                                            var xScroll = el.scrollLeft || document.documentElement.scrollLeft;
                                            var yScroll = el.scrollTop || document.documentElement.scrollTop;

                                            xPos += (el.offsetLeft - xScroll + el.clientLeft);
                                            yPos += (el.offsetTop - yScroll + el.clientTop);
                                        } else {
                                            // for all other non-BODY elements
                                            xPos += (el.offsetLeft - el.scrollLeft + el.clientLeft);
                                            yPos += (el.offsetTop - el.scrollTop + el.clientTop);
                                        }

                                        el = el.offsetParent;
                                    }
                                });

                                return {
                                    x: xPos,
                                    y: yPos
                                };
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

                if (!sys_core.isDefined(_require.EventRequireComplete)) {
                    _require.EventRequireComplete = new Event('EventRequireComplete');
                    _require.RequireComplete = function () {

                    };
                }

                window.removeEventListener('EventRequireComplete', _require.RequireComplete);
                _require.RequireComplete = function (e) {
                    callback ? callback() : function () {
                    };
                };
                window.addEventListener('EventRequireComplete', _require.RequireComplete);

                sys_core.each(requires, function (modulo, x, modulos, last) {
                    var module = _require.get(modulo);
                    if (last) {
                        window.dispatchEvent(_require.EventRequireComplete);
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
                new Function('', _require.readModule(module.path + '?' + module.id))();

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
                var menu = sys_core.object.create({name: ''});
                menu.name = config[0].name;
                sys_core.object.extend(menu, config[0]);
                menu.attach.each(function (e) {
                    var mnu = this.query_selector_Attribute_value('mnu-name', menu.name, e);
                    for (var x in mnu) {
                        mnu[x].event('click', function (e) {
                            menu.action.call(menu, mnu[x], e);
                        }, true);
                        if (sys_core.isDefined(menu.listeners)) {
                            sys_core.eachProto(menu.listeners, function (callback, eventName) {
                                mnu[x].event(eventName, function (e) {
                                    menu.listeners[eventName].call(menu, mnu[x], e);
                                }, true);
                            });
                        }
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
                        this.control.init.call(this.control, this.view, this.model, callback);
                    }
                });
                main.object.extend(_template, {
                    view: {
                        init: function (view_text, model) {
                            this['render-html'](view_text);
                            this.render(model);
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
                        'render-html': function (text) {
                            this['view-text'] = text;
                            main.$(this.self).mark_component(['view-template', '000']);

                            if (sys_core.isDefined(this.html)) {
                                main.$(this.self).content('');
                                main.Rendering(main.$(this.self), this.html);
                            } else {
                                main.$(this.self).content(this['view-text']);
                            }
                        },
                        'render': function (model) {

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
                                    model.load(function () {
                                        control['render-view'](view_text, view, this, callback);
                                    });
                                },
                                failure: function () {
                                    view.render('', model, {});
                                }
                            });
                            return this;
                        },
                        'render-view': function (view_text, view, model, callback) {
                            view.init.call(view, view_text, model, callback);
                            (callback ? callback.call(this, view, model) : false);
                        }
                    }
                });
                main.object.extend(_template, {
                    model: bovespa.memory({
                    })
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
        sys_core.object.extend(sys_core, {
            component: function (_object) {
                var comp = {};
                if (_object.type === 'chart') {
                    sys_core.component.chart.call(comp, _object);
                } else if (_object.type === 'table') {
                    sys_core.component.table.call(comp, _object);
                } else if (_object.type === 'select') {
                    sys_core.component.select.call(comp, _object);
                } else if (_object.type === 'mask') {
                    sys_core.component.mask.call(comp, _object);
                }

                return comp;
            }
        });
        sys_core.object.extend(sys_core.component, {
            chart: function (_object) {
                var c_render_to = null,
                        c_theme = null;

                c_theme = sys_core.config.chart.theme[_object.theme];
                c_render_to = Ext.Element.get(_object.renderTo);
                _object.Ext.renderTo = c_render_to;

                if (!sys_core.isDefined(_object.tType)) {
                    _object.tType = "bar";
                }
                if (c_theme) {
                    _object.Ext['theme'] = c_theme.name;
                    if (_object.Ext ['axes'][0]['grid'] === true) {
                        _object.Ext ['axes'][0]['grid'] = {
                            odd: c_theme.odd
                        };
                    }

                    sys_core.object.extend(_object.Ext ['series'][0]['label'], {
                        color: c_theme.color
                    });

                    sys_core.object.extend(_object.Ext ['series'][0]['style'], c_theme.style);

                    sys_core.object.extend(_object.Ext, {
                        id: sys_core.newID('chart' + '-' + _object.theme)
                    });

                } else {
                    sys_core.object.extend(_object.Ext, {
                        id: sys_core.newID('chart')
                    });
                }

                if (!sys_core.isDefined(_object.Ext.listeners)) {
                    _object.Ext.listeners = {};
                }

                sys_core.object.extend(_object.Ext.listeners, {
                    beforerender: function () {
                        Ext.getCmp(_object.Ext.id).setHeight(c_render_to.getHeight());
                        Ext.getCmp(_object.Ext.id).setWidth(c_render_to.getWidth());

                        Ext.EventManager.onWindowResize(function () {
                            Ext.getCmp(_object.Ext.id).setHeight(c_render_to.getHeight());
                            Ext.getCmp(_object.Ext.id).setWidth(c_render_to.getWidth());
                        });
                    }
                });


                Ext.create('Ext.chart.Chart', _object.Ext);
            },
            table: function (_object) {
                var eRenderTo = null,
                        $ = null;

                $ = sys_core.$;
                eRenderTo = $(_object.renderTo);
                if (!sys_core.isDefined(_object.id)) {
                    sys_core.object.extend(_object, {
                        id: sys_core.newID('table')
                    });
                }

                _object.id = sys_core.name + '-' + _object.id;

                var dtb = eRenderTo.create_element('div'),
                        dtbc = dtb.create_element('div'),
                        dtbcTable = dtbc.create_element('table'),
                        dtbcColumns = dtbcTable.create_element('thead'),
                        dtbcRows = dtbcTable.create_element('tbody');

                dtb.class().add('s-table');
                dtbc.class().add('s-table-body');
                dtbcTable.css('min-height', '50%');

                dtb.mark_component(['dtb', _object.id]);
                dtbc.mark_component(['dtbc', _object.id]);
                dtbcTable.mark_component(['dtbcTable', _object.id]);
                dtbcColumns.mark_component(['dtbcColumns', _object.id]);
                dtbcRows.mark_component(['dtbcRows', _object.id]);



                /* RENDER COLUMNS*/
                var dtRow = dtbcColumns.create_element('tr');
                sys_core.each(_object.columns, function (col) {
                    var dtRowCol = dtRow.create_element('th');
                    sys_core.Rendering.settings(dtRowCol, {
                        'data-column': col['data-name']
                    });

                    sys_core.eachProto(col, function (proto_value, protoName) {
                        var _title;
                        if (protoName === "title") {
                            _title = dtRowCol.create_element('div')
                                    .create_element('span');
                            _title.create_element('text').content(proto_value.text ? proto_value.text : '');
                            _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                        }
                    });
                });

                /* RENDER COLUMNS*/


                /* RENDER ROWS*/
                if (sys_core.isDefined(_object.data.Ext)) {
                    _object.data.Ext.each(function (data, row) {
                        var dtRow = dtbcRows
                                .create_element('tr');

                        sys_core.Rendering.settings(dtRow, {
                            'data-row': row + 1,
                            data: data
                        });

                        sys_core.each(_object.columns, function (col) {
                            var dtRowCol = dtRow.create_element('td');
                            sys_core.Rendering.settings(dtRowCol, {
                                'data-column': col['data-name']
                            });


                            dtRowCol.create_element('div')
                                    .create_element('span')
                                    .content(data.get(col['data-name']));
                        });
                    });
                } else {
                    sys_core.each(_object.data, function (data, row) {
                        var dtRow = dtbcRows
                                .create_element('tr');

                        sys_core.Rendering.settings(dtRow, {
                            'data-row': row + 1,
                            data: data
                        });

                        sys_core.each(_object.columns, function (col) {
                            var dtRowCol = dtRow.create_element('td');
                            sys_core.Rendering.settings(dtRowCol, {
                                'data-column': col['data-name']
                            });
                            dtRowCol.create_element('div')
                                    .create_element('span')
                                    .content(data[col['data-name']]);
                        });
                    });
                }
                /* RENDER ROWS*/


            },
            select: function (_object) {
                var eRenderTo = null,
                        $ = null
                mask = null;

                $ = sys_core.$;
                eRenderTo = $(_object.renderTo);
                mask = bovespa.component({type: 'mask', renderTo: _object.renderTo});

                if (!sys_core.isDefined(_object.id)) {
                    sys_core.object.extend(_object, {
                        id: sys_core.newID('select')
                    });
                }

                _object.id = sys_core.name + '-' + _object.id;

                var csComp = eRenderTo.create_element('select');
                csComp.class().add('select-default');
                csComp.mark_component(['select', _object.id]);
                csComp.attr('id', _object.id);



                if (sys_core.isDefined(_object.class)) {
                    sys_core.each(_object.class, function (c) {
                        csComp.class().add(c);
                    });
                }

                /* RENDER OPTIONS*/
                if (sys_core.isDefined(_object.data.Ext)) {
                    _object.data.Ext.each(function (data, row) {
                        var dtOption = csComp
                                .create_element('option');

                        sys_core.Rendering.settings(dtOption, {
                            'data-option': row + 1,
                            data: data.raw
                        });

                        if (sys_core.isDefined(_object.classMember)) {
                            sys_core.each(_object.classMember, function (c) {
                                dtOption.class().add(c);
                            });
                        }

                        dtOption.create_element('span')
                                .content(data.get(_object.displayMember));
                    });
                } else {
                    mask.show();
                    _object.data.load(function () {
                        _object.data.each(function () {
                            var dtOption = csComp
                                    .create_element('option'),
                                    data = this;

                            sys_core.Rendering.settings(dtOption, {
                                'data-option': data.getIndex() + 1,
                                data: data.raw()
                            });

                            if (sys_core.isDefined(_object.classMember)) {
                                sys_core.each(_object.classMember, function (c) {
                                    dtOption.class().add(c);
                                });
                            }

                            dtOption.create_element('span')
                                    .content(data.get(_object.displayMember));
                        });
                        mask.hide();
                    });
//                    mask.hide();

                }

                /* RENDER OPTIONS*/




            },
            mask: function mask(_object) {
                var eRenderTo = null,
                        $ = null,
                        mask = null;

                $ = sys_core.$;
                eRenderTo = $(_object.renderTo);

                if (!sys_core.isDefined(_object.id)) {
                    sys_core.object.extend(_object, {
                        id: sys_core.newID('mask')
                    });
                }



                var _mask = {
                    show: function () {
                        mask = eRenderTo.create_element('div');
                        mask.class().add('mask');
                        mask.class().add('s-md-back-DeepPurple-600');
                        mask.mark_component(['mask', _object.id]);
                        mask.attr('id', _object.id);
                        mask.css("min-height", eRenderTo.height() + 'px')
                                .css("min-width", eRenderTo.width() + 'px')
                                .css("position", 'absolute')
                                .css('top', eRenderTo.position().y + 'px')
                                .css('left', eRenderTo.position().x + 'px')
                                .css('opacity', "0.4");
                    },
                    hide: function () {
                        mask.remove();
                    }
                };

                sys_core.object.extend(this, _mask);
            },
            get: function (_id) {
                var comp_obj = sys_core.$(sys_core.name + '-' + _id),
                        comp_name = comp_obj.get('component-name').replace(sys_core.name + '-', '');
                var comp = {};


                sys_core.object.extend(comp, {
                    type: comp_name
                });

                if (comp_name === 'select') {
                    sys_core.object.extend(comp, {
                        selectedItem: function () {
                            var _selectedItem = null;
                            comp_obj.each(function (e) {
                                _selectedItem = e.options[e.selectedIndex];
                            });

                            if (sys_core.isDefined(_selectedItem)) {
                                var data = sys_core.$(_selectedItem).get('data');

                                if (sys_core.isDefined(data)) {
                                    if (data != "")
                                        JSON.parse(data);
                                    else
                                        data = {};
                                } else {
                                    data = {};
                                }

                                _selectedItem = JSON.parse(data);
                            }

                            return     _selectedItem;
                        },
                        selectedIdex: function () {
                            var _selectedIndex = -1;
                            comp_obj.each(function (e) {
                                _selectedIndex = e.selectedIndex;
                            });
                            return _selectedIndex;
                        },
                        options: function () {
                            var _options = null;

                            comp_obj.each(function (e) {
                                _options = e.options;
                            });
                            return _options;
                        }
                    });
                }

                return comp;

            }
        });
        /* ################### COMPONENT #####################*/

        /* ################### RENDERING #####################*/
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
                        sys_core.Rendering.settings(_render, proto_value.settings);
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

                _render.mark_component(["rendering", 'rendering']);
                return _render;
            }
        });
        sys_core.object.extend(sys_core.Rendering, {
            settings: function (_self, _settings) {
                sys_core.eachProto(_settings, function (proto_value, protoName) {
                    if (sys_core.type.isObject(proto_value)) {
                        _self.attr(protoName, JSON.stringify(proto_value));
                    } else {
                        _self.attr(protoName, proto_value);
                    }
                });
            },
            'rows': function (_colRow, _columns) {
                sys_core.each(_columns, function (it) {
                    var column = _colRow
                            .create_element('th');
                    if (sys_core.isDefined(it.settings)) {
                        sys_core.Rendering.settings(column, it.settings);
                    }

                    sys_core.eachProto(it, function (proto_value, protoName) {
                        var _title;

                        if (protoName === "col-title") {
                            _title = column
                                    .create_element('span');
                            _title.create_element('div').create_element('text').content(proto_value.text ? proto_value.text : '');
                            _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                        } else if (protoName === "title") {
                            _title = column
                                    .create_element('span');
                            _title.create_element('text').content(proto_value.text ? proto_value.text : '');
                            _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                        }

                    });
                });
            },
            'columns': function (_colRow, _columns) {
                sys_core.each(_columns, function (it) {
                    var column = _colRow
                            .create_element('th');
                    if (sys_core.isDefined(it.settings)) {
                        sys_core.Rendering.settings(column, it.settings);
                    }

                    sys_core.eachProto(it, function (proto_value, protoName) {
                        var _title;

                        if (protoName === "col-title") {
                            _title = column
                                    .create_element('span');
                            _title.create_element('div').create_element('text').content(proto_value.text ? proto_value.text : '');
                            _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                        } else if (protoName === "title") {
                            _title = column
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
                        sys_core.Rendering.settings(_literal, proto_value);
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
        /* ################### RENDERING #####################*/

        /* ################### RIPPLE #####################*/
        sys_core.object.extend(sys_core, {
            ripple: function (config) {
                var $ = sys_core.$,
                        self = config[0],
                        event = config[1];

                sys_core.$(self).event(event, function (e) {
                    e.preventDefault();
                    var self = $(this),
                            _affect = self
                            .create_element('div'),
                            ripple_name = $(this).get('ripple-name'),
                            ripple = {};

                    if (!self.class().contains('ripple')) {
                        self.class().add('ripple');
                    }

                    _affect.create_id('ripple');
                    _affect.mark_component(["ripple", _affect.get_id()]);
                    _affect.class().add('ripple-effect');

                    if (ripple_name) {
                        ripple = sys_core.ripple.get(ripple_name);
                    }

                    _affect.css("position", 'absolute')
                            .css('background', ripple.color ? ripple.color : '')
                            .css("height", $(this).height() + 'px')
                            .css("width", $(this).width() + 'px')
                            .css('top', $(this).position().y + 'px')
                            .css('left', $(this).position().x + 'px');

                    window.setTimeout(function () {
//                         self.class().remove('ripple');
                        _affect.css("height", '0px')
                                .css("width", '0px')
                                .css('background', 'transparent')
                                .css("visibility", 'hidden');
                        _affect.class().remove('ripple-effect');
                        _affect.remove();
                    }, 700);
                });

                return sys_core.ripple;
            }
        });
        sys_core.object.extend(sys_core.ripple, {
            ripples: {},
            register: function register(ripple) {
                this.ripples[ripple.name] = ripple;
                return this;
            },
            get: function get(name) {
                return this.ripples[name];
            }
        });
        /* ################### RIPPLE #####################*/



        /* ################### COOKIE #####################*/
        sys_core.object.extend(sys_core, {
            cookie: function (_dataCookie) {
                var strCookie = "";

                sys_core.eachProto(_dataCookie, function (cookValue, cookName) {
                    strCookie = strCookie + " " + cookName + "=" + cookValue + ";";
                    document.cookie = strCookie + sys_core.cookie.expires(2) + ";";
                    strCookie = "";
                });
            }
        });
        sys_core.object.extend(sys_core.cookie, {
            expires: function (exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
                return "expires=" + d.toUTCString();

            },
            get: function (cname) {
                var name = cname + "=";
                var ca = document.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) == ' ') {
                        c = c.substring(1);
                    }
                    if (c.indexOf(name) == 0) {
                        return c.substring(name.length, c.length);
                    }
                }

                return "";
            },
            exists: function (cookName) {
                var cookValue = sys_core.cookie.get(cookName);
                return !cookValue == "";
            }
        });
        /* ################### COOKIE #####################*/

        /* ################### MEMORY #####################*/
        sys_core.object.extend(sys_core, {
            memory: function memory(_parameter_settings) {
                var memory;
                memory = sys_core.object.create(sys_core.memory);

                sys_core.object.extend(memory, {'type': 'json'}, 'proxy');
                sys_core.object.extend(memory, [], 'data');
                sys_core.object.extend(memory, {}, 'model');

                if (_parameter_settings['model']) {
                    sys_core.object.extend(memory['model'], _parameter_settings['model']);
                }

                sys_core.object.extend(memory['model'], {
                    getFields: function getFields() {
                        return this['fields'];
                    },
                    getField: function getField(x) {
                        return this['fields'][x];
                    },
                    each: function each(fn) {
                        for (var x in this ['fields']) {
                            fn.call(this ['fields'][x], this, this ['fields']);
                        }
                    }
                });
                if (_parameter_settings['proxy']) {
                    sys_core.object.extend(memory['proxy'], _parameter_settings['proxy']);
                }
                sys_core.object.extend(memory['proxy'], {
                    load_data: function (fn) {
                        var s_scope = this;
                        s_scope['progress-in'] = true;
                        s_scope['progress-complete'] = false;

                        if (sys_core.isDefined(s_scope['url'])) {
                            if (s_scope['url'] === "") {
                                fn.call(memory, memory['data']);
                                return;
                            }
                        } else {
                            fn.call(memory, memory['data']);
                            return;
                        }

                        sys_core.request({
                            url: s_scope['url'],
                            success: function () {
                                s_scope.load_complete.call(s_scope, this.responseText, fn);
                            },
                            failure: function () {

                            }
                        });
                    },
                    load_complete: function (response, fn) {
                        this['progress-complete'] = true;
                        this['progress-in'] = false;
                        if (this['type'] === 'json') {
                            if (sys_core.type.isJson(response)) {
                                memory['data'] = JSON.parse(response);
                                if (this['root']) {
                                    var parts = this['root'].split('.');
                                    var dt = memory['data'];

                                    for (var i = 0; i < parts.length; i++) {
                                        dt = dt[parts[i]];
                                    }
                                    memory['data'] = dt;
                                }
                            }
                        }

                        fn.call(memory, memory['data']);
                    }
                });
                if (_parameter_settings['data']) {
                    sys_core.object.extend(memory['data'], _parameter_settings['data']);
                }

                sys_core.object.extend(memory, {
                    load: function (self_fn) {

                        if (Array.isArray(this['data'])) {
                            if (this['data'].length > 0) {
                                self_fn.call(memory, this['data']);
                                return true;
                            }
                        }

                        this['proxy'].load_data(self_fn);
                    },
                    each: function (self_fn) {
                        var data;

                        data = this['data'];

                        for (var x in data) {
                            var _store = sys_core.object.create({
                                get: function (node_name) {
                                    var _r;
                                    if (data[x][node_name]) {
                                        _r = data[x][node_name];
                                    } else {
                                        _r = '';
                                    }

                                    return _r;
                                },
                                getIndex: function () {
                                    return x;
                                },
                                raw: function () {
                                    return data[x];
                                }
                            });

                            self_fn.call(_store);
                        }
                    }
                });

                return memory;
            }
        });
        /* ################### MEMORY #####################*/


        return sys_core;











    };





    return _core;
})(window);
