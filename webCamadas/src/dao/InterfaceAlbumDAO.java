package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Album;
import modelo.Foto;

public interface InterfaceAlbumDAO {

	public void cadastrarAlbum(Album _album) throws SQLException;
	public List<Foto> listarFotos(int _idAlbum) throws SQLException;
	public List<Album> listarTodos(int _matricula, int _idCurso) throws SQLException; // lista do aluno
	public Album consultarAlbum(int _idAlbum) throws SQLException;
	public boolean deletar(int _matricula) throws SQLException;
	public boolean atualizar(Album _album) throws SQLException;
	public List<Album> listarTodos(int _idDisciplina) throws SQLException; // disciplina do curso
}
