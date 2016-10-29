<?php

namespace ViewModel;

require_once __DIR__ . '/Model.php';

class ViewModel {

    protected $_Model;

}

class ViewModelSession extends ViewModel {

    public function create($credentials) {
        $return = array();
        $return['sucess'] = false;

        if (!$credentials) {
            $return['message'] = 'credencias inválidas';
        } else if ($credentials == '') {
            $return['message'] = 'credencias inválidas';
        } else {
            $credentials = json_decode(json_encode($credentials));
            $viewuser = new \View\ViewUser();
            $user = $viewuser->get_byCredentials($credentials);

            $return['user'] = $user;
        }


        return $return;
    }

}

class ViewModelUser extends ViewModel {

    public function __construct() {
        $this->_model = new \Model\ModelUser();
    }

    public function get_byCredentials($credentials) {
        $return = array();
        $return ['data'] = $this->_model->get_byCredentials($credentials);
        $return ['sucess'] = !(!$return ['data']);


        return $return;
    }

}
