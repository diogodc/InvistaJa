package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.SimulacaoInformacaoView;
import br.com.invistaja.invistaja.view.fragments.SimulacaoQuestoesView;
import static br.com.invistaja.invistaja.app.Funcoes.iniciarFragment;
import static br.com.invistaja.invistaja.app.Funcoes.menuGeral;

public class SimulacaoView extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_simulacao);
        iniciarFragment(new SimulacaoInformacaoView(), R.id.frlIntroducao, getSupportFragmentManager());
        iniciarFragment(new SimulacaoQuestoesView(), R.id.frlConteudo, getSupportFragmentManager());
    }

    public void onClickMenu(View view){
        menuGeral(this);
    }
}
