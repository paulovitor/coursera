<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <h1>Tópico</h1>
        </div>

        <div class="form-group">
            <label for="titulo">Título</label>
            <label class="form-control" id="titulo" name="titulo">${topico.titulo}</label>
        </div>
        <div class="form-group">
            <label for="login">Usuário</label>
            <label class="form-control" id="login" name="login">${topico.login}</label>
        </div>
        <div class="form-group">
            <label for="conteudo">Conteúdo</label>
            <label class="form-control" id="conteudo" name="conteudo">${topico.conteudo}</label>
        </div>
        <div class="form-group">
            <h4>Comentários</h4>
            <hr>
        </div>
    </div>
</body>
</html>
