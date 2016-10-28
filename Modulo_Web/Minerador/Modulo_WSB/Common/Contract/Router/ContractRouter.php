<?php

namespace Common\Contract\Router;

require_once __DIR__ . '/../../Dependency/Router/Router.php';

class Contract {

    private $_router;

    public function __construct() {
        $this->_router = new \Common\Dependency\Routing\Router(array(definer_parameter => "::"));
    }

    public function SetRoute($parametro_method, $parametro_1, $parametro_2) {
        switch ($parametro_method) {
            case "GET":
                $this->_router->Get($parametro_1, $parametro_2);
                break;
            case "POST":
                $this->_router->Post($parametro_1, $parametro_2);
                break;
            case "PUT":
                $this->_router->Put($parametro_1, $parametro_2);
                break;
            default:
                $this->_router->Get($parametro_1, $parametro_2);
                break;
        }
        return $this;
    }

    public function SetRoutes($parametro, $parametro_1, $parametro_2) {

        foreach ($parametro as $method) {
            $this->SetRoute($method, $parametro_1, $parametro_2);
        }
        
        return $this;
    }

    public function GetRouter() {
        return $this->_router;
    }

}
