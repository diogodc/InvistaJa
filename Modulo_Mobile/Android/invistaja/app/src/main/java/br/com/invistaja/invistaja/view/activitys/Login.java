package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import br.com.invistaja.invistaja.R;

import static br.com.invistaja.invistaja.app.Funcoes.iniciarActivity;
import static br.com.invistaja.invistaja.app.Funcoes.modalNeutro;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
    }

    public void onClickCriarConta(View view){
        iniciarActivity(this,Cadastro.class,null);
    }

    public void onClickLogin(View view){
        modalNeutro(this,R.string.str_atencao,R.string.str_teste,R.string.str_opcao_ok);
    }
}
