package controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

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
 * Servlet implementation class InserirPessoaServlet
 */
@WebServlet("/InserirPessoaServlet")
public class InserirPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			System.out.println("executando.....");
			
			Pessoa pessoa = new Pessoa();
			//pessoa.setId(Integer.parseInt(request.getParameter("id")));
			pessoa.setNome(request.getParameter("nome"));
			pessoa.setTel(request.getParameter("tel"));
			pessoa.setDtCadastro(new Date());
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			dao.inserir(pessoa);
			
			fabrica.fecharConexao();
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/novaPessoa.jsp?msg=Cadastro feito com Sucesso!!!");
	        rd.forward(request, response);
			
			doGet(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/novaPessoa.jsp?msg=DEU ZEBRA!!!");
	        rd.forward(request, response);
		}
	}

}
