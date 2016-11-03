package br.com.invistaja.invistaja.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FuncoesGeraisApp {
    public static void iniciarActivity(Context contexto,Class classe, Bundle paramentros){
        Intent intent = new Intent(contexto,classe);
        if (paramentros != null){intent.putExtras(paramentros);}
        contexto.startActivity(intent);
    }

    public static void iniciarFragment(Fragment fragment , int id, FragmentManager fragmentManager){
        FragmentManager manFrg = fragmentManager;
        FragmentTransaction traFrg = manFrg.beginTransaction();
        traFrg.replace(id, fragment);
        traFrg.setTransition(FragmentTransaction.TRANSIT_NONE);
        traFrg.commit();
    }
}
