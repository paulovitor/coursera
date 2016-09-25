<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<link href="assets/login.css" rel="stylesheet">
	<title>Aplicação web com acesso ao banco de dados</title>
</head>
<body>
	<div class="container">
		<form class="form-login" method="post" action="login">
			<c:if test="${mensagem != null}">
				<div class="alert alert-success" role="alert">${mensagem}</div>
			</c:if>
			<c:if test="${erro != null}">
				<div class="alert alert-danger" role="alert">${erro}</div>
			</c:if>
			<div class="form-group">
			    <label for="login">Login</label>
			    <input type="text" class="form-control" id="login" name="login">
		 	</div>
		 	<div class="form-group">
		    	<label for="senha">Senha</label>
			    <input type="password" class="form-control" id="senha" name="senha">
		  	</div>
			<button type="submit" class="btn btn-default">Login</button>
			<p align="right"><a href="usuario">Ir para tela de cadastro</a></p>
		</form>
	</div>
</body>
</html>