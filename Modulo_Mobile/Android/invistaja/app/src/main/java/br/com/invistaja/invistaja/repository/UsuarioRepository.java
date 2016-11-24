package br.com.invistaja.invistaja.repository;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import br.com.invistaja.invistaja.app.Funcoes;
import br.com.invistaja.invistaja.controller.AtualizarUsuarioController;
import br.com.invistaja.invistaja.controller.AutenticarUsuarioController;
import br.com.invistaja.invistaja.controller.CadastrarUsuarioController;
import br.com.invistaja.invistaja.model.UsuarioModel;
import static br.com.invistaja.invistaja.app.Funcoes.conectar;
import static br.com.invistaja.invistaja.app.Funcoes.urlBase;

public class UsuarioRepository extends AsyncTask<UsuarioModel,Void,UsuarioModel> {
    private String url = urlBase + "user/";
    private ProgressDialog dialog;
    private CadastrarUsuarioController cadastrarUsuario;
    private AutenticarUsuarioController autenticarUsuario;
    private AtualizarUsuarioController atualizarUsuario;

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
            if (usuario.getOperacao()== UsuarioModel.Operacao.cadastrar){
                this.cadastrarUsuario = new CadastrarUsuarioController(usuario);
                this.url = this.url + this.cadastrarUsuario.getApiMetodo();
                this.cadastrarUsuario.setJson(conectar(url,this.cadastrarUsuario.getJson()));
            }else if (usuario.getOperacao()== UsuarioModel.Operacao.autenticar){
                this.autenticarUsuario = new AutenticarUsuarioController(usuario);
                this.url = this.url + this.autenticarUsuario.getApiMetodo();
                this.autenticarUsuario.setJson(conectar(url,this.autenticarUsuario.getJson()));
            }else if (usuario.getOperacao()== UsuarioModel.Operacao.atualizar){
                this.atualizarUsuario = new AtualizarUsuarioController(usuario);
                this.url = this.url + this.atualizarUsuario.getApiMetodo();
                this.atualizarUsuario.setJson(conectar(url,this.atualizarUsuario.getJson()));
            }
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
