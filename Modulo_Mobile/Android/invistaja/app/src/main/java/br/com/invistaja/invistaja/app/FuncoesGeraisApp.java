package br.com.invistaja.invistaja.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;

import br.com.invistaja.invistaja.view.activitys.PerfilActivity;
import br.com.invistaja.invistaja.view.activitys.ContatoActivity;
import br.com.invistaja.invistaja.view.activitys.PrincipalActivity;
import br.com.invistaja.invistaja.view.activitys.SimulacaoActivity;

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

    public static void mensagemModalNeutro(Context contexto,int idTitulo, int idMensagem, int idMensagemBotao){
        new AlertDialog.Builder(contexto)
                .setTitle(idTitulo)
                .setMessage(idMensagem)
                .setNeutralButton(idMensagemBotao, null).show();
    }

    public static void opcoesMenuGeral(Context context, DialogInterface dialog, int idOpcao){
        switch (idOpcao){
            case 0://Aprenda a investir
                if (validaActivity(context,PrincipalActivity.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,PrincipalActivity.class,null);
                }
                break;
            case 1: //Conheça seu perfil
                if (validaActivity(context,PerfilActivity.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,PerfilActivity.class,null);
                }
                break;
            case 2://Faça uma simulação
                if (validaActivity(context,SimulacaoActivity.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,SimulacaoActivity.class,null);
                }
                break;
            case 3: //Contato
                if (validaActivity(context,ContatoActivity.class)) {
                    dialog.dismiss();
                }else {
                    iniciarActivity(context, ContatoActivity.class, null);
                }
                break;
        }
    }

    public static boolean validaActivity(Context context,Class classe){
        if(context.getClass().getName().equals(classe.getName())){
            return true;
        }
        return false;
    }
}
