package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.app.Funcoes;
import br.com.invistaja.invistaja.model.UsuarioModel;
import br.com.invistaja.invistaja.repository.UsuarioRepository;
import br.com.invistaja.invistaja.view.iView;

import static br.com.invistaja.invistaja.app.Funcoes.aplicarMascaras;
import static br.com.invistaja.invistaja.app.Funcoes.excecoes;
import static br.com.invistaja.invistaja.app.Funcoes.mascaraTelefone;
import static br.com.invistaja.invistaja.app.Funcoes.modalNeutro;
import static br.com.invistaja.invistaja.app.Funcoes.usuarioLogado;

public class ContatoAtualizarView extends Activity implements iView {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtTelefone;
    private UsuarioModel usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atualizar);
        this.inflarComponetes();
        this.lerUsuarioLogado();
    }

    public void inflarComponetes(){
        this.edtNome = (EditText) findViewById(R.id.edtNome);
        this.edtEmail = (EditText) findViewById(R.id.edtEmail);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);
        this.edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        this.edtEmail.setEnabled(false);
        this.usuario = new UsuarioModel();
        aplicarMascaras(this.edtTelefone,mascaraTelefone);
    }

    private void lerUsuarioLogado(){
        this.edtNome.setText((usuarioLogado.getName()));
        this.edtEmail.setText((usuarioLogado.getLogin()));
        this.edtSenha.setText((usuarioLogado.getPassword()));
        this.edtTelefone.setText((usuarioLogado.getCellphone()));
    }

    public void onClickBtAtualizar(View view){
        this.atualizar();
    }

    private void atualizar(){
        try {
            Funcoes.context = ContatoAtualizarView.this;
            this.usuario.setName(this.edtNome.getText().toString());
            this.usuario.setLogin(this.edtEmail.getText().toString());
            this.usuario.setPassword(this.edtSenha.getText().toString());
            this.usuario.setCellphone(this.edtTelefone.getText().toString());
            this.usuario.setOperacao(UsuarioModel.Operacao.cadastrar);
            this.usuario = new UsuarioRepository().execute(this.usuario).get();
            if (this.usuario.getSucess()){
                usuarioLogado = this.usuario;
                Toast.makeText(this,R.string.str_acty_cadastro_atualizacao_sucesso,Toast.LENGTH_LONG).show();
            }else{
                modalNeutro(this,"Atenção!",this.usuario.getMessage(),"Ok!");
            }
        }catch (Exception ex){
            excecoes(this,ex);
        }
    }
}
