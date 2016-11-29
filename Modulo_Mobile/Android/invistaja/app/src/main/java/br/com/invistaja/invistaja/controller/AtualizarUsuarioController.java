package br.com.invistaja.invistaja.controller;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.invistaja.invistaja.model.UsuarioModel;

public class AtualizarUsuarioController implements iController{
    private UsuarioModel usuario;
    private String apiMetodo = "update/";

    public AtualizarUsuarioController(UsuarioModel usuario){
        this.usuario = usuario;
    }

    @Override
    public JSONObject getJson() throws JSONException {
        JSONObject json = new JSONObject();

        if (!this.usuario.getLogin().equals("")){json.put("username",this.usuario.getLogin());}
        if (!this.usuario.getPassword().equals("")){json.put("password",this.usuario.getPassword());}
        if (!this.usuario.getName().equals("")){json.put("name",this.usuario.getLogin());}
        if (!this.usuario.getCellphone().equals("")){json.put("cellphone",this.usuario.getCellphone());}

        return json;
    }

    @Override
    public void setJson(JSONObject json) throws JSONException {
        if (json.toString().contains("sucess")){this.usuario.setSucess(json.getBoolean("sucess"));}
        if (json.toString().contains("message")){this.usuario.setMessage(json.getString("message"));}
    }

    @Override
    public String getApiMetodo() {
        return apiMetodo;
    }
}
