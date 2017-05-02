package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Foto;

public interface InterfaceFotoDAO {

	public void cadastrarFoto(Foto _foto) throws SQLException;
	public List<Foto> listarTodas(int _idAlbum) throws SQLException; // lista do aluno
	public Foto consultarFoto(int _idFoto) throws SQLException;
	public boolean deletar(int _matricula) throws SQLException;
	public boolean atualizar(Foto _Foto) throws SQLException;
	
}
