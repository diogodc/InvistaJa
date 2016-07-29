package Modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModeloUsuario {
    private String sUsuario;
    private String sSenha;
    private String sUsuario_ID;
    private String sUsuario_Nome;

    public ModeloUsuario(){
        this.sUsuario = "";
        this.sSenha = "";
        this.sUsuario_ID = "";
        this.sUsuario_Nome = "";
    }
    
    public ModeloUsuario(String sUsuario,String sSenha,
            String sUsuario_ID,String sUsuario_Nome){
        this.sUsuario = sUsuario;
        this.sSenha = sSenha;
        this.sUsuario_ID = sUsuario_ID;
        this.sUsuario_Nome = sUsuario_Nome;
    }
        
    public String getUsuario() {
        return sUsuario.replace("'", "''");
    }

    public void setUsuario(String sUsuario) {
        this.sUsuario = sUsuario;
    }

    public String getSenha() {
        return sSenha.replace("'", "''");
    }

    public void setSenha(String sSenha) {
        this.sSenha = sSenha;
    }

    public String getUsuario_ID() {
        return sUsuario_ID;
    }

    public void setUsuario_ID(String sUsuario_ID) {
        this.sUsuario_ID = sUsuario_ID;
    }

    public String getUsuario_Nome() {
        return sUsuario_Nome.replace("'", "''");
    }

    public void setUsuario_Nome(String sUsuario_Nome) {
        this.sUsuario_Nome = sUsuario_Nome;
    }
}
