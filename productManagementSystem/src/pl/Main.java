package pl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader buff = new BufferedReader(isr);
	Admin admin = new Admin();
	ProductMaster pm = new ProductMaster();
	User usr=new User();

	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Main(InputStreamReader isr, BufferedReader buff) {
//		this.buff = buff;
//		this.isr = isr;
//		
//		// TODO Auto-generated constructor stub
//	}

	public void adminMenu() {
		try {
			System.out.println("Now choose.....");
			System.out.println("1.Register a product master\n2.View products");
			int j = Integer.parseInt(buff.readLine());
			switch (j) {
			case 1:
				System.out.println("Enter the master name:");
				String uname = buff.readLine();
				System.out.println("Enter the password:");
				String password = buff.readLine();
				admin.addProductMaster(uname, password);
				break;
			case 2:
				pm.viewProduct();
				break;
			}
		} catch (Exception e) {
		}

	}

	public void productMasterMenu() {
		try {

			System.out.println("Now choose.....");
			System.out.println("1.Add a product\n2.Edit a product\n3.Delete a product\4.Register a user");
			int k = Integer.parseInt(buff.readLine());
			switch (k) {
			case 1:
				System.out.println("Enter Product id:");
				String id = buff.readLine();
				System.out.println("Enter Product Name:");
				String pname = buff.readLine();
				System.out.println("Enter Product colour:");
				String colour = buff.readLine();
				System.out.println("Enter Product dimension:");
				String dimension = buff.readLine();
				System.out.println("Enter Product specification:");
				String specification = buff.readLine();
				System.out.println("Enter Product manufacturer:");
				String manufacturer = buff.readLine();
				System.out.println("Enter Product price:");
				Double price = Double.parseDouble(buff.readLine());
				System.out.println("Enter Product quantity:");
				Integer quantity = Integer.parseInt(buff.readLine());
				System.out.println("Enter Product category:");
				Integer category = Integer.parseInt(buff.readLine());
				pm.addProduct(id, colour, dimension, specification, manufacturer, pname, price, quantity, category);
				break;

			case 2:
				System.out.println("Enter the product id to update:");
				String productId = buff.readLine();
				System.out.println("Enter the manufacturer:");
				String pmanufacturer = buff.readLine();
				break;

			case 3:
				System.out.println("Enter the product id to delete:");
				String Id = buff.readLine();
				pm.deleteProduct(Id);
				break;
			case 4:
				System.out.println("Enter username:");
				String uname=buff.readLine();
				System.out.println("Enter mobileNo:");
				Integer mobileNo=Integer.parseInt(buff.readLine());
				long userId=usr.uuid();
				pm.registerUser(userId, uname, mobileNo);
				break;
			}
		} catch (Exception e) {
		}

	}

	public void displayMainMenu() {
		String exit = null;
		try {
			do {
				System.out.println("1.Login as Admin\n2.Login as Product Master\n3.Sign in/Sign Up as User");
				int i = Integer.parseInt(buff.readLine());
				System.out.println(i);
				switch (i) {
				case 1:
					// For Admin
					System.out.println("Enter the credentials:(username and password)");
					String adminName = buff.readLine();
					String Adminpassword = buff.readLine();

					if (admin.signIn(adminName, Adminpassword))
						adminMenu();
					else
						System.out.println("Invalid credentials!");
					break;
					
				case 2:

					System.out.println("Enter the id of the master:");
					long mid = Long.parseLong(buff.readLine());
					Admin adm = new Admin();
					if (adm.signIn(mid))
						productMasterMenu();
					else
						System.out.println("Invalid credentials!");
					break;
				case 3:
					break;
				}

				System.out.println("Do u want to continue:(yes/no)");
				exit = buff.readLine();
			} while (exit != "no");
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		Main m = new Main();
		m.displayMainMenu();
	}
}
