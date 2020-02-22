package pl;

import java.util.HashMap;
import java.util.Random;

import bean.Product;

public class Admin {

	public static HashMap<Long, ProductMaster> adminHashmap=new HashMap< Long, ProductMaster>();
	
	
	public long uuid() {
		return Long.parseLong(String.format("%s%s%s%s%s%s%s%s", new Random().nextInt(9), new Random().nextInt(9),
				new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9),
				new Random().nextInt(9), new Random().nextInt(9)));
	}
	
	
	public boolean signIn(String username,String password)
	{
		if(username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin"))
			return true;
		else
			return false;
	}
	
	public boolean signIn(long id) {
		if(adminHashmap.containsKey(id))
			return true;
		else
			return false;

	}
	
	public void addProductMaster(String username,String password)
	
	{	long uid=uuid();
		ProductMaster pm=new ProductMaster(uid,username,password);
		adminHashmap.put(uid,pm);
		adminHashmap.forEach((k,v)->{
			System.out.println(k+":"+v.getUsername()+v.getPassword());
		});
	}
	

}
