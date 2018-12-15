package models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ProductBean implements Serializable {
	private int productId;
	private int sellerId;
	private String name;
	private double price;
	private String category;
	private String description;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean sold;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	
	@Override 
	public String toString() {
		return "User{\n"
				+ "product_id: " + productId + "\n"
				+ "seller_id: " + sellerId + "\n"
				+ "name: " + name + "\n"
				+ "price: " + price + "\n"
				+ "description: " + description + "\n"
				+ "category: " + category + "\n"
				+ "is_sold: " + sold + "\n"
				+ "created_at: " + created_at.toString() + "\n"
				+ "updated_at: " + updated_at.toString() + "\n"
				+ "}\n";
	}
	
	
}
