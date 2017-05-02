package modelo;

import java.io.Serializable;
import java.util.Date;


public class Album implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int idAlbum;
	int matricula;
	int idDisciplina;
	int idCurso;
	String descricao;
	Date dataCriacao;
	
	public Album(int idAlbum, int matricula, int idDisciplina, int idCurso, String descricao, Date dataCriacao) {
		
		this.idAlbum = idAlbum;
		this.matricula = matricula;
		this.idDisciplina = idDisciplina;
		this.idCurso = idCurso;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}
	
	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
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

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


}
