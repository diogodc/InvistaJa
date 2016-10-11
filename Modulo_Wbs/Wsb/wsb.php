<?php
session_start();

require_once './App/Features.php';

$App = new \Features();

$App->Routing()->Get("/", function() {
    echo json_encode(array('success' => true, 'error' => func_get_args()));
});

$App->Routing()->Error(function() {
    echo json_encode(array('success' => false, 'error' => func_get_args()));
});
