<?php

namespace Common\Dependency\DataConnection\Json;

Class DataConnectionOracle implements \Common\Dependency\DataConnection {

    private $db_server;
    private $db_con;

    public function SetUser($user) {
        
    }

    public function SetPassword($password) {
        
    }

    public function SetServer($server = __DIR__) {
        $this->db_server = $server;
    }

    public function connect() {
        try {
            $this->db_con = $this->db_server . '.json';

            if (!file_exists($this->db_con)) {
                $fp = fopen($this->db_con, "a");
                fclose($fp);
            }
        } catch (Exception $e) {
            
        }
        return true;
    }

    public function disconnect() {
        try {
            $this->_db_con = null;
        } catch (Exception $e) {
            
        }
    }

    public function executeQuery($query) {
        try {
            return $this->prepare('GET', $query);
        } catch (Exception $e) {
            return false;
        }
    }

    public function executeNoQuery($query, $bindnames = null) {
        try {
            return $this->prepare('SET', $query, $bindnames);
        } catch (Exception $e) {
            return false;
        }
    }

    public function getStatus() {
        try {
            return ($this->_db_con) ? true : false;
        } catch (Exception $e) {
            return false;
        }
    }

    private function prepare($method = 'GET', $query = '', $oexecute = null) {
        $this->connect();

        if ($this->getStatus()) {
            $data = file_get_contents($this->db_con);
            $rows = $this->dbType == 'json' ? json_decode($data, true) : $data;

            $odata = $this->despatch($query, $method, $rows, $oexecute);

            if ($method == 'SET') {
                $oexecute = file_put_contents($this->db_con, json_encode($odata));
            }
        }

        $this->disconnect();

        return $method == 'GET' ? $oexecute : ($oexecute ? $odata : null);
    }

    private function despatch($path, $method, $data, &$value = NULL) {
        $path = explode('/', $path);

        $key = array_shift($path);

        $npath = implode('/', $path);

        if ($method == 'GET' && count($path) === 0) {
            $value = $data[$key];
        } else if ($method == 'SET' && count($path) === 0) {
            $data[$key] = $value;
        } else if (!empty($data[$key]) && is_array($data[$key])) {
            $data[$key] = $this->despatch($npath, $method, $data[$key], $value);
        } else if ($method == 'SET' && empty($data[$key])) {
            $data[$key] = array();
            $data[$key] = $this->despatch($npath, $method, $data[$key], $value);
        } else {
            $value = FALSE;
        }

        return $data;
    }

}
