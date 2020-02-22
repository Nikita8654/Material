package onlineWallet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WalletRepoImp implements WalletRepo {

	private static Map<String, Customer> accounts = new HashMap<String, Customer>();
	private static Map<String, List<String>> transactions = new HashMap<String, List<String>>();
	private List<String> list;
	
	public WalletRepoImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WalletRepoImp(List<String> list, Map<String, Customer> accounts, Map<String, List<String>> transactions) {
		super();
		WalletRepoImp.accounts = accounts;
		WalletRepoImp.transactions = transactions;
		this.list = list;
	}

	@Override
	public boolean save(Customer customer) {
		accounts.put(customer.getPANCARD_NO(), customer);
		return true;
	}

	@Override
	public Customer findOne(String PANCARD_NO) {
		if (accounts.containsKey(PANCARD_NO)) {
			return accounts.get(PANCARD_NO);
		} else
			return null;
	}

	@Override
	public boolean createTransactionsList(String PANCARD_NO, Customer customer) {

		list = new LinkedList<String>();
		list.add(new java.util.Date() + "\tAccount Created Sucessfully");
		transactions.put(PANCARD_NO, list);
		return true;
	}

	@Override
	public boolean saveTransactions(String PANCARD_NO, String log) {
		if (transactions.get(PANCARD_NO).add(log))
			return true;
		else
			return false;
	}

	@Override
	public List<String> getList(String PANCARD_NO) {
		if (transactions.containsKey(PANCARD_NO))
			return transactions.get(PANCARD_NO);
		else
			return null;
	}

	

}
