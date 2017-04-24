package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Disciplina;

public interface InterfaceDisciplinaDAO {

	public void cadastrarDisciplina(Disciplina _disciplina) throws SQLException;
	public List<Disciplina> listarTodos() throws SQLException;
	public Disciplina consultarDisciplina (int _idDisciplina) throws SQLException;
	public boolean deletar(int _idDisciplina) throws SQLException;
	public boolean atualizar(Disciplina _disciplina) throws SQLException;

}
