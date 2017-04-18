package dao;

import modelo.Aluno;

public class AlunoDAO implements InterfaceAlunoDAO{
	
	private Connection conexao;
	
	public AlunoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	

	@Override
	public void cadastrarAluno(Aluno _aluno) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> listartodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean consultarAluno(int _matricula) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean deletar(int _matricula) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean atualizar(Aluno _aluno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
