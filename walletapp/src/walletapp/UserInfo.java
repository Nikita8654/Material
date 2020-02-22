package walletapp;

@SuppressWarnings("serial")
enum banktype{
	Saving_account,Current_account;
}

class ShowException extends Exception {
	ShowException(String msg) {
		String message = msg;
		System.out.println(message);
	}
}

public class UserInfo {

	private long USERID;
	private String USERNAME;
	private String PASSWORD, PHONE_NO, LOGIN_NAME;
	long id = generateAccountNo();
	private banktype status;
	

	public void signUp(String username, String password, String phoneno, String loginname,banktype status ) throws ShowException {
		if (username == "")
			throw new ShowException("Username cant be null!!");
		setUSERNAME(username);
		if (password.length() < 8 && password == "")
			throw new ShowException("password should be minimmum of 8 characters and not null");
		setPASSWORD(password);
		if (phoneno.length() != 10 && phoneno == "" && (!phoneno.matches("(0/91)?[7-9][0-9]{9}")))
			throw new ShowException(phoneno);
		setPHONE_NO(phoneno);
		setLOGIN_NAME(loginname);
		setUSERID(id);
		setStatus(status);
	}

	public banktype getStatus() {
		return status;
	}

	public void setStatus(banktype status) {
		this.status = status;
	}

	public boolean signIn(String username, String password) {
		if (username == getUSERNAME() && password == getPASSWORD()) {
			return true;
		}
		return false;
	}

	public long getUSERID() {
		return USERID;
	}

	public void setUSERID(long uSERID) {
		USERID = uSERID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getPHONE_NO() {
		return PHONE_NO;
	}

	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}

	public String getLOGIN_NAME() {
		return LOGIN_NAME;
	}

	public void setLOGIN_NAME(String lOGIN_NAME) {
		LOGIN_NAME = lOGIN_NAME;
	}

	public long generateAccountNo() {
		long AccountNo = (long) (Math.random() * ((1000000000 - 99000) + 99000)) + 99000;
		return AccountNo;
	}

}
