<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
 
class Login extends CI_Controller {
    function __construct(){
        parent::__construct();
        $this->load->model("usuarios_model");// chama o modelo usuarios_model
    }
 
    public function index()
    {
        $this->load->view('login');
    }
    
    public function logar(){
		
		$email = $this->input->post("email");
		$senha = $this->input->post("senha");
		
        $usuario = $this->usuarios_model->buscaPorEmailSenha($email,$senha); // acessa a função buscaPorEmailSenha do modelo
        
		if ($usuario) {
			$this->session->set_userdata("logado", 1);
			redirect(base_url());
		} else {
			//caso a senha/usuário estejam incorretos, então mando o usuário novamente para a tela de login com uma mensagem de erro.
			$dados['erro'] = "Usuário/Senha incorretos";
			$this->load->view(base_url(), $dados);
		}
	}
    
/*
	 * Aqui eu destruo a variável logado na sessão e redireciono para a url base. Como esta variável não existe mais, o usuário
	 * será direcionado novamente para a tela de login.
	 */
	public function logout(){
		$this->session->unset_userdata("logado");
		redirect('login');
		
	}
}