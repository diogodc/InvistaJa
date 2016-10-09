<?php
session_start();

require_once './App/App.php';

$App = new \Features();

$App::CopySession();

$App->Routing()->Error(function() {
    echo json_encode(array(success => false, error => func_get_args()));
});
