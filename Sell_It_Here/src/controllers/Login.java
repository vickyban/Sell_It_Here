package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in login servlet. uri is " + request.getAttribute("uri"));
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").toLowerCase().trim();
		String password =  request.getParameter("password").trim();
		String uri = request.getParameter("redirect_uri");
		
		User user = UserDao.getUserByEmail(email);
		if(user != null && user.authenticate(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(uri);
		}else {
			request.setAttribute("uri", uri);
			request.setAttribute("msg", "invalid email or password!!!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
