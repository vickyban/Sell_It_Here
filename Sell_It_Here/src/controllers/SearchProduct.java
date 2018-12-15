package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import models.ProductBean;
import models.UserBean;
import util.SortBy;

/**
 * Servlet implementation class SearchProduct
 */
//@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city = request.getParameter("city");
		String category = request.getParameter("category");
		ArrayList<ProductBean> products = null;
		
		if( city == null ) {
			city = "toronto";
			products = ProductDAO.getFilteredProducts(city, category);
		}else {
			String search = request.getParameter("search").trim();
			double minPrice = Double.parseDouble(request.getParameter("minPrice"));
			double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
			SortBy sort = SortBy.valueOf(request.getParameter("sort"));
			products = ProductDAO.getFilteredProducts(city, category, search, minPrice, maxPrice, sort);
		}
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
