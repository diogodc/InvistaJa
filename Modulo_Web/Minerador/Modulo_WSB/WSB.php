<?php
require_once __DIR__ . '/Common/Contract/Router/ContractRouter.php';

$Router = New \Common\Contract\Router\Contract();
$Router->SetRoutes(['GET','POST','PUT'], "/user/GET", function() {
    require_once __DIR__ . '/MVM/View.php';
    
    
    
});
