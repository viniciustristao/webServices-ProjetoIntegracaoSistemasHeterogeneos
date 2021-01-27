package tsi.webservices.turma.cadastro;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import tsi.webservices.entradasaida.EntradaSaida;
import tsi.webservices.integracao.IntegracaoSocket;
import tsi.webservices.modelo.JsonModel;
import tsi.webservices.modelo.Turma;

public class Principal {

	public static void main(String[] args) {
		inicializar();

	}

	private static void inicializar() {
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		
		menu(turmas);
		
	}

	private static void menu(ArrayList<Turma> turmas) {
		Integer op;
		do {
			op = EntradaSaida.lerNumeroInteiro("1-Cadastrar Turma\n2-Cadastrar Aluno\n3-Exibir Turma\n4-Enviar dados\n5-Sair", "Cadastro de Turmas");
			if(op!=null)	
				switch (op) {
				case 1:
					turmas.add(cadastrarTurma());
					break;
				case 2:
					cadastrarAluno(turmas);
					break;
				case 3:
					exibeTurmas(turmas);
					break;
				case 4:
					enviaDado(turmas);
					break;
				}
		}while(op!=null && op!=5);

	}

	private static void enviaDado(ArrayList<Turma>turmas) {
		JSONArray jTurma = JsonModel.parseTurmatoJson(turmas);
		IntegracaoSocket.enviarDados(jTurma);	
	}

	private static void exibeTurmas(ArrayList<Turma>turmas) {
		StringBuilder sb = new StringBuilder();
		
		for (Turma turma : turmas) {
			sb.append(turma).append("\n");
		}
	
		EntradaSaida.exibirTexto(sb.toString(), "Exibe Turmas");
	}

	private static void cadastrarAluno(ArrayList<Turma>turmas) {
		String titulo = "Cadastro de aluno";
		int idt;
		boolean cad=false;
		idt=EntradaSaida.lerNumeroInteiro("Informe o ID da turma:", titulo);
		for (Turma turma : turmas) {
			if(turma.getId()==idt)
				cad=turma.cadastraAluno(titulo);
		}
		if(!cad)
			EntradaSaida.msgErro("Aluno nao cadastrado", titulo);
		else
			EntradaSaida.msgInfo("Aluno Cadastrado", titulo);
	}

	private static Turma cadastrarTurma() {
		Turma turma = new Turma();
		String titulo ="Cadastro de Turma";
		turma.setCurso(EntradaSaida.lerString("Informe o nome do curso:", titulo));
		turma.setAno(EntradaSaida.lerNumeroInteiro("Informa o ano:", titulo));
		return turma;
	}
}