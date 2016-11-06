<?php

namespace View;

require_once __DIR__ . '/ViewModel.php';

abstract class View {

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

    public function create($credentials) {
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

    public function newUser($information) {
        return json_encode($this->_viewmodel->newUser($information));
    }
    
    public function updateUser($information) {
        return json_encode($this->_viewmodel->updateUser($information));
    }

}

class ViewQuestion extends View {

    public function __construct() {
        $this->_viewmodel = new \ViewModel\ViewModelQuestion();
    }

    public function handleAllQuestion() {
        return json_encode($this->_viewmodel->handleAllQuestion());
    }
    
    public function handleQuestion($id) {
        return json_encode($this->_viewmodel->handleQuestion($id));
    }

}

class ViewAnswer extends View {

    public function __construct() {
        $this->_viewmodel = new \ViewModel\ViewModelAnswer();
    }

    public function handleAllAnswer() {
        return json_encode($this->_viewmodel->handleAllAnswer());
    }
    
    public function handleAnswer($id) {
        return json_encode($this->_viewmodel->handleAnswer($id));
    }
    
    public function handleQuestionAnswer($id) {
        return json_encode($this->_viewmodel->handleQuestionAnswer($id));
    }

}

class ViewProfile extends View {

    public function __construct() {
        $this->_viewmodel = new \ViewModel\ViewModelProfile();
    }
    
    public function questionResponse($id, $question_id, $answer_id) {
        return json_encode($this->_viewmodel->questionResponse($id, $question_id, $answer_id));
    }
    
    public function whatProfile($id) {
        return json_encode($this->_viewmodel->whatProfile($id));
    }
    
}

