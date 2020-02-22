package walletapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {

	public void userDetails() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(isr);
		
		try {

			System.out.println("Enter the username:");
			String username = b.readLine();			
			System.out.println("Enter the password :");
			String password = b.readLine();			
			System.out.println("Enter the phone no:");
			String phoneno = b.readLine();
			System.out.println("Enter the login name:");
			String loginname = b.readLine();
			System.out.println("Enter the banktype:(saving=0,cuurent=1)");
			int status = Integer.parseInt(b.readLine());
			
			HashMap<Long, WalletAccount> userAccount = new HashMap<Long, WalletAccount>();	
			WalletAccount walletaccount=new WalletAccount();
			if(status==0)
				walletaccount.signUp(username, password, phoneno, loginname,banktype.Saving_account);
			else
				walletaccount.signUp(username, password, phoneno, loginname,banktype.Current_account);

			System.out.println("Now u can access your payment wallet!");
			System.out.println("1.Add to your wallet\n2.Show account balance\n3.Transfer funds\n");
			int choice=Integer.parseInt(b.readLine());
			switch(choice)
			{
			case 1:break;
			case 2:break;
			case 3:break;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String args[]) {
		Main user = new Main();
		user.userDetails();
	}
}
