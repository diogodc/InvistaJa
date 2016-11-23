package br.com.invistaja.invistaja.model;

import org.json.JSONException;
import org.json.JSONObject;

public class UsuarioModel implements iModel {
    private String login;
    private String password;
    private String name;
    private String cellphone;
    private Boolean sucess;
    private String message;
    private String token;
    private int id;

    private Operacao operacao;

    public UsuarioModel(String login, String password, String name, String cellphone, Boolean sucess, String message, String token, int id, Operacao operacao){
        this.login = login;
        this.password = password;
        this.name = name;
        this.cellphone = cellphone;
        this.sucess = sucess;
        this.message = message;
        this.token = token;
        this.id = id;
        this.operacao = operacao;
    }

    public UsuarioModel(){
        this.login = "";
        this.password = "";
        this.name = "";
        this.cellphone = "";
        this.sucess = false;
        this.message = "";
        this.token = "";
        this.id = 0;
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

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public JSONObject getJson() throws JSONException {
        try{
            JSONObject json = new JSONObject();

            if (this.getLogin().equals("")){json.put("username",this.getLogin());}
            if (this.getPassword().equals("")){json.put("password",this.getPassword());}
            if (this.getName().equals("")){json.put("name",this.getName());}
            if (this.getCellphone().equals("")){json.put("cellphone",this.getCellphone());}

            return json;
        }catch (Exception ex){
            throw  ex;
        }
    }

    public void setJson(JSONObject json) throws JSONException {
        try{
            if (json.toString().contains("sucess")){this.setSucess(json.getBoolean("sucess"));}
            if (json.toString().contains("message")){this.setMessage(json.getString("message"));}
            if (json.toString().contains("token")) {this.setToken(json.getString("token"));}
            if (json.toString().contains("name")) {this.setName(json.getString("name"));}
            if (json.toString().contains("id")) {this.setId(json.getInt("id"));}
            if (json.toString().contains("cellphone")) {this.setCellphone(json.getString("cellphone"));}
            if (json.toString().contains("username")){this.setLogin(json.getString("username"));}
            if (json.toString().contains("password")){this.setPassword(json.getString("password"));}
        }catch (Exception ex){
            throw  ex;
        }
    }

    public String aspas(String str){
        return str.replace("'","''");
    }

    public enum Operacao{
        authenticate,
        register;
    }
}
