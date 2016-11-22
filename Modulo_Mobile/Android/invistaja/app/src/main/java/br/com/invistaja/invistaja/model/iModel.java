package br.com.invistaja.invistaja.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public interface iModel {
    public JSONObject getJson() throws JSONException;
    public void setJson(JSONObject json)throws JSONException;
    public String aspas(String str);
}
