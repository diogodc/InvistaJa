package App;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import Dados.DadosManipulacao;

public class AppWs {
	public static DadosManipulacao conn = new DadosManipulacao();
	
	public static Gson gJson = new Gson();
	
	private static String sCaminhoArquivo = "C:\\LOGS\\";
	
	public enum tipoEmpresas{
        TODAS,IMPORTADAS,CALCULADAS;
    }
	
	public static void gravarLog(String sClasse, 
			String sMetodo,String sNomeArquivo, 
			String sMenssagem_1,String sMenssagem_2){
		try{
			File fDiretorio = new File(sCaminhoArquivo);
			File fArquivo;
			
			if (!sNomeArquivo.isEmpty()) {
				fArquivo = new File(fDiretorio,sNomeArquivo);
			}else{
				fArquivo = new File(fDiretorio,"LogWS_InvistaJa_Erros.txt");
			}
			
			fArquivo.createNewFile();
			FileWriter fwArquivoEscrever = new FileWriter(fArquivo, true);
			PrintWriter pwEscrever = new PrintWriter(fwArquivoEscrever);

			pwEscrever.println("|--------------------Log WS Invista Já!--------------------|");
			pwEscrever.println("Data/Hora: " + new Date().toString());
			if (!sClasse.isEmpty()){pwEscrever.println("Classe: " + sClasse);}
			if (!sMetodo.isEmpty()){pwEscrever.println("Método: " + sMetodo);}
			if (!sMenssagem_1.isEmpty()){pwEscrever.println("Mensagem principal: " + sMenssagem_1);}
			if (!sMenssagem_2.isEmpty()){pwEscrever.println("Mensagem secundária: " + sMenssagem_2);}
			pwEscrever.println("");
			
			pwEscrever.flush();
			pwEscrever.close();
		}catch(Exception ex){
			
		}
	}
	
	public static void logAcesso(HttpServletRequest hsr,String sClasse,String sMetodo){
		try{
			AppWs.gravarLog(sClasse, sMetodo,
					"LogWS_InvistaJa_Autenticacao.txt",
					"Dados remotos --> IP: " + hsr.getRemoteAddr() +
					" Porta: " + hsr.getRemotePort(),
					"Dados locais --> IP: " + hsr.getServerName() +
					" Porta: " + hsr.getServerPort());
		}catch(Exception ex){
			
		}
	}
}