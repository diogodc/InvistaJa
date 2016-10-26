<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class simulacao extends CI_Controller {

    function __construct() {

        parent::__construct();

        $this->load->model('perfilModel');
        $logado = $this->session->userdata("logado");

        if (!$logado){
            redirect(base_url('login'));
        }

        $existePerfil = $this->perfilModel->existePerfil();
        if (!$existePerfil) {
            $this->load->view('simulacao');
        }
    }

    public function index() {
        
        $perfil = $this->perfilModel->existePerfil();
                
        if($perfil['TYPE'] == 1){
            $this->load->view('conservador');
        }elseif($perfil['TYPE'] == 2){
            $this->load->view('moderado');
        }elseif ($perfil['TYPE'] == 3) {
            $this->load->view('arrojado');
        }
    }
}
