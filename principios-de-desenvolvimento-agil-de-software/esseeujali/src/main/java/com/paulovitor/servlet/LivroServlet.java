package com.paulovitor.servlet;

import com.paulovitor.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/livro")
public class LivroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String nomeDaClasse = "com.paulovitor.controller." + Character.toUpperCase(acao.charAt(0)) + acao.substring(1) + "LivroController";

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Controller instance = (Controller) classe.newInstance();

            instance.executar(request, response);

        } catch (Exception exception) {
            request.setAttribute("erro", exception.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
