<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');
/*
 * Formulário de contato do website
 */

class MeuPerfil extends CI_Controller {
    /*
     * Construtor da classe
     */

    public function __construct() {
        parent::__construct();
        $this->load->model('perfilModel');
    }

    public function index() {

        $data['perfil'] = $this->perfilModel->existePerfil();

        $this->load->view('meuPerfil', $data);
    }

}
