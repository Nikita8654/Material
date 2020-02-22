package onlineWallet;

import java.util.List;

public interface WalletRepo {

	public boolean save(Customer customer);
	public Customer findOne(String PANCARD_NO);
	public boolean createTransactionsList(String PANCARD_NO, Customer customer);
	public boolean saveTransactions(String PANCARD_NO, String log);
	public List<String> getList(String PANCARD_NO);
}
