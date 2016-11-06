<?php

require_once __DIR__ . '/Common/Contract/Router/ContractRouter.php';
require_once __DIR__ . '/MVVM/View.php';

$Router = New \Common\Contract\Router\Contract();
$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/user/authenticate/", function() {
    $View = new \View\ViewSession();
    echo $View->create(file_get_contents('php://input'));
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/user/authenticate/::username/::password/", function($username, $password) {
    $View = new \View\ViewSession();
    echo $View->create(array('username' => $username, 'password' => $password));
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/user/register/::username/::password/::name/::cellphone/", function($username, $password, $name, $cellphone) {
    $View = new \View\ViewUser();
    echo $View->newUser(array('username' => $username, 'password' => $password, 'name' => $name, 'cellphone' => $cellphone));
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/user/register/", function() {
    $View = new \View\ViewUser();
    echo $View->newUser(file_get_contents('php://input'));
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/user/update/::id/::username/::password/::name/::cellphone/", function($token, $id, $username, $password, $name, $cellphone) {
    $View = new \View\ViewUser();
    echo $View->updateUser(array('id' => $id, 'username' => $username, 'password' => $password, 'name' => $name, 'cellphone' => $cellphone));
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/user/update/", function($token) {
    $View = new \View\ViewUser();
    echo $View->updateUser(file_get_contents('php://input'));
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/questions/", function($token) {
    $View = new \View\ViewQuestion();
    echo $View->handleAllQuestion();
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/question/::id/", function($token, $id) {
    $View = new \View\ViewQuestion();
    echo $View->handleQuestion($id);
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/answers/", function($token) {
    $View = new \View\ViewAnswer();
    echo $View->handleAllAnswer();
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/answer/::id/", function($token, $id) {
    $View = new \View\ViewAnswer();
    echo $View->handleAnswer($id);
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/question/answer/::id/", function($token, $id) {
    $View = new \View\ViewAnswer();
    echo $View->handleQuestionAnswer($id);
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/profile/::id/response/::question_id/::answer_id/", function($token, $id, $question_id, $answer_id) {
    $View = new \View\ViewProfile();
    echo $View->questionResponse($id, $question_id, $answer_id);
});

$Router->SetRoutes(array('GET', 'POST', 'PUT'), "/::token/profile/::id/what/", function($token, $id) {
    $View = new \View\ViewProfile();
    echo $View->whatProfile($id);
});

