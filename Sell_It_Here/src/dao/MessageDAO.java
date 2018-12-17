package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.*;
import util.dbConnection;

public class MessageDAO {

	public static void sendMessage(MessageBean message) {
		Connection con = null;
		try {
			con = dbConnection.getConnection();
			String query = "Insert into message (senderid,recipientid,message) values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, message.getSenderID());
			pstmt.setInt(2, message.getRecipientID());
			pstmt.setString(3, message.getMessage());
			
			pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.closeConnection(con);
		}
	}
	
	public static ArrayList<MessageBean> getAllMessage(int id){
		Connection con = null;
		ArrayList<MessageBean> messages = new ArrayList<>();			
		
		try {
			con = dbConnection.getConnection();
			String query = "select a.messageid, a.senderid, b.username, a.message, a.recipientid, c.username, a.dateSent, a.isRead from message a " + 
					"inner join users b on (b.userID = a.senderid)" + 
					"inner join users c on (c.userID = a.recipientid)" + 
					"where recipientID = ? or senderid = ? order by dateSent";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MessageBean mBean = new MessageBean();
				mBean.setMessageID(rs.getInt("a.messageid"));
				mBean.setSenderID(rs.getInt("a.senderid"));
				mBean.setSenderUser(rs.getString("b.username"));
				mBean.setRecipientID(rs.getInt("a.recipientid"));
				mBean.setRecipientUser(rs.getString("c.username"));
				mBean.setMessage(rs.getString("a.message"));
				mBean.setDateCreated(rs.getTimestamp("a.dateSent"));
				mBean.setRead(rs.getBoolean("a.isRead"));
				messages.add(mBean);
			}
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			dbConnection.closeConnection(con);
		}
		
		return messages;
	}
	
	public static ArrayList<MessageBean> getBuyingMessage(int id){
		Connection con = null;
		ArrayList<MessageBean> messages = new ArrayList<>();			
		
		try {
			con = dbConnection.getConnection();
			String query = "select a.messageid, a.senderid, b.username, a.message, a.recipientid, c.username, a.dateSent, a.isRead from message a " + 
					"inner join users b on (b.userID = a.senderid)" + 
					"inner join users c on (c.userID = a.recipientid)" + 
					"where senderid = ? order by isRead ASC";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MessageBean mBean = new MessageBean();
				mBean.setMessageID(rs.getInt("a.messageid"));
				mBean.setSenderID(rs.getInt("a.senderid"));
				mBean.setSenderUser(rs.getString("b.username"));
				mBean.setRecipientID(rs.getInt("a.recipientid"));
				mBean.setRecipientUser(rs.getString("c.username"));
				mBean.setMessage(rs.getString("a.message"));
				mBean.setDateCreated(rs.getTimestamp("a.dateSent"));
				mBean.setRead(rs.getBoolean("a.isRead"));
				messages.add(mBean);
			}
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			dbConnection.closeConnection(con);
		}
		
		return messages;
	}
	
	public static ArrayList<MessageBean> getSellingMessage(int id){
		Connection con = null;
		ArrayList<MessageBean> messages = new ArrayList<>();			
		
		try {
			con = dbConnection.getConnection();
			String query = "select a.messageid, a.senderid, b.username, a.message, a.recipientid, c.username, a.dateSent, a.isRead from message a " + 
					"inner join users b on (b.userID = a.senderid)" + 
					"inner join users c on (c.userID = a.recipientid)" + 
					"where recipientid = ? order by dateSent";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MessageBean mBean = new MessageBean();
				mBean.setMessageID(rs.getInt("a.messageid"));
				mBean.setSenderID(rs.getInt("a.senderid"));
				mBean.setSenderUser(rs.getString("b.username"));
				mBean.setRecipientID(rs.getInt("a.recipientid"));
				mBean.setRecipientUser(rs.getString("c.username"));
				mBean.setMessage(rs.getString("a.message"));
				mBean.setDateCreated(rs.getTimestamp("a.dateSent"));
				mBean.setRead(rs.getBoolean("a.isRead"));
				messages.add(mBean);
			}
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			dbConnection.closeConnection(con);
		}
		
		return messages;
	}
	
	public static MessageBean getMessageByID(int id){
		Connection con = null;		
		MessageBean mBean = new MessageBean();
		try {
			con = dbConnection.getConnection();
			String query = "select a.messageid, a.senderid, b.username, a.message, a.recipientid, c.username, a.dateSent, a.isRead from message a " + 
					"inner join users b on (b.userID = a.senderid)" + 
					"inner join users c on (c.userID = a.recipientid)" + 
					"where messageid = ? order by dateSent";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mBean.setMessageID(rs.getInt("a.messageid"));
				mBean.setSenderID(rs.getInt("a.senderid"));
				mBean.setSenderUser(rs.getString("b.username"));
				mBean.setRecipientID(rs.getInt("a.recipientid"));
				mBean.setRecipientUser(rs.getString("c.username"));
				mBean.setMessage(rs.getString("a.message"));
				mBean.setDateCreated(rs.getTimestamp("a.dateSent"));
				mBean.setRead(rs.getBoolean("a.isRead"));
			}
			
			// Set message to read
			setReadMessage(id);
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			dbConnection.closeConnection(con);
		}
		
		return mBean;
	}
	
	public static void setReadMessage(int id) {
		Connection con = null;
		try {
			con = dbConnection.getConnection();
			String query = "Update message set isRead = true where messageid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.closeConnection(con);
		}
	}

}
