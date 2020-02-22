package onlineWallet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {
	WalletService service;

	public Client() {
		service = new WalletserviceImpl();
	}

	Scanner sc = new Scanner(System.in);

	public boolean validAmount(double amount) {
		if (amount > 0) {
			return true;
		} else {
			throw new InvalidInputException(" : Invalid Amount. Please enter a POSITIVE amount. Thanks. :) \n");
		}
	}

	public void displayMenu() {
		System.out.println("---------MyWallet-----------\n\n");

		System.out.println("1)Create Account");
		System.out.println("2)Balance Enquiry");
		System.out.println("3)Deposit Amount");
		System.out.println("4)Withdraw Funds");
		System.out.println("5)Transfer Funds");
		System.out.println("6)View All Transactions");
		System.out.println("7)Exit");

		System.out.println("\nChoose Operation:");

		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			createAccount();
			break;

		case 2:
			balance();
			break;

		case 3:
			deposit();
			break;

		case 4:
			withdraw();
			break;

		case 5:
			transfer();
			break;

		case 6:
			transactions();
			break;

		case 7:
			System.out.println("Are you sure you want to exit? (yes/no)");
			String reply = sc.next();

			if (reply.trim().equalsIgnoreCase("yes")) {
				exitWallet();
			}
			break;

		default:
			System.out.println("Invalid Operation! Please try again.");
			break;
		}
	}

	public void createAccount() {
		try {
			System.out.println("\nEnter Credentials to Create an Account with MyWallet");

			System.out.println("\nEnter Your Name: ");
			String name = sc.next();

			System.out.println("Enter Your PAN card Number:");
			String panno = sc.next();

			System.out.println("Enter Your bank name:");
			String bankname = sc.next();

			System.out.println("\nEnter Amount to Deposit:  ");
			double amount = sc.nextDouble();

			service.createAccount(name, panno, bankname, amount);
			System.out.println("\nDear " + name.toUpperCase()
					+ ", Your MyWallet Account has been SUCCESSFULLY created. Your MyWallet ID is your account linked with PAN : "
					+ panno + "\n");
			System.out.println("\nBalance in A/C: " + amount + "\n");

		} catch (InvalidInputException e) {
			System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.out.println("Something went WRONG: Please Try Again After Some Time. Thanks.\n");
		}
	}

	public void balance() {
		System.out.println("\nEnter PAN CARD Number: ");
		String panNo = sc.next();

		try {
			Customer c = service.showBalance(panNo);

			System.out.println("Balance in Your Wallet : " + c.getWallet().getBalance() + "\n");
		} catch (InvalidInputException e) {
			System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.out.println("Something went WRONG: Please Try Again After Some Time. Thanks.\n");
		}
	}

	public void deposit() {

		System.out.println("\nEnter PAN CARD Number: ");
		String panNo = sc.next();

		System.out.println("\nEnter Amount to Deposit:  ");
		double amount = sc.nextDouble();

		if (validAmount(amount)) {
			try {
				Customer c = service.depositAmount(panNo, amount);

				System.out.println("Amount of" + amount + " deposited Successfully to A/C linked to PAN CARD Number : "
						+ c.getBANKACCOUNT_NO() + "PAN NO:" + panNo + "\n");
				System.out.println("Balance in A/C: " + c.getWallet().getBalance() + "\n");

			} catch (InvalidInputException e) {

				System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
			} catch (Exception e) {// e.printStackTrace();
				System.out.println("Something went WRONG: Please Try Again After Some Time. Thanks.\n");
			}
		} else {
			System.out.println("Invalid Amount. Please enter a POSITIVE amount. Thanks. :)");
		}
	}

	public void withdraw() {

		System.out.println("\nEnter PAN Number: ");
		String panNo = sc.next();

		System.out.println("\nEnter Amount to Withdraw:  ");
		double amount = sc.nextDouble();

		if (validAmount(amount)) {
			try {
				Customer c = service.withdrawAmount(panNo, amount);

				System.out.println("Amount " + amount + " has been debited from A/C linked to PAN CARD Number : "
						+ c.getBANKACCOUNT_NO() + "PAN NO:" + panNo + "\n");
				System.out.println("Balance in A/C: " + c.getWallet().getBalance() + "\n");

			} catch (InvalidInputException e) {
				// e.printStackTrace();
				System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
			} catch (InsufficientBalanceException e) {
				// e.printStackTrace();
				System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("Something went WRONG: Please Try Again After Some Time. Thanks.\n");
			}
		} else {
			System.out.println("Invalid Amount. Please enter a POSITIVE amount. Thanks. :)");
		}
	}

	public void transfer() {

		System.out.println("\nEnter Pan Number: ");
		String sourcePanNo = sc.next();

		System.out.println("\nEnter Recipient's Pan Number:");
		String targetPanNo = sc.next();

		System.out.println("\nEnter Amount to Transfer:  ");
		double amount = sc.nextDouble();

		if (validAmount(amount)) {
			try {
				Customer c = service.fundTransfer(sourcePanNo, targetPanNo, amount);

				System.out.println(
						"Amount of" + amount + " has been SUCCESSFULLY transferred to A/C linked to Pan Number : xxxxxx"
								+ targetPanNo + "\n");
				System.out.println("Balance in A/C: " + c.getWallet().getBalance() + "\n");
			} catch (InvalidInputException e) {
				// e.printStackTrace();
				System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
			} catch (InsufficientBalanceException e) {
				// e.printStackTrace();
				System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("Something went WRONG: Please Try Again After Some Time. Thanks.\n");
			}
		} else {
			System.out.println("Invalid Amount. Please enter a POSITIVE amount. Thanks. :)");
		}
	}

	public void transactions() {

		System.out.println("\nEnter Pan Number: ");
		String panNo = sc.next();
		int count = 0;

		try {
			List<String> l = new LinkedList<String>();
			l = service.transactions(panNo);
			@SuppressWarnings("rawtypes")
			Iterator it = ((LinkedList<String>) l).descendingIterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				count++;
				if (count > 10)
					break;
			}
		} catch (InvalidInputException e) {
			// e.printStackTrace();
			System.out.println("Something went WRONG : Reason : " + e.getMessage() + "\n");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Something went WRONG: Please Try Again After Some Time. Thanks.\n");
		}
	}

	public void exitWallet() {
		System.out.println("\n--------- Thank you for using MyWallet services. Have a nice day! :) ----------- \n");
		System.exit(0);
	}


		
}
