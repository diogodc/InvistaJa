<?php

require_once __DIR__ . '/Common/Contract/Router/ContractRouter.php';
require_once __DIR__ . '/MVVM/View.php';

$Router = New \Common\Contract\Router\Contract();
$Router->SetRoutes(array('GET', 'POST','PUT'), "/user/login", function() {
    $View = new \View\ViewSession();
    echo $View->create(file_get_contents('php://input'));
});
$Router->SetRoutes(array('GET', 'POST','PUT'), "/user/login/::username/::password", function($username, $password) {
    $View = new \View\ViewSession();
    echo $View->create(array('username' => $username, 'password' => $password));
});
$Router->SetRoutes(array('GET', 'POST','PUT'), "/user/register/::username/::password/::name/::lastname/::cpf/::numberphone/::cellphone", function($username, $password, $name, $lastname ,$cpf,$numberphone, $cellphone) {
    $View = new \View\ViewUser();
    echo $View->newUser(array('username' => $username, 'password' => $password,'name' => $name,'lastname' => $lastname ,'cpf' => $cpf,'numberphone' => $numberphone,'cellphone' => $cellphone));
});
$Router->SetRoutes(array('GET', 'POST','PUT'), "/user/register/", function() {
    $View = new \View\ViewUser();
    echo $View->newUser(file_get_contents('php://input'));
});

