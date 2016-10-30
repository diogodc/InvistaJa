<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class perfilmodel extends CI_Model {

    public function buscarQtdPergunta() {

        $num_row = $this->db->count_all_results('BREW_QUESTION', TRUE);

        return $num_row;
    }

    public function buscarPerguntas($id) {

        $this->db->where('ID_QUESTION', $id);
        $query = $this->db->get('BREW_QUESTION');

        return $query->result();
    }

    public function buscarRespostas($id) {

        $this->db->where('ID_QUESTION', $id);
        $query = $this->db->get('BREW_ANSWER');

        return $query->result();
    }

    public function buscarIdUsuario() {

        //busco o usuario logado
        $user = $this->session->userdata('logado');

        //pego o id do usuario no banco
        $this->db->select('ID_USER');
        $this->db->where('LOGIN', $user['LOGIN']);
        $idUser = $this->db->get('BREW_USER')->row_array();

        return (int) $idUser['ID_USER'];
    }

    public function salvarResposta($resp) {

        //busco a o numero da questão de acordo com a resposta
        $this->db->select('ID_QUESTION');
        $this->db->where('ID_ANSWER', $resp);
        $idPergunta = $this->db->get('BREW_ANSWER')->row_array();

        $idUser = $this->buscarIdUsuario();

        //monto o array para inserir os dados no banco        
        $data = array(
            'ID_QUESTION' => (int) $idPergunta['ID_QUESTION'],
            'ID_ANSWER' => (int) $resp,
            'ID_USER' => $idUser
        );

        //comparo se a pergunta ja foi respondida
        $this->db->select('1');
        $this->db->where('ID_QUESTION', $data['ID_QUESTION']);
        $this->db->where('ID_USER', $data['ID_USER']);
        $existe = $this->db->get('BREW_TEMPLATE')->row_array();


        if (!$existe) {
            $this->db->insert('BREW_TEMPLATE', $data);
        }
    }

    public function existePerfil() {

        $idUser = $this->buscarIdUsuario();

        //comparo se o usuario ja tem perfil gravado no banco
        $this->db->where('ID_USER', $idUser);
        $Profile = $this->db->get('BREW_PROFILE')->row_array();

        return $Profile;
    }

    public function gravarPerfil() {

        $id = $this->buscarIdUsuario();

        $query = "select SUM(a.WEIGHT_ANSWER) as SOMA 
                  from 
                    BREW_ANSWER a, BREW_TEMPLATE t
                  where 
                    a.ID_ANSWER = t.ID_ANSWER 
                    and t.ID_USER = {$id}";
        $soma = $this->db->query($query)->row_array();

        if ((int) $soma['SOMA'] <= 28) {
            $data = array(
                'ID_USER' => $id,
                'NAME_PROFILE' => 'Perfil Conservador',
                'RESUMO' => 'Clientes com este perfil têm como objetivo a preservação do capital e possuem baixa tolerância a riscos. Também é representado por clientes que, apesar de estarem dispostos a correr um pouco mais de riscos na busca por retornos diferenciados, tenham necessidade de sacar os recursos em curto período de tempo.',
                'TYPE' => 1
            );
            $this->db->insert('BREW_PROFILE', $data);
        } elseif ((int) $soma['SOMA'] > 29 && (int) $soma['SOMA'] <= 52) {
            $data = array(
                'ID_USER' => $id,
                'NAME_PROFILE' => 'Perfil Moderado',
                'RESUMO' => 'Clientes com este perfil estão dispostos a correr alguns riscos em investimentos, buscando um retorno diferenciado no médio prazo, com baixa necessidade de liquidez no curto prazo, havendo disponibilidade para diversificar parte das aplicações em alternativas mais arrojadas.',
                'TYPE' => 2
            );
            $this->db->insert('BREW_PROFILE', $data);
        } else {
            $data = array(
                'ID_USER' => $id,
                'NAME_PROFILE' => 'Perfil Agressivo',
                'RESUMO' => 'Este perfil é representado por clientes com alta tolerância a riscos, baixa ou nenhuma necessidade de liquidez no curto/médio prazo e que estejam dispostos a aceitar as oscilações dos mercados de risco (e possíveis perdas) na busca por retornos diferenciados no longo prazo.',
                'TYPE' => 3
            );
            $this->db->insert('BREW_PROFILE', $data);
        }
    }

}
