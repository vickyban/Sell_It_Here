package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.UserDAO;
import models.ProductBean;
import models.UserBean;

/**
 * Servlet implementation class TransactionController
 */
//@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("product uri " + requestURI);
		switch (requestURI) {
			case "/transaction/new":
				newTransaction(request, response);
				break;
			case "/transaction":
				showTransaction(request,response);
				break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		ProductBean product = ProductDAO.getProductById(productId);
		UserBean seller = UserDAO.getUserById(product.getSellerId());
		
		request.setAttribute("product", product);
		request.setAttribute("seller", seller);
		
		request.getRequestDispatcher("/transactionForm.jsp").forward(request, response);
	}
	
	private void showTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		//ArrayList<Transaction> transactions = TransactionDAO.getUserTransaction(user.id);
		//request.setAttribute("transactions", transactions);
		
		request.getRequestDispatcher("/transactionHistory.jsp").forward(request, response);
	}
	

}
