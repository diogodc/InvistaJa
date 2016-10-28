<?php
namespace Common\Dependency\DataConnection\Oracle;
Class DataConnectionOracle implements \Common\Dependency\DataConnection {
    private $_db_user;
    private $_db_password; 
    private $_db_server; 
    
    
    public function SetUser($user){
        $this->_db_user =  $user;  
    }

    public function SetPassword($password){
         $this->_db_password =  $password;  
    }
    
    public function SetServer($server) {
         $this->_db_server =  $server;  
    }
    
    public function connect() {
        try {
            
        } catch (Exception $e) {
            
        }
        return true;
    }

    public function disconnect() {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    public function executeInsert($query) {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    public function executeUpdate($query) {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    public function executeQuery($query) {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    public function executeProcedure($query) {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    public function executeCount($query) {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    public function getStatus() {
        try {
            
        } catch (Exception $e) {
            
        }
    }

    private function showConnectionData() {
        try {
            
        } catch (Exception $e) {
            
        }
    }

}