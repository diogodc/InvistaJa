<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class pagina extends CI_Controller {
    
    function __construct(){
        parent::__construct();
        $this->load->helper('url');
    }


	public function index()
	{
		$this->load->view('pagina');
	}
    
    public function contato()
	{
		$this->load->view('contato');
	}
    public function perfil(){
        $this->db->model('perfil');
    }

}
