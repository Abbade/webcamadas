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
import dao.DisciplinaDAO;
import modelo.Disciplina;

@ManagedBean
@ViewScoped
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Disciplina> listaDisciplinas;
	private Disciplina disciplina;
	private ListDataModel<disciplina> disciplinas;
	
 	public DisciplinaBean() {
		listaDisciplinas = new ArrayList<>();
	}
 	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
	
	public ListDataModel<Disciplina> getDisciplinas() {
		return disciplina;
	}

	public void setDisciplinas(ListDataModel<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void prepararNovo() {
		try {
			
			this.disciplina = new Disciplina();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarDisciplina() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			this.disciplina.setDtCadastro(new Date());//Gera DATA Automaticamente e depois será Convertida
			
			DisciplinaDAO dao = new DisciplinaDAO(conexao);
			dao.inserir(this.Disciplina);
			
			this.listaDisciplinas = dao.listarTodos();
			
			this.disciplinas = new ListDataModel<Disciplina>(this.listaDisciplinas);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			
			this.disciplina = this.disciplinas.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarDisciplina() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			DisciplinaDAO dao = new DisciplinaDAO(conexao);
			dao.atualizar(this.disciplina);
			
			this.listaDisciplinas = dao.listarTodos();
			
			this.disciplinas = new ListDataModel<Disciplina>(this.listaDisciplinas);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir() {
		try {
			
			this.Disciplina = this.Disciplinas.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirDisciplina() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			DisciplinaDAO dao = new DisciplinaDAO(conexao);
			dao.deletar(this.Disciplina);
			
			this.listaDisciplinas = dao.listarTodos();
			
			this.disciplinas = new ListDataModel<Disciplina>(this.listaDisciplinas);
			
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
			
			DisciplinaDAO dao = new DisciplinaDAO(conn);
			this.listaDisciplinas = dao.listarTodos();
			
			this.disciplinas = new ListDataModel<Disciplina>(this.listaDisciplinas);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
