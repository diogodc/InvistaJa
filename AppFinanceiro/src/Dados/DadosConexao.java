/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosConexao {
   
    private final String sDriver="oracle.jdbc.driver.OracleDriver";
    private final String sBanco="jdbc:oracle:thin:@187.85.160.51.:1521:xe";
    private final String sUsuario="BOVESPA";
    private final String sSenha="BOVESPA123";
    private Connection cConnection = null;
    private Statement sStatement=null;
    private ResultSet rResultSet = null;
    private ResultSetMetaData rResultSetMetaData = null;
    
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
            Class.forName(getDriver()).newInstance();
            setConnection(DriverManager.getConnection(getBanco(),getUsuario(),getSenha()));
	    setStatement(getConnection().createStatement());
            return true;
        }catch(ClassNotFoundException 
              | SQLException
              | InstantiationException 
              | IllegalAccessException ex){
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
    
    public ResultSet consultar(String sConsulta) throws Exception{
        try{
            setResultSet(getStatement().executeQuery(sConsulta.trim()));
            setResultSetMetaData(getResultSet().getMetaData());
            return getResultSet();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean alterar(String sAlteracao) throws Exception{
        try{
            getStatement().execute(sAlteracao.trim());
            return true;
        }catch(Exception ex){
           throw ex; 
        }
    }
    
}
