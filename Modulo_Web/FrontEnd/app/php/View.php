<?php

namespace App\View;

namespace App\View\Login;

function doLogin($dt_user) {
    $doLogin = \App\Control\Login\doLogin($dt_user);
    $return = array();
    $return['success'] = !(!$doLogin);    
    return $return;
}

namespace App\View\Company;

function GetAll($dt_token) {
    $getAll = \App\Control\Company\GetAll($dt_token);
    $return = array();
    $return['success'] = !(!$getAll);   
    $return['data'] = $getAll;
    return $return;
}

namespace App\View\Indicators;

function GetAll($emp_id ,$dt_token) {
    $getAll = \App\Control\Indicators\GetAll($emp_id ,$dt_token);
    $return = array();
    $return['success'] = !(!$getAll);   
    $return['data'] = $getAll;
    return $return;
}

