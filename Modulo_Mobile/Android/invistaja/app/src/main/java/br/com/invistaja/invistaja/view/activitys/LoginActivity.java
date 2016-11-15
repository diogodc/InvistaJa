package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import br.com.invistaja.invistaja.R;

import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.iniciarActivity;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.mensagemModalNeutro;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
    }

    public void onClickCriarConta(View view){
        iniciarActivity(this,CadastroActivity.class,null);
    }

    public void onClickLogin(View view){
        mensagemModalNeutro(this,R.string.str_atencao,R.string.str_teste,R.string.str_opcao_ok);
    }
}
