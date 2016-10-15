<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
 
class Login extends CI_Controller {
    function __construct(){
        parent::__construct();
        
    }
 
    public function index()
    {
        $this->load->view('login');
    }
    
        
    public function logar(){
		
        $this->load->model("usuarios_model");// chama o modelo usuarios_model
        
		$email = $this->input->post("usuario");
		$senha = sha1($this->input->post("senha"));
		
        $usuario = $this->usuarios_model->buscaPorEmailSenha($email,$senha); // acessa a função buscaPorEmailSenha do modelo
        
		//Código sha1  da senha 123456 7c4a8d09ca3762af61e59520943dc26494f8941b
		//O usuário no exemplo aqui será usuario@email.com.br
		//Mas em um projeto real, você trará isto do banco de dados.
		
		//Se o usuário e senha combinarem, então basta eu redirecionar para a url base, pois agora o usuário irá passa
		//pela verificação que checa se ele está logado.
		if ($usuario) {
			$this->session->set_userdata("logado", $usuario);
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
		$this->session->unset_userdata("logado", $usuario);
		redirect('login');
		
	}
}