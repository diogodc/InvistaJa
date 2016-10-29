<?php
namespace Common\Dependency;
Interface DataConnection {

    public function SetUser($user);

    public function SetPassword($password);
    
    public function SetServer($server);

    public function connect();

    public function disconnect();

    public function executeQuery($query);

    public function getStatus();
}
