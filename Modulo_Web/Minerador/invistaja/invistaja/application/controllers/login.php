<?php

//Controler que faz a autenica��o do usu�rio, inicia e encerra a sees�o
if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Login extends CI_Controller {

    //construtor da classe
    function Login() {
        parent::__construct();
        $this->load->model('perfilModel');
    }

    //carrega a index
    public function index() {
        $this->load->view('login');
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

    //valida��o do usu�rio
    public function validar() {
        //pega usu�rio e senha da p�gina
        $this->form_validation->set_rules('usuario', 'LOGIN', 'required');
        $this->form_validation->set_rules('senha', 'PASSWORD_USER', 'required');
        $existePerfil = $this->perfilModel->existePerfil();
        //valida as informa��es do formul�rio
        if ($this->form_validation->run() == false) {
            $this->load->view('login');
        } else {
            $email = $this->input->post("usuario");
            $senha = $this->input->post("senha");
            $usuario = $this->usuarios_model->getLogin($email, $senha); // acessa a função buscaPorEmailSenha do modelo
            if ($usuario) {
                //inicia a sess�o com os dados do usu�rio
                $this->session->set_userdata("logado", $usuario);
                $this->gravaArquivo($usuario["LOGIN"]);
				
                //carrega a pagina
                if ($existePerfil) {
                    redirect('meuperfil');
                } else {
                    redirect('perfil');
                }
            } else {
                //caso a senha/usuário estejam incorretos, então mando o usuário novamente para a tela de login com uma mensagem de erro.
                $dados['erro'] = "Usuário/Senha incorretos";
                $this->load->view('login', $dados);
            }
        }
    }

    /* Aqui eu destruo a variável logado na sessão e redireciono para a url base. Como esta variável não existe mais, o usuário
     * será direcionado novamente para a tela de login.
     */
    public function logout() {
        $this->session->unset_userdata("logado");
		$this->session->sess_destroy();
        redirect('login');
    }

}
