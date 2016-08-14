<?php

namespace App\Control;

function Guid() {
    if (function_exists('com_create_guid') === true) {
        return trim(com_create_guid(), '{}');
    }

    return sprintf('%04X%04X-%04X-%04X-%04X-%04X%04X%04X', mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(16384, 20479), mt_rand(32768, 49151), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535));
}

function Home() {
    header("location:" . sprintf('http%s://%s%s', isset($_SERVER['HTTPS']) ? 's' : null, $_SERVER['HTTP_HOST'], ''));
}

namespace App\Control\Login;

function doLogin($dt_user) {
    $return = false;
    $doLogin = \App\Model\Login\doLogin($dt_user);

    if ($doLogin) {
        $doLogin = json_decode($doLogin);
        if (is_object($doLogin)) {
            if ($doLogin->usuario_ID) {
                $_SESSION['user_id'] = $doLogin->usuario_ID;
                $_SESSION['user_name'] = $doLogin->usuario_Nome;
                $_SESSION['user_token'] = \App\Control\Guid();
                $return = array(token => $_SESSION['user_token']);
            }
        }
    }


    return $return;
}

namespace App\Control\Company;

function GetAll($dt_token) {
    if ($dt_token != $_SESSION['user_token']) {
        \App\Control\Home();
        exit;
    }

    $getAll = \App\Model\Company\GetAll();
    if ($getAll) {
        $getAll = json_decode($getAll);
    }

    return $getAll;
}

namespace App\Control\Indicators;

function GetAll($emp_id, $dt_token) {
    if ($dt_token != $_SESSION['user_token']) {
        \App\Control\Home();
        exit;
    }

    $getAll = \App\Model\Indicators\GetAll($emp_id);
    if ($getAll) {
        $getAll = json_decode($getAll);
    }

    return $getAll;
}
