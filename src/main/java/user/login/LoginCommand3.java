package user.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.SecurityUtil;
import user.UserDAO;
import user.UserInterface;
import user.UserVO;

public class LoginCommand3 implements UserInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id") == null ? "" : request.getParameter("id");
		String password = request.getParameter("password") == null ? "" : request.getParameter("password");

		System.out.println("로그인 시도한 아이디 : " + id);

		if (id.isEmpty() || password.isEmpty()) {
			setMessage(request, response, "모든 정보를 입력해주세요.", "login.l");
			return;
		}

		// DB 확인
		UserDAO userDAO = new UserDAO();
		UserVO userVO = userDAO.validateUser(id);

		System.out.println("userVO : " + userVO);

		if (userVO == null) {
			// setMessage(request, response, "아이디를 확인해주세요.", "login.l");
			request.setAttribute("message", "아이디를 확인해주세요");
			request.setAttribute("url", "login.l");
			return;
		}

		// 비밀번호 암호화
		String storedPassword = userVO.getPassword();
		String salt = storedPassword.substring(0, 8);
		SecurityUtil security = new SecurityUtil();
		String hashedPassword = security.encryptSHA256(salt + password);

		System.out.println("Stored password(DB에 저장된 비밀번호): " + storedPassword);
		System.out.println("salt : " + salt);
		System.out.println("Computed hash(로그인 시도한 비밀번호): " + salt + hashedPassword);

		if (!storedPassword.equals(salt + hashedPassword)) {
			// setMessage(request, response, "비밀번호를 확인해주세요.", "login.l");
			request.setAttribute("message", "비밀번호를 확인해주세요");
			request.setAttribute("url", "login.l");
			System.out.println(salt + hashedPassword);
		} 
		
		else {
			// 아이디 저장을 위한 쿠키 처리
			boolean rememberId = request.getParameter("rememberId") != null;
			Cookie cookieId = new Cookie("cookieId", id);
			cookieId.setPath("/");
			cookieId.setMaxAge(rememberId ? 60 * 60 * 24 * 7 : 0);
			response.addCookie(cookieId);

			// 세션 처리
			HttpSession session = request.getSession();
			session.setAttribute("sessionUserIdx", userVO.getUserIdx());
			session.setAttribute("sessionNickname", userVO.getNickname());
			session.setAttribute("sessionRole", userVO.getRole());

			// request.setAttribute("url", request.getContextPath() + "/welcome.l");
			request.setAttribute("url", "welcome.l");
		}
	}

	private void setMessage(HttpServletRequest request, HttpServletResponse response, String message, String url) throws ServletException, IOException {
		System.out.println("message : " + message);
		System.out.println("url : " + url);
		request.setAttribute("message", message);
		request.setAttribute("url", url);
	}
}
