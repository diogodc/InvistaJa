package App;

import Dados.DadosManipulacao;
import Visao.VisaoAutenticacao;
import com.google.gson.Gson;
import java.awt.Component;
import java.io.File;
import java.util.Formatter;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;

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
    
    public static String sCaminhoArquivos = "C:\\Projetos\\BOVESPA_ANALYTICS\\Modulo_Web\\FrontEnd\\app\\Json\\";
    
    public enum tipoRelatorio{
        DRE,BPA,BPP;
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
            (new File(sCaminhoArquivos)).mkdir();
            Formatter fArquivo = new Formatter(sCaminhoArquivos + sNomeArquivo);
            fArquivo.format(sConteudo);
            fArquivo.close();
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
