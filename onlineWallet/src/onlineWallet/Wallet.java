package onlineWallet;

public class Wallet {

	private double balance;

	public Wallet() {
		super();
	}

	@Override
	public String toString() {
		return "Wallet [balance=" + balance + "]";
	}

	public Wallet(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
