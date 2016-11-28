<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');
/*
 * Formulário de contato do site
 */

class Contato extends CI_Controller {
    /*
     * Construtor da classe
     */

    function Contato() {
        parent::__construct();
        $this->load->helper('form');
    }

    /*
     * Método Index, página inicial do formulário de contato
     */

    public function index() {
        $this->load->view('contato');
    }

    /*
     * Método enviaEmail, onde será realmente enviado.
     */

    public function enviaEmail() {
        $this->load->library('email');

        $email = $this->input->post('email', TRUE);
        $nome = $this->input->post('nome', TRUE);
        $telefone = $this->input->post('telefone', TRUE);
        $mensagem = $this->input->post('mensagem', TRUE);

        $this->email->from($email, $nome);
        $this->email->to('bruno.ed00@gmail.com');

        $this->email->subject("Email Invista Já");

        $this->email->message('<html><head></head><body>
            Nome:       ' . $nome . ' <br />
            E-mail:     ' . $email . ' <br />
            Telefone:   ' . $telefone . ' <br />
            Mensagem:   ' . $mensagem . ' <br />
            </body></html>');

        $em = $this->email->send();
        if ($em) {
            $data['email_enviado'] = 'E-mail enviado com sucesso. Aguarde contato.';
        } else {
            $data['email_enviado'] = 'Erro ao enviar o email. Favor enviar um e-mail para bruno.ed00@gmail.com';
        }
        $this->load->view('contato', $data);
    }

}

/* End of file contato.php */