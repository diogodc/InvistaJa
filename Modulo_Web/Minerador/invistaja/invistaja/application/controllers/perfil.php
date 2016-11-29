<?php

defined('BASEPATH') OR exit('No direct script access allowed');

//Controler que manipula os dados do usu�rio para identifica��o do perfil
class Perfil extends CI_Controller {

    function __construct() {
        parent::__construct();
        //construtor da classe
        $this->load->model('perfilModel');
        $logado = $this->session->userdata("logado");
        //usu�rio s� acessa se estiver logado
        if (!$logado) {
            redirect(base_url('login'));
        }
        $existePerfil = $this->perfilModel->existePerfil();
        if ($existePerfil) {
            redirect(base_url('meuPerfil'));
        }
    }

    //carrega a view com a primeira pergunta
    public function index() {
        try {
            $id = 1;
            $data['id'] = $id;

            $data['qtdPergunta'] = $this->perfilModel->buscarQtdPergunta();

            $data['pergunta'] = $this->perfilModel->buscarPerguntas($id);

            $data['resposta'] = $this->perfilModel->buscarRespostas($id);

            $this->load->view('perfil', $data);
        } catch (Exception $ex) {
            echo $ex->getMessage();
        }
    }

    //carrega as outras perguntas
    public function perguntas() {

        try {
            $data['qtdPergunta'] = $this->perfilModel->buscarQtdPergunta();

            $id = $this->input->post('idx');
            $data['id'] = $id;

            $data['pergunta'] = $this->perfilModel->buscarPerguntas($id);

            $data['resposta'] = $this->perfilModel->buscarRespostas($id);

            $resp = $this->input->post('resposta');
            $this->perfilModel->salvarResposta($resp);

            $this->load->view('perfil', $data);
        } catch (Exception $ex) {
            echo $ex->getMessage();
        }
    }

    //guardo o perfil do usuario de acordo com as respostas
    public function perfil() {

        try {
            $resp = $this->input->post('resposta');
            $this->perfilModel->salvarResposta($resp);

            $this->perfilModel->gravarPerfil();

            redirect(base_url('meuPerfil'));
        } catch (Exception $ex) {
            echo $ex->getMessage();
        }
    }

}
