package user.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserInterface;

@SuppressWarnings("serial")
@WebServlet("*.l")
public class LoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInterface command = null;
		String viewPage = "/WEB-INF/user/login/";

		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/") + 1, com.lastIndexOf("."));

		if (com.equals("login")) {
			viewPage += "login.jsp";
		} else if (com.equals("tryToLogin")) {
			command = new LoginCommand();
			command.execute(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
