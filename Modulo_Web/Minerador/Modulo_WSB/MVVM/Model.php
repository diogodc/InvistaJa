<?php

namespace Model;

require_once __DIR__ . '/../Common/Contract/DataConnection/ContractDataConnection.php';

abstract class Model extends \Common\Contract\DataConnection\ConnectionOracle {

    protected $_table_name;

    public function executeQuery($fields, $where, $joins) {
        try {
            $query_string = "SELECT {FIELDS} "
                    . "      FROM {TABLE} {JOIN}"
                    . "      WHERE 1=1 {WHERE}";

            $connection = $this->connection();

            if ($fields && is_array($fields)) {
                $query_string = str_replace("{FIELDS}", implode(",", $fields), $query_string);
            } else {
                $query_string = str_replace("{FIELDS}", "*", $query_string);
            }
            if ($joins && is_array($joins)) {
                $innerjoin = "";
                foreach ($joins as $join => $on) {
                    $innerjoin .= " INNER JOIN {$join} ON {$on} ";
                }
                $query_string = str_replace("{JOIN}", $innerjoin, $query_string);
            } else {
                $query_string = str_replace("{JOIN}", "", $query_string);
            }


            if ($where && is_array($where)) {
                $query_string = str_replace("{WHERE}", " And " . implode(",", $where), $query_string);
            } else {
                $query_string = str_replace("{WHERE}", "", $query_string);
            }

            $query_string = str_replace("{TABLE}", $this->_table_name, $query_string);

            return $connection->executeQuery($query_string);
        } catch (Exception $e) {
            return null;
        }
    }

    public function executeInsert() {
        
    }

    public function executeUpdate($fields, $where) {
        try {
            $query_string = "UPDATE {TABLE} "
                    . "      SET {FIELDS} "
                    . "      WHERE 1=1 {WHERE}";

            $connection = $this->connection();

            if ($fields && is_array($fields)) {
                $query_string = str_replace("{FIELDS}", implode(",", $fields), $query_string);
            } else {
                $query_string = "";
            }

            if ($where && is_array($where)) {
                $query_string = str_replace("{WHERE}", " And " . implode(",", $where), $query_string);
            } else {
                $query_string = str_replace("{WHERE}", "", $query_string);
            }

            $query_string = str_replace("{TABLE}", $this->_table_name, $query_string);

            return $connection->executeInsert($query_string, null);
        } catch (Exception $ex) {
            return null;
        }
    }

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
        $this->_fiels = array('LOGIN',
            'PASSWORD_USER',
            'NAME_USER',
            'PHONE_NUMBER_USER');
    }

    public function get_byCredentials($credentials) {
        return $this->executeQuery(null, array("{$this->_field_username} = '{$credentials->username}'"), "{$this->_field_password} = '{$credentials->password}'");
    }

    public function newUser($information) {
        $connection = $this->connection();

        $query_string = "Insert Into {$this->_table_name}
                                (" . implode(",", $this->_fiels) . ')'
                . "Values("
                . "       '{$information->username}'"
                . "      ,'{$information->password}'"
                . "      ,'{$information->name}'"
                . "      ,'{$information->cellphone}' "
                . "       )";
        return $connection->executeInsert($query_string, null);
    }

    public function updateUser($information) {
        return $this->executeUpdate(array("LOGIN = '{$information->username}'",
                    "PASSWORD_USER = '{$information->password}'",
                    "NAME_USER = '{$information->name}'",
                    "PHONE_NUMBER_USER = '{$information->cellphone}'"), array("{$this->_field_id} = {$information->id}"));
    }

}

class ModelQuestion extends Model {

    public function __construct() {
        $this->_table_name = 'BREW_QUESTION';
    }

    public function handleAllQuestion() {
        return $this->executeQuery(null, null, null);
    }

    public function handleQuestion($id) {
        return $this->executeQuery(null, array("ID_QUESTION = {$id}"));
    }

}

class ModelAnswer extends Model {

    public function __construct() {
        $this->_table_name = 'BREW_ANSWER';
    }

    public function handleAllAnswer() {
        return $this->executeQuery(null, null, null);
    }

    public function handleAnswer($id) {
        return $this->executeQuery(null, array("ID_ANSWER = {$id}"));
    }
    
     public function handleQuestionAnswer($id) {
        return $this->executeQuery(null, array("ID_QUESTION = {$id}"));
    }

}