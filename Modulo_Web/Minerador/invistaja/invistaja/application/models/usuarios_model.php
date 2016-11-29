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

    public function alter($id, $data) {

        if (isset($data['PASSWORD_USER'])) {
            $data['PASSWORD_USER'] = sha1($data['PASSWORD_USER'] . $this->salt); //encriptografa a senha
        }
        $this->db->where('ID_USER', $id);
        $update = $this->db->update('BREW_USER', $data);
        return $update;
    }

    public function delete($id) {
        $this->db->where('id', $id);
        $this->db->delete('user');
    }
	
	public function getEmail($login) {
        $query = "select 
                    login
                  from 
                    BREW_USER 
                  WHERE 
                    LOGIN = '{$login}'";

        $result = $this->db->query($query)->row_array();
        return $result;
    }

    public function buscarUsuario() {

        //busco o usuario logado
        $userLog = $this->session->userdata('logado');

        //pego o usuario no banco
        $this->db->where('LOGIN', $userLog['LOGIN']);
        $user = $this->db->get('BREW_USER')->row_array();

        return $user;
    }

}
