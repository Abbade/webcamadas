package controle;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FabricaConexao;
import dao.AlunoDAO;
import modelo.Aluno;



@WebServlet("/ListarAlunosServlet")
public class ListarAlunosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListarAlunosServlet() {
    	
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
		
			AlunoDAO daoP = new AlunoDAO(conexao);
			List<Aluno> listaAlunos = daoP.listarTodos();
			
			request.setAttribute("listaAlunos", listaAlunos);
			
			fabrica.fecharConexao();
			
			RequestDispatcher despachante = request.getRequestDispatcher("/listarAlunos.jsp");
			despachante.forward(request, response);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

	
}
