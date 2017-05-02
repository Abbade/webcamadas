package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Foto;

public class FotoDAO implements InterfaceFotoDAO {
	
	private Connection conexao;
	
	public FotoDAO(Connection _conexao) {
		
		this.conexao = _conexao;
	}

	@Override
	public void cadastrarFoto(Foto _foto) throws SQLException {
		
		String comando = "INSERT INTO foto VALUES (?, ?, ?, ?, ?, ?); ";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		
		ps.setInt(1, _foto.getIdFoto());
		ps.setInt(2, _foto.getMatricula());
		ps.setInt(3, _foto.getIdDisciplina());
		ps.setInt(4, _foto.getIdAlbum());
		ps.setInt(5, _foto.getIdCurso());
		ps.setBoolean(6, _foto.isPermissao());	

		ps.execute();	
		
	}

	@Override
	public List<Foto> listarTodas(int _idAlbum) throws SQLException {
		
		List<Foto> listaFotos = new ArrayList<Foto>();
		
		String comando = "select * from Foto where _idAlbum = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idAlbum);
	
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			int idFoto = rs.getInt(1);
			int matricula = rs.getInt(2);
			int idDisciplina = rs.getInt(3);
			int idAlbum = rs.getInt(4);
			int idCurso = rs.getInt(5);
			boolean permissao = rs.getBoolean(6);


			listaFotos.add(new Foto(idFoto,matricula,idDisciplina,idAlbum,idCurso,permissao) );
			
		}
		
		return listaFotos;
	}



	@Override
	public Foto consultarFoto(int _idFoto) throws SQLException {
		
		Foto p = null;
		
		String comando = "select * from Foto where idFoto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idFoto);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
	
			p = new Foto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getBoolean(6));
			

	
		}
		
		return p;
	}

	@Override
	public boolean deletar(int _idFoto) throws SQLException {
		
		String comando = "delete from foto where idFoto = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setInt(1, _idFoto);
	
		
		return ps.execute();
	}

	@Override
	public boolean atualizar(Foto _foto) throws SQLException {
		
		String comando = "update Album set permissao = ? where idFoto = ?";

		PreparedStatement ps = this.conexao.prepareStatement(comando);
		
		ps.setBoolean(1, _foto.isPermissao());
		ps.setInt(2, _foto.getIdFoto());
		
	

		return ps.execute();
	}

}
