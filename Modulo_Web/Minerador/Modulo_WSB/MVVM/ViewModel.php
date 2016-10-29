<?php

namespace ViewModel;

require_once __DIR__ . '/Model.php';

class ViewModel {

    protected $_Model;

}

class ViewModelSession extends ViewModel {

    private $_token_generator;

    public function __construct() {
        require_once __DIR__ . '/../Common/Dependency/Tokken/Tokken.php';
        $this->_token_generator = New \Common\Dependency\Tokken\Tokken();
    }

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
            $modeluser = $viewuser->get_byCredentials($credentials);

            if ($modeluser['sucess']) {
                $return['token'] = $this->create_session($modeluser['data'][0]);
            }
        }


        return $return;
    }

    private function create_session($user_data) {

        $user = array();
        $user['name'] = $user_data['NAME_USER'];
        $user['id'] = $user_data['ID_USER'];
        $user['dt'] = date('dmYhis');
        
        return $this->_token_generator->newTokken(json_encode($user));
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
