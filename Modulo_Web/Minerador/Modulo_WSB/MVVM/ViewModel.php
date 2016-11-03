<?php

namespace ViewModel;

require_once __DIR__ . '/Model.php';

class ViewModel {

    protected $_model;

}

class ViewModelSession extends ViewModel {

    private $_token_generator;

    public function __construct() {
        require_once __DIR__ . '/../Common/Dependency/Token/Token.php';
        $this->_token_generator = New \Common\Dependency\Token\Token();
    }

    public function create($credentials) {
        $return = array();
        $return['sucess'] = false;

        if (!$credentials) {
            $return['message'] = 'credencias inválidas';
        } else if ($credentials == '') {
            $return['message'] = 'credencias inválidas';
        } else {
            $credentials = is_array($credentials) ? json_decode(json_encode($credentials)) : json_decode($credentials);
            $viewuser = new \View\ViewUser();
            $modeluser = $viewuser->get_byCredentials($credentials);

            if ($modeluser['sucess']) {
                $return['sucess'] = true;
                $return['message'] = "acesso permitido";
                $return['session'] = $this->create_session($modeluser['data'][0]);
            } else {
                $return['message'] = $modeluser['message'];
            }
        }


        return $return;
    }

    private function create_session($user_data) {

        $user = array();
        $user['name'] = $user_data['NAME_USER'];
        $user['id'] = $user_data['ID_USER'];
        $user['token'] = $this->_token_generator->newToken(date('d-m-Y h:i:s'));

        return $user;
    }

}

class ViewModelUser extends ViewModel {

    public function __construct() {
        $this->_model = new \Model\ModelUser();
    }

    public function get_byCredentials($credentials) {
        $return = array();

        if (!isset($credentials->username) || !isset($credentials->password)) {
            $return ['data'] = null;
        } else if ($credentials->username == "" || $credentials->password == "") {
            $return ['data'] = null;
        } elseif (isset($credentials->username) && isset($credentials->password)) {
            $return ['data'] = $this->_model->get_byCredentials($credentials);
        } else {
            $return ['data'] = null;
        }

        $return ['sucess'] = !(!$return ['data']);
        $return['message'] = $return ['sucess'] ? '' : 'credencias incorretas';

        return $return;
    }

    public function newUser($information) {
        $return = array();
        $return['sucess'] = false;

        if (!$information) {
            $return['message'] = 'informações de casdastro inválidas';
        } else if ($information == '') {
            $return['message'] = 'informações de casdastro inválidas';
        } else {
            $information = is_array($information) ? json_decode(json_encode($information)) : json_decode($information);
            $isValid = $this->isValidInformation($information);

            if ($isValid['sucess']) {
                $modeluser = $this->_model->newUser($information);
                $return['sucess'] = !(!$modeluser);
                $return['message'] = !$return['sucess'] ? 'não foi possivel cadastrar, tente mais tarde' : 'cadastrado com sucesso';
            } else {
                $return['message'] = $isValid['message'];
            }
        }
        
        return $return;
    }

    private function isValidInformation($information) {
        $return = array();
        $return['sucess'] = false;

        if (!isset($information->username) || $information->username == '') {
            $return['message'] = 'login inválido';
        } else if (!isset($information->password) || $information->password == '') {
            $return['message'] = 'senha inválida';
        } else if (!isset($information->name) || $information->name == '') {
            $return['message'] = 'nome em branco';  
        } else if (!isset($information->cellphone) || $information->cellphone == '') {
            $return['message'] = 'celular em branco';
        } else {
            $return['sucess'] = true;
        }

        return $return;
    }

}
