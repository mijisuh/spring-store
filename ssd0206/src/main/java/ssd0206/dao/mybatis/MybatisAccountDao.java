package ssd0206.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.AccountDao;
import ssd0206.dao.mybatis.mapper.AccountMapper;
import ssd0206.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccount(int userId) throws DataAccessException {
		return accountMapper.getAccountByUserId(userId);
	}

	public Account getAccount(String username, String password) 
			throws DataAccessException {
		return accountMapper.getAccountByAccountNameAndPassword(username, password);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
	}
	
	public void deleteAccountByUserId(String userId) throws DataAccessException {
		accountMapper.deleteAccountByUserId(userId);
	}
 
	public List<Account> getAccountList() throws DataAccessException {
		return accountMapper.getAccountList();
	}
}