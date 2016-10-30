<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Usuario extends CI_Controller {

    private $LEVEL;

    function Usuario() {
        parent::__construct();

        $this->LEVEL = array(
            1 => 'adm',
            2 => 'usuario'
        );
    }

    public function index() {
        // Load View
        $this->load->view('usuario');
    }

    public function novo() {
        $sql_data = array(
            'LOGIN' => $this->input->post('email', TRUE),
            'NAME_USER' => $this->input->post('nome', TRUE),
            'LAST_NAME_USER' => $this->input->post('sobrenome', TRUE),
            'PASSWORD_USER' => $this->input->post('senha', TRUE),
            'PHONE_NUMBER_USER' => $this->input->post('telefone', TRUE),
            'CPF_USER' => $this->input->post('cpf', TRUE),
            'CELL_PHONE_NUMBER_USER' => $this->input->post('telefone', TRUE)
        );
        $this->usuarios_model->novo($sql_data);

        $this->load->view('login');
    }

    public function editar() {
        $email = $this->input->post('email', TRUE);
    }

    public function remover($id) {
        $this->load->model('user_model');
        $this->user_model->delete($id);

        redirect('usuario');
    }

    public function salvar() {
        $sql_data = array(
            'email' => $this->input->post('email'),
            'level' => $this->input->post('level')
        );

        if ($this->input->post('reset_password')) {
            $sql_data['password'] = $this->input->post('password');
        }

        if ($this->input->post('id'))
            $this->user_model->update($this->input->post('id'), $sql_data);
        else
            $this->user_model->create($sql_data);

        redirect('usuario');
    }

}
