package pl;

import java.util.Random;

public class User {

	private long id;
	private String username;
	private int mobileNo;
	
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
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public User(long id, String username, int mobileNo) {
		super();
		this.id = id;
		this.username = username;
		this.mobileNo = mobileNo;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
	