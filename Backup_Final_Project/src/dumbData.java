import java.util.ArrayList;
import java.util.Date;

import dao.ProductDAO;
import dao.UserDAO;
import models.ProductBean;
import models.UserBean;

public class dumbData {

	public static void main(String[] args) {
		String[] usernames = {"kim", "kevin", "michael", "michelle", "lisa", "ashley", "tom", "tim", "jessie", "jane", "jake", "andrew"};
		String[] city = {"Toronto", "Mississauga","Brampton", "Oakville", "Waterloo"};
		String[] category = {"car","electonic","accessory","toy", "garden", "fashion", "motor","sport", "other"};
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
			int n = (int)(Math.random() * 20 + 1);
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
		
}

}
