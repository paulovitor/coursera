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

    <title>Esse eu já li!</title>
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h1>Livro</h1>
        </div>

        <p align="right"><a href="livro?acao=lista">Voltar para os livros</a></p>

        <div class="form-group">
            <label for="titulo">Título</label>
            <label class="form-control" id="titulo" name="titulo">${livro.titulo}</label>
        </div>
        <div class="form-group">
            <label for="autor">Autor</label>
            <label class="form-control" id="autor" name="autor">${livro.autor}</label>
        </div>
        <div class="form-group">
            <label for="estilo">Estilo</label>
            <label class="form-control" id="estilo" name="estilo">${livro.estilo}</label>
        </div>
        <div class="form-group">
            <label for="paginas">Páginas</label>
            <label class="form-control" id="paginas" name="paginas">${livro.paginas}</label>
        </div>
        <div class="form-group">
            <c:if test="${jaLeuLivro}">
                <a href="livro?acao=desmarca&id=${livro.id}">Desmarcar</a>
            </c:if>
            <c:if test="${!jaLeuLivro}">
                <a href="livro?acao=marca&id=${livro.id}">Marcar como lido</a>
            </c:if>
        </div>
    </div>
</body>
</html>
