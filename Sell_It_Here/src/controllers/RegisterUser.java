package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.*;
import models.UserBean;
import dao.UserDAO;
/**
 * Servlet implementation class RegisterUser
 */
//@WebServlet("/Signup")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("user");
		String email = request.getParameter("email");
		
		ArrayList<String> messages = new ArrayList<>(); 
		
		if(UserDAO.isValidEmail(email)) {
			if(UserDAO.isValidUsername(username)) {
				UserBean createUser = new UserBean();
				
				createUser.setUsername(username);
				createUser.setEmail(email);
				
				
				String fname = request.getParameter("fname");
				createUser.setFname(fname);
				
				String lname = request.getParameter("lname");
				createUser.setLname(lname);
				
				
				String password = request.getParameter("password");
				createUser.hashPassword(password);
				
				
				String street = request.getParameter("street");
				createUser.setStreet(street);
				
				String city = request.getParameter("city");
				createUser.setCity(city);
				
				String province = request.getParameter("province");
				createUser.setProvince(province);
				
				String postal = request.getParameter("postal");
				createUser.setPostal(postal);
				
				String phone = request.getParameter("phone");
				createUser.setPhone(phone);
				
				Calendar calendar = Calendar.getInstance();
				Date now = calendar.getTime();
				java.sql.Timestamp dateCreated = new java.sql.Timestamp(now.getTime());
				createUser.setDateCreated(dateCreated);
				
				UserDAO.createUser(createUser);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", createUser);
				
				System.out.println("Complete!");
				response.sendRedirect("");
			} else {
				messages.add("Username already taken");
				System.out.println("Username already used");
			}
		} else {
			messages.add("Email already used");
			System.out.println("email already taken");
		}
		
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

}
