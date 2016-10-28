<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class perfil extends CI_Controller {

    function __construct() {
        parent::__construct();
        $this->load->model('perfilModel');
        $logado = $this->session->userdata("logado");

        if (!$logado) {
            redirect(base_url('login'));
        }
        $existePerfil = $this->perfilModel->existePerfil();
        if ($existePerfil) {
            redirect(base_url('meuPerfil'));
        }
    }

    public function index() {
        $id = 1;
        $data['id'] = $id;

        $data['qtdPergunta'] = $this->perfilModel->buscarQtdPergunta();

        $data['pergunta'] = $this->perfilModel->buscarPerguntas($id);

        $data['resposta'] = $this->perfilModel->buscarRespostas($id);

        $this->load->view('perfil', $data);
    }

    public function perguntas() {

        $data['qtdPergunta'] = $this->perfilModel->buscarQtdPergunta();

        $id = $this->input->post('idx');
        $data['id'] = $id;

        $data['pergunta'] = $this->perfilModel->buscarPerguntas($id);

        $data['resposta'] = $this->perfilModel->buscarRespostas($id);

        $resp = $this->input->post('resposta');
        $this->perfilModel->salvarResposta($resp);

        $this->load->view('perfil', $data);
    }

    public function perfil() {

        $resp = $this->input->post('resposta');
        $this->perfilModel->salvarResposta($resp);

        $this->perfilModel->gravarPerfil();

        redirect(base_url('meuPerfil'), $data);
        ;
    }

}
