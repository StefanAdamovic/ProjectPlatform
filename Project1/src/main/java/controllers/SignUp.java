package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import databases.UserDataBase;
import model.JobTypes;
import validators.Validator;


@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SignUp() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//doGet(request, response);
		String action = request.getParameter("action");
		String name = request.getParameter("registerName");
		String username = request.getParameter("registerUsername");
		JobTypes position = JobTypes.valueOf(request.getParameter("jobType"));
		String email = request.getParameter("registerEmail");
		String password = request.getParameter("registerPassword");
		String repeatPassword = request.getParameter("registerPasswordRepeat");
		String signUpErrorMsg = "";

		if (action != null) {
			
			if (Validator.checkName(name) && Validator.checkUserName(username) && Validator.checkEmail(email) && 
				Validator.checkPassword(password) && Validator.checkPasswordRepeat(repeatPassword)) {
				
				if (password.equals(repeatPassword)) {
					DAO newUser = new DAO();
					if (!newUser.alreadyRegistered(username, password)) {
						
						newUser.registerNewUser(name, username, email, password, position);
						request.setAttribute("signUpSuccess", "Successfully registered! Now you can LOG IN using same credentials!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
						
					}else {
						signUpErrorMsg += "* You have already registered with this username and password!";
						request.setAttribute("signUpErrorMsg", signUpErrorMsg);
						request.getRequestDispatcher("signUp.jsp").forward(request, response);
					}
			
				} else {
					signUpErrorMsg += "* Password and PasswordRetype doesnt match!";
					request.setAttribute("signUpErrorMsg", signUpErrorMsg);
					request.getRequestDispatcher("signUp.jsp").forward(request, response);
				}
			} else {
				signUpErrorMsg += "* Must input all fields!";
				request.setAttribute("signUpErrorMsg", signUpErrorMsg);
				request.getRequestDispatcher("signUp.jsp").forward(request, response);
			}
		} else {
			signUpErrorMsg += "* Action ERROR!";
			request.setAttribute("signUpErrorMsg", signUpErrorMsg);
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}

	}

}
