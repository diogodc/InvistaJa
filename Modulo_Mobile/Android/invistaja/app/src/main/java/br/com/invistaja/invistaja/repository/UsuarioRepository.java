package br.com.invistaja.invistaja.repository;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import br.com.invistaja.invistaja.app.Funcoes;
import br.com.invistaja.invistaja.model.UsuarioModel;
import static br.com.invistaja.invistaja.app.Funcoes.conectar;
import static br.com.invistaja.invistaja.app.Funcoes.urlBase;

public class UsuarioRepository extends AsyncTask<UsuarioModel,Void,UsuarioModel> {
    private String url = urlBase + "user/";

    private String register = "register/";
    private String authenticate = "authenticate/";

    private ProgressDialog dialog;

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        this.dialog = new ProgressDialog(Funcoes.context);
        this.dialog.setMessage("Aguarde...");
        this.dialog.setIndeterminate(false);
        this.dialog.setCancelable(false);
        this.dialog.show();
    }

    @Override
    protected UsuarioModel doInBackground(UsuarioModel... usuarios) {
        UsuarioModel usuario = usuarios[0];
        try{
            if (usuario.getOperacao() == UsuarioModel.Operacao.register){
                this.url = this.url + this.register;
            }else if(usuario.getOperacao() == UsuarioModel.Operacao.authenticate){
                this.url = this.url + this.authenticate;
            }
            usuario.setJson(conectar(url,usuario.getJson()));
        }catch (Exception ex){
            usuario.setSucess(false);
            usuario.setMessage(ex.getMessage());
        }
        return usuario;
    }

    @Override
    protected void onPostExecute(UsuarioModel usuario) {
        super.onPostExecute(usuario);
        this.dialog.dismiss();
    }
}
