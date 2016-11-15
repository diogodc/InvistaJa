package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.SimulacaoInformacaoFragment;
import br.com.invistaja.invistaja.view.fragments.SimulacaoQuestoesFragment;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.iniciarFragment;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.menuGeral;

public class SimulacaoActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_simulacao);
        iniciarFragment(new SimulacaoInformacaoFragment(), R.id.frlIntroducao, getSupportFragmentManager());
        iniciarFragment(new SimulacaoQuestoesFragment(), R.id.frlConteudo, getSupportFragmentManager());
    }

    public void onClickMenu(View view){
        menuGeral(this);
    }
}
