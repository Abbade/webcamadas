package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.AlunoMatriculado;
import modelo.Curso;
import modelo.Disciplina;


public class CursoDAO implements InterfaceCursoDAO {
	
	private Connection conexao;
	
	public CursoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void cadastrarCurso(Curso _curso) throws SQLException {
		
		String comando = "INSERT INTO Curso values(?); ";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		
		ps.setString(1, _curso.getNome());
	

		ps.execute();
		
	}

	@Override
	public List<Curso> listarTodos() throws SQLException {
			
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		String comando = "select * from Curso";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int idCurso = rs.getInt(1);
			String nome = rs.getString(2);

			listaCursos.add(new Curso(idCurso,nome) );
			
		}
		
		return listaCursos;
	}

	@Override
	public Curso consultarCurso(int _idCurso) throws SQLException {

		Curso p = null;
		
		String comando = "select * from Curso where idCurso = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idCurso);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
	
			p = new Curso();
			
			p.setidCurso(rs.getInt(1));
			p.setNome(rs.getString(2));

	
		}
		
		return p;
	}

	@Override
	public boolean deletar(int _idCurso) throws SQLException {

		String comando = "delete from Curso where idCurso = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idCurso);
	
		
		return ps.execute();
	}

	@Override
	public boolean atualizar(Curso _curso) throws SQLException {
		
		String comando = "update curso set nome = ? where idCurso = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(2, _curso.getIdCurso());
		ps.setString(1, _curso.getNome());
	

		


		return ps.execute();
	}

	@Override
	public List<Disciplina> listarDisciplinas(int _idCurso) throws SQLException {
		
		DisciplinaDAO disciplina = new DisciplinaDAO(this.conexao);
		
		return disciplina.listarTodos(_idCurso);
	}

	@Override
	public List<AlunoMatriculado> listarAlunos(int _idCurso) throws SQLException {
		
		AlunoMatriculadoDAO aluno = new AlunoMatriculadoDAO(this.conexao);
		
		return aluno.listarTodos(_idCurso);
	}
		
		
}
