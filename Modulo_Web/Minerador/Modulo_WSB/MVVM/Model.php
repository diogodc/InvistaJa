<?php

namespace Model;

require_once __DIR__ . '/../Common/Contract/DataConnection/ContractDataConnection.php';

abstract class Model extends \Common\Contract\DataConnection\ConnectionOracle {

    protected $_table_name;

    private function prepare_fields($fields = null) {
        $query_fields = "*";

        if (is_array($fields)) {
            $query_fields = implode(", ", $fields);
        }

        return $query_fields;
    }

    private function prepare_joins($joins = null) {
        $query_join = "";

        if (is_array($joins)) {
            foreach ($joins as $join => $on) {
                $query_join .= " INNER JOIN {$join} ON {$on} ";
            }
        }

        return $query_join;
    }

    private function prepare_where($where = null) {
        $query_where = "";

        if (is_array($where)) {
            $query_where = " AND " . implode(" AND ", $where);
        }

        return $query_where;
    }

    protected function executeQuery($fields = null, $where = null, $joins = null) {
        try {
            $query_base = "SELECT {FIELDS} "
                    . "    FROM {TABLE} "
                    . "         {JOIN} "
                    . "    WHERE 1=1 "
                    . "         {WHERE} ";

            $query_fields = $this->prepare_fields($fields);
            $query_join = $this->prepare_joins($joins);
            $query_where = $this->prepare_where($where);

            $query_string = str_replace("{FIELDS}", $query_fields, str_replace("{TABLE}", $this->_table_name, str_replace("{JOIN}", $query_join, str_replace("{WHERE}", $query_where, $query_base))));

            return $this->connection()->executeQuery($query_string);
        } catch (Exception $e) {
            return null;
        }
    }

    protected function executeInsert($fields, $values) {
        try {
            $query_base = "INSERT INTO {TABLE} ({FIELDS}) "
                    . "        VALUES ({FIELDS_VALUES}) ";

            $query_fields = $this->prepare_fields($fields);
            $query_values = $this->prepare_fields($values);
            $query_join = $this->prepare_joins(null);
            $query_where = $this->prepare_where(null);

            $query_string = str_replace("{FIELDS}", $query_fields, str_replace("{TABLE}", $this->_table_name, str_replace("{JOIN}", $query_join, str_replace("{WHERE}", $query_where, str_replace("{FIELDS_VALUES}", $query_values, $query_base)))));

            return $this->connection()->executeNoQuery($query_string, null);
        } catch (Exception $ex) {
            return null;
        }
    }

    protected function executeUpdate($fields, $where = null) {
        try {
            $query_base = "UPDATE {TABLE} "
                    . "      SET {FIELDS} "
                    . "      WHERE 1=1 {WHERE}";

            $query_fields = $this->prepare_fields($fields);
            $query_join = $this->prepare_joins(null);
            $query_where = $this->prepare_where($where);

            $query_string = str_replace("{FIELDS}", $query_fields, str_replace("{TABLE}", $this->_table_name, str_replace("{JOIN}", $query_join, str_replace("{WHERE}", $query_where, $query_base))));

            return $this->connection()->executeNoQuery($query_string, null);
        } catch (Exception $ex) {
            return null;
        }
    }

    protected function executeNoQuery($query_string) {
        try {
            return $this->connection()->executeNoQuery($query_string);
        } catch (Exception $e) {
            return null;
        }
    }

}

class ModelSession extends \Common\Contract\DataConnection\ConnectionJson {

    public function create_session($token, $data) {
        try {
            return $this->connection(__DIR__ . "\BREW_SESSION.{$token}")
                            ->executeNoQuery("SESSION/{$token}", $data);
        } catch (Exception $ex) {
            return null;
        }
    }

    public function handleSession($token) {
        try {
            return $this->connection(__DIR__ . "\BREW_SESSION.{$token}")
                            ->executeQuery("SESSION/{$token}");
        } catch (Exception $ex) {
            return null;
        }
    }

}

class ModelUser extends Model {

    private $_field_id;
    private $_field_username;
    private $_field_password;
    private $_field_name;
    private $_fields;

    public function __construct() {
        $this->_table_name = 'BREW_USER';
        $this->_field_id = "ID_USER";
        $this->_field_username = "LOGIN";
        $this->_field_password = "PASSWORD_USER";
        $this->_field_name = "NAME_USER";
        $this->_fields = array('LOGIN',
            'PASSWORD_USER',
            'NAME_USER',
            'PHONE_NUMBER_USER');
    }

    public function get_byCredentials($credentials) {
        return $this->executeQuery(null, array("{$this->_field_username} = '{$credentials->username}'"
                    , "{$this->_field_password} = '{$credentials->password}'"), null);
    }

    public function newUser($information) {
        return $this->executeInsert($this->_fields, array("'{$information->username}'",
                    "'{$information->password}'",
                    "'{$information->name}'",
                    "'{$information->cellphone}'"));
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
        return $this->executeQuery();
    }

    public function handleQuestion($id) {
        return $this->executeQuery(null, array("ID_QUESTION = {$id}"), null);
    }

}

class ModelAnswer extends Model {

    public function __construct() {
        $this->_table_name = 'BREW_ANSWER';
    }

    public function handleAllAnswer() {
        return $this->executeQuery();
    }

    public function handleAnswer($id) {
        return $this->executeQuery(null, array("ID_ANSWER = {$id}"), null);
    }

    public function handleQuestionAnswer($id) {
        return $this->executeQuery(null, array("ID_QUESTION = {$id}"), null);
    }

}

class ModelProfile extends Model {

    public function __construct() {
        $this->_table_name = 'BREW_TEMPLATE';
    }

    public function questionResponse($id, $question_id, $answer_id) {
        $this->_table_name = 'BREW_TEMPLATE';
        return $this->executeInsert(array('ID_USER', 'ID_QUESTION', 'ID_ANSWER'), array($id, $question_id, $answer_id));
    }

    public function handleQuestionResponse($id, $question_id) {
        $this->_table_name = 'BREW_TEMPLATE';
        return $this->executeQuery(null, array("ID_USER = {$id}", "ID_QUESTION =  {$question_id}"));
    }

    public function handleTotal($id) {
        $this->_table_name = 'BREW_TEMPLATE';
        return $this->executeQuery(array('SUM(BREW_ANSWER.WEIGHT_ANSWER) TOTAL'), array("{TABLE}.ID_USER = {$id}"), array("BREW_ANSWER" => "BREW_ANSWER.ID_ANSWER = {TABLE}.ID_ANSWER"));
    }

    public function setProfile($id, $name, $resumo, $type) {
        $this->_table_name = 'BREW_PROFILE';
        return $this->executeInsert(array('ID_USER', 'NAME_PROFILE', 'RESUMO', 'TYPE'), array($id, "'{$name}'", "'{$resumo}'", $type));
    }

    public function handleProfile($id) {
        $this->_table_name = 'BREW_PROFILE';
        return $this->executeQuery(array('NAME_PROFILE', 'RESUMO', 'TYPE'), array("{TABLE}.ID_USER = {$id}"));
    }

}
