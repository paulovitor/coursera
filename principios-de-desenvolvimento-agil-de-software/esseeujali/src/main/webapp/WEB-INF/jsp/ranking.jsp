<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<title>Esse eu já li!</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Ranking</h1>
			<p class="lead">Bem vindo ${login}</p>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="livro?acao=lista">Livros</a></li>
				<li><a href="usuario?acao=ranking">Ranking</a></li>
				<li><a href="usuario?acao=perfil">Perfil</a></li>
				<li><a href="logoff">Logoff</a></li>
			</ul>
		</div>

		<div class="row text-center">
			<div class="box">
				<div class="col-lg-12 text-left">

					<div>
						<table class="table table-condensed">
							<thead>
							<tr>
								<th></th>
								<th>Login</th>
								<th>Email</th>
								<th>Nome</th>
								<th>Pontos</th>
							</thead>
							<tbody>
							<c:forEach items="${usuarios}" var="usuario" varStatus="contador">
								<tr>
									<td>${contador.count}</td>
									<td>${usuario.login}</td>
									<td>${usuario.email}</td>
									<td>${usuario.nome}</td>
									<td>${usuario.pontos}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>