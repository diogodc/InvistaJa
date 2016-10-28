<?php

namespace Common\Contract\DataConnection;

require_once __DIR__ . '/../../Dependency/DataConnection/DataConnection.php';
require_once __DIR__ . '/../../Dependency/DataConnection/DataConnectionOracle.php';

class Connection {

    public static function connection() {
        
    }

    public static function is_error() {
        return $_SESSION["PDO_ERROR"] === true;
    }

}

class ConnectionOracle extends \Common\Contract\DataConnection\Connection {

    public static function connection() {
        $connection = new \Common\Dependency\DataConnection\Oracle\DataConnectionOracle();

        $connection->SetPassword("");
        $connection->SetUser("");
        $connection->SetServer("");

        return $connection;
    }

}
