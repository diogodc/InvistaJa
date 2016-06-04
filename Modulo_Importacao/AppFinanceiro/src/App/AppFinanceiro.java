package App;

import Dados.DadosManipulacao;
import Visao.VisaoInicio;
import com.google.gson.Gson;
import java.io.File;
import java.util.Formatter;
import javax.swing.JFrame;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class AppFinanceiro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VisaoInicio visaoInicio = new VisaoInicio(); 
        visaoInicio.setVisible(true);
        visaoInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }  
    
    public static String sCaminhoArquivos = "C:\\Arquivos_Json\\";
    
    public enum tipoRelatorio{
        DRE,BPA,BPP;
    }
    
    public static DadosManipulacao conn = new DadosManipulacao();
    
    public static String converteParaJson(Object objeto){
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
}
