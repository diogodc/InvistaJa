<?php

namespace Common\Dependency\Routing;
require_once __DIR__.'/Route.php';

function Server_Root() {   
    return isset($_SERVER['PATH_INFO']) ? $_SERVER['PATH_INFO'] : '/' ;
}

function Server_Method() {   
    return isset($_SERVER['REQUEST_METHOD']) ? $_SERVER['REQUEST_METHOD'] : 'GET';
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
                call_user_func_array($callable, array(parameters => array(root => \Common\Dependency\Routing\Server_Root())));
            }
        }
    }

    private function map($root, $callable, $method) {
        array_push($this->routes_list, new \Common\Dependency\Routing\Router\Route($method, $root, $callable , $this->settings['definer_parameter']));
    }

}


