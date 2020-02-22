package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import bean.Product;

public class ProductMaster {
	Admin admin=new Admin();
	private String username;
	private String password;
	private Long uid;

	public static HashMap<String, Product> productHashmap = new HashMap<String, Product>();
	public static HashMap<Long, User> userHashmap = new HashMap<Long, User>();

	public long uuid() {
		return Long.parseLong(String.format("%s%s%s%s%s%s%s%s", new Random().nextInt(9), new Random().nextInt(9),
				new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9),
				new Random().nextInt(9), new Random().nextInt(9)));
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

	public ProductMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductMaster(Long uid, String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.uid = uid;
	}

	public ProductMaster(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}

	public void addProduct(String productId, String colour, String dimension, String specification, String manufacturer,
			String productName, double price, int quantity, int productCategory) {
		Product product = new Product(productId, colour, dimension, specification, manufacturer, productName, price,
				quantity, productCategory);
		System.out.println("check1");
		productHashmap.put(productId, product);
		System.out.println("check2");
		productHashmap.forEach((k, v) -> {
			System.out.println(v.getProductCategory()+","+v.getProductName());
		});
		System.out.println("check3");
		System.out.println(productHashmap);
		System.out.println("check4");
	}

	public void editProduct(String productId, String update) {
		if (productHashmap.containsKey(productId)) {
			System.out.println("Details of the product:");
			productHashmap.forEach((k, v) -> {
				v.toString();
			});
			// productHashmap.re

		}

	}

	public void deleteProduct(String productId) {
		if (productHashmap.containsKey(productId)) {
			productHashmap.remove(productId);
		} else {
			System.out.println("Product Id not found!!");
		}

	}

	public void registerUser(Long id, String username, int mobileNo) {
		User user = new User(id, username, mobileNo);
		userHashmap.put(id, user);
	}

	public void searchProduct(String pid) {
		productHashmap.forEach((k, v) -> {
			System.out.println("Product Id:" + k + " " + v.toString());
		});
	}

	public Map<String, Product> filterProducts(HashMap<String, Product> productHashmap) {

		return productHashmap.entrySet().stream().filter(entry -> Integer.parseInt(entry.getValue().getProductId()) > 1).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));


	}
	
	public void viewProduct() {
		System.out.println("check");
		System.out.println(productHashmap);
		productHashmap.forEach((k, v) -> {
			System.out.println("Product Id:" + k + " " + v.toString());
		});
		System.out.println("check2");
	}


}
