/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import App.AppWs;

public class DadosConexao {
    public static String sIpServidor;
    private String sDriver;
    private String sBanco;
    private String sUsuario;
    private String sSenha;
    private Connection cConnection = null;
    private Statement sStatement=null;
    private ResultSet rResultSet = null;
    private ResultSetMetaData rResultSetMetaData = null;
   
    public DadosConexao(){
            this.sDriver = "com.mysql.jdbc.Driver";
            this.sBanco = "jdbc:mysql://186.202.152.190:3306/dbinvistaja"; 
            this.sUsuario = "dbinvistaja";
            this.sSenha = "Kalunga@01";
    }
    
    public String getDriver(){
        return this.sDriver;
    }
    
    public String getBanco(){
        return this.sBanco;
    }
    
    public String getUsuario(){
        return this.sUsuario;
    }
    
    public String getSenha(){
        return this.sSenha;
    }
    
    public Connection getConnection(){
        return this.cConnection;
    }
    public void setConnection(Connection cConnection){
        this.cConnection = cConnection;
    }
    
    public Statement getStatement(){
        return this.sStatement;
    }
    public void setStatement(Statement sStatement){
        this.sStatement = sStatement;
    }
    
    public ResultSet getResultSet(){
        return this.rResultSet;
    }
    public void setResultSet(ResultSet rResultSet){
        this.rResultSet = rResultSet;
    }
    
    public ResultSetMetaData getResultSetMetaData(){
        return this.rResultSetMetaData;
    }
    public void setResultSetMetaData(ResultSetMetaData rResultSetMetaData){
        this.rResultSetMetaData = rResultSetMetaData;
    }
            
    public boolean abrirConexao() throws ClassNotFoundException, 
                                         SQLException, 
                                         InstantiationException, 
                                         IllegalAccessException{
        try{
            Class.forName(getDriver());
            setConnection(DriverManager.getConnection(getBanco(),getUsuario(),getSenha()));
	    setStatement(getConnection().createStatement());
            return true;
        }catch(ClassNotFoundException 
              | SQLException
              ex){
            throw ex;
        }
    }
    
    public boolean fecharConexao() throws Exception{
        try{
            getConnection().close();
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    protected ResultSet consultar(String sConsulta) throws Exception{
        try{
            getStatement().setQueryTimeout(0);
            setResultSet(getStatement().executeQuery(sConsulta.trim()));
            setResultSetMetaData(getResultSet().getMetaData());
            return getResultSet();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    protected boolean alterar(String sAlteracao) throws Exception{
        try{
            getStatement().setQueryTimeout(0);
            getStatement().execute(sAlteracao.trim());
            return true;
        }catch(Exception ex){
           throw ex; 
        }
    }
    
    protected boolean procedure(String sProcedure)throws Exception{
        try{
            CallableStatement  cs = AppWs.conn.getConnection().prepareCall(sProcedure);
            cs.execute(); 
            return true;
        }catch(Exception ex){
           throw ex; 
        }
    }    
}
