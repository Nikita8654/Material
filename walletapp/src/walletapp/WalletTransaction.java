package walletapp;

import java.time.LocalDateTime;

public class WalletTransaction {

	private long TRANSACTION_ID;
	private String DESCRIPTION;
	private LocalDateTime DATE_OF_TRANSACTION;
	private double AMOUNT;
	private double ACCOUNT_BALANCE;

	public long getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}

	public void setTRANSACTION_ID(long tRANSACTION_ID) {
		TRANSACTION_ID = tRANSACTION_ID;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public LocalDateTime getDATE_OF_TRANSACTION() {
		return DATE_OF_TRANSACTION;
	}

	public void setDATE_OF_TRANSACTION(LocalDateTime dATE_OF_TRANSACTION) {
		DATE_OF_TRANSACTION = dATE_OF_TRANSACTION;
	}

	public double getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public double getACCOUNT_BALANCE() {
		return ACCOUNT_BALANCE;
	}

	public void setACCOUNT_BALANCE(double aCCOUNT_BALANCE) {
		ACCOUNT_BALANCE = aCCOUNT_BALANCE;
	}
}
