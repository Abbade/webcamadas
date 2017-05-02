package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Album;
import modelo.Disciplina;

public class DisciplinaDAO implements InterfaceDisciplinaDAO {

	private Connection conexao;
	
	public DisciplinaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void cadastrarDisciplina(Disciplina _disciplina) throws SQLException {
		
		String comando = "INSERT INTO disciplina values(?); ";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		
		ps.setString(1, _disciplina.getNome());
	

		ps.execute();	
	}

	@Override
	public List<Disciplina> listarTodos(int _idCurso) throws SQLException {
	
		List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		
		String comando = "select * from Disciplina where idCurso = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idCurso);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int idDisciplina = rs.getInt(1);
			String nome = rs.getString(2);

			listaDisciplinas.add(new Disciplina(idDisciplina,nome) );
			
		}
		
		return listaDisciplinas;
	}

	@Override
	public Disciplina consultarDisciplina(int _idDisciplina) throws SQLException {
		
		Disciplina p = null;
		
		String comando = "select * from Disciplina where idDisciplina = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idDisciplina);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
	
			p = new Disciplina();
			
			p.setIdDisciplina(rs.getInt(1));
			p.setNome(rs.getString(2));

	
		}
		
		return p;
	}

	@Override
	public boolean deletar(int _idDisciplina) throws SQLException {
		
		
		String comando = "delete from disciplina where idDisciplina = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idDisciplina);
	
		
		return ps.execute();
	}

	@Override
	public boolean atualizar(Disciplina _disciplina) throws SQLException {
		
		String comando = "update Disciplina set nome = ? where idDisciplina = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(2, _disciplina.getIdDisciplina());
		ps.setString(1, _disciplina.getNome());
	

		return ps.execute();
	}

	@Override
	public List<Album> listarAlbuns(int _idCurso, int _idDisciplina) throws SQLException {
		
		AlbumDAO album = new AlbumDAO(this.conexao);
		
		return album.listarTodos(_idCurso, _idDisciplina);
	}
	

}
