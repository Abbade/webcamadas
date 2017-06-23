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
import dao.FotoDAO;
import modelo.Foto;

@ManagedBean
@ViewScoped
public class FotoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Foto> listaFotos;
	private Foto foto;
	private ListDataModel<Foto> fotos;
	
 	public FotoBean() {
		listaFotos = new ArrayList<>();
	}
 	
	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}
	
	public ListDataModel<Foto> getFotos() {
		return foto;
	}

	public void setfotos(ListDataModel<Foto> fotos) {
		this.fotos = fotos;
	}

	public void prepararNovo() {
		try {
			
			this.foto = new Foto();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarFoto() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			this.foto.setDtCadastro(new Date());//Gera DATA Automaticamente e depois será Convertida
			
			FotoDAO dao = new FotoDAO(conexao);
			dao.inserir(this.Foto);
			
			this.listaFotos = dao.listarTodos();
			
			this.fotos = new ListDataModel<Foto>(this.listaFotos);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			
			this.foto = this.fotos.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarFoto() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FotoDAO dao = new FotoDAO(conexao);
			dao.atualizar(this.foto);
			
			this.listaFotos = dao.listarTodos();
			
			this.fotos = new ListDataModel<Foto>(this.listaFotos);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir() {
		try {
			
			this.Foto = this.Fotos.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirFoto() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FotoDAO dao = new FotoDAO(conexao);
			dao.deletar(this.Foto);
			
			this.listaFotos = dao.listarTodos();
			
			this.fotos = new ListDataModel<Foto>(this.listaFotos);
			
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
			
			FotoDAO dao = new FotoDAO(conn);
			this.listaFotos = dao.listarTodos();
			
			this.fotos = new ListDataModel<Foto>(this.listaFotos);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
