package onlineWallet;

import java.util.List;
import java.util.Map;

public class WalletserviceImpl implements WalletService {

	WalletRepo repo;

	public WalletserviceImpl() {
		repo = new WalletRepoImp();
	}

	public WalletserviceImpl(Map<String, Customer> data) {
		super();
	}

	public boolean isValidName(String name) {
		if (((name != null) && name.matches("[A-Z][a-z]+"))) {
			return true;
		} else {
			throw new InvalidInputException(" : Name cannot be NULL (or) INVALID Name.");
		}
	}

	public boolean validAmount(double amount) {
		if (amount > 0) {
			return true;
		} else {
			throw new InvalidInputException(" : Amount cannot be NEGATIVE.");
		}
	}

	@Override
	public Customer createAccount(String ACCOUNT_HOLDER_NAME, String PANCARD_NO, String BANK_NAME,double amount) throws InvalidInputException {
		if (isValidName(ACCOUNT_HOLDER_NAME) && validAmount(amount)) {
			if (repo.findOne(PANCARD_NO) != null) {
				throw new InvalidInputException(
						" : Account linked to the Entered PAN Number ALREADY EXISTS: Please try again.\n");
			} else {
				Wallet w = new Wallet(amount);
				Customer c = new Customer(ACCOUNT_HOLDER_NAME, PANCARD_NO, BANK_NAME, w);
				boolean flag = repo.createTransactionsList(PANCARD_NO, c);
				boolean flag1 = repo.save(c);
				if (flag && flag1) {
					return c;
				} else {
					throw new InvalidInputException(" : Try at a later time. Thank you.\n");
				}
			}
		} else {
			throw new InvalidInputException(" : INVALID Input : ");
		}
	}

	@Override
	public Customer showBalance(String PANCARD_NO) throws InvalidInputException {

		if (repo.findOne(PANCARD_NO) == null) {
			throw new InvalidInputException(" : A/C with Entered Pan card Does NOT EXIST: Please try again. \n");
		} else {
			String log = new java.util.Date() + "\tViewed Balance.";
			repo.saveTransactions(PANCARD_NO, log);
			return repo.findOne(PANCARD_NO);
		}

	}

	@Override
	public Customer fundTransfer(String sourcePANCARD_NO, String targetPANCARD_NO, double amount)
			throws InvalidInputException, InsufficientBalanceException {
		if (validAmount(amount)) {
			if (repo.findOne(sourcePANCARD_NO) != null) {
				if (repo.findOne(targetPANCARD_NO) != null) {
					double b = repo.findOne(sourcePANCARD_NO).getWallet().getBalance();
					double c = repo.findOne(targetPANCARD_NO).getWallet().getBalance();
					if (b - amount > 0) {
						b = b - amount;
						repo.findOne(sourcePANCARD_NO).getWallet().setBalance(b);
						String log1 = new java.util.Date() + "\tAmount of" + amount
								+ " Debited from A/C towards A/C linked with PAN card Number" + sourcePANCARD_NO
								+ ". Balance in A/C : " + b;
						repo.saveTransactions(sourcePANCARD_NO, log1);
						c = c + amount;
						repo.findOne(targetPANCARD_NO).getWallet().setBalance(c);
						String log2 = new java.util.Date() + "\tAmount of" + amount
								+ " Credited to A/C from A/C linked with PAN card Number" + targetPANCARD_NO
								+ ". Balance in A/C : " + c;
						repo.saveTransactions(targetPANCARD_NO, log2);
						return repo.findOne(sourcePANCARD_NO);
					} else {
						throw new InsufficientBalanceException(
								" : Insufficient Balance : Please Check Balance and Try Again. Thanks.\n");
					}
				} else {
					throw new InvalidInputException(" : A/C with Entered Recipient PAN CARD Number Does NOT EXIST : \n");
				}
			} else {
				throw new InvalidInputException(" : A/C with Entered sender PAN CARD Number Does NOT EXIST : \n");
			}
		} else {
			throw new InvalidInputException(" : INVALID Input : ");
		}
	}

	@Override
	public Customer depositAmount(String PANCARD_NO, double amount) throws InvalidInputException {
		if (validAmount(amount)) {
			if (repo.findOne(PANCARD_NO) != null) {
				double b = repo.findOne(PANCARD_NO).getWallet().getBalance();
				b = b+amount;
				repo.findOne(PANCARD_NO).getWallet().setBalance(b);
				String log = new java.util.Date() + "\tAmount of" + amount + " Credited to A/C. Balance in A/C : " + b;
				repo.saveTransactions(PANCARD_NO, log);
				return repo.findOne(PANCARD_NO);
			} else {
				throw new InvalidInputException(" : A/C with Entered PAN card Number Does NOT EXIST : \n");
			}
		} else {
			throw new InvalidInputException(" : INVALID Input : ");
		}
	}

	@Override
	public Customer withdrawAmount(String PANCARD_NO, double amount)
			throws InvalidInputException, InsufficientBalanceException {
		if (validAmount(amount)) {
			if (repo.findOne(PANCARD_NO) != null) {
				double b = repo.findOne(PANCARD_NO).getWallet().getBalance();
			
				if (b-amount>0) {
					b = b-amount;
					repo.findOne(PANCARD_NO).getWallet().setBalance(b);
					String log = new java.util.Date() + "\tAmount of" + amount + " Debited from A/C. Balance in A/C : " + b;
					repo.saveTransactions(PANCARD_NO, log);
					return repo.findOne(PANCARD_NO);
				} else {
					throw new InsufficientBalanceException(
							" : Insufficient Balance : Please Check Balance and Try Again. Thanks.\n");
				}
			} else {
				throw new InvalidInputException(" : A/C with Entered PAN CARD Number Does NOT EXIST : \n");
			}
		} else {
			throw new InvalidInputException(" : INVALID Input : ");
		}
	}

	@Override
	public List<String> transactions(String PANCARD_NO) throws InvalidInputException {
		if (repo.getList(PANCARD_NO) != null) {
			return repo.getList(PANCARD_NO);
		} else {
			throw new InvalidInputException(" : A/C with Entered PAN CARD Number Does NOT EXIST : \n");
		}
	}
	}


