package controle;

import java.io.IOException;
import java.io.PrintWriter;
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
import dao.PessoaDAO;
import modelo.Pessoa;

/**
 * Servlet implementation class ListarPessoasServlet
 */
@WebServlet("/ListarPessoasServlet")
public class ListarPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListarPessoasServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PrintWriter out = response.getWriter();
//
//        // escreve o texto
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<h1>Minha primeira página com Servlet</h1>");
//        out.println("</body>");
//        out.println("</html>");
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
		
			PessoaDAO daoP = new PessoaDAO(conexao);
			List<Pessoa> listaPessoas = daoP.listarTodos();
			
			request.setAttribute("listaPessoas", listaPessoas);
			
			fabrica.fecharConexao();
			
			RequestDispatcher despachante = request.getRequestDispatcher("/listarPessoas.jsp");
			despachante.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
