<?php
session_start();
ini_set('memory_limit', '-1');
ini_set("max_execution_time", 1000);
require_once './php/Library/Router.php';
require_once './php/View.php';
require_once './php/Control.php';
require_once './php/Model.php';

$App = new \stdClass();

$App->Routing = new \Library\Routing\Router();

$App->Routing->Post("/Login/:data", function($dt_user) {
    echo json_encode(\App\View\Login\doLogin($dt_user));
});

$App->Routing->Get("/Login/:data", function($dt_user) {
    echo json_encode(\App\View\Login\doLogin($dt_user));
});

$App->Routing->Post("/Company/GetAll/:token", function($dt_token) {
    echo json_encode(\App\View\Company\GetAll($dt_token));
});

$App->Routing->Get("/Company/GetAll/:token", function($dt_token) {
    echo json_encode(\App\View\Company\GetAll($dt_token));
});

$App->Routing->Post("/Indicators/GetAll/:emp_id/:token", function($emp_id, $dt_token) {
    echo json_encode(\App\View\Indicators\GetAll($emp_id  ,$dt_token));
});

$App->Routing->Get("/Indicators/GetAll/:emp_id/:token", function($emp_id, $dt_token) {
    echo json_encode(\App\View\Indicators\GetAll($emp_id ,$dt_token));
});

$App->Routing->Error(function() {
    echo json_encode(array('success' => false, 'error' => func_get_args()));
});


