package onlineWallet;

import java.util.List;

public interface WalletService {

	public Customer createAccount(String ACCOUNT_HOLDER_NAME, String PANCARD_NO,String BANK_NAME, double amount) throws InvalidInputException;
	public Customer showBalance(String PANCARD_NO) throws InvalidInputException;
	public Customer fundTransfer(String sourcePANCARD_NO,String targetPANCARD_NO, double amount)
			throws InvalidInputException, InsufficientBalanceException;
	public Customer depositAmount(String PANCARD_NO, double amount) throws InvalidInputException;
	public Customer withdrawAmount(String PANCARD_NO, double amount)
			throws InvalidInputException, InsufficientBalanceException;
	public List<String> transactions(String PANCARD_NO) throws InvalidInputException;
}
