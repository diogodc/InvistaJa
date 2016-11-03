package br.com.invistaja.invistaja.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import br.com.invistaja.invistaja.R;

public class ConteudoFragment extends Fragment {

    private ImageButton imgCabin;
    private ImageButton imgCake;
    private ImageButton imgCircus;
    private ImageButton imgGame;
    private ImageButton imgSafe;
    private ImageButton imgSubmarine;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conteudo, container, false);
        this.inflarComponentes();
        return view;
    }

    private void inflarComponentes(){
        this.imgCabin = (ImageButton) getActivity().findViewById(R.id.imgCabin);
        this.imgCake = (ImageButton) getActivity().findViewById(R.id.imgCake);
        this.imgCircus = (ImageButton) getActivity().findViewById(R.id.imgCircus);
        this.imgGame = (ImageButton) getActivity().findViewById(R.id.imgGame);
        this.imgSafe = (ImageButton) getActivity().findViewById(R.id.imgSafe);
        this.imgSubmarine = (ImageButton) getActivity().findViewById(R.id.imgSubmarine);
    }
}
