package br.com.invistaja.invistaja.controller;

import org.json.JSONException;
import org.json.JSONObject;

public interface iController {
    public JSONObject getJson() throws JSONException;
    public void setJson(JSONObject json)throws JSONException;
    public String getApiMetodo();
}
