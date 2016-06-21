/*
 
 */
(function (_object) {
    var _core = _object.core = {};
    _core['instance'] = function (_set) {
        var sys_core;
        var sys = function object() {
        };
        String.prototype.contains = function (text) {
            return this.toString().indexOf(text) > -1;
        };
        Number.prototype.formatMoney = function (c, d, t) {
            var n = this, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t, s = n < 0 ? "-" : "", i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", j = (j = i.length) > 3 ? j % 3 : 0;
            return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "JLib 1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
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
            onResize: function (callback, _width) {
                if (sys_core.isDefined(_width)) {
                    _width = 0;
                }

                setTimeout(function () {
                    var _onResize = false;
                    if (_width !== sys_core.width()) {
                        _width = sys_core.width();
                        _onResize = callback();
                    }

                    if (!_onResize) {
                        sys_core.onResize(callback, _width);
                    }
                }, 1);
//                document.getElementsByTagName("body")[0].onresize = callback;
                window.addEventListener('resize', callback);
//                var observer = new MutationObserver(callback);
//                observer.observe(document.body, {
//                    attributes: true,
//                    childList: true,
//                    characterData: true,
//                    subtree: true
//                });
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
            eachProtoRecursive: function (ary, callback, parentKey) {
                for (var key in ary) {
                    var _parentKey = parentKey;
                    if (ary.hasOwnProperty(key)) {
                        if (sys_core.isDefined(_parentKey))
                            _parentKey = parentKey + '.' + key;
                        else
                            _parentKey = key;
                        if (ary[key]) {
                            if (sys_core.type.isObject(ary[key])) {
                                if (sys_core.eachProtoRecursive(ary[key], callback, _parentKey)) {
                                    break;
                                }
                            } else {
                                if (callback(ary[key], key, _parentKey, ary)) {
                                    break;
                                }
                            }

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
            },
            format: function (value, Mascara) {
                var boleanoMascara;
                var Digitato = 9;
                exp = /\-|\.|\/|\(|\)| /g
                campoSoNumeros = value.toString().replace(exp, "");
                var posicaoCampo = 0;
                var NovoValorCampo = "";
                var TamanhoMascara = campoSoNumeros.length;
                ;
                if (Digitato != 8) { // backspace 
                    for (i = 0; i <= TamanhoMascara; i++) {
                        boleanoMascara = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
                                || (Mascara.charAt(i) == "/"))
                        boleanoMascara = boleanoMascara || ((Mascara.charAt(i) == "(")
                                || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " "))
                        if (boleanoMascara) {
                            NovoValorCampo += Mascara.charAt(i);
                            TamanhoMascara++;
                        } else {
                            NovoValorCampo += campoSoNumeros.charAt(posicaoCampo);
                            posicaoCampo++;
                        }
                    }
                    return NovoValorCampo;                   
                } else {
                    return true;
                }
            }
        });
        sys_core.object.extend(sys_core, {
            type: {},
            router: {},
            request: {},
            template: {},
            JLib: {}
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
                } catch (error) {
                    return false;
                }
            }
        });
        /* ################### BIBLIOTECA DE MANIPULAÇÃO DE DOCUMENTOS E ESTILO HTML #################### */
        sys_core.object.extend(sys_core, {
            JLib: function JLib(prototype, doc) {
                var _element;
                var doc = doc || document;
                sys_core.object.extend(this, {
                    query: function (qr) {
                        var nodeList = doc.getElementsByTagName('*');
                        var nodeArray = [];
                        var iterator = 0;
                        var node = null;
                        try {
                            if (qr.trim() == '') {
                                return nodeArray;
                            }
                        } catch (err) {

                        }



                        var query = qr.substring(0, 1) == "." ? 'class' : qr.substring(0, 1) == "#" ? 'id' : '';
                        var queryValue = qr.substring(1);
                        while (node = nodeList[iterator++]) {
                            var _node = node.getAttribute(query);
                            if (sys_core.isDefined(_node)) {
                                if (_node.contains(queryValue)) {
                                    nodeArray.push(node);
                                    if (query === "id")
                                        return nodeArray;
                                }
                            }
                        }

                        return nodeArray;
                    }
                });
                sys_core.object.extend(this, {
                    dom: function dom() {
                        var mlh = sys_core.JLib.mlh(_element);
                        var instance = sys_core.object.create({
                            'component-name': 'dom-element',
                            'component-date': new Date()
                        });
                        sys_core.object.extend(instance, mlh);
                        return instance;
                    }
                });
                _element = this.dom();
                sys_core.object.extend(_element, {
                    event: function event(_name, _function, _remove) {
                        this.each(function (e) {
                            if (_name === 'observer') {
                                var observer = new MutationObserver(_function);
                                observer.observe(e, {
                                    attributes: true,
                                    childList: true,
                                    characterData: true,
                                    subtree: true
                                });
                            } else {
                                if (_remove)
                                    e.removeEventListener(_name, _function, false);
                                e.addEventListener(_name, _function, false);
                            }
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
                    },
                    up: function () {
                        var parentNode;
                        this.each(function (e) {
                            parentNode = sys_core.JLib(e.parentNode);
                        });
                        return parentNode;
                    }
                });
                if (prototype instanceof Element) {
                    sys_core.object.extend(_element, {
                        type: 'id',
                        el: prototype
                    });
                } else {
                    if (doc.getElementById(prototype) != undefined) {
                        sys_core.object.extend(_element, {
                            type: 'id',
                            el: doc.getElementById(prototype)
                        });
                    } else if (doc.getElementsByName(prototype) != undefined && doc.getElementsByName(prototype).length != 0) {
                        sys_core.object.extend(_element, {
                            type: 'name',
                            el: doc.getElementsByName(prototype)
                        });
                    } else if (doc.getElementsByTagName(prototype) != undefined && doc.getElementsByTagName(prototype).length != 0) {
                        sys_core.object.extend(_element, {
                            type: 'tag',
                            el: doc.getElementsByTagName(prototype)
                        });
                    } else {
                        sys_core.object.extend(_element, {
                            type: 'query',
                            el: this.query(prototype)
                        });
                    }
                }

                return _element;
            }
        });
        sys_core.object.extend(sys_core.JLib, {
            mlh: function () {
                return  {
                    class: function () {
                        var _class,
                                _self;
                        _class = sys_core.object.create({
                            component: 'class-element'
                        });
                        _self = this;
                        sys_core.object.extend(_class, {
                            remove: function (name_class) {
                                if (_self.el.classList) {
                                    _self.el.classList.remove(name_class);
                                } else {
                                    var _class = _self.get('class').trim();
                                    this.attr('class', _class.replace(name_class, ""));
                                }
                            },
                            add: function (name_class) {
                                if (_self.el.classList) {
                                    _self.el.classList.add(name_class);
                                } else {
                                    var _class = _self.get('class').trim();
                                    this.attr('class', _class + " " + name_class);
                                }
                            },
                            contains: function (name_class) {
                                if (_self.el.classList)
                                    return  _self.el.classList.contains(name_class);
                                var _class = _self.get('class').trim();
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
                        _element = sys_core.JLib(_element);
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
                                    nodeArray.push(sys_core.JLib(node));
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
                                    nodeArray.push(sys_core.JLib(node));
                            } else {
                                if (query == "") {
                                    nodeArray.push(sys_core.JLib(node));
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
                        if (sys_core.isChrome()) {
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
                        }
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
                    },
                    mask: function () {
                        var _mask = {
                            _self: null,
                            _render: null,
                            _resize_mask: function () {
                                this._render.css("min-height", this._self.height() + 'px')
                                        .css("min-width", this._self.width() + 'px')
                                        .css('position', 'fixed')
                                        .css("z-index", '1')
                                        .css("background", 'black')
                                        .css('top', this._self.position().y + 'px')
                                        .css('left', this._self.position().x + 'px')
                                        .css('opacity', "0.4");
                            },
                            get: function () {
                                return _mask._child_;
                            }
                        };
                        this.unmask();
                        _mask._self = this;
                        _mask._render = _mask._self.create_element('div');
                        _mask._child_ = _mask._render.create_element('div');
                        _mask._render.class().add('mask');
                        _mask._render.mark_component(['mask', sys_core.newID('mask')]);
                        _mask._render.attr('id', sys_core.newID('mask'));
                        _mask._child_.css("z-index", "1");
                        _mask._child_.css("height", "100%");
                        _mask._child_.css("width", "100%");
                        _mask._child_.css('opacity', "1");
                        _mask._child_.css('background', "white");
                        sys_core.onResize(function () {
                            _mask._resize_mask.call(_mask);
                        });
                        this['_mask_'] = _mask;
                        return this['_mask_'];
                    },
                    unmask: function () {
                        if (this['_mask_']) {
                            if (this['_mask_']._render)
                                this['_mask_']._render.remove();
                        } else {
                            this.each(function (e) {
                                var _masks = sys_core.JLib(e).query_selector_Attribute_value('component-name', sys_core.name + '-' + 'mask');
                                for (var x in _masks) {
                                    _masks[x].remove();
                                }
                            });
                        }
                    },
                    fileFrame: function (_set) {
                        var _FileFrame = {
                            _self: null,
                            validator: function (File, FileText) {
                                return true;
                            },
                            load: function (File, FileText) {

                            },
                            error: function () {

                            },
                            init: function () {

                            }
                        };
                        sys_core.object.extend(_FileFrame, _set);
                        _FileFrame.init.call(_FileFrame);
                        _FileFrame._self = this;
                        _FileFrame._render = _FileFrame._self.create_element('div');
                        _FileFrame._render.class().add('file-frame');
                        _FileFrame._render.mark_component(['file-frame', sys_core.newID('file-frame')]);
                        _FileFrame._render.attr('id', sys_core.newID('file-frame'));
                        _FileFrame._render.css("min-height", '200px')
                                .css("border", "dashed 4px White")
                                .css("transition", "background-color 0.3s");
                        sys_core.object.extend(_FileFrame, {
                            _dragHover: function (e) {
                                e.stopPropagation();
                                e.preventDefault();
                                _FileFrame._render.class().add((e.type == "dragover" ? "hover" : "dragleave"));
                            },
                            _drop: function (e) {
                                _FileFrame.init.call(_FileFrame);
                                _FileFrame._dragHover(e);
                                _FileFrame._File = e.dataTransfer.files[0];
                                _FileFrame._read(_FileFrame._File);
                            },
                            _read: function (File) {
                                var reader = new FileReader();
                                reader.onload = function (_File) {
                                    var _text = _File.target.result;
                                    if (!_FileFrame.validator(_File, _text)) {
                                        _FileFrame.error.call(_FileFrame);
                                        return false;
                                    }

                                    _FileFrame.load.call(_FileFrame, _File, _text);
                                };
                                reader.readAsText(File);
                            },
                            _click: function () {
                                var _input = null;
                                _FileFrame.init.call(_FileFrame);
                                _input = _FileFrame._self.create_element("input");
                                _input.css("opacity", "0");
                                _input.attr("type", "file");
                                _input.event("change", function (e) {

                                    if (sys_core.isDefined(this.files[0])) {
                                        _FileFrame._File = this.files[0];
                                        _FileFrame._read(_FileFrame._File);
                                    }
                                });
                                _input.each(function (e) {
                                    e.click();
                                    return false;
                                });
                                _input.remove();
                            }
                        });
                        _FileFrame._render.event("dragleave", _FileFrame._dragHover);
                        _FileFrame._render.event("dragover", _FileFrame._dragHover);
                        _FileFrame._render.event("drop", _FileFrame._drop);
                        _FileFrame._render.event("click", _FileFrame._click);
                        return {
                        };
                    },
                    tost: function (settings) {
                        var _tost = {
                            _self: null
                        },
                        _position_top = 0,
                                _position_right = 0;
                        sys_core.object.extend(_tost, settings);
                        _tost._self = this;
                        _tost._render = sys_core.JLib("body").create_element('div');
                        _tost._body = _tost._render.create_element('div');
                        sys_core.Rendering.settings(_tost._render, settings.attr);
                        sys_core.Rendering.settings(_tost._body, settings.attr);
                        _tost._render.class().add("tost");
                        _tost._render.class().add("s-md-col-3");
                        _tost._render.class().add("shadow");
                        _tost._render.class().add("s-md-back-White");
                        _tost._render.css("min-height", '50px')
                                .css("min-width", '190px')
                                .css("transition", "background-color 0.3s");
                        _position_top = _tost._self.position().y;
                        _position_right = _tost._self.position().x - _tost._self.width();
                        _position_right = _position_right <= 0 ? _tost._self.position().x : _position_right;
                        _tost._render.css('position', 'absolute')
                                .css("z-index", '1')
                                .css('top', _position_top + 'px')
                                .css('right', _position_right + 'px');
                        _tost._body.class().add("s-center");
                        _tost._body.css("min-height", '50px')
                                .css("min-width", '190px');
                        _tost._body.create_element("span")
                                .content(settings.text || "");
                        setTimeout(function () {
                            _tost._render.remove();
                        }, 4000);
                    },
                    chart: function (settings) {
                        var _chart = {
                            _self: null
                        };
                    },
                    table: function (settings) {
                        var _table = {
                            _self: null
                        };
                        if (!sys_core.isDefined(settings.id)) {
                            sys_core.object.extend(settings, {
                                id: sys_core.newID('table')
                            });
                        } else {
                            settings.id = sys_core.name + '-' + settings.id;
                        }



                        _table._self = this;
                        _table._render = _table._self.create_element('div');
                        _table._div_ = _table._render.create_element('div');
                        _table._table_ = _table._div_.create_element('table');
                        _table._thead_ = _table._table_.create_element('thead');
                        _table._tbody_ = _table._table_.create_element('tbody');
                        _table._columns_ = _table._thead_.create_element('tr');
                        _table._render.class().add('s-table');
                        _table._div_.class().add('s-table-body');
                        _table._table_.css('min-height', '50%');
                        _table._render.mark_component(['data-table', settings.id]);
                        _table._div_.mark_component(['data-table-div', settings.id]);
                        _table._table_.mark_component(['data-table-main', settings.id]);
                        _table._thead_.mark_component(['data-table-head', settings.id]);
                        _table._tbody_.mark_component(['data-table-body', settings.id]);
                        _table._columns_.mark_component(['data-table-columns', settings.id]);
                        /* RENDER COLUMNS*/

                        sys_core.each(settings.columns, function (col) {
                            var _column = _table._columns_.create_element('th');
                            _column.mark_component(['data-row-columns', settings.id]);
                            sys_core.Rendering.settings(_column, {
                                'data-column': col['data-name']
                            });
                            sys_core.eachProto(col, function (proto_value, protoName) {
                                var _title;
                                if (protoName === "title") {
                                    _title = _column.create_element('div')
                                            .create_element('span');
                                    _title.create_element('text').content(proto_value.text ? proto_value.text : '');
                                    _title.create_element('subText').content(proto_value.subText ? proto_value.subText : '');
                                }
                            });
                        });
                        /* RENDER COLUMNS*/


                        /* RENDER ROWS*/
                        settings.model.each(function () {
                            var _rows = _table._tbody_
                                    .create_element('tr'),
                                    data = this;
                            _rows.mark_component(['data-row', settings.id]);
                            sys_core.Rendering.settings(_rows, {
                                'data-row': data.getIndex() + 1,
                                data: data.raw()
                            });
                            sys_core.each(settings.columns, function (col) {
                                var _cell = _rows.create_element('td');
                                var dtValue = data.get(col['data-name']);
                                _rows.mark_component(['data-row-cell', settings.id]);
                                sys_core.Rendering.settings(_cell, {
                                    'data-column': col['data-name']
                                });
                                if (sys_core.type.isFunction(col.render)) {
                                    dtValue = col.render(dtValue);
                                }


                                _cell.create_element('div')
                                        .create_element('span')
                                        .content(dtValue);
                            });
                        });
                        /* RENDER ROWS*/

                        return _table;
                    },
                    replace: function (settings) {
                        var _regx = {
                            _self: null
                        };
                        _regx._self = this;
                        _regx._self.each(function (e) {
                            _regx._child = _regx._self.query(settings.tag, e);
                            for (var x in  _regx._child) {
                                _regx._child[x].each(function (e) {
                                    if (e.textContent === settings.from) {
                                        _regx._child[x].content(settings.to || "");
                                    }
                                });
                            }
                        });
                    },
                    frame: function (settings) {
                        var _Frame = {
                            _self: null
                        };
                        _Frame._self = this;
                        _Frame._render = _Frame._self.create_element('iframe');
                        _Frame._render.attr('height', settings.height);
                        _Frame._render.attr('width', settings.width);
                        _Frame._render.attr('src', settings.src);
                        _Frame._render.attr('frameborder', "0");
                        _Frame._render.mark_component(['frame', sys_core.newID('frame')]);
                        _Frame._render.attr('id', sys_core.newID('frame'));
                        _Frame._render.event('load', function () {
                            var y = (this.contentWindow || this.contentDocument);
                            settings.onReady.apply({
                                doc: y.document,
                                body: y.document.getElementsByTagName('body')[0]
                            });
                        });
                    }
                };
            }

        });
        /* ################### BIBLIOTECA DE MANIPULAÇÃO DE DOCUMENTOS E ESTILO HTML #################### */

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


                ele = sys_core.JLib(document.createElement(eType));
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
                    root: ''
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
                        return this['url'];
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
                if (!sys_core.isDefined(module))
                    return false;
                else if (sys_core.isDefined(module.complete))
                    return false;
                module.load = 'complete';
                module.id = 'require-' + sys_core.generateUUID();
                new Function('', _require.readModule(module.path + '?' + module.id))();
                sys_core.JLib('head').include(sys_core.structure({
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
                router['route'] = router['route'].replace(/#(.*)JLib /, '');
                if (typeof config[1] == 'function') { //callback
                    router['callback'] = config[1];
                } else {
                    router['callback'] = function () {
                    };
                }

                sys_core.object.extend(router, {
                    navigate: function (callback) {
                        var location = window.location.href.replace(/#(.*)$/, '');
                        var route = this['route'].replace(/#(.*)$/, '');
                        window.location.href = location + '#' + route + "?" + sys_core.generateUUID().substring(1, 8).toUpperCase();
                        (callback ? callback : this.callback).call(this, true);
                        return this;
                    }
                });
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
                        'inject-json': function (dataBind) {
                            var view = main.JLib(this.self);
                            sys_core.eachProtoRecursive(dataBind, function (v, n, s) {
                                view.each(function (e) {
                                    var expressions = main.JLib(e).query_selector_Attribute_value('bind-value', s);
                                    sys_core.each(expressions, function (bind) {
                                        bind.content(v);
                                    });
                                });
                            });
                        },
                        'render-html': function (text) {
                            this['view-text'] = text;
                            main.JLib(this.self).mark_component(['view-template', '000']);
                            main.JLib(this.self).attr('template-name', _template.name);
                            if (sys_core.isDefined(this.html)) {
                                main.JLib(this.self).content('');
                                main.Rendering(main.JLib(this.self), this.html);
                            } else {
                                main.JLib(this.self).content(this['view-text']);
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
                        'render-before': function (view, model) {

                        },
                        'render-after': function (view, model) {

                        },
                        'render': function (view, control, model, callback) {
                            main.request({
                                url: this.url + '?get-template*' + sys_core.newID('template'),
                                success: function () {
                                    var view_text = this.responseText;
                                    model.load(function () {
                                        control['render-view'].call(control, view_text, view, this, callback);
                                    });
                                },
                                failure: function () {
                                    view.render('', model, {});
                                }
                            });
                            return this;
                        },
                        'render-view': function (view_text, view, model, callback) {
                            this['render-before'](view, model);
                            view.init.call(view, view_text, model, callback);
                            this['render-after'](view, model);
                            (callback ? callback.call(this, view, model) : false);
                        }
                    }
                });
                main.object.extend(_template, {
                    model: sys_core.memory({
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
            components: {
                select: {
                }
            },
            chart: function (config) {
                var render_to = null,
                        chart_theme = null,
                        settings = config.configs;
                if (config.tType === "line") {
                    chart_theme = sys_core.config.chart.theme[config.theme][config.tType];
                    render_to = sys_core.JLib(config.renderTo);
                    render_to.each(function (e) {
                        var chart = e.getContext("2d"),
                                data_values = null,
                                data_labels = config.model[0].toArray().get(config.label),
                                data = null;
                        data = {
                            labels: data_labels,
                            datasets: [],
                            series: []
                        };
                        if (sys_core.type.isArray(config.model)) {
                            sys_core.each(config.model, function (model, x) {
                                var data_values = model.toArray().get(config.values);
                                settings[x]['data'] = data_values;
                                data.datasets.push(settings[x]);
                                data.series.push(settings[x]);
                            });
                        } else {
                            var data_values = config.model.toArray().get(config.values);
                            settings[0]['data'] = data_values;
                            data.datasets.push(settings[0]);
                            data.series.push(settings[0]);
                        }


                        if (config.tType === "line") {
                            new Chart(chart).Line(data, chart_theme);
                        }
                    });
                } else {
                    var data = {
                        series: [],
                        labels: config.model[0].toArray().get(config.label),
                    };
                    if (sys_core.type.isArray(config.model)) {
                        sys_core.each(config.model, function (model, x) {
                            var data_values = model.toArray().get(config.values);
                            data.series.push(data_values);
                        });
                    }
                    if (config.tType === "bar") {
                        new Chartist.Bar(config.renderTo, data, settings.options, settings.responsiveOptions);
                    }
                }



                return render_to;
            },
            table: function (_object) {
                var _self = null,
                        JLib = null;
                JLib = sys_core.JLib;
                _self = JLib(_object.renderTo);
                if (!sys_core.isDefined(_object.id)) {
                    sys_core.object.extend(_object, {
                        id: sys_core.newID('table')
                    });
                }

                _object.id = sys_core.name + '-' + _object.id;
                var dtb = _self.create_element('div'),
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
                _object.model.each(function () {
                    var dtRow = dtbcRows
                            .create_element('tr'),
                            data = this;
                    sys_core.Rendering.settings(dtRow, {
                        'data-row': data.getIndex() + 1,
                        data: data.raw()
                    });
                    sys_core.each(_object.columns, function (col) {
                        var dtRowCol = dtRow.create_element('td');
                        var dtValue = data.get(col['data-name']);
                        sys_core.Rendering.settings(dtRowCol, {
                            'data-column': col['data-name']
                        });
                        if (sys_core.type.isFunction(col.render)) {
                            dtValue = col.render(dtValue);
                        }


                        dtRowCol.create_element('div')
                                .create_element('span')
                                .content(dtValue);
                    });
                });
                /* RENDER ROWS*/


            },
            select: function (_object) {
                var _self = null,
                        JLib = null,
                        mask = null,
                        _select = this;
                JLib = sys_core.JLib;
                _self = JLib(_object.renderTo);
                if (!sys_core.isDefined(_object.id)) {
                    sys_core.object.extend(_object, {
                        id: sys_core.newID('select')
                    });
                }

                _object.id = _object.id.replace(sys_core.name + '-', '');
                _object.id = sys_core.name + '-' + _object.id;
                var cs_comp,
                        cs_input,
                        cs_selectBox,
                        cs_searchText,
                        cs_selectOptions,
                        event_reset,
                        event_search,
                        event_option;
                cs_comp = _self.create_element('div');
                cs_comp.class().add('select-default');
                cs_comp.mark_component(['select', _object.id]);
                cs_comp.attr('id', _object.id);
                sys_core.component.components.select[_object.id] = {
                    selectedItem: function () {
                        var _selectedItem = cs_input.get('data');
                        if (sys_core.isDefined(_selectedItem)) {
                            var data = _selectedItem;
                            _selectedItem = JSON.parse(data);
                        } else {
                            _selectedItem = null;
                        }

                        return     _selectedItem;
                    }
                };
                if (sys_core.isDefined(_object.class)) {
                    sys_core.each(_object.class, function (c) {
                        cs_comp.class().add(c);
                    });
                }

                if (sys_core.isChrome()) {
                    cs_input = cs_comp.create_element('input');
                    cs_input.attr('value', 'Selecione uma empresa ...');
                    cs_input.css('text-align', 'center');
                    cs_comp.css('padding-top', '5px');
                    cs_comp.css('padding-bottom', '10px');
                    cs_comp.class().add('s-size-15');
                    _self.mask();
                    _object.data.load(function () {
                        cs_input.event('focus', event_rendering);
                        _self.unmask();
                    });
                    /* RENDER OPTIONS*/
                    event_rendering = function () {
                        if (cs_selectBox) {
                            cs_searchText.remove();
                            cs_selectOptions.remove();
                            cs_selectBox.remove();
                        }

                        cs_selectBox = _self.create_element('div');
                        cs_searchText = cs_selectBox.create_element('div').create_element('input');
                        cs_selectOptions = cs_selectBox.create_element('div');
                        cs_selectBox.class().add('select-default');
                        cs_selectBox.mark_component(['select-selection', _object.id]);
                        cs_selectBox.attr('style', "height:200px;z-index: 1;");
                        cs_selectBox.css('position', 'fixed');
                        cs_selectBox.css('height', '200px');
                        cs_selectOptions.attr('style', "height:125px;overflow-y:scroll;");
                        cs_searchText.attr('type', 'text');
                        /* EVENTOS DE PERDA DE FOCUS
                         * AO PEDER O FOCO - REMOVE TUDO                     *
                         * */
                        sys_core.component.components.select[_object.id]['_focus_txt'] = false;
                        sys_core.component.components.select[_object.id]['_focus_body'] = false;
                        cs_searchText.event('blur', function () {
                            sys_core.component.components.select[_object.id]._focus_txt = false;
                            var _focus_txt = sys_core.component.components.select[_object.id]._focus_txt,
                                    _focus_body = sys_core.component.components.select[_object.id]._focus_body;
                            if (!_focus_body && !_focus_txt)
                                event_lostFocus();
                        });
                        cs_selectOptions.event('blur', function () {
                            sys_core.component.components.select[_object.id]._focus_body = false;
                            var _focus_txt = sys_core.component.components.select[_object.id]._focus_txt,
                                    _focus_body = sys_core.component.components.select[_object.id]._focus_body;
                            if (!_focus_body && !_focus_txt)
                                event_lostFocus();
                        });
                        cs_selectBox.event('blur', function () {
                            sys_core.component.components.select[_object.id]._focus_body = false;
                            var _focus_txt = sys_core.component.components.select[_object.id]._focus_txt,
                                    _focus_body = sys_core.component.components.select[_object.id]._focus_body;
                            if (!_focus_body && !_focus_txt)
                                event_lostFocus();
                        });
                        cs_searchText.event('focusin', function () {
                            sys_core.component.components.select[_object.id]._focus_txt = true;
                        });
                        cs_selectOptions.event('focusin', function () {
                            sys_core.component.components.select[_object.id]._focus_body = true;
                        });
                        cs_searchText.event('mouseover', function () {
                            sys_core.component.components.select[_object.id]._focus_txt = true;
                        });
                        cs_selectOptions.event('mouseover', function () {
                            sys_core.component.components.select[_object.id]._focus_body = true;
                        });
                        cs_searchText.event('mouseout', function () {
                            sys_core.component.components.select[_object.id]._focus_txt = false;
                        });
                        cs_selectOptions.event('mouseout', function () {
                            sys_core.component.components.select[_object.id]._focus_body = false;
                        });
                        /* EVENTOS DE PERDA DE FOCUS */

                        /* EVENTOS PARA TRATAR DINAMICAMENTE O CSS
                         * TRATA A POSIÇÃO  - TOP E LEFT
                         * TRATA O TAMANHO  - WIDTH
                         * */
                        sys_core.onResize(function () {
                            cs_comp.each(function (e) {
                                cs_selectBox.css('z-index', '1');
                                cs_selectBox.css('width', cs_input.width() + 'px');
                                cs_selectBox.css('left', JLib(e.parentNode).position().x + 'px');
                                cs_selectBox.css('top', JLib(e.parentNode).position().y + 'px');
                                cs_searchText.css('width', cs_input.width() + 'px');
                                cs_selectOptions.css('width', cs_input.width() + 'px');
                            });
                        });
                        /* EVENTOS PARA TRATAR DINAMICAMENTE O CSS */

                        /* EVENTOS DE PESQUISA */
                        cs_searchText.each(function (e) {
                            e.focus();
                        });
                        cs_searchText.event('keyup', function () {
                            var _value = this.value;
                            var _data;
                            if (_value === "") {
                                event_reset.call(_object.data);
                            } else {
                                _data = _object.data.query(function () {
                                    if (_object.searchSensitive)
                                        return this.get(_object.displayMember).contains(_value);
                                    else
                                        return this.get(_object.displayMember).toLowerCase().contains(_value.toLowerCase());
                                });
                                event_search.call(_data);
                            }
                        });
                        /* EVENTOS DE PESQUISA */

                        event_reset.call(_object.data);
                    };
                    event_reset = function () {
                        cs_selectOptions.content('');
                        this.each(function () {
                            event_option.call(this);
                        });
                    };
                    event_search = function () {
                        cs_selectOptions.content('');
                        sys_core.each(this, function (data) {
                            event_option.call(data);
                        });
                    };
                    event_option = function () {
                        var dtOption = cs_selectOptions.create_element('div'),
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

                        dtOption.content(data.get(_object.displayMember));
                        dtOption.event('click', function () {
                            var _option = this;
                            cs_input.attr('value', _option.innerText);
                            sys_core.Rendering.settings(cs_input, {
                                'data-option': JLib(_option).get('data-option'),
                                'data': JLib(_option).get('data')
                            });
                            cs_selectBox.remove();
                        });
                    };
                    event_lostFocus = function () {
                        cs_searchText.remove();
                        cs_selectOptions.remove();
                        cs_selectBox.remove();
                    };
                    _object['_chrome_event'] = function () {
                        if (!sys_core.isChrome()) {
                            cs_comp.remove();
                            bovespa.component(_object);
                        }
                    };
                    window.removeEventListener('Event', _object['_chrome_event']);
                    window.addEventListener('Event', _object['_chrome_event']);
                    _object['_chrome_'] = true;
                    sys_core.onResize(function () {
                        if (!sys_core.isChrome() && _object['_chrome_']) {
                            _object['_chrome_'] = false;
                            window.dispatchEvent(sys_core.Event);
                            return true;
                        }
                    });
                    /* RENDER OPTIONS*/
                } else {
                    cs_comp.css('padding-top', '5px');
                    cs_comp.css('padding-bottom', '10px');
                    cs_comp.class().add('s-size-15');
                    cs_input = cs_comp.create_element('div');
                    cs_selectBox = cs_input.create_element('select');
                    cs_selectBox.class().add('select-default');
                    cs_selectBox.mark_component(['select-selection', _object.id]);
                    _object.data.load(function () {
                        var _primary = true;
                        this.each(function () {
                            var dtOption = cs_selectBox.create_element('option'),
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

                            dtOption.css('display', 'block');
                            dtOption.content(data.get(_object.displayMember));
                            dtOption.event('click', function () {
                                var _option = this;
                                sys_core.Rendering.settings(cs_input, {
                                    'data-option': JLib(_option).get('data-option'),
                                    'data': JLib(_option).get('data')
                                });
                            });
                            if (_primary) {
                                dtOption.each(function (e) {
                                    e.click.call(e);
                                });
                                _primary = false;
                            }
                        });
                    });
                }

                return false;
            },
            get: function (_id) {
                var comp_id = sys_core.name + '-' + _id,
                        comp_obj = sys_core.JLib(comp_id),
                        comp_name = comp_obj.get('component-name').replace(sys_core.name + '-', '');
                var comp = {};
                sys_core.object.extend(comp, {
                    type: comp_name
                });
                if (comp_name === 'select') {
                    sys_core.object.extend(comp, sys_core.component.components.select[comp_id]);
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
                var _table = sys_core.JLib(document.createElement('table'));
                if (sys_core.isDefined(s_table.columns)) {
                    if (sys_core.type.isArray(s_table.columns)) {
                        var _columns = _table.create_element('thead').create_element('tr');
                        sys_core.Rendering.columns(_columns, s_table.columns);
                    }
                }

                return _table;
            },
            'view': function (s_view) {
                return  sys_core.JLib(document.createElement('div'));
            },
            'title': function (s_title) {
                var _title = sys_core.JLib(document.createElement('div'));
                _title.create_element('span')
                        .create_element('text')
                        .content(s_title.text ? s_title.text : '');
                return _title;
            },
            'literal': function (s_literal) {
                var _literal = sys_core.JLib(document.createElement('literal-child'));
                sys_core.eachProto(s_literal, function (proto_value, protoName) {
                    if (protoName === 'settings') {
                        sys_core.Rendering.settings(_literal, proto_value);
                    } else {
                        var child_literal = sys_core.JLib(document.createElement(protoName));
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
                var JLib = sys_core.JLib,
                        self = config[0],
                        event = config[1];
                sys_core.JLib(self).event(event, function (e) {
                    e.preventDefault();
                    var self = JLib(this),
                            _affect = self
                            .create_element('div'),
                            ripple_name = JLib(this).get('ripple-name'),
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
                            .css("height", JLib(this).height() + 'px')
                            .css("width", JLib(this).width() + 'px')
                            .css('top', JLib(this).position().y + 'px')
                            .css('left', JLib(this).position().x + 'px');
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
                memory = sys_core.object.create({
                });
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
                            url: s_scope['url'] + '?get-data-model*' + sys_core.newID('data-model'),
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
                                    for (var i in parts) {
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

                var _data_store_object = function (data, x) {
                    return  sys_core.object.create({
                        get: function (node_name) {
                            var _r, dt = data[x] || data;
                            if (dt[node_name]) {
                                _r = dt[node_name];
                            } else {
                                _r = '';
                            }

                            return _r;
                        },
                        getIndex: function () {
                            return Number(x || 0);
                        },
                        raw: function () {
                            return data[x] || data;
                        }
                    });
                };
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
                    loadData: function (data) {
                        this['data'] = data;
                    },
                    each: function (self_fn) {
                        var data;
                        data = this['data'];
                        if (sys_core.type.isArray(data)) {
                            for (var x in data) {
                                self_fn.call(_data_store_object(data, x));
                            }
                        } else {
                            self_fn.call(_data_store_object(data, null));
                        }
                    },
                    toArray: function () {
                        var dataFields = {};
                        memory['model'].each(function () {
                            var field = this.name;
                            dataFields[field] = [];
                            memory.each(function () {
                                dataFields[field].push(this.get(field));
                            });
                        });
                        return sys_core.object.create({
                            get: function (node_name) {
                                var _r;
                                if (dataFields[node_name]) {
                                    _r = dataFields[node_name];
                                } else {
                                    _r = '';
                                }

                                return _r;
                            }
                        });
                    },
                    sum: function (field) {
                        var sum = 0;
                        memory.each(function () {
                            sum += Number(this.get(field));
                        });
                        return sum;
                    },
                    count: function () {
                        var y = 0;
                        if (sys_core.type.isArray(memory['data']))
                            for (var x in memory['data']) {
                                y += 1;
                            }
                        else
                            y = memory['data'] ? 1 : 0;
                        return y;
                    },
                    query: function (fn) {
                        var data = this['data'],
                                _query = [];
                        if (sys_core.type.isArray(data)) {
                            for (var x in data) {
                                if (fn.call(_data_store_object(data, x))) {
                                    _query.push(_data_store_object(data, x));
                                }
                            }
                        } else {
                            if (fn.call(_data_store_object(data, null))) {
                                _query.push(_data_store_object(data, null));
                            }
                        }


                        return {
                            each: function (fn) {
                                sys_core.each(_query, function (_data) {
                                    fn.call(_data);
                                });
                            }
                        };
                    }
                });
                return memory;
            }
        });
        /* ################### MEMORY #####################*/

        /* ################### STORAGE #####################*/
        sys_core.object.extend(sys_core, {
            storage: function (_dataStorage) {
                sys_core.eachProto(_dataStorage, function (stValue, stName) {
                    sessionStorage.setItem(stName, stValue);
                });
            }
        });
        sys_core.object.extend(sys_core.storage, {
            get: function (stName) {
                return  sessionStorage[stName];
            },
            getJson: function (stName) {
                return   JSON.parse(sessionStorage[stName]);
            },
            exists: function (stName) {
                return !(!sessionStorage.getItem(stName));
            },
            removeAll: function (stName) {
                sessionStorage.clear();
            }
        });
        /* ################### STORAGE #####################*/

        sys_core.object.extend(sys_core, {
            browserVersion: function () {
                var browser = sys_core.browser,
                        version = navigator.appVersion,
                        userAgent = navigator.userAgent,
                        _version;
                if (browser.isIE()) {
                    var thestart = parseFloat(version.indexOf("MSIE")) + 1;
                    _version = parseFloat(version.substring(thestart + 4, thestart + 7));
                    return  _version ? _version : 11;
                } else if (browser.isOpera()) {
                    return userAgent.between('opera', '') || userAgent.between('opr', '');
                } else if (browser.isEdeg()) {
                    return userAgent.between('edge', '');
                } else if (browser.isChrome()) {
                    return userAgent.between('chrome', '');
                } else if (browser.isFirefox()) {
                    return userAgent.between('firefox', '');
                } else {
                    return '';
                }


                return navigator.appVersion;
            },
            isIE: function () {
                if (navigator.appName == 'Microsoft Internet Explorer') {
                    return true;
                } else if (navigator.userAgent.match(/MSIE\s([\d]+)/)) {
                    return true;
                } else if (navigator.appName == 'Netscape' && new RegExp("Trident/.*rv:([0-9]{1,}[\.0-9]{0,})").exec(navigator.userAgent) != null) {
                    return true;
                }
                return false;
            },
            isOpera: function () {
                var nav = navigator.userAgent.toLowerCase();
                return Object.prototype.toString.call(window.opera) == '[object Opera]' || nav.indexOf("opera") != -1 || nav.indexOf("opr") != -1;
            },
            isWebKit: function () {
                return navigator.userAgent.indexOf('AppleWebKit/') > -1;
            },
            isGecko: function () {
                return navigator.userAgent.indexOf('Gecko') > -1 && navigator.userAgent.indexOf('KHTML') === -1;
            },
            isMobileSafari: function () {
                return  /Apple.*Mobile/.test(navigator.userAgent);
            },
            isEdeg: function () {
                var nav = navigator.userAgent.toLowerCase();
                return  nav.indexOf("edge") != -1;
            },
            isFirefox: function () {
                var nav = navigator.userAgent.toLowerCase();
                if (nav.indexOf("mozilla") != -1) {
                    if (nav.indexOf("firefox") != -1) {
                        return   true;
                    } else if (nav.indexOf("firefox") != -1) {
                        return  true;
                    }
                }

                return true;
            },
            isChrome: function () {
                var ua = navigator.userAgent.toLowerCase();
                var is_chrome = /chrome/.test(ua);
                return is_chrome && !sys_core.isEdeg();
            },
            isSafari: function () {
                var nav = navigator.userAgent.toLowerCase();
                if (nav.indexOf("Safari") != -1) {
                    return   true;
                }

                return true;
            }
        });
        sys_core.Event = new Event('Event');
        sys_core.object.extend(sys_core, _set);
        return sys_core;
    };
    return _core;
})(window);
