package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Album;
import modelo.AlunoMatriculado;

public interface InterfaceAlunoMatriculadoDAO {
	
	public void cadastrarMatricula(AlunoMatriculado _aluno) throws SQLException;
	public List<AlunoMatriculado> listarTodos() throws SQLException;
	public List<AlunoMatriculado> listarTodos(int _idCurso) throws SQLException;
	public AlunoMatriculado consultarMatricula(int _matricula, int _idCurso) throws SQLException;
	public boolean deletar(int _matricula, int _idCurso) throws SQLException;
	public boolean atualizar(AlunoMatriculado _aluno) throws SQLException;
	public List<Album> listarAlbuns (int _idCurso, int _idDisciplina) throws SQLException;
}
