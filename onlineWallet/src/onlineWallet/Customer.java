package onlineWallet;

public class Customer {

	private String ACCOUNT_HOLDER_NAME;
	private String PANCARD_NO;
	private String BANK_NAME;
	private String BANKACCOUNT_NO;
	private Wallet wallet;

	public Customer() {
		super();

	}

	public Customer(String aCCOUNT_HOLDER_NAME, String pANCARD_NO, String bANK_NAME, Wallet wallet) {
		super();
		ACCOUNT_HOLDER_NAME = aCCOUNT_HOLDER_NAME;
		PANCARD_NO = pANCARD_NO;
		BANK_NAME = bANK_NAME;
		setBANKACCOUNT_NO(getBANKACCOUNT_NO());
		this.wallet = wallet;
	}

	public Customer(String aCCOUNT_HOLDER_NAME, String pANCARD_NO, String bANK_NAME) {
		super();
		ACCOUNT_HOLDER_NAME = aCCOUNT_HOLDER_NAME;
		PANCARD_NO = pANCARD_NO;
		setBANK_NAME(bANK_NAME);
		setBANKACCOUNT_NO(getBANKACCOUNT_NO());
	}

	@Override
	public String toString() {
		return "Customer [ACCOUNT_HOLDER_NAME=" + ACCOUNT_HOLDER_NAME + ", PANCARD_NO=" + PANCARD_NO + ", BANK_NAME="
				+ BANK_NAME + ", BANKACCOUNT_NO=" + BANKACCOUNT_NO + ", wallet=" + wallet + "]";
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String getACCOUNT_HOLDER_NAME() {
		return ACCOUNT_HOLDER_NAME;
	}

	public void setACCOUNT_HOLDER_NAME(String aCCOUNT_HOLDER_NAME) {
		ACCOUNT_HOLDER_NAME = aCCOUNT_HOLDER_NAME;
	}

	public String getBANK_NAME() {
		return BANK_NAME;
	}

	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}

	public String getPANCARD_NO() {
		return PANCARD_NO;
	}

	public void setPANCARD_NO(String pANCARD_NO) {
		PANCARD_NO = pANCARD_NO;
	}

	public String getBANKACCOUNT_NO() {
		return (getBANK_NAME() + "_" + generateAccountNo());
	}

	public void setBANKACCOUNT_NO(String bANKACCOUNT_NO) {
		BANKACCOUNT_NO = bANKACCOUNT_NO;
	}

	public long generateAccountNo() {
		long AccountNo = (long) (Math.random() * ((1000000000 - 99999) + 1)) + 99999;
		return AccountNo;
	}

}
