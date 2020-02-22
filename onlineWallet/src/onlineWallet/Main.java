package onlineWallet;

import java.util.*;

public class Main {
	static WalletService service;
	public void initData() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		Map<String, List<String>> data1 = new HashMap<String, List<String>>();
		List<String> data3 = new ArrayList<String>();
		
		Customer cust1 = new Customer("Bob", "QABC779722","ICICI", new Wallet(5000));
		Customer cust2 = new Customer("Jack", "ABCD69898", "SBI",new Wallet(400));
		Customer cust3 = new Customer("Max", "BJI7654321","ICICI", new Wallet(300));
		data.put("QABC779722", cust1);
		data.put("ABCD69898", cust2);
		data.put("BJI7654321", cust3);
		data.forEach((k,v)->{
			System.out.println(k+":"+v);
		});
		data3.add("Account Opened");
		System.out.println("data in data1 hashmap");
		
		data1.put("QABC779722", data3);
		System.out.println(data3);
		data1.forEach((k,v)->{
			System.out.println(k+":"+v);
		});
		service = new WalletserviceImpl(data);
		Client c = new Client();
		while (true)
			c.displayMenu();
	}

	
	public static void main(String[] args) {
		Main obj=new Main();
		obj.initData();
		
	
		
	}

}
