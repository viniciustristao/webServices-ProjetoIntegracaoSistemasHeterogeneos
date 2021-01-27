package tsi.webservices.modelo;

public class Aluno {
	private int id;
	private String nome;
	private boolean matriculado;
	private static int naluno = 0;
	
	public Aluno() {
		super();
		naluno++;
		id=naluno;
	}
	
	public Aluno(int id, String nome, boolean matriculado) {
		this();
		this.id = id;
		this.nome = nome;
		this.matriculado = matriculado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	@Override
	public String toString() {
		return String.format("ID: %s -- Nome: %s -- Matriculado: %s", id, nome, matriculado==true?"Sim":"Nao");
	}
}
