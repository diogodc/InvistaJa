package br.com.invistaja.invistaja.controller;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.invistaja.invistaja.model.UsuarioModel;

public class CadastrarUsuarioController implements iController {
    private UsuarioModel usuario;
    private String apiMetodo = "register/";

    public CadastrarUsuarioController(UsuarioModel usuario){
        this.usuario = usuario;
    }

    public JSONObject getJson() throws JSONException {
        try{
            JSONObject json = new JSONObject();

            if (!this.usuario.getLogin().equals("")){json.put("username",this.usuario.getLogin());}
            if (!this.usuario.getPassword().equals("")){json.put("password",this.usuario.getPassword());}
            if (!this.usuario.getName().equals("")){json.put("name",this.usuario.getName());}
            if (!this.usuario.getCellphone().equals("")){json.put("cellphone",this.usuario.getCellphone());}

            return json;
        }catch (Exception ex){
            throw  ex;
        }
    }

    public void setJson(JSONObject json) throws JSONException {
        try{
            if (json.toString().contains("sucess")){this.usuario.setSucess(json.getBoolean("sucess"));}
            if (json.toString().contains("message")){this.usuario.setMessage(json.getString("message"));}
        }catch (Exception ex){
            throw  ex;
        }
    }

    @Override
    public String getApiMetodo() {
        return apiMetodo;
    }
}
