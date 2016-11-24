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


    public UsuarioModel(String login, String password, String name, String cellphone, Boolean sucess, String message, String token, int id,Operacao operacao){
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
        this.operacao = Operacao.cadastrar;
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

    public String aspas(String str){
        return str.replace("'","''");
    }

    public enum Operacao{
        autenticar,atualizar,cadastrar
    }
}
