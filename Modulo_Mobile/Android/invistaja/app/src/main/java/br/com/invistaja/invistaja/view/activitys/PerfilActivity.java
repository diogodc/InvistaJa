package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.PerfilInformacaoFragment;
import br.com.invistaja.invistaja.view.fragments.PerfilQuestoesFragment;

import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.iniciarFragment;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.menuGeral;

public class PerfilActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_perfil);
        iniciarFragment(new PerfilInformacaoFragment(), R.id.frlGeral, getSupportFragmentManager());
    }

    public void onClickTracarPerfil(View view){
        iniciarFragment(new PerfilQuestoesFragment(),R.id.frlGeral,getSupportFragmentManager());
    }
}
