package com.paulovitor.controller;

import com.paulovitor.domain.Biblioteca;
import com.paulovitor.domain.Gamificacao;
import com.paulovitor.domain.Livro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesmarcaLivroController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Livro livro = Biblioteca.get().recuperarLivro(Integer.parseInt(request.getParameter("id")));

        String login = (String) request.getSession().getAttribute("login");

        Gamificacao.get().desmarcarLivroComoLidoPorUsuario(livro, login);

        response.sendRedirect("livro?acao=visualiza&id=" + livro.getId());
    }
}
