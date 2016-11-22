package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.SimulacaoInformacao;
import br.com.invistaja.invistaja.view.fragments.SimulacaoQuestoes;
import static br.com.invistaja.invistaja.app.Funcoes.iniciarFragment;
import static br.com.invistaja.invistaja.app.Funcoes.menuGeral;

public class Simulacao extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_simulacao);
        iniciarFragment(new SimulacaoInformacao(), R.id.frlIntroducao, getSupportFragmentManager());
        iniciarFragment(new SimulacaoQuestoes(), R.id.frlConteudo, getSupportFragmentManager());
    }

    public void onClickMenu(View view){
        menuGeral(this);
    }
}
