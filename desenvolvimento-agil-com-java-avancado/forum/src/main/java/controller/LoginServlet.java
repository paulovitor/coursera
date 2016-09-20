package controller;

import model.Autenticador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private Autenticador autenticador = new Autenticador();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = autenticador.autentica(request.getParameter("login"), request.getParameter("senha"));
			request.setAttribute("nome", nome);
			request.getRequestDispatcher("/WEB-INF/jsp/topicos.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erro", "Erro na autenticação!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
