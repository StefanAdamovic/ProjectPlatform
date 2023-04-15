package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databases.UserDataBase;

@WebServlet("/loginV1")
public class LoginV1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginV1() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMsg = "";
		
		if (action != null) {
			/////////////////// LOGIN //////////////////////
			if (action.equals("login")) {
				if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
					if (UserDataBase.isRegistered(username, password)) {
						request.setAttribute("successMsg", "Log in success!");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} else {
						errorMsg += "* No user with entered username and password!";
						request.setAttribute("errorMsg", errorMsg);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				} else {
					errorMsg += "* Must login with both username and password!";
					request.setAttribute("errorMsg", errorMsg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				errorMsg += "Action Error!";
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/////////////////// SIGNUP ////////////////////
		String action = request.getParameter("action");

		String name = request.getParameter("registerName");
		String username = request.getParameter("registerUsername");
		String email = request.getParameter("registerEmail");
		String password = request.getParameter("registerPassword");
		String repeatPassword = request.getParameter("registerPasswordRepeat");

		String signUpErrorMsg = "";

		if (action != null) {
			if (action.equals("signUp")) {
				if (name != null && !name.isEmpty() && username != null && !username.isEmpty() && email != null
						&& !email.isEmpty() && password != null && !password.isEmpty() && repeatPassword != null
						&& !repeatPassword.isEmpty()) {
					if (password.equals(repeatPassword)) {
						UserDataBase.addUser(email, password, username);
						request.setAttribute("signUpSuccess", "Successfully registered!");
						request.getRequestDispatcher("login.jsp").forward(request, response);

					} else {
						signUpErrorMsg += "* Password and PasswordRetype doesnt match!";
						request.setAttribute("signUpErrorMsg", signUpErrorMsg);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}

				} else {
					signUpErrorMsg += "* Must input all fields!";
					request.setAttribute("signUpErrorMsg", signUpErrorMsg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		} else {
			signUpErrorMsg += "* Action ERROR!";
			request.setAttribute("signUpErrorMsg", signUpErrorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
