package App;

import java.io.File;
import java.util.Formatter;

import Dados.DadosManipulacao;

public class AppWs {
	public static DadosManipulacao conn = new DadosManipulacao();
	
	private static String sCaminhoArquivo = "D:\\EVERALDO\\InvistaJa\\Modulo_Web\\FrontEnd\\app\\Json";
	
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