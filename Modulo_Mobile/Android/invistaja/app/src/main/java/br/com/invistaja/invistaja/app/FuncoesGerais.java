package br.com.invistaja.invistaja.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.activitys.Perfil;
import br.com.invistaja.invistaja.view.activitys.Contato;
import br.com.invistaja.invistaja.view.activitys.Principal;
import br.com.invistaja.invistaja.view.activitys.Simulacao;
import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class FuncoesGerais {

    public static final String urlBase = "http://invistaja.brazilsouth.cloudapp.azure.com:8080/modulo_wsb/wsb.php/";

    private static android.app.AlertDialog alerta;
    public static final String mascaraTelefone = "(##)###-####";
    public static final String mascaraCelular = "(##)####-###";
    public static final String mascaraCPF = "###.###.###-##";
    public static final String mascaraCNPJ = "##.###.###/####-##";

    public static void iniciarActivity(Context context,Class classe, Bundle paramentros){
        Intent intent = new Intent(context,classe);
        if (paramentros != null){intent.putExtras(paramentros);}
        context.startActivity(intent);
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
                if (validaActivity(context,Principal.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,Principal.class,null);
                }
                break;
            case 1: //Conheça seu perfil
                if (validaActivity(context,Perfil.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,Perfil.class,null);
                }
                break;
            case 2://Faça uma simulação
                if (validaActivity(context,Simulacao.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,Simulacao.class,null);
                }
                break;
            case 3: //Contato
                if (validaActivity(context,Contato.class)) {
                    dialog.dismiss();
                }else {
                    iniciarActivity(context, Contato.class, null);
                }
                break;
            case 4: //Sair

                break;
        }
    }

    public static boolean validaActivity(Context context,Class classe){
        if(context.getClass().getName().equals(classe.getName())){
            return true;
        }
        return false;
    }

    public static void montarSpinner(Context context,View view,Spinner spn, ArrayList<String> array){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
    }

    public static void aplicarMascaras(EditText edt, String mascara){
        MaskEditTextChangedListener mascaraTelefone = new MaskEditTextChangedListener(mascara,edt);
        edt.addTextChangedListener(mascaraTelefone);
    }

    public static void menuGeral(final Context context) {
        ArrayList<String> itens = new ArrayList<String>();

        itens.add("Aprenda a investir");
        itens.add("Conheça o seu perfil");
        itens.add("Faça uma simulação");
        itens.add("Contato");

        ArrayAdapter adapter = new ArrayAdapter(context, R.layout.menu_lista_item, itens);
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int idOpcao) {
                opcoesMenuGeral(context,dialog,idOpcao);
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    public static ArrayAdapter<String> adaptadorLista(Context context, List<String> lista){
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,android.R.id.text1,lista);
        return adaptador;
    }

    public static JSONObject conectar(String url,JSONObject obj)throws IOException, JSONException {
        try {
            ConexaoHttp conexao = new ConexaoHttp();
            return conexao.post(url, obj);
        }catch (Exception ex){
            throw  ex;
        }
    }
}
