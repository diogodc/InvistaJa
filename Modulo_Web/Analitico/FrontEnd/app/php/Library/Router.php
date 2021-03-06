<?php

namespace Library\Routing;

function Server_Root() {   
    return $_SERVER['PATH_INFO'];
}

function Server_Method() {
   
    return $_SERVER['REQUEST_METHOD'];
}

class Router {

    private $method_get = "GET";
    private $method_post = "POST";
    private $method_put = "PUT";
    private $routes_list;
    private $settings;
    public function __construct($settings = array(definer_parameter  => ":")) {
        $this->routes_list = array();
        $this->settings = $settings;
    }

    public function Get($root, $callable) {
        $this->map($root, $callable, $this->method_get);
    }

    public function Post($root, $callable) {
        $this->map($root, $callable, $this->method_post);
    }

    public function Put($root, $callable) {
        $this->map($root, $callable, $this->method_put);
    }

    public function Error($callable) {
        if (is_callable($callable)) {
            $error = false;
            foreach ($this->routes_list as $route) {
                if (!$route->getError()) {
                    $error = true;
                    break;
                }
            }

            if (!$error) {
                call_user_func_array($callable, array(parameters => array(root => \Library\Routing\Server_Root())));
            }
        }
    }

    private function map($root, $callable, $method) {
        array_push($this->routes_list, new \Library\Routing\Router\Route($method, $root, $callable , $this->settings['definer_parameter']));
    }

}

namespace Library\Routing\Router;

Class Route {

    private $method;
    private $root;
    private $callable;
    private $error;
    private $definer_parameter;

    public function getMethod() {
        return $this->method;
    }

    public function getDefinerParameter() {
        return $this->definer_parameter;
    }

    public function getRoot() {
        return $this->root;
    }

    public function getCallable() {
        return $this->callable;
    }

    public function getError() {
        return $this->error;
    }

    public function setMethod($method) {
        $this->method = $method;
    }

    public function setDefinerParameter($definer_parameter) {
        $this->definer_parameter = $definer_parameter;
    }

    public function setRoot($root) {
        $this->root = $root;
    }

    public function setCallable($callable) {
        $this->callable = $callable;
    }

    public function setError($error) {
        $this->error = $error;
    }

    public function __construct($method, $root, $callable, $definer_parameter = ":") {
        $this->setCallable($callable);
        $this->setRoot($root);
        $this->setMethod($method);
        $this->setError(false);
        $this->setDefinerParameter($definer_parameter);
        $this->map();
    }

    private function map() {
        if (!is_callable($this->getCallable())) {
            $this->setError(true);
        }

        if (\Library\Routing\Server_Method() !== $this->getMethod()) {
            $this->setError(true);
        }

        if (!$this->getError()) {
            $route_rules = $this->root_to_array($this->getRoot());
            $route_request = $this->root_to_array(\Library\Routing\Server_Root());

            if (count($route_rules) === count($route_request)) {
                $this->on($route_rules, $route_request);
            } else {
                $this->setError(true);
            }
        }
    }

    private function on($route_rules, $route_request) {
        $rounting_parameters = array();

        foreach ($route_rules as $route_position => $route_name) {
            $is_parameter = !is_bool(strrpos($route_name, $this->getDefinerParameter()));
            $route_req_name = $route_request[$route_position];

            if ($is_parameter) {
                array_push($rounting_parameters, $route_req_name);
            } else if ($route_req_name == "") {
                $this->setError(true);
            } else if ($route_name !== $route_req_name) {
                $this->setError(true);
            }
        }

        if (!$this->getError()) {
            call_user_func_array($this->getCallable(), $rounting_parameters);
        }
    }

    private function root_to_array($roots) {
        $routes_rules = explode('/', $roots);
        $map = array();

        foreach ($routes_rules as $route) {
            if (trim($route) != '') {
                array_push($map, $route);
            }
        }

        return $map;
    }

}

