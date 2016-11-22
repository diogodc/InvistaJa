package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.model.Usuario;
import br.com.invistaja.invistaja.repository.RegistrarUsuario;
import static br.com.invistaja.invistaja.app.Funcoes.aplicarMascaras;
import static br.com.invistaja.invistaja.app.Funcoes.excecoes;
import static br.com.invistaja.invistaja.app.Funcoes.mascaraTelefone;
import static br.com.invistaja.invistaja.app.Funcoes.modalNeutro;
import static br.com.invistaja.invistaja.app.Funcoes.progresso;

public class Cadastro extends Activity {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtTelefone;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_cadastro);
        this.inflarComponetes();
    }

    private void inflarComponetes(){
        this.edtNome = (EditText) findViewById(R.id.edtNome);
        this.edtEmail = (EditText) findViewById(R.id.edtEmail);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);
        this.edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        this.usuario = new Usuario();
        aplicarMascaras(this.edtTelefone,mascaraTelefone);
    }

    public void onClickSalvar(View view){
        this.salvar();
    }

    private void salvar(){
        progresso(this,null,false);
        try {
            this.usuario.setName(this.edtNome.getText().toString());
            this.usuario.setLogin(this.edtEmail.getText().toString());
            this.usuario.setPassword(this.edtSenha.getText().toString());
            this.usuario.setCellphone(this.edtTelefone.getText().toString());
            this.usuario = new RegistrarUsuario().execute(this.usuario).get();
            if (this.usuario.getSucess()){
                modalNeutro(this,R.string.str_atencao,R.string.str_sucesso,R.string.str_opcao_ok);
            }else{
                modalNeutro(this,"Atenção!",this.usuario.getMessage(),"Ok!");
            }
        }catch (Exception ex){
            excecoes(this,ex);
        }finally {
            progresso(null,null,true);
        }
    }
}
