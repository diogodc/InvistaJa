<?php

defined('BASEPATH') OR exit('No direct script access allowed');

//Controler que carrega a pagina inicial
class Pagina extends CI_Controller {

    function Pagina() {
        parent::__construct();
        $this->load->helper('url');
    }

    public function index() {
        $this->load->view('pagina');
    }

}
