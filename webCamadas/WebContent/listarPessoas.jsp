<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelo.Pessoa" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Pessoas</title>
</head>
<body>
	<h1>Listagem de Pessoas (APP JSP)</h1>
	<div align="center">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Dt. de Cadastro</th>
			</tr>
			<% 
				List<Pessoa> pessoas = (List<Pessoa>)request.getAttribute("listaPessoas");
				for( Iterator i = pessoas.iterator(); i.hasNext(); ) {
					Pessoa p = (Pessoa)i.next();
			%>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNome() %></td>
				<td><%= p.getTel() %></td>
				<td><%= p.getDtCadastro() %></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>