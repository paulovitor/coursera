import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConvertServlet")
public class ConvertServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int conversao = Integer.valueOf(request.getParameter("conversao"));
		int valor = Integer.valueOf(request.getParameter("valor"));

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h3>Resultado: "
				+ (conversao == 0 ? converteCelsiusParaFahrenheit(valor) : converteFahrenheitParaCelsius(valor))
				+ "</h3>");
		writer.println("</body></html>");
	}

	private int converteCelsiusParaFahrenheit(int valor) {
		return ((valor * 9) / 5) + 32;
	}

	private int converteFahrenheitParaCelsius(int valor) {
		return ((valor - 32) * 5) / 9;
	}
}
