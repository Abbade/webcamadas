package modelo;

import java.io.Serializable;

public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String estado;
	private String cidade;
	private String bairro;
	private String logrodouro;
	private String cep;
	private int idPessoa;
	
	public Endereco() {
		
	}

	public Endereco(int _id, String _estado, String _cidade, String _bairro, String _logrodouro, String _cep, int _idPessoa) {
		super();
		this.id = _id;
		this.estado = _estado;
		this.cidade = _cidade;
		this.bairro = _bairro;
		this.logrodouro = _logrodouro;
		this.cep = _cep;
		this.idPessoa = _idPessoa;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getLogrodouro() {
		return logrodouro;
	}
	
	public void setLogrodouro(String logrodouro) {
		this.logrodouro = logrodouro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public int getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
}
