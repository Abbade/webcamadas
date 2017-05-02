package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.AlunoMatriculado;
import modelo.Curso;
import modelo.Disciplina;

public interface InterfaceCursoDAO {
	
	public void cadastrarCurso(Curso _curso) throws SQLException;
	public List<Curso> listarTodos() throws SQLException;
	public Curso consultarCurso (int _idCurso) throws SQLException;
	public boolean deletar(int _idCurso) throws SQLException;
	public boolean atualizar(Curso _curso) throws SQLException;
	public List<Disciplina> listarDisciplinas (int _idCurso) throws SQLException;
	public List<AlunoMatriculado> listarAlunos (int _idCurso) throws SQLException;

}
