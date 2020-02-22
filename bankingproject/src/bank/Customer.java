package bank;

public class Customer {
	private String ACCOUNT_HOLDER_NAME;
	private String BANK_NAME;
	private long PANCARD_NO;
	private String BANKACCOUNT_NO;

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

	public long getPANCARD_NO() {
		return PANCARD_NO;
	}

	public void setPANCARD_NO(long pANCARD_NO) {
		PANCARD_NO = pANCARD_NO;
	}

	public String getBANKACCOUNT_NO() {
		return (getBANK_NAME()+"_"+generateAccountNo());
	}
	public void setBANKACCOUNT_NO(String bANKACCOUNT_NO) {
		BANKACCOUNT_NO = bANKACCOUNT_NO;
	}

	public long generateAccountNo() {
		long AccountNo = (long) (Math.random() * ((1000000000 - 99999) + 1)) + 99999;
		return AccountNo;
	}

	Customer(String CUSTOMERNAME, String BANKNAME, long PANCARDNO) {
		setACCOUNT_HOLDER_NAME(CUSTOMERNAME);
		setBANK_NAME(BANKNAME);
		setPANCARD_NO(PANCARDNO);
		setBANKACCOUNT_NO(BANKACCOUNT_NO);
	}

}
