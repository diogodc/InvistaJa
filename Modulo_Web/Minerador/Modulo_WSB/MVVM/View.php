<?php

namespace View;

require_once __DIR__ . '/ViewModel.php';

class View {

    protected $_viewmodel;

    public static function guid() {
        if (function_exists('com_create_guid') === true) {
            return trim(com_create_guid(), '{}');
        }

        return sprintf('%04X%04X-%04X-%04X-%04X-%04X%04X%04X', mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(16384, 20479), mt_rand(32768, 49151), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535));
    }

}

class ViewSession extends View {

    public function __construct() {
        $this->_viewmodel = new \ViewModel\ViewModelSession();
    }

    public function create() {
        $credentials = array('username' => 'rafael', 'password' => '1'); //file_get_contents('php://input');
        return json_encode($this->_viewmodel->create($credentials));
    }

}

class ViewUser extends View {

    public function __construct() {
        $this->_viewmodel = new \ViewModel\ViewModelUser();
    }

    public function get_byCredentials($credentials) {
        return $this->_viewmodel->get_byCredentials($credentials);
    }

}
