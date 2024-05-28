package record.guestBook;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import place.PlaceDAO;
import place.PlaceVO;

public class SearchPlaceCommand implements GuestBookInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String placeName = request.getParameter("placeName");
		if (placeName == null || placeName.trim().isEmpty()) {
			throw new ServletException("placeName 파라미터가 유효하지 않음");
		}

		PlaceDAO placeDAO = new PlaceDAO();
		/* List<PlaceVO> places = placeDAO.searchPlacesByName(placeName); */
		List<PlaceVO> places = placeDAO.searchAllPlaces();

		request.setAttribute("places", places);
		request.setAttribute("placeSw", "0");
	}
}