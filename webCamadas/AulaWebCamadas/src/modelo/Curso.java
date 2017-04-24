package modelo;

import java.io.Serializable;

public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idCurso;
	private String nome;

	
	
	public Curso(int _idCurso, String _nome){
		
		this.setidCurso(_idCurso);
		this.setNome(_nome);
	}
	public Curso(String _nome){
		
		this.setNome(_nome);
	}

	public Curso(){
		
	}
	

	
	public int getIdCurso() {
		return idCurso;
	}
	
	/*idCurso = autoincrement postgre
	 * public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}*/
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setidCurso (int _idCurso){
		this.idCurso = _idCurso;
	}
	
	

	
}
