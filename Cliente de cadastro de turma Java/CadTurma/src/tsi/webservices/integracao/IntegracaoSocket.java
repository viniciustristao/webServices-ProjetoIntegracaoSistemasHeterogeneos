package tsi.webservices.integracao;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;

import tsi.webservices.entradasaida.EntradaSaida;

public class IntegracaoSocket {
	
	public IntegracaoSocket() {
	
	}
	public static void enviarDados(JSONArray jTurma){
		try {
			int porta;
			String ip = null;
			porta = solicitaDadosServidor(ip);
			Socket cliente = new Socket(ip, porta);
			System.out.println("Enviando os dados para o servidor!");
			
			BufferedOutputStream bf = new BufferedOutputStream(cliente.getOutputStream());
	        byte[] byteT = jTurma.toJSONString().getBytes();
	        bf.write(byteT);
	        bf.flush();
	        bf.close();
	        
			cliente.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static int solicitaDadosServidor(String ip) {
		int porta;
		ip=EntradaSaida.lerString("Informe o IP do servidor", "Conexão ao Servidor");
		porta = EntradaSaida.lerNumeroInteiro("Informa a porta utilizada", "Conexão ao Servidor");
		return porta;
	}
}
