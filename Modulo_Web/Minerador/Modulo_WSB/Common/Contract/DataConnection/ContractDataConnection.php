<?php

namespace Common\Contract\DataConnection;

require_once __DIR__ . '/../../Dependency/DataConnection/DataConnection.php';
require_once __DIR__ . '/../../Dependency/DataConnection/DataConnectionOracle.php';
require_once __DIR__ . '/../../Dependency/DataConnection/DataConnectionJson.php';
abstract class Connection {

    public static function connection(){
        
    }

    public static function is_error() {

        return $_SESSION["PDO_ERROR"] === true;
    }

}

class ConnectionOracle extends \Common\Contract\DataConnection\Connection {

    public static function connection() {
        $connection = new \Common\Dependency\DataConnection\Oracle\DataConnectionOracle();

        $connection->SetPassword("rafael");
        $connection->SetUser("system");
        $connection->SetServer("localhost:1521/XE");

        return $connection;
    }

}

class ConnectionJson extends \Common\Contract\DataConnection\Connection {

    public static function connection() {
        $connection = new \Common\Dependency\DataConnection\Json\DataConnectionJson();

        $connection->SetPassword("");
        $connection->SetUser("");
        $connection->SetServer(__DIR__."/BASEConnection");

        return $connection;
    }

}
