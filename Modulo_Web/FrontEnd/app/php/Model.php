<?php

namespace App\Model;

class DataConnection {

    private $token_connection;
    private $curl;
    private $method = "POST";

    public function __construct() {
        $this->token_connection = '';
        $this->method = "POST";
        $this->connect();
    }

    private function connect() {
        $this->curl = curl_init();
        return true;
    }

    public function executeQuery($url, $fields = array()) {
        $fields_string = "dt=Ktldwd932";

        if ($fields) {
            array_push($fields, array('token' => urlencode($this->token_connection)));
        } else {
            $fields = array('token' => urlencode($this->token_connection));
        }

        foreach ($fields as $key => $value) {
            $fields_string .= $key . '=' . $value . '&';
        }

        $fields_string = rtrim($fields_string, '&');


        curl_setopt($this->curl, CURLOPT_URL, $url);
        curl_setopt($this->curl, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($this->curl, CURLOPT_POST, count($fields));
        curl_setopt($this->curl, CURLOPT_POSTFIELDS, $fields_string);
        // return web page

        return curl_exec($this->curl);
    }

}

class DataDefault {

    public static function connection() {
        return new \App\Model\DataConnection();
    }

    public static function connection_uri() {
        return "http://invistaja.cloudapp.net:8080/ws_invistaja";
    }

}

namespace App\Model\Login;

function doLogin($dt_user) {
    $connection = \App\Model\DataDefault::connection();
    $query_string = \App\Model\DataDefault::connection_uri() . "/usuarios/autenticar/" . urlencode($dt_user);

    return $connection->executeQuery($query_string);
}

namespace App\Model\Company;

function GetAll() {
    $connection = \App\Model\DataDefault::connection();
    $query_string = \App\Model\DataDefault::connection_uri() . "/empresas/listar/" . urlencode($_SESSION['user_id']);
    return $connection->executeQuery($query_string);
}

namespace App\Model\Indicators;

function GetAll($emp_id) {
    $connection = \App\Model\DataDefault::connection();
    $query_string = \App\Model\DataDefault::connection_uri() . "/indicadores/consultar/" . urlencode($_SESSION['user_id']) . '/' . urlencode($emp_id);
    return $connection->executeQuery($query_string);
}
