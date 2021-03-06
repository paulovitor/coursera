package com.paulovitor.controller;

import com.paulovitor.domain.Biblioteca;
import com.paulovitor.domain.Livro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisualizaLivroController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Livro livro = Biblioteca.get().recuperarLivro(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("livro", livro);

        String login = (String) request.getSession().getAttribute("login");
        boolean jaLeuLivro = Biblioteca.get().usuarioJaLeuLivro(login, livro.getId());

        request.setAttribute("jaLeuLivro", jaLeuLivro);

        request.getRequestDispatcher("/WEB-INF/jsp/visualiza-livro.jsp").forward(request, response);
    }
}
