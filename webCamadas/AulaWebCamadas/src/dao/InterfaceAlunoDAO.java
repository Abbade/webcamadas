package dao;
import java.sql.SQLException;
import java.util.List;

import modelo.Aluno;


public interface InterfaceAlunoDAO 
{
	public void cadastrarAluno(Aluno _aluno) throws SQLException;
	public List<Aluno> listartodos() throws SQLException;
	public boolean consultarAluno(int _matricula) throws SQLException;
	public Boolean deletar(int _matricula) throws SQLException;
	public Boolean atualizar(Aluno _aluno) throws SQLException;
	
	
	
}
