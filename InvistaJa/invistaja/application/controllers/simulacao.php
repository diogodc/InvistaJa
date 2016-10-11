<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class simulacao extends CI_Controller {
    
    function __construct(){
        parent::__construct();
        $this->load->helper('url');
        $logado = $this->session->userdata("logado");
			
			if ($logado != 1) 
				redirect(base_url('login'));
    }

	public function index()
	{
		$this->load->view('simulacao');
	}
    
}
