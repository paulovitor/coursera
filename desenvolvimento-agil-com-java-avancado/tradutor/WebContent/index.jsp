<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aplicação Web com Tradutor</title>
</head>
<body>
	<h1>Aplicação Web com Tradutor</h1>
	<form action="TradutorServlet" method="post">
		<input type="text" name="palavra" />
		<input type="submit" value="Traduzir" />
	</form>
</body>
</html>