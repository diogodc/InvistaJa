package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.PerfilInformacaoView;
import br.com.invistaja.invistaja.view.fragments.PerfilQuestoesView;

import static br.com.invistaja.invistaja.app.Funcoes.iniciarFragment;

public class PerfilView extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_perfil);
        iniciarFragment(new PerfilInformacaoView(), R.id.frlGeral, getSupportFragmentManager());
    }

    public void onClickTracarPerfil(View view){
        iniciarFragment(new PerfilQuestoesView(),R.id.frlGeral,getSupportFragmentManager());
    }
}
