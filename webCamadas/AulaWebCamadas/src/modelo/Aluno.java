package modelo;

import java.io.Serializable;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int matricula;
	private String senha;
	
	public Aluno(int _matricula, String _senha){
		
		this.matricula = _matricula;
		this.senha = _senha;
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

}
