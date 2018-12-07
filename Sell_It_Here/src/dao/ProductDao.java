package dao;

import models.Product;
import models.User;
import util.SortBy;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProductDao {
	// Create new product 
	public static Product createProduct(Product product) {
		Connection conn = null;
		try {
			conn = DB.getConnection();
			String query = "INSERT INTO Products "
					+ "(seller_id, name, price, category, description, is_sold, created_at, updated_at) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, product.getSellerId());
			stmt.setString(2,product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setString(4, product.getCategory());
			stmt.setString(5, product.getDescription());
			stmt.setBoolean(6, product.isSold());
			java.util.Date now = new java.util.Date();
			stmt.setDate(7, new java.sql.Date(now.getTime()));
			stmt.setDate(8, new java.sql.Date(now.getTime()));
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				product = getProductById(product.getProductId());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(conn);
		}
		return product;
	}
	
	// Read record by productID
	public static Product getProductById(int id) {
		Connection con = null;
		Product product = null;
		try{
			con = DB.getConnection();
			String query = "Select * from Products where product_id=? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setSellerId(rs.getInt("seller_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setDescription(rs.getString("description"));
				product.setSold(rs.getBoolean("is_sold"));
				product.setCreated_at(rs.getDate("created_at"));
				product.setUpdated_at(rs.getDate("updated_at"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return product;
	}
	
	// Return list of Products from the SE
		public static ArrayList<Product> getFilteredProducts(String location, String category, String search, double pmin, double pmax, SortBy sort) {
			Connection con = null;
			ArrayList<Product> list = null;
			try{
				con = DB.getConnection();
				String query = "Select * from Products where "
						+ "category=? AND "
						+ "is_sold IS FALSE AND "
						+ "name LIKE ? AND "
						+ "seller_id IN (SELECT * FROM Users WHERE location = ?) "
						+ "price BETWEEN ? AND ? "
						+ "ORDER BY " + sort.getValue();
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, category);
				stmt.setString(2, location);
				stmt.setString(3,"%" + search + "%");
				stmt.setDouble(4, pmin);
				stmt.setDouble(5, pmax);
				
				ResultSet rs = stmt.executeQuery();
				list = new ArrayList<>();
				while(rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt("product_id"));
					product.setSellerId(rs.getInt("seller_id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setSold(rs.getBoolean("is_sold"));
					product.setCreated_at(rs.getDate("created_at"));
					product.setUpdated_at(rs.getDate("updated_at"));
					
					list.add(product);
				}			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DB.closeConnection(con);
			}
		
			return list;
		}
		
		// Return list of products that a user is SELLING 
		public static ArrayList<Product> getActiveProducts(int userId){
			Connection con = null;
			ArrayList<Product> list = null;
			try{
				con = DB.getConnection();
				String query = "Select * from Products where "
						+ "is_sold IS FALSE AND "
						+ "seller_id =? "
						+ "ORDER BY " + SortBy.NEW_OLD.getValue();
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, userId);
				
				ResultSet rs = stmt.executeQuery();
				list = new ArrayList<>();
				while(rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt("product_id"));
					product.setSellerId(rs.getInt("seller_id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setSold(rs.getBoolean("is_sold"));
					product.setCreated_at(rs.getDate("created_at"));
					product.setUpdated_at(rs.getDate("updated_at"));
					
					list.add(product);
				}			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DB.closeConnection(con);
			}
			return list;
		}
		
		public static ArrayList<Product> getRecentPosts(){
			Connection con = null;
			ArrayList<Product> list = null;
			try{
				con = DB.getConnection();
				String query = "Select * from Products where "
						+ "is_sold IS FALSE "
						+ "ORDER BY " + SortBy.NEW_OLD.getValue()
						+ " LIMIT 10";
				System.out.println("query " +query);
				PreparedStatement stmt = con.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				list = new ArrayList<>();
				while(rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt("product_id"));
					product.setSellerId(rs.getInt("seller_id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setSold(rs.getBoolean("is_sold"));
					product.setCreated_at(rs.getDate("created_at"));
					product.setUpdated_at(rs.getDate("updated_at"));
					
					list.add(product);
				}			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DB.closeConnection(con);
			}
			System.out.println("size " +list.size());
			return list;
		}
		
		// Update Product info for SELL
		public static Product updateProduct(Product product) {
			Connection conn = null;
			try {
				conn = DB.getConnection();
				String query = "UPDATE Products SET "
						+ "name=?, "
						+ "price=?, "
						+ "category=?, "
						+ "description=?, "
						+ "updated_at=? "
						+ "WHERE product_id=? AND is_sold IS FALSE";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1,product.getName());
				stmt.setDouble(2, product.getPrice());
				stmt.setString(3, product.getCategory());
				stmt.setString(4, product.getDescription());
				java.util.Date now = new java.util.Date();
				stmt.setDate(5, new java.sql.Date(now.getTime()));
				stmt.setInt(6, product.getProductId());
				
				int status = stmt.executeUpdate();
				if(status == 1) {
					product = getProductById(product.getProductId());
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DB.closeConnection(conn);
			}
			return product;
		}
		
		// update isSold status when the product is sold
		public static int setSoldProduct(int productId) {
			Connection conn = null;
			int status = 0;
			try {
				conn = DB.getConnection();
				String query = "UPDATE Products SET "
						+ "is_sold = TRUE, "
						+ "updated_at=? "
						+ "WHERE product_id=? AND is_sold IS FALSE";
				PreparedStatement stmt = conn.prepareStatement(query);
				java.util.Date now = new java.util.Date();
				stmt.setDate(1, new java.sql.Date(now.getTime()));
				stmt.setInt(2, productId);
				
				status = stmt.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}finally { 
				DB.closeConnection(conn);
			}
			return status;
		}
		
		// delete product if it is NOT SOLD
		public static int deleteProduct(int productId){
			Connection conn = null;
			int status = 0;
			try {
				conn = DB.getConnection();
				String query = "DELETE Products SET "
						+ "WHERE product_id=? AND is_sold IS FALSE";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, productId);
				
				status = stmt.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DB.closeConnection(conn);
			}
			return status;
		}
}
