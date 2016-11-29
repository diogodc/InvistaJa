<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');
/*
 * Controler carrega o perfil do usu�rio
 */

class MeuPerfil extends CI_Controller {
    /*
     * Construtor da classe
     */

    function MeuPerfil() {
        parent::__construct();
        $this->load->model('perfilModel');
    }

    //carrega o perfil do usu�rio
    public function index() {

        $data['perfil'] = $this->perfilModel->existePerfil();

        $this->load->view('meuPerfil', $data);
    }

}
