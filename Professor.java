package aula_16_05;

public class Professor {
	private String nome;
	private String titulo;
	private double salario;
	
	public Professor(String nome, String titulo, double salario) {
		super();
		this.nome = nome;
		this.titulo = titulo;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
