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
import static br.com.invistaja.invistaja.app.Funcoes.mascaraCelular;
import static br.com.invistaja.invistaja.app.Funcoes.modalNeutro;

public class CadastroView extends Activity implements iView {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtTelefone;
    private UsuarioModel usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inflarComponetes();
    }

    @Override
    public void inflarComponetes(){
        this.setContentView(R.layout.activity_cadastro);
        this.edtNome = (EditText) findViewById(R.id.edtNome);
        this.edtEmail = (EditText) findViewById(R.id.edtEmail);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);
        this.edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        this.usuario = new UsuarioModel();
        aplicarMascaras(this.edtTelefone,mascaraCelular);
    }

    public void onClickSalvar(View view){
        this.salvar();
    }

    private void salvar(){
        try {
            Funcoes.context = CadastroView.this;
            this.usuario.setName(this.edtNome.getText().toString());
            this.usuario.setLogin(this.edtEmail.getText().toString());
            this.usuario.setPassword(this.edtSenha.getText().toString());
            this.usuario.setCellphone(this.edtTelefone.getText().toString());
            this.usuario.setOperacao(UsuarioModel.Operacao.cadastrar);
            this.usuario = new UsuarioRepository().execute(this.usuario).get();
            if (this.usuario.getSucess()){
                Toast.makeText(this,R.string.str_acty_cadastro_sucesso,Toast.LENGTH_LONG).show();
                this.limpar();
            }else{
                modalNeutro(this,"Atenção!",this.usuario.getMessage(),"Ok!");
            }
        }catch (Exception ex){
            excecoes(this,ex);
        }
    }

    private void limpar(){
        this.edtNome.requestFocus();
        this.edtNome.setText(null);
        this.edtEmail.setText(null);
        this.edtSenha.setText(null);
        this.edtTelefone.setText(null);
        this.finish();
    }
}
