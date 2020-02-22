package bank;

import java.util.Scanner;

public class Main {
	RBI r;
	Scanner sc = new Scanner(System.in);

//	public void selectBank() {
//		System.out.println("Select the bank:\n1.ICICI \n2.SBI");
//		int ch = sc.nextInt();
//		switch (ch) {
//		case 1:
//			r = new ICICI();
//			selectOperation();
//			break;
//		case 2:
//			r = new SBI();
//			selectOperation();
//			break;
//		}
//
//	}
	
	public void selectOperation()
	{
		System.out.println("Select the operation:\n1.Deposit amount \n2.Withdraw amount\n3.Show Balance");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			r.addAmount(sc);
			break;
		case 2:
			r.withdrawAmount(sc);
			break;
		case 3:r.getBALANCE();
		break;
		}
		
	}
	
	public void customerEntry()
	{
		System.out.println("Enter account holder name:");
		String name=sc.next();
		System.out.println("Enter bank name:");
		String bankname=sc.next();
		System.out.println("Enter pan card no:");
		long pancard=sc.nextLong();
		
	}
	public static void main(String[] args) {
		
		

	}

}
