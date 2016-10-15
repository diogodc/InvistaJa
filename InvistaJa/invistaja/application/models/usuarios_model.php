<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Usuarios_model extends CI_Model {
    public $USER_LEVEL_ADMIN = 1;
    public $USER_LEVEL_USER = 2;
    private $salt = 'r4nd0m';
    
    public function buscaPorEmailSenha($email, $senha){
        $this->db->where('email', $email);
        $this->db->where('senha', $senha);
        $usuario = $this->db->get('usuario')->row_array();
        return $usuario;
    }
    
    public function create($data)
    {
    $data['password'] = sha1($data['password'].$this->salt);
    return $this->db->insert('user', $data);
    }
    
    public function validate($email, $password)
    {
        $this->db->where('email', $email)->where('password', sha1($password.$this->salt));
        $get = $this->db->get('user');

        return $get->row_array();
    }
    
    public function update($id, $data)
    {
        if(isset($data['password']))
            $data['password'] = sha1($data['password'].$this->salt);
        $this->db->where('id', $id);
        $update = $this->db->update('user', $data);
        return $update;
    }
    
    public function delete($id)
    {
        $this->db->where('id', $id);
        $this->db->delete('user');
    }
    
}