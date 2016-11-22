package br.com.invistaja.invistaja.repository;

import android.os.AsyncTask;
import br.com.invistaja.invistaja.model.Usuario;
import static br.com.invistaja.invistaja.app.Funcoes.conectar;
import static br.com.invistaja.invistaja.app.Funcoes.urlBase;

public class RegistrarUsuario extends AsyncTask<Usuario,Void,Usuario> {
    private String url = urlBase + "user/register/";

    @Override
    protected Usuario doInBackground(Usuario... usuarios) {
        Usuario usuario = usuarios[0];
        try{
            usuario.setJson(conectar(url,usuario.getJson()));
        }catch (Exception ex){
            usuario.setSucess(false);
            usuario.setMessage(ex.getMessage());
        }
        return usuario;
    }
}
