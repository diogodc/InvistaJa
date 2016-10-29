<?php

namespace Common\Dependency\DataConnection\Oracle;

Class DataConnectionOracle implements \Common\Dependency\DataConnection {

    private $_db_user;
    private $_db_password;
    private $_db_server;
    private $_db_con;

    public function SetUser($user) {
        $this->_db_user = $user;
    }

    public function SetPassword($password) {
        $this->_db_password = $password;
    }

    public function SetServer($server) {
        $this->_db_server = $server;
    }

    public function connect() {
        try {
            $this->_db_con = \oci_connect($this->_db_user, $this->_db_password, $this->_db_server);
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

            $data = null;
            $this->connect();
            if ($this->getStatus()) {
                $stid = $this->prepare($query);

                \oci_execute($stid);

                $nrows = \oci_fetch_all($stid, $data ,  null, null, OCI_FETCHSTATEMENT_BY_ROW);
                print_r($data, $nrows);
                if (!$nrows) {
                    return null;
                } else if ($nrows == 0) {
                    return null;
                }
            }

            if ($data) {
                return $data;
            } else {
                return false;
            }

            $this->disconnect();
        } catch (Exception $e) {
            
        }
    }

    public function getStatus() {
        try {
            return ($this->_db_con) ? true : false;
        } catch (Exception $e) {
            
        }
    }

    private function showConnectionData() {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    private function prepare($query) {
        try {
            return \oci_parse($this->_db_con, $query);
        } catch (Exception $e) {
            
        }
    }

}
