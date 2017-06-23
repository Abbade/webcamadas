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
import dao.CursoDAO;
import modelo.Curso;

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Curso> listaCursos;
	private Curso curso;
	private ListDataModel<curso> cursos;
	
 	public CursoBean() {
		listaCursos = new ArrayList<>();
	}
 	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	public ListDataModel<Curso> getCursos() {
		return curso;
	}

	public void setCursos(ListDataModel<Curso> cursos) {
		this.cursos = cursos;
	}

	public void prepararNovo() {
		try {
			
			this.curso = new Curso();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarCurso() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			this.curso.setDtCadastro(new Date());//Gera DATA Automaticamente e depois será Convertida
			
			CursoDAO dao = new CursoDAO(conexao);
			dao.inserir(this.Curso);
			
			this.listaCursos = dao.listarTodos();
			
			this.cursos = new ListDataModel<curso>(this.listaCursos);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararEditar() {
		try {
			
			this.curso = this.cursos.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarCurso() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			CursoDAO dao = new CursoDAO(conexao);
			dao.atualizar(this.curso);
			
			this.listaCursos = dao.listarTodos();
			
			this.cursos = new ListDataModel<Curso>(this.listaCursos);
			
			fabrica.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararExcluir() {
		try {
			
			this.Curso = this.Cursos.getRowData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirCurso() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			CursoDAO dao = new CursoDAO(conexao);
			dao.deletar(this.Curso);
			
			this.listaCursos = dao.listarTodos();
			
			this.cursos = new ListDataModel<Curso>(this.listaCursos);
			
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
			
			CursoDAO dao = new CursoDAO(conn);
			this.listaCursos = dao.listarTodos();
			
			this.cursos = new ListDataModel<Curso>(this.listaCursos);
			
			fabrica.fecharConexao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
