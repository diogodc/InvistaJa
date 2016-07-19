package App;

import Dados.DadosManipulacao;
import Visao.VisaoAutenticacao;
import com.google.gson.Gson;
import java.awt.Component;
import java.io.OutputStream;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class AppFinanceiro {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        VisaoAutenticacao vServidor = new VisaoAutenticacao(); 
        vServidor.setVisible(true);
    }  
    
    public static String sFTP_Servidor = "invistaja.com";
    public static String sFTP_Usuario = "invistaja1";
    public static String sFTP_Senha = "t1oph1ll";
    public static String sFTP_Diretorio = "/public_html/app/json";
    
    public enum tipoRelatorio{
        DRE,BPA,BPP;
    }
    
    public enum tipoEmpresas{
        TODAS,IMPORTADAS,CALCULADAS;
    }
    
    public static DadosManipulacao conn;
    
    public static String converteObjetoParaJson(Object objeto){
        try{
            Gson gson = new Gson();
            String sJson = gson.toJson(objeto);
            return sJson;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static String converteJsonParaObjeto(Object objeto){
        try{
            Gson gson = new Gson();
            String sJson = gson.toJson(objeto);
            return sJson;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean gravarArquivo(String sNomeArquivo, 
            String sConteudo) throws Exception{
        try{
            if (gravarArquivoFTP(sFTP_Servidor,sFTP_Usuario,sFTP_Senha,sFTP_Diretorio,sNomeArquivo,sConteudo)){
                return true;
            }
            return false;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean gravarArquivoFTP(String sHostname, 
            String sUsername, String sPassword,
            String sDiretorio, String sNomeArquivo, String sConteudo) throws Exception{
        try{
            FTPClient ftp = new FTPClient();
            ftp.connect(sHostname);
            ftp.login(sUsername, sPassword);
            ftp.changeWorkingDirectory(sDiretorio);
            OutputStream os = ftp.storeFileStream(sNomeArquivo);
            os.write(sConteudo.getBytes());
            os.flush();
            os.close();
            ftp.logout();
            ftp.disconnect();
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    public static void abrirVisao(JDesktopPane pnl,JInternalFrame form) throws Exception{
        try{
            pnl.add(form);
            form.setVisible(true);
            form.setMaximum(true);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static String abrirVisaoArquivo(JInternalFrame form){
        try{
            JFileChooser fileChooser = new JFileChooser();  
            fileChooser.setDialogTitle("Informe o caminho do arquivo"); 
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (fileChooser.showOpenDialog((Component) form) == JFileChooser.APPROVE_OPTION){  
                return fileChooser.getSelectedFile().getPath();
            }
            return "";
        }catch(Exception ex){
            throw ex;
        } 
    }
}
