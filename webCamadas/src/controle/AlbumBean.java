package controle;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.AlbumDAO;
import modelo.Album;

@ManagedBean
@ViewScoped
public class AlbumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Album> listaAlbums;
	private Album album;
	private ListDataModel<album> albums;
	
 	public AlbumBean() {
		listaAlbums = new ArrayList<>();
	}
 	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Album> getListaAlbums() {
		return listaAlbums;
	}

	public void setListaAlbums(List<Album> listaAlbums) {
		this.listaAlbums = listaAlbums;
	}
	
	public ListDataModel<Album> getAlbums() {
		return album;
	}

	public void setAlbums(ListDataModel<Album> albums) {
		this.album = album;
	}

	public void prepararNovo() {
		try {
			
			this.album = new Album();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarAlbum() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			this.album.setDtCadastro(new Date());//Gera DATA Automaticamente e depois será Convertida
			
			AlbumDAO dao = new AlbumDAO(conexao);
			dao.inserir(this.Album);
			
			this.listaAlbums = dao.listarTodos();
			
			this.albums = new ListDataModel<Album>(this.listaAlbums);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			
			this.album = this.albums.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarAlbum() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlbumDAO dao = new AlbumDAO(conexao);
			dao.atualizar(this.album);
			
			this.listaAlbums = dao.listarTodos();
			
			this.albums = new ListDataModel<Album>(this.listaAlbums);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir() {
		try {
			
			this.Album = this.Albums.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAlbum() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlbumDAO dao = new AlbumDAO(conexao);
			dao.deletar(this.Album);
			
			this.listaAlbums = dao.listarTodos();
			
			this.albums = new ListDataModel<Album>(this.listaAlbums);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	private void inicializar() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conn = fabrica.fazerConexao();
			
			AlbumDAO dao = new AlbumDAO(conn);
			this.listaAlbums = dao.listarTodos();
			
			this.albums = new ListDataModel<Album>(this.listaAlbums);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
