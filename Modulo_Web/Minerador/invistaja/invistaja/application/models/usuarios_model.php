<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Usuarios_model extends CI_Model {

    private $salt = 'r4nd0m';

    //valida usuario e senha
    public function getLogin($login, $senha) {

        $sen = sha1($senha . $this->salt); //encriptografa a senha

        $query = "select 
                    login, PASSWORD_USER 
                  from 
                    BREW_USER 
                  WHERE 
                    LOGIN = '{$login}' and PASSWORD_USER ='{$sen}'";

        $result = $this->db->query($query)->row_array();
        return $result;
    }

    //grava um novo usuário no banco
    public function novo($data) {
        $data['PASSWORD_USER'] = sha1($data['PASSWORD_USER'] . $this->salt); //encriptografa a senha
        return $this->db->insert('BREW_USER', $data);
    }

    public function update($id, $data) {
        if (isset($data['password']))
            $data['password'] = sha1($data['password'] . $this->salt);
        $this->db->where('id', $id);
        $update = $this->db->update('user', $data);
        return $update;
    }

    public function delete($id) {
        $this->db->where('id', $id);
        $this->db->delete('user');
    }

}
