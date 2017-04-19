package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;


public class AlunoDAO implements InterfaceAlunoDAO {

	private Connection conexao;
	
	public AlunoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void cadastrarAluno(Aluno _aluno) throws SQLException {
		
		String comando = "INSERT INTO Aluno values(?,?,?); ";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		
		ps.setInt(1, _aluno.getMatricula());
		ps.setString(2, _aluno.getSenha());
		ps.setString(3, _aluno.getNome());

		ps.execute();
		
		
	}

	@Override
	public List<Aluno> listartodos() throws SQLException {
		
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		String comando = "select * from aluno";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int matricula = rs.getInt(1);
			String senha = rs.getString(2);
			String nome = rs.getString(3);
		
			
		
			
			listaAlunos.add(new Aluno(matricula, senha, nome) );
		}
		
		return listaAlunos;
	
	}

	@Override
	public Aluno consultarAluno(int _matricula) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletar(int _matricula) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Aluno _aluno) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
