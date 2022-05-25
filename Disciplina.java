

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Disciplina {
	private String nome;
	private int numeroVagas;
	private Professor professor;
	private ArrayList<Aluno> alunosMatriculados;
	private ArrayList<Aluno> alunosEspera;
	
	public Disciplina(String nome, int numeroVagas, Professor professor) {
		super();
		this.nome = nome;
		this.numeroVagas = numeroVagas;
		this.professor = professor;
		this.alunosMatriculados = new ArrayList<Aluno>();
		this.alunosEspera = new ArrayList<Aluno>();
	}

	public Disciplina(String nome, int numeroVagas, Professor professor, ArrayList<Aluno> alunosMatriculados) throws ParametroInvalidoException{
		super();
		if(alunosMatriculados.size() <= numeroVagas) {
			this.nome = nome;
			this.numeroVagas = numeroVagas;
			this.professor = professor;
			this.alunosMatriculados = alunosMatriculados;
			this.alunosEspera = new ArrayList<Aluno>();
		}
		else {
			throw new ParametroInvalidoException();
		}
	}
	
	public Aluno consultarAluno(String matricula) throws AlunoNaoMatriculadoException {
		for(Aluno aluno : this.alunosMatriculados) {
			if(aluno.getMatricula().equals(matricula)) {
				System.out.println("Matriculado");
				return aluno;
			}
		}
		for(Aluno aluno : this.alunosMatriculados) {
			if(aluno.getMatricula().equals(matricula)) {
				System.out.println("Lista de espera");
				return aluno;
			}
		}
		throw new AlunoNaoMatriculadoException();
	}
	
	public void matricularAluno(Aluno alunoNovo) throws AlunoJaMatriculadoException {
		if(this.alunosMatriculados.contains(alunoNovo) || this.alunosEspera.contains(alunoNovo)) {
			throw new AlunoJaMatriculadoException();
		}
		else if(this.alunosMatriculados.size() < this.numeroVagas) {
			this.alunosMatriculados.add(alunoNovo);
		} 
		else {
			this.alunosEspera.add(alunoNovo);
		}
		
	}
	
	public void cancelarMatriculaAluno (String matriculaAluno) throws AlunoNaoMatriculadoException {
		Aluno aluno = consultarAluno(matriculaAluno);
		if(this.alunosMatriculados.contains(aluno)) {
			this.alunosMatriculados.remove(aluno);
			if(this.alunosEspera.size() != 0) {
				this.alunosMatriculados.add(this.alunosEspera.get(0));
				this.alunosEspera.remove(0);
			}
		}
		else if(this.alunosEspera.contains(aluno)) {
			this.alunosEspera.remove(aluno);
		}
		else throw new AlunoNaoMatriculadoException();
		
	}

	@Override
	public String toString() {
		Collections.sort(this.alunosMatriculados, Comparator.comparing(Aluno::getMatricula));
		Collections.sort(this.alunosEspera, Comparator.comparing(Aluno::getMatricula));
		String texto1 = "Disciplina: " + this.nome +"\n" +"Professor: " + this.professor.getTitulo() + this.professor.getNome() + "\n" + "Número de Alunos Matrículados: " + this.alunosMatriculados.size() + "\n\n";
		
		for(Aluno aluno : this.alunosMatriculados) {
			
		}
		
		return ;
	}
	
	
	
}
