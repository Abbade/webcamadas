package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Album;
import modelo.Foto;

public class AlbumDAO implements InterfaceAlbumDAO {

	private Connection conexao;
	
	public AlbumDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void cadastrarAlbum(Album _album) throws SQLException {

		String comando = "INSERT INTO album VALUES (?, ?, ?, ?, ?, ?); ";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		
		ps.setInt(1, _album.getIdAlbum());
		ps.setInt(2, _album.getMatricula());
		ps.setInt(3, _album.getIdDisciplina());
		ps.setInt(4, _album.getIdCurso());
		ps.setString(5, _album.getDescricao());
		ps.setDate(6, (Date) _album.getDataCriacao());
	

		ps.execute();	
		
	}



	@Override
	public Album consultarAlbum(int _idAlbum) throws SQLException {
		
		Album p = null;
		
		String comando = "select * from Album where idAlbum = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idAlbum);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
	
			p = new Album(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6));
			

	
		}
		
		return p;
	}

	@Override
	public boolean deletar(int _matricula) throws SQLException {

		String comando = "delete from album where idAlbum = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
	
		
		return ps.execute();
	}

	@Override
	public boolean atualizar(Album _album) throws SQLException {

		String comando = "update Album set descricao = ? where idAlbum = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setString(1, _album.getDescricao());
		ps.setInt(2, _album.getIdAlbum());
		
	

		return ps.execute();
	}

	@Override
	public List<Album> listarTodos(int _matricula, int _idCurso) throws SQLException {
		
		List<Album> listaAlbuns = new ArrayList<Album>();
		
		String comando = "select * from Album where matricula = ? AND idcurso = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _matricula);
		ps.setInt(2, _idCurso);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int idAlbum = rs.getInt(1);
			int matricula = rs.getInt(2);
			int idDisciplina = rs.getInt(3);
			int idCurso = rs.getInt(4);
			String descricao = rs.getString(5);
			Date dataCriacao = rs.getDate(6);

			listaAlbuns.add(new Album(idAlbum,matricula,idDisciplina,idCurso,descricao,dataCriacao) );
			
		}
		
		return listaAlbuns;
	}

	@Override
	public List<Album> listarTodos(int _idDisciplina) throws SQLException {
		
		List<Album> listaAlbuns = new ArrayList<Album>();
		
		String comando = "select * from Album where idDisciplina = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
			
	
		ps.setInt(1, _idDisciplina);
		
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int idAlbum = rs.getInt(1);
			int matricula = rs.getInt(2);
			int idDisciplina = rs.getInt(3);
			int idCurso = rs.getInt(4);
			String descricao = rs.getString(5);
			Date dataCriacao = rs.getDate(6);

			listaAlbuns.add(new Album(idAlbum,matricula,idDisciplina,idCurso,descricao,dataCriacao) );
			
		}
		
		return listaAlbuns;
	}

	@Override
	public List<Foto> listarFotos(int _idAlbum) throws SQLException {

		FotoDAO foto = new FotoDAO(this.conexao);
		
		return foto.listarTodas(_idAlbum);
	}

}
