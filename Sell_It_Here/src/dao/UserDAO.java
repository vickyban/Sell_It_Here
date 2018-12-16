package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.UserBean;
import util.dbConnection;


public class UserDAO {
	
	public static UserBean createUser(UserBean user) {
		Connection conn = null;
		try {
			conn = dbConnection.getConnection();
			String query= "Insert into users (firstname,lastname,username,salt,password,email,street,city,province,postal,"
					+ "phone,date_created) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getSalt());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getStreet());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getProvince());
			pstmt.setString(10, user.getPostal());
			pstmt.setString(11, user.getPhone());
			pstmt.setTimestamp(12, user.getDateCreated());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				user.setId(rs.getInt(1));
			}
			
			pstmt.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.closeConnection(conn);
		}
		
		return user;
	}
	
	public static Boolean isValidUsername(String username) {
		Connection conn = null;
		Boolean valid = true;
		
		try {
			conn = dbConnection.getConnection();	
			
			String query = "Select * from users where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			valid = !rs.next();
			
		} catch(SQLException e) {
			e.getMessage();
		} finally{
			dbConnection.closeConnection(conn);
		}
		
		return valid;
	}
	
	public static Boolean isValidEmail(String email) {
		Connection conn = null;
		Boolean valid = true;
		
		try {
			conn = dbConnection.getConnection();	
			String query = "Select * from users where email = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			valid = !rs.next();
			
		} catch(SQLException e) {
			e.getMessage();
		} finally{
			dbConnection.closeConnection(conn);
		}
		
		return valid;
	}
	
	
	public static UserBean getUserById(int id) {
		Connection con = null;
		UserBean user = null;
		try{
			con = DB.getConnection();
			String query = "Select * from Users where userID=? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
		
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserBean();
				user.setId(rs.getInt("userID"));
				user.setFname( rs.getString("firstname"));
				user.setLname( rs.getString("lastname"));
				user.setUsername( rs.getString("username"));
				user.setSalt( rs.getString("salt"));
				user.setPassword( rs.getString("password"));
				user.setEmail( rs.getString("email"));
				user.setStreet( rs.getString("street"));
				user.setCity( rs.getString("city"));
				user.setProvince( rs.getString("province"));
				user.setPostal( rs.getString("postal"));
				user.setPhone( rs.getString("phone"));
				user.setDateCreated(rs.getTimestamp("date_created"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection(con);
		}
		return user;
	}
	
	// Search user by EMAIL for LOGIN VALIDATION PURPOSE
			public static UserBean getUserByEmail(String email) {
				Connection con = null;
				UserBean user = null;
				try{
					con = DB.getConnection();
					String query = "Select * from Users where email=? ";
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setString(1, email);
					
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						user = new UserBean();
						user.setId(rs.getInt("userID"));
						user.setFname( rs.getString("firstname"));
						user.setLname( rs.getString("lastname"));
						user.setUsername( rs.getString("username"));
						user.setSalt( rs.getString("salt"));
						user.setPassword( rs.getString("password"));
						user.setEmail( rs.getString("email"));
						user.setStreet( rs.getString("street"));
						user.setCity( rs.getString("city"));
						user.setProvince( rs.getString("province"));
						user.setPostal( rs.getString("postal"));
						user.setPhone( rs.getString("phone"));
						user.setDateCreated(rs.getTimestamp("date_created"));
					}			
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					DB.closeConnection(con);
				}
//				System.out.println(user);
				return user;
			}
			
			// user update profile info EXCEPT PASSWORD and CREDIT POINT
			public static UserBean updateUser(UserBean user) {
				Connection con = null;
				try {
					con = DB.getConnection();
					String query = "UPDATE Users SET "
							+ "firstname=?, "
							+ "lastname=?, "
							+ "username=?,"
							+ "email=?,"
							+ "street=?,"
							+ "city=?, "
							+ "postal=?, "
							+ "province=?, "
							+ "firstname=?, "
							+ "updated_at=? "
							+ "WHERE user_id=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, user.getFname());
					pstmt.setString(2, user.getLname());
					pstmt.setString(3, user.getUsername());
					pstmt.setString(5, user.getEmail());
					pstmt.setString(6, user.getStreet());
					pstmt.setString(7, user.getCity());
					pstmt.setString(8, user.getProvince());
					pstmt.setString(9, user.getPostal());
					pstmt.setString(10, user.getPhone());
					pstmt.setTimestamp(11, user.getDateCreated());
					pstmt.executeUpdate();
					
					// get the new update record
					user = getUserById(user.getId());
					
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					DB.closeConnection(con);
				}
				return user;
			}
}
