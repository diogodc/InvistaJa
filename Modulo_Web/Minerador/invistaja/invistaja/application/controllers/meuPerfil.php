<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');
/*
 * Controler carrega o perfil do usuário
 */

class MeuPerfil extends CI_Controller {
    /*
     * Construtor da classe
     */

    function MeuPerfil() {
        parent::__construct();
        $this->load->model('perfilModel');
    }

    //carrega o perfil do usuário
    public function index() {

        $data['perfil'] = $this->perfilModel->existePerfil();

        $this->load->view('meuPerfil', $data);
    }

}
