<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User_model extends CI_Model {
    public $USER_LEVEL_ADMIN = 1;
    public $USER_LEVEL_PM = 2;
    public $USER_LEVEL_DEV = 3;
    private $salt = 'r4nd0m';
    
    public function get($id = false)
    {
        if ($id) $this->db->where('id', $id);
        $this->db->order_by('email', 'asc');
        $get = $this->db->get('user');
        if($id) return $get->row_array();
        if($get->num_rows > 0) return $get->result_array();
        return array();
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