package tsi.webservices.modelo;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonModel {
	
	@SuppressWarnings("unchecked")
	public static JSONArray parseTurmatoJson(ArrayList<Turma> turmas) {
		JSONArray jTurmas = new JSONArray();
		JSONObject objTurma;
		for (Turma turma : turmas) {
			objTurma = new JSONObject();
			objTurma.put("ID", String.valueOf(turma.getId()));
			objTurma.put("Curso", turma.getCurso());
			objTurma.put("Ano", String.valueOf(turma.getAno()));
			JSONArray alunosJs = parseAlunostoJson(turma.getAlunos());
			objTurma.put("Alunos", alunosJs);
			jTurmas.add(objTurma);
		}	
		return jTurmas;
	}

	@SuppressWarnings("unchecked")
	private static JSONArray parseAlunostoJson(ArrayList<Aluno> alunos) {
		JSONArray alunosJson = new JSONArray();
		JSONObject objAluno;
		for (Aluno aluno : alunos) {
			objAluno = new JSONObject();
			objAluno.put("ID", aluno.getId());
			objAluno.put("Nome", aluno.getNome());
			objAluno.put("Matriculado", aluno.isMatriculado()?"True":"False");
			alunosJson.add(objAluno);
		}
		
		return alunosJson;
	}
}
