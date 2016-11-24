package br.com.invistaja.invistaja.controller;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.invistaja.invistaja.model.UsuarioModel;

public class AutenticarUsuarioController implements iController {
    private UsuarioModel usuario;
    private String apiMetodo = "authenticate/";

    public AutenticarUsuarioController(UsuarioModel usuario){
        this.usuario = usuario;
    }

    @Override
    public JSONObject getJson() throws JSONException {
        JSONObject json = new JSONObject();

        if (!this.usuario.getLogin().equals("")){json.put("username",this.usuario.getLogin());}
        if (!this.usuario.getPassword().equals("")){json.put("password",this.usuario.getPassword());}

        return json;
    }

    @Override
    public void setJson(JSONObject json) throws JSONException {
        if (json.toString().contains("sucess")){this.usuario.setSucess(json.getBoolean("sucess"));}
        if (json.toString().contains("message")){this.usuario.setMessage(json.getString("message"));}
        if (json.toString().contains("session")) {
            JSONObject jSession = json.getJSONObject("session");
            if (jSession.toString().contains("token")) {
                this.usuario.setToken(jSession.getString("token"));
            }
            if (jSession.toString().contains("name")) {
                this.usuario.setName(jSession.getString("name"));
            }
            if (jSession.toString().contains("id")) {
                this.usuario.setId(jSession.getInt("id"));
            }
            if (jSession.toString().contains("cellphone")) {
                this.usuario.setCellphone(jSession.getString("cellphone"));
            }
            if (jSession.toString().contains("username")) {
                this.usuario.setLogin(jSession.getString("username"));
            }
            if (jSession.toString().contains("password")) {
                this.usuario.setPassword(jSession.getString("password"));
            }
        }
    }

    @Override
    public String getApiMetodo() {
        return apiMetodo;
    }
}
