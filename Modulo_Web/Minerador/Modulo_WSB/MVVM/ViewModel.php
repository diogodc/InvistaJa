<?php

namespace ViewModel;

require_once __DIR__ . '/Model.php';

abstract class ViewModel {

    protected $_model;

    static function guid() {
        if (function_exists('com_create_guid') === true) {
            return trim(com_create_guid(), '{}');
        }

        return sprintf('%04X%04X-%04X-%04X-%04X-%04X%04X%04X', mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(16384, 20479), mt_rand(32768, 49151), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535));
    }

}

class ViewModelSession extends ViewModel {

    public function __construct() {

        $this->_model = New \Model\ModelSession();
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
                $return['session'] = $this->create_session($modeluser['data'][0]);
                $return['sucess'] = !(!$return['session']);
                $return['message'] = "acesso permitido";
            } else {
                $return['message'] = $modeluser['message'];
            }
        }



        return $return;
    }

    public function handleSession($token) {

        $return = array();
        $return['token'] = $this->_model->handleSession($token);
        $return['sucess'] = !(!$return['token']);

        return $return;
    }

    public function expiredSession($token) {

        $return = array();
        $return ['session'] = $token ? $this->handleSession($token) : null;
        $return ['sucess'] = $return ['session']['sucess'];
        $return ['session'] = $return ['session']['token'];
        $return ['message'] = $return ['sucess'] ? '' : 'sessão expirada!';

        return $return;
    }

    private function create_session($user_data) {

        $user = array();
        $user['name'] = $user_data['NAME_USER'];
        $user['id'] = $user_data['ID_USER'];
        $user['cellphone'] = $user_data['PHONE_NUMBER_USER'];
        $user['date'] = date('d-m-Y h:i:s');
        $user['token'] = $this->guid();

        if ($this->_model->create_session($user['token'], $user)) {
            return $user;
        }

        return null;
    }

}

class ViewModelUser extends ViewModel {

    private $session = null;

    public function __construct($token = null) {
        $this->_model = new \Model\ModelUser();
        $this->session = (new ViewModelSession())->expiredSession($token);
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

    public function updateUser($information) {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            if (!$information) {
                $return['message'] = 'informações inválidas';
            } else if ($information == '') {
                $return['message'] = 'informações inválidas';
            } else {
                $information = is_array($information) ? json_decode(json_encode($information)) : json_decode($information);
                $validatesUpdate = $this->validatesUpdate($information);

                if ($validatesUpdate['sucess']) {
                    $modeluser = $this->_model->updateUser($information);
                    $return['sucess'] = !(!$modeluser);
                    $return['message'] = !$return['sucess'] ? 'não foi possivel atualizar, tente mais tarde' : 'atualizado com sucesso';
                } else {
                    $return['message'] = $validatesUpdate['message'];
                }
            }
        }


        return $return;
    }

    private function validatesUpdate($information) {
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
        } else if (!isset($information->id) || $information->id == '') {
            $return['message'] = 'id do usuário em branco';
        } else {
            $return['sucess'] = true;
        }

        return $return;
    }

}

class ViewModelQuestion extends ViewModel {

    private $session = null;

    public function __construct($token = null) {
        $this->_model = new \Model\ModelQuestion();
        $this->session = (new ViewModelSession())->expiredSession($token);
    }

    public function handleAllQuestion() {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            $return['question'] = $this->_model->handleAllQuestion();
            $return['sucess'] = !(!$return['question']);
        }

        return $return;
    }

    public function handleQuestion($id) {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            $return['question'] = $this->_model->handleQuestion($id);
            $return['sucess'] = !(!$return['question']);
        }
        return $return;
    }

}

class ViewModelAnswer extends ViewModel {

    private $session = null;

    public function __construct($token = null) {
        $this->_model = new \Model\ModelAnswer();
        $this->session = (new ViewModelSession())->expiredSession($token);
    }

    public function handleAllAnswer() {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            $return['answer'] = $this->_model->handleAllAnswer();
            $return['sucess'] = !(!$return['answer']);
        }
        return $return;
    }

    public function handleAnswer($id) {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            $return['answer'] = $this->_model->handleAnswer($id);
            $return['sucess'] = !(!$return['answer']);
        }
        return $return;
    }

    public function handleQuestionAnswer($id) {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            $return['answer'] = $this->_model->handleQuestionAnswer($id);
            $return['sucess'] = !(!$return['answer']);
        }
        return $return;
    }

}

class ViewModelProfile extends ViewModel {

    private $session = null;

    public function __construct($token = null) {
        $this->_model = new \Model\ModelProfile();
        $this->session = (new ViewModelSession())->expiredSession($token);
    }

    public function questionResponse($id, $question_id, $answer_id) {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            if (!$this->_model->handleQuestionResponse($id, $question_id)) {
                $return['response'] = $this->_model->questionResponse($id, $question_id, $answer_id);
            } else {
                $return['response'] = true;
            }

            $return['sucess'] = !(!$return['response']);
        }
        return $return;
    }

    public function whatProfile($id) {
        $return = array();
        $return['sucess'] = false;
        $return['message'] = $this->session['message'];
        if ($this->session['sucess']) {
            $return['profile'] = $this->_model->handleProfile($id);
            if (!$return['profile']) {
                $total = $this->_model->handleTotal($id);
                if ($total) {
                    $total = $total[0];
                    $profile = $this->detectsProfile((int) $total);

                    if ($profile) {
                        $save = $this->_model->setProfile($id, $profile['NAME_PROFILE'], $profile['RESUMO'], $profile['TYPE']);
                        $return['sucess'] = !(!$save);
                        $return['profile'] = $return['sucess'] ? $profile : null;
                    }
                }
            }


            $return['sucess'] = !(!$return['profile']);
        }
        return $return;
    }

    private function detectsProfile($total) {
        $profile = null;
        if ($total <= 28) {
            $profile = array(
                'NAME_PROFILE' => 'Perfil Conservador',
                'RESUMO' => 'Clientes com este perfil têm como objetivo a preservação do capital e possuem baixa tolerância a riscos. Também é representado por clientes que, apesar de estarem dispostos a correr um pouco mais de riscos na busca por retornos diferenciados, tenham necessidade de sacar os recursos em curto período de tempo.',
                'TYPE' => 1
            );
        } elseif ($total > 29 && $total <= 52) {
            $profile = array(
                'NAME_PROFILE' => 'Perfil Moderado',
                'RESUMO' => 'Clientes com este perfil estão dispostos a correr alguns riscos em investimentos, buscando um retorno diferenciado no médio prazo, com baixa necessidade de liquidez no curto prazo, havendo disponibilidade para diversificar parte das aplicações em alternativas mais arrojadas.',
                'TYPE' => 2
            );
        } else {
            $profile = array(
                'NAME_PROFILE' => 'Perfil Agressivo',
                'RESUMO' => 'Este perfil é representado por clientes com alta tolerância a riscos, baixa ou nenhuma necessidade de liquidez no curto/médio prazo e que estejam dispostos a aceitar as oscilações dos mercados de risco (e possíveis perdas) na busca por retornos diferenciados no longo prazo.',
                'TYPE' => 3
            );
        }
        return $profile;
    }

}
