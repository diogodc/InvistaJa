<?php

//Controler que manipula os dados do usu�rio
if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Usuario extends CI_Controller {

    function Usuario() {
        //construtor da classe
        parent::__construct();
    }

    public function index() {
        // Carrega a view
        $this->load->view('usuario');
    }

    public function novo() {
        $sql_data = array(
            'LOGIN' => $this->input->post('email', TRUE),
            'NAME_USER' => $this->input->post('nome', TRUE),
            'PASSWORD_USER' => $this->input->post('senha', TRUE),
            'PHONE_NUMBER_USER' => $this->input->post('telefone', TRUE)
        );
		if(!$this->usuarios_model->getEmail($sql_data['LOGIN']))
		{
			$gravou = $this->usuarios_model->novo($sql_data);
			if($gravou){
				$this->session->set_userdata("logado", $sql_data);
				$this->gravaArquivo($sql_data['LOGIN']);
			}
			else{
				throw new Exception("Ocorreu um erro");
			}
			redirect('perfil');
		}else{
			$data['erro'] = "Você já possui conta!";
			$this->load->view('usuario', $data);
		}

        
    }

    public function editar() {

        $usuario = $this->usuarios_model->buscarUsuario();
        $this->load->view('editar', $usuario);
    }

    public function remover($id) {
        $this->load->model('user_model');
        $this->user_model->delete($id);

        redirect('usuario');
    }

    public function alter() {
        $sql_data = array(
            'LOGIN' => $this->input->post('email', TRUE),
            'NAME_USER' => $this->input->post('nome', TRUE),
            'PASSWORD_USER' => $this->input->post('senha', TRUE),
            'PHONE_NUMBER_USER' => $this->input->post('telefone', TRUE)
        );
        $id = $this->input->post('id', TRUE);
        $alterado = $this->usuarios_model->alter($id, $sql_data);
        if ($alterado) {
            $data['mensagem'] = "Dados alterados com sucesso";
        } else {
            $data['mensagem'] = "Ocorreu um erro ao alterar os dados";
        }
        redirect('perfil', $dados);
    }
	
	public function gravaArquivo($usuario){
        
        $this->load->helper('date');
        //guarda a data para salvar no arquivo
        date_default_timezone_set('America/Sao_Paulo');
        $data = date('d/m/Y H:i:s', time());
        $conteudo["Data"] = $data;
        $conteudo["ip"] = $this->input->ip_address();
        $conteudo["usuario"] = $usuario;
        $arq = fopen("logs.txt", 'a');
        foreach ($conteudo as $element) {
            fwrite($arq, $element . "\r\n");
        }
        fclose($arq);
    }

}
