package br.com.invistaja.invistaja.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario implements iModel {
    private String login;
    private String password;
    private String name;
    private String cellphone;
    private Boolean sucess;
    private String message;
    private String token;
    private int id;
    private Date date;

    public Usuario(String login, String password, String name, String cellphone){
        this.login = login;
        this.password = password;
        this.name = name;
        this.cellphone = cellphone;
    }

    public Usuario(){
        this.login = null;
        this.password = null;
        this.name = null;
        this.cellphone = null;
        this.sucess = false;
        this.message = null;
    }

    public Usuario(Boolean sucess, String message){
        this.sucess = sucess;
        this.message = message;
    }

    public String getLogin() {
        this.login = this.login.replace("'","''");
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.aspas(this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.aspas(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        this.cellphone = this.cellphone.replace("(","").replace(")","").replace("-","");
        return aspas(this.cellphone);
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getMessage() {
        return this.aspas(this.message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSucess() {
        return sucess;
    }

    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
    }

    public String getToken() {
        return aspas(this.token);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public JSONObject getJson() throws JSONException {
        try{
            JSONObject json = new JSONObject();

            if (this.getLogin()!= null){json.put("login",this.getLogin());}
            if (this.getPassword()!=null){json.put("password",this.getPassword());}
            if (this.getName() != null){json.put("name",this.getName());}
            if (this.getCellphone() != null){json.put("cellphone",this.getCellphone());}

            return json;
        }catch (Exception ex){
            throw  ex;
        }
    }

    public void setJson(JSONObject json) throws JSONException {
        try{
            if (json.get("sucess")!=null){this.setSucess(json.getBoolean("sucess"));}
            if (json.get("message")!=null){this.setMessage(json.getString("message"));}
            if (json.get("token") != null) {this.setToken(json.getString("token"));}
            if (json.get("name") != null) {this.setName(json.getString("name"));}
            if (json.get("id") != null) {this.setId(json.getInt("id"));}
            if (json.get("cellphone") != null) {this.setCellphone(json.getString("cellphone"));}
        }catch (Exception ex){
            throw  ex;
        }
    }

    public String aspas(String str){
        return str.replace("'","''");
    }
}
