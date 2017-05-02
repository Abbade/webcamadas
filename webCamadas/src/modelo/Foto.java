package modelo;

import java.io.Serializable;


public class Foto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	int idFoto;
	int matricula;
	int idDisciplina;
	int idAlbum;
	int idCurso;
	boolean permissao;
	
	public Foto(int idFoto, int matricula, int idDisciplina, int idAlbum, int idCurso, boolean permissao) {
		super();
		this.idFoto = idFoto;
		this.matricula = matricula;
		this.idDisciplina = idDisciplina;
		this.idAlbum = idAlbum;
		this.idCurso = idCurso;
		this.permissao = permissao;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public boolean isPermissao() {
		return permissao;
	}

	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}

}
