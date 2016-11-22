package br.com.invistaja.invistaja.view.fragments;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import br.com.invistaja.invistaja.R;

import static br.com.invistaja.invistaja.app.Funcoes.adaptadorLista;

public class PerfilQuestoes extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil_questoes, container, false);
        this.carregaLista();
        return view;
    }

    private void carregaLista(){
        List<String> lista = new ArrayList<String>();
        lista.add("Resposta 1");
        lista.add("Resposta 2");
        lista.add("Resposta 3");
        lista.add("Resposta 4");
        lista.add("Resposta 5");

        this.setListAdapter(adaptadorLista(getActivity(),lista));
    }
}
