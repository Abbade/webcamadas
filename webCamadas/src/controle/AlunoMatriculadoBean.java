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
import dao.AlunoMatriculadoDAO;
import modelo.AlunoMatriculado;

@ManagedBean
@ViewScoped
public class AlunoMatriculadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AlunoMatriculado> listaAlunoMatriculados;
	private AlunoMatriculado alunoMatriculado;
	private ListDataModel<alunoMatriculado> alunoMatriculados;
	
 	public AlunoMatriculadoBean() {
		listaAlunoMatriculados = new ArrayList<>();
	}
 	
	public AlunoMatriculado getAlunoMatriculado() {
		return alunoMatriculado;
	}

	public void setAlunoMatriculado(AlunoMatriculado alunoMatriculado) {
		this.alunoMatriculado = alunoMatriculado;
	}

	public List<AlunoMatriculado> getListaAlunoMatriculados() {
		return listaAlunoMatriculados;
	}

	public void setListaAlunoMatriculados(List<AlunoMatriculado> listaAlunoMatriculados) {
		this.listaAlunoMatriculados = listaAlunoMatriculados;
	}
	
	public ListDataModel<AlunoMatriculado> getAlunoMatriculados() {
		return alunoMatriculado;
	}

	public void setAlunoMatriculados(ListDataModel<AlunoMatriculado> alunoMatriculados) {
		this.alunoMatriculados = alunoMatriculados;
	}

	public void prepararNovo() {
		try {
			
			this.alunoMatriculado = new AlunoMatriculado();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarAlunoMatriculado() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			this.alunoMatriculado.setDtCadastro(new Date());//Gera DATA Automaticamente e depois será Convertida
			
			AlunoMatriculadoDAO dao = new AlunoMatriculadoDAO(conexao);
			dao.inserir(this.AlunoMatriculado);
			
			this.listaAlunoMatriculados = dao.listarTodos();
			
			this.alunoMatriculados = new ListDataModel<AlunoMatriculado>(this.listaAlunoMatriculados);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			
			this.alunoMatriculado = this.alunoMatriculados.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarAlunoMatriculado() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlunoMatriculadoDAO dao = new AlunoMatriculadoDAO(conexao);
			dao.atualizar(this.alunoMatriculado);
			
			this.listaAlunoMatriculados = dao.listarTodos();
			
			this.alunoMatriculados = new ListDataModel<AlunoMatriculado>(this.listaAlunoMatriculados);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir() {
		try {
			
			this.AlunoMatriculado = this.AlunoMatriculados.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAlunoMatriculado() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlunoMatriculadoDAO dao = new AlunoMatriculadoDAO(conexao);
			dao.deletar(this.AlunoMatriculado);
			
			this.listaAlunoMatriculados = dao.listarTodos();
			
			this.alunoMatriculados = new ListDataModel<AlunoMatriculado>(this.listaAlunoMatriculados);
			
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
			
			AlunoMatriculadoDAO dao = new AlunoMatriculadoDAO(conn);
			this.listaAlunoMatriculados = dao.listarTodos();
			
			this.alunoMatriculados = new ListDataModel<AlunoMatriculado>(this.listaAlunoMatriculados);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
