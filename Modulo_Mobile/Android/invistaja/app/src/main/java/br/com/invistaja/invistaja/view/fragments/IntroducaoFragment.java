package br.com.invistaja.invistaja.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.invistaja.invistaja.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroducaoFragment extends Fragment {


    public IntroducaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_introducao, container, false);
    }

}
