package bank;

import java.util.Scanner;

public class RBI {

	protected int ADD_COUNTER=0,WITHDRAW_COUNTER=0;
	protected double ADD_INTEREST,WITHDRAW_INTEREST,MINIMUM_BALANCE,BALANCE,ADD_RATE,WITHDRAW_RATE;
	public static Scanner ScannerInput(Scanner sc)
	{
		if(sc!=null)
			return sc;
		else
		{ sc=new Scanner(System.in);
		}
		return sc;  
	}
	
	public void addAmount(Scanner sc)
	{
		double amount=sc.nextFloat();
		setADD_COUNTER((getADD_COUNTER())+1);
		if(getADD_COUNTER()>3)
			{setBALANCE(getBALANCE()+amount+(getADD_RATE()*getBALANCE()));
			System.out.println("Your current balance is:"+getBALANCE());
			}
		else
			{setBALANCE(getBALANCE()+amount);
			System.out.println("Your current balance is:"+getBALANCE());
			}
	}
	
	
	public void withdrawAmount(Scanner sc)
	{
		double wamount=sc.nextFloat();
		setWITHDRAW_COUNTER((getWITHDRAW_COUNTER())+1);
		if((getBALANCE()-wamount)<getMINIMUM_BALANCE())
			System.out.println("U cannot withdraw the respective amount");
		if(getWITHDRAW_COUNTER()>3)
			setBALANCE(getBALANCE()-wamount-(getWITHDRAW_RATE()*getBALANCE()));
		else
			setBALANCE(getBALANCE()-wamount);
	}

	public int getADD_COUNTER() {
		return ADD_COUNTER;
	}

	public void setADD_COUNTER(int aDD_COUNTER) {
		ADD_COUNTER = aDD_COUNTER;
	}

	public int getWITHDRAW_COUNTER() {
		return WITHDRAW_COUNTER;
	}

	public void setWITHDRAW_COUNTER(int wITHDRAW_COUNTER) {
		WITHDRAW_COUNTER = wITHDRAW_COUNTER;
	}

	public double getADD_INTEREST() {
		return ADD_INTEREST;
	}

	public void setADD_INTEREST(double aDD_INTEREST) {
		ADD_INTEREST = aDD_INTEREST;
	}

	public double getWITHDRAW_INTEREST() {
		return WITHDRAW_INTEREST;
	}

	public void setWITHDRAW_INTEREST(double wITHDRAW_INTEREST) {
		WITHDRAW_INTEREST = wITHDRAW_INTEREST;
	}

	public double getMINIMUM_BALANCE() {
		return MINIMUM_BALANCE;
	}

	public void setMINIMUM_BALANCE(double mINIMUM_BALANCE) {
		MINIMUM_BALANCE = mINIMUM_BALANCE;
	}

	public double getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(double bALANCE) {
		BALANCE = bALANCE;
	}

	public double getADD_RATE() {
		return ADD_RATE;
	}

	public void setADD_RATE(double aDD_RATE) {
		ADD_RATE = aDD_RATE;
	}

	public double getWITHDRAW_RATE() {
		return WITHDRAW_RATE;
	}

	public void setWITHDRAW_RATE(double wITHDRAW_RATE) {
		WITHDRAW_RATE = wITHDRAW_RATE;
	}	
	
}
