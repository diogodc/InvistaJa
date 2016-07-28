package App;

import java.io.File;
import java.util.Formatter;

public class AppWs {
	private static String sCaminhoArquivo = "D:\\EVERALDO\\BOVESPA_ANALYTICS\\Modulo_Web\\FrontEnd\\app\\Json\\";
	
	public static void gravarLog(String sClasse, String sMetodo,String sNomeArquivo, String sMenssagem){
		try{
			(new File(sCaminhoArquivo)).mkdir();
			Formatter fArquivo;
			if (!sNomeArquivo.trim().isEmpty()){
				fArquivo = new Formatter(sCaminhoArquivo + sNomeArquivo);
			}else{
				fArquivo = new Formatter(sCaminhoArquivo + "LogWSInvistaJa.txt");
			}
			fArquivo.format("Classe: " + sClasse + "\nMetodo: " + sMetodo + "\nMensagem: " + sMenssagem);
	        fArquivo.close();
		}catch(Exception ex){
			AppWs.gravarLog("AppWs","gravarLog","",ex.getMessage());
		}
	}
}