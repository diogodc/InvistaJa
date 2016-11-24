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
import br.com.invistaja.invistaja.view.fragments.PerfilInformacaoView;
import br.com.invistaja.invistaja.view.iView;

import static br.com.invistaja.invistaja.app.Funcoes.excecoes;
import static br.com.invistaja.invistaja.app.Funcoes.iniciarActivity;
import static br.com.invistaja.invistaja.app.Funcoes.modalNeutro;
import static br.com.invistaja.invistaja.app.Funcoes.usuarioLogado;

public class LoginView extends Activity implements iView {

    private EditText edtEmail;
    private EditText edtSenha;
    private UsuarioModel usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inflarComponetes();
    }

    @Override
    public void inflarComponetes() {
        this.setContentView(R.layout.activity_login);
        this.edtEmail = (EditText) this.findViewById(R.id.edtEmail);
        this.edtSenha = (EditText) this.findViewById(R.id.edtSenha);
        this.usuario = new UsuarioModel();
    }

    public void onClickCriarConta(View view){
        iniciarActivity(this,CadastroView.class,null);
    }

    public void onClickLogin(View view){
        this.login();
    }

    private void login(){
        try {
            Funcoes.context = LoginView.this;
            this.usuario.setLogin(this.edtEmail.getText().toString());
            this.usuario.setPassword(this.edtSenha.getText().toString());
            this.usuario.setOperacao(UsuarioModel.Operacao.autenticar);
            this.usuario = new UsuarioRepository().execute(this.usuario).get();
            if (this.usuario.getSucess()){
                usuarioLogado = this.usuario;
                Toast.makeText(this,R.string.str_acty_login_sucesso,Toast.LENGTH_LONG).show();
                Bundle paramentros = new Bundle();
                paramentros.putBoolean("menu", false);
                iniciarActivity(LoginView.this,PrincipalView.class,paramentros);
                this.finish();
            }else {
                modalNeutro(this,"Atenção!",this.usuario.getMessage(),"OK");
            }
        } catch (Exception ex) {
            excecoes(this,ex);
        }
    }
}
