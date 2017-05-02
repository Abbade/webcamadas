package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Album;
import modelo.Disciplina;

public interface InterfaceDisciplinaDAO {

	public void cadastrarDisciplina(Disciplina _disciplina) throws SQLException;
	public List<Disciplina> listarTodos(int _idCurso) throws SQLException;
	public Disciplina consultarDisciplina (int _idDisciplina) throws SQLException;
	public boolean deletar(int _idDisciplina) throws SQLException;
	public boolean atualizar(Disciplina _disciplina) throws SQLException;
	public List<Album> listarAlbuns (int _idCurso, int _idDisciplina) throws SQLException;
}
