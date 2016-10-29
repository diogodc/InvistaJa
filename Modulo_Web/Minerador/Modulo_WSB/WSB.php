<?php

require_once __DIR__ . '/Common/Contract/Router/ContractRouter.php';
require_once __DIR__ . '/MVVM/View.php';

$Router = New \Common\Contract\Router\Contract();
$Router->SetRoutes(['GET', 'POST', 'PUT'], "/user/login", function() {
    $View = new \View\ViewSession();
    echo $View->create(file_get_contents('php://input'));
});
$Router->SetRoutes(['GET', 'POST', 'PUT'], "/user/login/::username/::password", function($username, $password) {
    $View = new \View\ViewSession();
    echo $View->create(array('username' => $username, 'password' => $password));
});

