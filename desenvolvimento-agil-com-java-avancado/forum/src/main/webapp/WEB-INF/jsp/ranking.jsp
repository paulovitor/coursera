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

    <title>Aplicação web com acesso ao banco de dados</title>
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h1>Ranking</h1>
        </div>

        <p align="right"><a href="topico?acao=lista">Voltar para os tópicos</a></p>

        <div class="row text-center">
            <div class="box">
                <div class="col-lg-12 text-left">

                    <div>
                        <table class="table table-condensed">
                            <thead>
                            <tr>
                                <th>Colocação</th>
                                <th>Nome</th>
                                <th>Login</th>
                                <th>Quantidades de pontos</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${usuarios}" var="usuario" varStatus="contador">
                                <tr>
                                    <td>${contador.count}</td>
                                    <td>${usuario.nome}</td>
                                    <td>${usuario.login}</td>
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
