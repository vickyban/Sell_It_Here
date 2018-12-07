import java.util.Date;

import dao.UserDao;
import models.Product;
import models.User;
import util.HashPassword;
public class Test {

	public static void main(String[] args) {
		String salt = HashPassword.getSalt();
		String password = "Poyo";
		String hash = HashPassword.getHashPassword(password, salt);
		
//		User user = new User();
//		user.setUsername("Poyo");
//		user.setPassword(hash);
//		user.setSalt(salt);
//		user.setLocation("Mississauga");
//		user.setEmail("poyo@example.com");
//		
//		user = UserDao.createUser(user);
//		System.out.println("New user");
//		System.out.println(user);
//		
//		User user2 = UserDao.getUserByEmail("poyo@example.com");
//		System.out.println("Get by email");
//		System.out.println(user2);
//		
//		user2.setLocation("Toronto");
//		user2 = UserDao.updateUser(user2);
//		System.out.println("Update user");
//		System.out.println(user2);
//		
//		salt = HashPassword.getSalt();
//		hash = HashPassword.getHashPassword("Poyo2", salt);
//		user2.setPassword(hash);
//		user2.setSalt(salt);
//		user2 = UserDao.updatePassword(user2);
//		System.out.println("Update password");
//		System.out.println(user2);
		
//		private int productId;
//		private int sellerId;
//		private String name;
//		private double price;
//		private String category;
//		private String description;
//		private Date created_at;
//		private Date updated_at;
//		private boolean sold;
		
		// testing Product model
		Product product = new Product();
		product.setSellerId(UserDao.getUserByEmail("poyo@example.com").getUserId());
		product.setName("Dog toy");
		product.setPrice(12.99);
		product.setCategory("Toy");
		product.setDescription("For dog only. KEEP OUT OF CHILDREN REACH");
		
		
	
	}

}
