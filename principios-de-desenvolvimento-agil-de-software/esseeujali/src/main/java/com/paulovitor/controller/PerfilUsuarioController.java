package com.paulovitor.controller;

import com.paulovitor.domain.Gamificacao;
import com.paulovitor.domain.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PerfilUsuarioController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = (String) request.getSession().getAttribute("login");

        Usuario usuario = Gamificacao.get().recuperarPerfil(login);
        request.setAttribute("usuario", usuario);

        request.getRequestDispatcher("/WEB-INF/jsp/perfil.jsp").forward(request, response);
    }
}
