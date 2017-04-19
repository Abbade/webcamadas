package dao;

import modelo.Aluno;
import modelo.Endereco;
import modelo.Pessoa;

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
	public Aluno consultarAluno(int _matricula) throws SQLException {
	
		Aluno p = null;
		
		String comando = "select * from aluno where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			/*
			 * p = new Aluno(rs.getInt(1), rs.getString(2), rs.getString(3) );
			 * 
			 * */
			p = new Aluno();
			
			p.setMatricula(rs.getInt(1));
			p.setSenha(rs.getString(2));
			p.setNome(rs.getString(3));

			
	
		}
		
		return p;
		
	}

	@Override
	public Boolean deletar(int _matricula) throws SQLException {
		
		String comando = "delete from aluno where matricula = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
	
		
		return ps.execute();
	}

	@Override
	public Boolean atualizar(Aluno _aluno) throws SQLException {
		
		String comando = "update pessoa set nome = ?, senha = ? where matricula = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setString(1, _aluno.getNome());
		ps.setString(2, _aluno.getSenha());
		ps.setInt(3, _aluno.getMatricula());
		


		return ps.execute();
	}

}
