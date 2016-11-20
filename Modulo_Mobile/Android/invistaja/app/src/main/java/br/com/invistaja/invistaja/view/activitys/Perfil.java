package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.PerfilInformacao;
import br.com.invistaja.invistaja.view.fragments.PerfilQuestoes;

import static br.com.invistaja.invistaja.app.FuncoesGerais.iniciarFragment;

public class Perfil extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_perfil);
        iniciarFragment(new PerfilInformacao(), R.id.frlGeral, getSupportFragmentManager());
    }

    public void onClickTracarPerfil(View view){
        iniciarFragment(new PerfilQuestoes(),R.id.frlGeral,getSupportFragmentManager());
    }
}
