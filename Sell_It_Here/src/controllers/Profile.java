package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO_OLD;
import models.UserBean;

/**
 * Servlet implementation class Profile
 */
//@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/userPages/profile.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String location = request.getParameter("location");
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		user.setUsername(username);
		user.setLocation(location);
		
		user = UserDAO_OLD.updateUser(user);
		System.out.println("Got inside profile servlet retrive user");
		if(user != null) {
			System.out.println("Got inside profile servlet ");
			request.getRequestDispatcher("/userPages/profile.jsp").forward(request, response);
		}
	}

}
