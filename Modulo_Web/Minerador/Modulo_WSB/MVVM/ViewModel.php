<?php

namespace ViewModel;

require_once __DIR__ . '/Model.php';

abstract class ViewModel {

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
        $user['cellphone'] = $user_data['PHONE_NUMBER_USER'];
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

    public function updateUser($information) {
        $return = array();
        $return['sucess'] = false;

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

    public function __construct() {
        $this->_model = new \Model\ModelQuestion();
    }

    public function handleAllQuestion() {
        $return = array();
        $return['sucess'] = false;
        $return['question'] = $this->_model->handleAllQuestion();
        $return['sucess'] = !(!$return['question']);

        return $return;
    }

    public function handleQuestion($id) {
        $return = array();
        $return['sucess'] = false;
        $return['question'] = $this->_model->handleQuestion($id);
        $return['sucess'] = !(!$return['question']);

        return $return;
    }

}

class ViewModelAnswer extends ViewModel {

    public function __construct() {
        $this->_model = new \Model\ModelAnswer();
    }

    public function handleAllAnswer() {
        $return = array();
        $return['sucess'] = false;
        $return['answer'] = $this->_model->handleAllAnswer();
        $return['sucess'] = !(!$return['answer']);

        return $return;
    }

    public function handleAnswer($id) {
        $return = array();
        $return['sucess'] = false;
        $return['answer'] = $this->_model->handleAnswer($id);
        $return['sucess'] = !(!$return['answer']);

        return $return;
    }

    public function handleQuestionAnswer($id) {
        $return = array();
        $return['sucess'] = false;
        $return['answer'] = $this->_model->handleQuestionAnswer($id);
        $return['sucess'] = !(!$return['answer']);

        return $return;
    }

}

class ViewModelProfile extends ViewModel {

    public function __construct() {
        $this->_model = new \Model\ModelProfile();
    }

    public function questionResponse($id, $question_id, $answer_id) {
        $return = array();
        $return['sucess'] = false;

        if (!$this->_model->handleQuestionResponse($id, $question_id)) {
            $return['response'] = $this->_model->questionResponse($id, $question_id, $answer_id);
        } else {
            $return['response'] = true;
        }

        $return['sucess'] = !(!$return['response']);

        return $return;
    }

    public function whatProfile($id) {
        $return = array();
        $return['sucess'] = false;
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

        return $return;
    }

    private function detectsProfile($total) {
        try {
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
        } catch (Exception $ex) {
            return null;
        }
    }

}
