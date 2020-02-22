package walletapp;

import java.util.ArrayList;

public class WalletAccount extends UserInfo {
	private long ACCOUNT_ID;
	private double ACCOUNT_BALANCE;
	private banktype Status;
	private ArrayList<WalletTransaction> TransactionHistory;

	@Override
	public void signUp(String username, String password, String phoneno, String loginname, 
			banktype status) throws ShowException {
		double accountbalance=1000;
		super.signUp(username, password, phoneno, loginname, status);
		setACCOUNT_BALANCE(accountbalance);
		
		setStatus(status);
		setACCOUNT_ID(id);
	}

	public long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public void setACCOUNT_ID(long aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}

	public double getACCOUNT_BALANCE() {
		return ACCOUNT_BALANCE;
	}

	public void setACCOUNT_BALANCE(double aCCOUNT_BALANCE) {
		ACCOUNT_BALANCE = aCCOUNT_BALANCE;
	}

	public banktype getStatus() {
		return Status;
	}

	public void setStatus(banktype status) {
		Status = status;
	}

	public ArrayList<WalletTransaction> getTransactionHistory() {
		return TransactionHistory;
	}

	public void setTransactionHistory(ArrayList<WalletTransaction> transactionHistory) {
		TransactionHistory = transactionHistory;
	}

}
