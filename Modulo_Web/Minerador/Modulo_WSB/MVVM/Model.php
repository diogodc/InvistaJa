<?php

namespace Model;

require_once __DIR__ . '/../Common/Contract/DataConnection/ContractDataConnection.php';

class Model extends \Common\Contract\DataConnection\ConnectionOracle {

    protected $_table_name;

}

class ModelSession {
    
}

class ModelUser extends Model {

    private $_field_id;
    private $_field_username;
    private $_field_password;
    private $_field_name;
    private $_fiels;

    public function __construct() {
        $this->_table_name = 'BREW_USER';
        $this->_field_id = "ID_USER";
        $this->_field_username = "LOGIN";
        $this->_field_password = "PASSWORD_USER";
        $this->_field_name = "NAME_USER";
        $this->_fiels = array('ID_USER',
            'LOGIN',
            'PASSWORD_USER',
            'NAME_USER',
            'LAST_NAME_USER',
            'CPF_USER',
            'PHONE_NUMBER_USER',
            'CELL_PHONE_NUMBER_USER');
    }

    public function get_byCredentials($credentials) {
        $connection = $this->connection();

        $query_string = "Select {$this->_field_id},"
                . "             {$this->_field_name}"
                . "      From   {$this->_table_name} "
                . "      Where  {$this->_field_username} = '{$credentials->username}'"
                . "       And   {$this->_field_password} = '{$credentials->password}'";

        return $connection->executeQuery($query_string);
    }

    public function newUser($information) {
        $connection = $this->connection();

        $query_string = "Insert Into {$this->_table_name}
                                (" . implode(",", $this->_fiels) . ')'
                . "Values("
                . "       '{$information->username}'"
                . "      ,'{$information->password}'"
                . "      ,'{$information->name}'"
                . "      ,'{$information->lastname}'"
                . "      ,'{$information->cpf}'"
                . "      ,'{$information->numberphone}'"
                . "      ,'{$information->cellphone}'"
                . "      )"
                . 'commit;';
        return $connection->executeQuery($query_string);
    }

}
