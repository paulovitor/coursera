package com.paulovitor.controller;

import com.paulovitor.domain.Gamificacao;
import com.paulovitor.domain.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RankingUsuarioController implements Controller {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Usuario> usuarios = Gamificacao.get().ranking();

        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp").forward(request, response);
    }
}
