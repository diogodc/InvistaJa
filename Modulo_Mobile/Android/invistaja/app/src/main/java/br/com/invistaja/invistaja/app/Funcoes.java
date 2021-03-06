package br.com.invistaja.invistaja.app;

import android.app.Activity;
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
import br.com.invistaja.invistaja.model.UsuarioModel;
import br.com.invistaja.invistaja.view.activitys.ContatoAtualizarView;
import br.com.invistaja.invistaja.view.activitys.LoginView;
import br.com.invistaja.invistaja.view.activitys.PerfilView;
import br.com.invistaja.invistaja.view.activitys.PrincipalView;
import br.com.invistaja.invistaja.view.activitys.SimulacaoView;
import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Funcoes {

    public static final String urlBase = "http://invistaja.brazilsouth.cloudapp.azure.com/modulo_wsb/wsb.php/";
    public static UsuarioModel usuarioLogado;

    private static android.app.AlertDialog alerta;
    public static Context context;

    public static final String mascaraTelefone = "(##)####-####";
    public static final String mascaraCelular = "(##)#####-####";
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

    public static void modalNeutro(Context contexto,int idTitulo, int idMensagem, int idMensagemBotao){
        new AlertDialog.Builder(contexto)
                .setTitle(idTitulo)
                .setMessage(idMensagem)
                .setNeutralButton(idMensagemBotao, null).show();
    }

    public static void modalNeutro(Context contexto,String titulo, String mensagem, String mensagemBotao){
        new AlertDialog.Builder(contexto)
                .setTitle(titulo)
                .setMessage(mensagem)
                .setNeutralButton(mensagemBotao, null).show();
    }

    public static void opcoesMenuGeral(Context context, DialogInterface dialog, int idOpcao){
        switch (idOpcao){
            case 0://Aprenda a investir
                if (validaActivity(context,PrincipalView.class)){
                    dialog.dismiss();
                }else {
                    iniciarActivity(context,PrincipalView.class,null);
                }
                break;
            case 1: //Conheça seu perfil
                if (validaActivity(context,PerfilView.class)){
                    dialog.dismiss();
                }else {
                    if (usuarioLogado!=null){
                        iniciarActivity(context,PerfilView.class,null);
                    }else{
                        iniciarActivity(context, LoginView.class,null);
                    }
                }
                break;
            case 2://Faça uma simulação
                if (validaActivity(context,SimulacaoView.class)){
                    dialog.dismiss();
                }else {
                    if (usuarioLogado!=null) {
                        iniciarActivity(context, SimulacaoView.class, null);
                    }else{
                        iniciarActivity(context,LoginView.class,null);
                    }
                }
                break;
            case 3://Minha conta
                if (validaActivity(context,ContatoAtualizarView.class)) {
                    dialog.dismiss();
                }else {
                    iniciarActivity(context, ContatoAtualizarView.class, null);
                }
                break;
            case 4: //Sair
                usuarioLogado = null;
                if (validaActivity(context,PrincipalView.class)){
                    Bundle paramentros = new Bundle();
                    paramentros.putBoolean("menu",true);
                    iniciarActivity(context,PrincipalView.class,paramentros);
                    ((Activity) context).finish();
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
        if (usuarioLogado!=null){
            itens.add("Minha conta");
            itens.add("Sair");
        }


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
            Conexao conexao = new Conexao();
            return conexao.post(url, obj);
        }catch (Exception ex){
            throw  ex;
        }
    }

        public static void excecoes(Context context,Exception erro){
            new AlertDialog.Builder(context)
                    .setTitle("Atenção!")
                    .setMessage("Erro: " + erro.getMessage() + "  " + erro.getStackTrace())
                    .setNeutralButton("OK", null).show();
        }
}
