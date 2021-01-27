package tsi.webservices.modelo;

import java.util.ArrayList;

import tsi.webservices.entradasaida.EntradaSaida;

public class Turma {
	private int id,ano;
	private String curso;
	private ArrayList<Aluno> alunos;
	private static int nTurma = 0;
	public Turma() {
		super();
		alunos = new ArrayList<Aluno>();
		nTurma++;
		id=nTurma;
	}
	public Turma(int id, int ano, String curso) {
		this();
		this.id = id;
		this.ano = ano;
		this.curso = curso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	@Override
	public String toString() {
		return String.format("Turma: %d, ano: %d, curso: %s\n\tAlunos:\n%s", id, ano, curso, listaAlunosString());
	}
	
	private String listaAlunosString() {
		StringBuilder sb = new StringBuilder();
		
		for (Aluno aluno : alunos) {
			sb.append(aluno).append("\n");
		}
		
		return sb.toString();
	}
	
	
	public boolean cadastraAluno(String titulo) {
		Aluno aluno = new Aluno();
		aluno.setNome(EntradaSaida.lerString("Informe o nome do Aluno:", titulo));
		aluno.setMatriculado(EntradaSaida.msgConfirma("Aluno Matriculado?", titulo)==0?true:false);
		return alunos.add(aluno);
	}
	
	
}