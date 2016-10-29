<?php

require_once __DIR__ . '/Common/Contract/Router/ContractRouter.php';
require_once __DIR__ . '/MVVM/View.php';

$Router = New \Common\Contract\Router\Contract();
$Router->SetRoutes(['GET', 'POST', 'PUT'], "/user/login", function() {
    $View = new \View\ViewSession();
    echo $View->create();
});
$Router->SetRoutes(['GET', 'POST', 'PUT'], "/user/login/::username/::password", function() {
    $View = new \View\ViewSession();
    echo $View->create();
});

