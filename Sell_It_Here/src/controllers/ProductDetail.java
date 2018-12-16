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
 * Servlet implementation class ProductDetail
 */
// @WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("product uri " + requestURI);
		switch (requestURI) {
			case "/products/product/edit":
				editProduct(request, response);
				break;
			case "/products/product":
				showProduct(request,response);
				break;
			case "/products/product/new":
				newProduct(request,response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		UserBean seller = (UserBean) request.getSession(false).getAttribute("user");
		ProductBean product = new ProductBean();
		product.setName(request.getParameter("name"));
		product.setSellerId(seller.getId());
		product.setCategory(request.getParameter("category"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		
		switch(action) {
		case "new":
				product = ProductDAO.createProduct(product); break;
		case "edit":
				product.setProductId( Integer.parseInt(request.getParameter("id")));
				product = ProductDAO.updateProduct(product); break;
		}
		response.sendRedirect(request.getRequestURI() + "?id=" + product.getProductId());
	}

	
	private void editProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductBean product = ProductDAO.getProductById(id);
		req.setAttribute("product", product);
		req.setAttribute("action", "edit");
		req.setAttribute("submit", "Save Change");
		req.getRequestDispatcher("/productEdit.jsp").forward(req, res);
	}
	
	private void showProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductBean product = ProductDAO.getProductById(id);
		req.setAttribute("product", product);
		UserBean seller = UserDAO.getUserById(product.getSellerId());
		req.setAttribute("seller", seller);
		req.getRequestDispatcher("/productDetail.jsp").forward(req, res);
	}
	
	private void newProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/productEdit.jsp").forward(req, res);
	}
	
}
