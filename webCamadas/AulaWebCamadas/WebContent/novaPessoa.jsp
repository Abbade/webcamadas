<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="right" style="width: 300px; padding-left: 50px; padding-top: 100px;">
	<p align="center">Form Cadastro Pessoa</p>
	<form action="InserirPessoaServlet" method="post">
		<fieldset>
<!-- 			<label>Id:</label> -->
<!-- 			<input type="text" name="id" /> -->
<!-- 			<br /> -->
			<label>Nome:</label>
			<input type="text" name="nome" />
			<br />
			<label>Tel:</label>
			<input type="text" name="tel" />
			<br />
			<input type="submit" value="Salvar" />
			<br />
			<label><%= request.getParameter("msg") %></label>
		</fieldset>
	</form>
	
	</div>
	<br />
	<br />
	<br />
	<br />
	<a href="index.jsp">Home Page</a>
</body>
</html>