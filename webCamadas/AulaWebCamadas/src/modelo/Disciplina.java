package modelo;

import java.io.Serializable;

public class Disciplina implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private int idDisciplina;
	private String nome;
	private int periodo;
	private String tipo;
	
	public Disciplina(int _idDisciplina, String _nome){
		
		this.setIdDisciplina(_idDisciplina);
		this.setNome(_nome);
	}
	
	public Disciplina (){
		
	}
	
	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
