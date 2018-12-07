package models;

import java.io.Serializable;
import java.util.Date;  // ??????

import util.HashPassword;

public class User implements Serializable {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String salt;
	private double credit;
	private String location;
	private Date created_at;
	private Date updated_at;
	
	public User() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userid) {
		this.userId = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date update_at) {
		this.updated_at = update_at;
	}
	
	@Override 
	public String toString() {
		return "User{\n"
				+ "user_id: " + userId + "\n"
				+ "username: " + username + "\n"
				+ "password: " + password + "\n"
				+ "salt: " + salt + "\n"
				+ "email: " + email + "\n"
				+ "location: " + location + "\n"
				+ "credit: " + credit + "\n"
				+ "created_at: " + created_at.toString() + "\n"
				+ "updated_at: " + updated_at.toString() + "\n"
				+ "}\n";
	}
	
	public boolean authenticate(String password) {
		String hash = HashPassword.getHashPassword(password, this.salt);
		return hash.equals(this.password);
	}
	
	public void hashPassword(String raw) {
		this.salt = HashPassword.getSalt();
		this.password = HashPassword.getHashPassword(raw, this.salt);
	}
	
}
