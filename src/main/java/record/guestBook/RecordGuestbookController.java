package record.guestBook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import record.SearchPlaceCommand;

@SuppressWarnings("serial")
@WebServlet("*.g")
public class RecordGuestbookController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookInterface command = null;
		String viewPage = "/WEB-INF/record/guestBook/";

		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/") + 1, com.lastIndexOf("."));

		if (com.equals("record-guestBook")) {
			command = new RecordGuestBookCommand();
			command.execute(request, response);
			return;
		} else if (com.equals("addANewPlace")) {
			command = new AddANewPlaceCommand();
			command.execute(request, response);
			return;
		} else if (com.equals("searchPlace")) {
			command = new SearchPlaceCommand();
			command.execute(request, response);
			return;
		} 
//		else if (com.equals("getPlaceDetails")) {
//			command = new GetPlaceDetailsCommand();
//			command.execute(request, response);
//			return;
//		} 
		else if (com.equals("submitGuestBook")) {
//			command = new SubmitGuestBookCommand();
//			command.execute(request, response);
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
