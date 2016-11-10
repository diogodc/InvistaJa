<?php

namespace Common\Contract\DataConnection;

require_once __DIR__ . '/../../Dependency/DataConnection/DataConnection.php';
require_once __DIR__ . '/../../Dependency/DataConnection/DataConnectionOracle.php';
require_once __DIR__ . '/../../Dependency/DataConnection/DataConnectionJson.php';

abstract class Connection {

    public static function connection() {
        
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

class ConnectionJson  {

    private $connection;

    public function __construct() {
        $this->connection = new \Common\Dependency\DataConnection\Json\DataConnectionJson();
    }

    public function connection($server) {
        
        $this->connection->SetPassword("");
        $this->connection->SetUser("");
        $this->connection->SetServer($server);

        return $this->connection;
    }

}
