package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import databases.UserDataBase;
import validators.Validator;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO user = new DAO();
		
		String action = request.getParameter("action");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMsg = "";

		if (action == null) {
			errorMsg += "Action Error!";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		if (!Validator.checkUserName(username) && !Validator.checkPassword(password)) {
			errorMsg += "* Must login with both username and password!";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		if (!user.alreadyRegistered(username, password)) {
			errorMsg += "* No user with entered username and password!";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		request.setAttribute("successMsg", "Log in success!");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
