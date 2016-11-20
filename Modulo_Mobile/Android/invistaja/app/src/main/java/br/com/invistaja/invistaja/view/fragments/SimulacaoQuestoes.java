package br.com.invistaja.invistaja.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.invistaja.invistaja.R;

import static br.com.invistaja.invistaja.app.FuncoesGerais.montarSpinner;

public class SimulacaoQuestoes extends Fragment {
    Spinner spnOpcoesSimulacao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simulacao_questoes, container, false);
        this.inflarComponentes(view);
        montarSpinner(this.getContext(),view,this.spnOpcoesSimulacao,this.listarOpcoes());
        return view;
    }

    private void inflarComponentes(View view){
        this.spnOpcoesSimulacao = (Spinner) view.findViewById(R.id.spnOpcoesSimulacao);
    }

    private ArrayList<String> listarOpcoes(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Teusoro Direto");
        lista.add("Bolsa de valores");
        lista.add("Imóveis");
        lista.add(("Ações"));
        return lista;
    }
}
