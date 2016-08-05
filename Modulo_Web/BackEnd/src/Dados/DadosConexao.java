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
    private Statement sStatement = null;
    private ResultSet rResultSet = null;
    private ResultSetMetaData rResultSetMetaData = null;
   
    protected DadosConexao(){
            this.sDriver = "com.mysql.jdbc.Driver";
            this.sBanco = "jdbc:mysql://186.202.152.190:3306/dbinvistaja"; 
            this.sUsuario = "dbinvistaja";
            this.sSenha = "Kalunga@01";
    }
    
    protected String getDriver(){
        return this.sDriver;
    }
    
    protected String getBanco(){
        return this.sBanco;
    }
    
    protected String getUsuario(){
        return this.sUsuario;
    }
    
    protected String getSenha(){
        return this.sSenha;
    }
    
    protected Connection getConnection(){
        return this.cConnection;
    }
    protected void setConnection(Connection cConnection){
        this.cConnection = cConnection;
    }
    
    protected Statement getStatement(){
        return this.sStatement;
    }
    protected void setStatement(Statement sStatement){
        this.sStatement = sStatement;
    }
    
    protected ResultSet getResultSet(){
        return this.rResultSet;
    }
    protected void setResultSet(ResultSet rResultSet){
        this.rResultSet = rResultSet;
    }
    
    protected ResultSetMetaData getResultSetMetaData(){
        return this.rResultSetMetaData;
    }
    protected void setResultSetMetaData(ResultSetMetaData rResultSetMetaData){
        this.rResultSetMetaData = rResultSetMetaData;
    }
            
    protected boolean abrirConexao() throws ClassNotFoundException, 
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
    
    protected boolean fecharConexao() throws Exception{
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
