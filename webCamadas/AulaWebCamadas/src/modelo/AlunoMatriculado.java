package modelo;

import java.io.Serializable;

public class AlunoMatriculado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int matricula;
	private int idCurso;
	
	public AlunoMatriculado(int _matricula, int _idCurso){
		
		this.matricula = _matricula;
		this.idCurso = _idCurso;
	}
	
	public AlunoMatriculado(){
		
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	

}
