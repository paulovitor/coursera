package com.paulovitor.controller;

import com.paulovitor.domain.Biblioteca;
import com.paulovitor.domain.Livro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListaLivroController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = (String) request.getSession().getAttribute("login");
        request.setAttribute("login", login);

        List<Livro> livros = Biblioteca.get().recuperarLivros();
        request.setAttribute("livros", livros);

        request.getRequestDispatcher("/WEB-INF/jsp/livros.jsp").forward(request, response);
    }
}
