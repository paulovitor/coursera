<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conversão de Celsius para Fahrenheit</title>
</head>
<body>
	<h1>Aplicação Web que converte Celsius para Fahrenheit</h1>
	<form action="ConvertServlet" method="post">
		<select name="conversao">
			<option value="0">Celsius para Fahrenheit</option>
			<option value="1">Fahrenheit para Celsius</option>
		</select> <input type="text" name="valor" /> <input type="submit"
			value="Submeter" />
	</form>
</body>
</html>