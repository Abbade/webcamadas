package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.AlunoMatriculado;

public class AlunoMatriculadoDAO implements InterfaceAlunoMatriculadoDAO{

	private Connection conexao;
	
	public AlunoMatriculadoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void cadastrarMatricula(AlunoMatriculado _aluno) throws dao.SQLException {

		String comando = "INSERT INTO AlunoMatriculado values(?,?); ";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		
		ps.setInt(1, _aluno.getMatricula());
		ps.setInt(1, _aluno.getMatricula());
		
		ps.execute();
		
	}

	@Override
	public List<AlunoMatriculado> listarTodos() throws SQLException {
		
		List<AlunoMatriculado> listaAlunos = new ArrayList<AlunoMatriculado>();
		
		String comando = "select * from alunoMatriculado";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int matricula = rs.getInt(1);
			int idCurso = rs.getInt(2);
			
			listaAlunos.add(new AlunoMatriculado(matricula, idCurso) );
		}
		
		return listaAlunos;
	}

	@Override
	public AlunoMatriculado consultarMatricula(int _matricula, int _idCurso) throws SQLException {
		
		AlunoMatriculado p = null;
		
		String comando = "select * from alunomatriculado where matricula = ? AND idCurso = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
		ps.setInt(2, _idCurso);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			  p = new AlunoMatriculado(rs.getInt(1), rs.getInt(2) );
		
		}
		
		return p;
	}

	@Override
	public boolean deletar(int _matricula, int _idCurso) throws SQLException {
		
		String comando = "delete from aluno where matricula = ? AND idcurso = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
		ps.setInt(2, _idCurso);
	
		
		return ps.execute();
	}

	@Override
	public boolean atualizar(AlunoMatriculado _aluno) throws SQLException {
		
		String comando = "update aluno set idCurso = ? where matricula = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setString(1, _aluno.getIdCurso());
		ps.setString(2, _aluno.getMatricula());
		


		return ps.execute();
	}
}
