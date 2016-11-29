<?php

//Controler que trata as simulações
defined('BASEPATH') OR exit('No direct script access allowed');

class Simulacao extends CI_Controller {

    function Simulacao() {
        //construtor da classe
        parent::__construct();
        try {
            $this->load->model('perfilModel');
            $logado = $this->session->userdata("logado");
            //carrega a view apenas se estiver logado
            if (!$logado) {
                redirect(base_url('login'));
            }
            //carrega apenas se existir perfil cadastrado
            $existePerfil = $this->perfilModel->existePerfil();
            if (!$existePerfil) {
                $this->load->view('simulacao');
            }
        } catch (Exception $ex) {
            echo $ex->getMessage();
        }
    }

    //exibe o perfil
    public function index() {

        $perfil = $this->perfilModel->existePerfil();
        try {
            if ($perfil['TYPE'] == 1) {
                $this->load->view('conservador');
            } elseif ($perfil['TYPE'] == 2) {
                $this->load->view('moderado');
            } elseif ($perfil['TYPE'] == 3) {
                $this->load->view('arrojado');
            }
        } catch (Exception $ex) {
            echo $ex->getMessage();
        }
    }

}
