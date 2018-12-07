package dao;

import java.sql.Timestamp;

import models.User;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class UserDao {
	// Create new User 
	public static User createUser(User user) {
		Connection con = null;
		try {
			con = DB.getConnection();
			String query = "INSERT INTO Users "
					+ "(username,password,salt,email,location,created_at,updated_at)"
					+ "VALUES (?,?,?,?,?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getSalt());
			stmt.setString(4,user.getEmail());
			stmt.setString(5, user.getLocation());
			java.util.Date now = new java.util.Date();
			stmt.setDate(6, new java.sql.Date(now.getTime()));
			stmt.setDate(7, new java.sql.Date(now.getTime()));
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setCreated_at(now);
				user.setUpdated_at(now);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return user;
	}
	
	// Retrieve User's info
	public static User getUserById(int id) {
		Connection con = null;
		User user = null;
		try{
			con = DB.getConnection();
			String query = "Select * from Users where user_id=? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setSalt(rs.getString("salt"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setCredit(rs.getDouble("credit"));
				user.setLocation(rs.getString("location"));
				user.setCreated_at(rs.getDate("created_at"));
				user.setUpdated_at(rs.getDate("updated_at"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return user;
	}
	
	// Search user by EMAIL for LOGIN VALIDATION PURPOSE
		public static User getUserByEmail(String email) {
			Connection con = null;
			User user = null;
			try{
				con = DB.getConnection();
				String query = "Select * from Users where email=? ";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, email);
				
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setPassword(rs.getString("password"));
					user.setSalt(rs.getString("salt"));
					user.setUsername(rs.getString("username"));
					user.setEmail(rs.getString("email"));
					user.setCredit(rs.getDouble("credit"));
					user.setLocation(rs.getString("location"));
					user.setCreated_at(rs.getDate("created_at"));
					user.setUpdated_at(rs.getDate("updated_at"));
				}			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DB.closeConnection(con);
			}
			return user;
		}
	
	
	// user update profile info EXCEPT PASSWORD and CREDIT POINT
	public static User updateUser(User user) {
		Connection con = null;
		try {
			con = DB.getConnection();
			String query = "UPDATE Users SET "
					+ "username=?,"
					+ "email=?,"
					+ "location=?,"
					+ "updated_at=? "
					+ "WHERE user_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUsername());
			stmt.setString(2,user.getEmail());
			stmt.setString(3, user.getLocation());
			stmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			stmt.setInt(5, user.getUserId());
			
			stmt.executeUpdate();
			
			// get the new update record
			user = getUserById(user.getUserId());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return user;
	}
	
	// Update PASSWORD 
	public static User updatePassword(User user) {
		Connection con = null;
		try {
			con = DB.getConnection();
			String query = "UPDATE Users SET "
					+ "password=?,"
					+ "salt=?,"
					+ "updated_at=? "
					+ "WHERE user_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,user.getPassword());
			stmt.setString(2, user.getSalt());
			stmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			stmt.setInt(4, user.getUserId());
			
			stmt.executeUpdate();
			// get the new update record
			user = getUserById(user.getUserId());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return user;
	}
	
	public static int deleteUser(User user) {
		int status = 0;
		Connection con = null;
		try {
			con = DB.getConnection();
			String query = "DELETE Users WHERE user_id=?";
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, user.getUserId());
			
			status = stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return status;
	}
	
	
}
