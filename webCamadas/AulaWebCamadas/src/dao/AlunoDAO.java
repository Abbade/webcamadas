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
	public List<Aluno> listarTodos() throws SQLException {
		
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
	
		Aluno p = null;
		
		String comando = "select * from aluno where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
		
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
	public boolean deletar(int _matricula) throws SQLException {
		
		String comando = "delete from aluno where matricula = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
	
		
		return ps.execute();
	}

	@Override
	public boolean atualizar(Aluno _aluno) throws SQLException {
		
		String comando = "update aluno set nome = ?, senha = ? where matricula = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setString(1, _aluno.getNome());
		ps.setString(2, _aluno.getSenha());
		ps.setInt(3, _aluno.getMatricula());
		


		return ps.execute();
	}


}
