<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Login extends CI_Controller {

    function __construct() {
        parent::__construct();
    }

    public function index() {
        $this->load->view('login');
    }

    public function validar() {
        $this->form_validation->set_rules('usuario', 'LOGIN', 'required');
        $this->form_validation->set_rules('senha', 'PASSWORD_USER', 'required');

        if ($this->form_validation->run() == false) {
            $this->load->view('login');
        } else {
            $email = $this->input->post("usuario");
            $senha = $this->input->post("senha");
            $usuario = $this->usuarios_model->getLogin($email, $senha); // acessa a função buscaPorEmailSenha do modelo
            if ($usuario) {
                $this->session->set_userdata("logado", $usuario);
                redirect();
            } else {
                //caso a senha/usuário estejam incorretos, então mando o usuário novamente para a tela de login com uma mensagem de erro.
                $dados['erro'] = "Usuário/Senha incorretos";
                redirect();
            }
        }
    }

    /* Aqui eu destruo a variável logado na sessão e redireciono para a url base. Como esta variável não existe mais, o usuário
     * será direcionado novamente para a tela de login.
     */

    public function logout() {
        $this->session->unset_userdata("logado", $usuario);
        redirect('login');
    }

}
