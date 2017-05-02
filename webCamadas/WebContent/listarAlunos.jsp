<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelo.Aluno, dao.AlunoDAO" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de alunos</title>
</head>
<body>
	<h1>Listagem de alunos (APP JSP)</h1>
	<div align="center">
		<table border="1">
			<tr>
				<th>Matricula</th>
				<th>Nome</th>
				<th>Senha</th>
			</tr>
			<% 
				List<Aluno> alunos = (List<Aluno>)request.getAttribute("listaAlunos");
				for( Iterator i = alunos.iterator(); i.hasNext(); ) {
					Aluno p = (Aluno)i.next();
			%>
			<tr>
				<td><%= p.getMatricula() %></td>
				<td><%= p.getNome() %></td>
				<td><%= p.getSenha() %></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>