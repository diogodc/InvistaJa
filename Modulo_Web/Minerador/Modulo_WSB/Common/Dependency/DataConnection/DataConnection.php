<?php

Interface DataConnection {

    public function connect();

    public function disconnect();

    public function executeInsert($query);

    public function executeUpdate($query);

    public function executeQuery($query);

    public function executeProcedure($query);

    public function executeCount($query);

    public function getStatus();
}

