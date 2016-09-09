package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tradutor;

@WebServlet("/TradutorServlet")
public class TradutorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tradutor tradutor = new Tradutor(request.getParameter("palavra"));
		request.setAttribute("traducao", tradutor.traduz());
		request.getRequestDispatcher("traducao.jsp").forward(request, response);
	}
}
