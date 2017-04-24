package controle;

import java.io.IOException;
import java.sql.Connection;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import dao.FabricaConexao;
import modelo.Aluno;




@WebServlet("/InserirAlunoServlet")

public class InserirAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InserirAlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			System.out.println("executando.....");
			
			Aluno aluno = new Aluno();
			
			aluno.setMatricula(Integer.parseInt(request.getParameter("matricula")));
			aluno.setNome(request.getParameter("nome"));
			aluno.setSenha(request.getParameter("senha"));
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlunoDAO dao = new AlunoDAO(conexao);
			dao.cadastrarAluno(aluno);
			
			fabrica.fecharConexao();
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/novoAluno.jsp?msg=Cadastro feito com Sucesso!!!");
	        rd.forward(request, response);
			
			doGet(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/novoAluno.jsp?msg=DEU ZEBRA!!!");
	        rd.forward(request, response);
		}

	}

}
