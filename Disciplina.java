package aula_16_05;

import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private int numeroVagas;
	private String professor;
	private ArrayList<Aluno> alunosMatriculados;
	private ArrayList<Aluno> alunosEspera;
	
	public Disciplina(String nome, int numeroVagas, String professor) {
		super();
		this.nome = nome;
		this.numeroVagas = numeroVagas;
		this.professor = professor;
		this.alunosMatriculados = new ArrayList<Aluno>();
		this.alunosEspera = new ArrayList<Aluno>();
	}

	public Disciplina(String nome, int numeroVagas, String professor, ArrayList<Aluno> alunosMatriculados) throws ParametroInvalidoException{
		super();
		if(alunosMatriculados.size() <= numeroVagas) {
			this.nome = nome;
			this.numeroVagas = numeroVagas;
			this.professor = professor;
			this.alunosMatriculados = alunosMatriculados;
			this.alunosEspera = new ArrayList<Aluno>();
		}
		else {
			throw new ParametroInvalidoException("ERRO. Lista de matriculados superior ao numero de vagas");
		}
	}
	
	public String consultarAluno(String matricula) {
		for(int i = 0; i < alunosMatriculados.size(); i++) {
			if(alunosMatriculados[i].matricula)
		}
	}
	
}
