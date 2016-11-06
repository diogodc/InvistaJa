<?php

require_once __DIR__ . '/Common/Contract/Router/ContractRouter.php';
require_once __DIR__ . '/MVVM/View.php';

$Router = New \Common\Contract\Router\Contract();
$Router->SetRoutes(array('POST'), "/user/authenticate", function() {
    $View = new \View\ViewSession();
    echo $View->create(file_get_contents('php://input'));
});
$Router->SetRoutes(array('POST'), "/user/authenticate/::username/::password", function($username, $password) {
    $View = new \View\ViewSession();
    echo $View->create(array('username' => $username, 'password' => $password));
});
$Router->SetRoutes(array('PUT'), "/user/register/::username/::password/::name/::cellphone", function($username, $password, $name, $cellphone) {
    $View = new \View\ViewUser();
    echo $View->newUser(array('username' => $username, 'password' => $password,'name' => $name,'cellphone' => $cellphone));
});
$Router->SetRoutes(array('GET', 'POST','PUT'), "/user/register/", function() {
    $View = new \View\ViewUser();
    echo $View->newUser(file_get_contents('php://input'));
});

$Router->SetRoutes(array('GET', 'POST','PUT'), "/questions", function() {
    $View = new \View\ViewQuestion();
    echo $View->handleAllQuestion();
});

$Router->SetRoutes(array('GET', 'POST','PUT'), "/question/::id", function($id) {
    $View = new \View\ViewQuestion();
    echo $View->handleQuestion($id);
});

$Router->SetRoutes(array('GET', 'POST','PUT'), "/answer/", function() {
    $View = new \View\ViewAnswer();
    echo $View->handleAllAnswer();
});

$Router->SetRoutes(array('GET', 'POST','PUT'), "/answer/::id", function($id) {
    $View = new \View\ViewAnswer();
    echo $View->handleAnswer($id);
});

$Router->SetRoutes(array('GET', 'POST','PUT'), "/question/answer/::id", function($id) {
    $View = new \View\ViewAnswer();
    echo $View->handleQuestionAnswer($id);
});


