package modelo;

import java.io.Serializable;


public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int matricula;
	private String senha;
	private String nome;

	
	
	public Aluno(int _matricula, String _senha, String _nome){
		
		this.matricula = _matricula;
		this.senha = _senha;
		this.setNome(_nome);
	}
	public Aluno(){
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
