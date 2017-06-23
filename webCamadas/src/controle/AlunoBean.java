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
import dao.AlunoDAO;
import modelo.Aluno;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Aluno> listaAlunos;
	private Aluno aluno;
	private ListDataModel<Aluno> alunos;
	
 	public AlunoBean() {
		listaAlunos = new ArrayList<>();
	}
 	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	public ListDataModel<Aluno> getAlunos() {
		return aluno;
	}

	public void setAlunos(ListDataModel<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void prepararNovo() {
		try {
			
			this.aluno = new Aluno();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarAluno() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			this.aluno.setDtCadastro(new Date());//Gera DATA Automaticamente e depois será Convertida
			
			AlunoDAO dao = new AlunoDAO(conexao);
			dao.inserir(this.Aluno);
			
			this.listaAlunos = dao.listarTodos();
			
			this.alunos = new ListDataModel<Aluno>(this.listaAlunos);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			
			this.aluno = this.alunos.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarAluno() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlunoDAO dao = new AlunoDAO(conexao);
			dao.atualizar(this.aluno);
			
			this.listaAlunos = dao.listarTodos();
			
			this.alunos = new ListDataModel<Aluno>(this.listaAlunos);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir() {
		try {
			
			this.Aluno = this.Alunos.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAluno() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlunoDAO dao = new AlunoDAO(conexao);
			dao.deletar(this.Aluno);
			
			this.listaAlunos = dao.listarTodos();
			
			this.alunos = new ListDataModel<Aluno>(this.listaAlunos);
			
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
			
			AlunoDAO dao = new AlunoDAO(conn);
			this.listaAlunos = dao.listarTodos();
			
			this.alunos = new ListDataModel<Aluno>(this.listaAlunos);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
