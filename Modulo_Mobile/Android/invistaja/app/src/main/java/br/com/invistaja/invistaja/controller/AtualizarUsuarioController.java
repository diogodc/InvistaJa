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
        return null;
    }

    @Override
    public void setJson(JSONObject json) throws JSONException {

    }

    @Override
    public String getApiMetodo() {
        return apiMetodo;
    }
}
