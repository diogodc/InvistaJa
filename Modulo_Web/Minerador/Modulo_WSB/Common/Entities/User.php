<?php

namespace Common\Entities;

class User {

    private $_user_name;
    private $_user_id;
    private $_user_password;

    public function __construct() {
        $this->_user_id = null;
        $this->_user_name = "";
        $this->_user_password = "";
    }

    public function GetName() {
        return $this->_user_name;
    }

    public function GetPassword() {
        return $this->_user_password;
    }
    
     public function GetID() {
        return $this->_user_id;
    }

}
