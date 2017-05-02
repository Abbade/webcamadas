package dao;
import java.sql.SQLException;
import java.util.List;

import modelo.Aluno;


public interface InterfaceAlunoDAO 
{
	public void cadastrarAluno(Aluno _aluno) throws SQLException;
	public List<Aluno> listarTodos() throws SQLException;
	public Aluno consultarAluno(int _matricula) throws SQLException;
	public boolean deletar(int _matricula) throws SQLException;
	public boolean atualizar(Aluno _aluno) throws SQLException;
	
	
	
}
