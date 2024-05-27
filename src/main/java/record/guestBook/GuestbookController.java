package record.guestBook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import record.AddANewPlaceCommand;
import record.RecordInterface;

@SuppressWarnings("serial")
@WebServlet("*.g")
public class GuestbookController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecordInterface command = null;
		String viewPage = "/WEB-INF/record/";

		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/") + 1, com.lastIndexOf("."));

		if (com.equals("record-guestBook")) {
			command = new GuestBookCommand();
			command.execute(request, response);
			return;
		}
		else if (com.equals("addANewPlace")) {
			command = new AddANewPlaceCommand();
			command.execute(request, response);
			return;
		}
		else if (com.equals("submitGuestBook")) {
            command = new SubmitGuestBookCommand();
            command.execute(request, response);
            return;
        }
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}