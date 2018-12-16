import java.util.ArrayList;
import java.util.Date;

import dao.ProductDAO;
import dao.UserDAO;
import dao.UserDAO_OLD;
import models.ProductBean;
import models.UserBean;
import util.HashPassword;
import util.SortBy;
public class Test {

	public static void main(String[] args) {
		String[] usernames = {"kim", "kevin", "michael", "michelle", "lisa", "ashley", "tom", "tim", "jessie", "jane", "jake", "andrew"};
		String[] city = {"Toronto", "Mississauga","Brampton", "Oakville", "Waterloo"};
		String[] category = {"car","toy", "garden", "fashion", "motor","sport"};
		String[] names = {"Animal ", "Honda ", "Canadian Tire ", "Zera ", "Dress ", "clock ", "watch ", "engine "};
		Double[] prices = {12.15,2000.0,230.34,12.0, 7.88, 5.99,60.3,80.99,405.3};
		
		ArrayList<UserBean> users = new ArrayList<>();
		for(String u : usernames) {
			UserBean bean = new UserBean();
			bean.setFname(u);
			bean.setLname("Smith");
			bean.setUsername(u);
			bean.hashPassword("1234");
			bean.setEmail(u + "@example.com");
			bean.setStreet("12");
			bean.setCity( city[ (int)(Math.random() * city.length ) ] );
			bean.setProvince("Ontario");
			bean.setPostal("l4t2y4");
			bean.setPhone("123 990 1002");
			bean.setDateCreated( new java.sql.Timestamp(new Date().getTime()) );
			
			users.add(UserDAO.createUser(bean));
		}
		
		for(UserBean bean : users) {
			int n = (int)(Math.random() * 10 + 1);
			for(int i = 0; i < n; i++) {
				String type = category[ (int)(Math.random() * category.length ) ];
				
				ProductBean product = new ProductBean();
				product.setSellerId(bean.getId());
				product.setName( names[ (int)(Math.random() * names.length ) ] + type);
				product.setPrice(prices[ (int)(Math.random() * prices.length ) ]);
				product.setCategory(type);
				product.setDescription("For dog only. KEEP OUT OF CHILDREN REACH");
				
				ProductDAO.createProduct(product);
			}
		}
		
//		
//		
//		// testing Product model
//		ProductBean product = new ProductBean();
//		UserBean user = UserDAO_OLD.getUserByEmail("poyo@example.com");
//		product.setSellerId(user.getUserId());
//		product.setName("Dog toy");
//		product.setPrice(12.99);
//		product.setCategory("Toy");
//		product.setDescription("For dog only. KEEP OUT OF CHILDREN REACH");
//		
//		System.out.println("insert into DB");
//		product = ProductDAO.createProduct(product);
//		
//		ProductBean product2 = new ProductBean();
//		product2.setSellerId(UserDAO_OLD.getUserByEmail("poyo@example.com").getUserId());
//		product2.setName("Cat toy");
//		product2.setPrice(10.99);
//		product2.setCategory("Toy");
//		product2.setDescription("For cat only. KEEP OUT OF CHILDREN REACH");
//		
//		System.out.println("2nd insert into DB");
//		product2 = ProductDAO.createProduct(product2);
//		
//		System.out.println("search product");
//		ArrayList<ProductBean> products = ProductDAO.getFilteredProducts("Toronto", "Toy", "", 0, 30, SortBy.HIGH_LOW);
//		System.out.println("here product");
//		if(products != null || !products.isEmpty()) {
//			for(ProductBean p : products) {
//				System.out.println(p.toString());
//			}
//				
//		}
			
		
//		
//		System.out.println("Update product");
//		ProductDao.setSoldProduct(product.getProductId());
//		System.out.println(product);
//		
//		System.out.println("Get recent posts");
//		products = ProductDao.getRecentPosts();
//		if(products != null || !products.isEmpty()) {
//			for(Product p : products) {
//				System.out.println(p.toString());
//			}
//		}
	
	}

}
