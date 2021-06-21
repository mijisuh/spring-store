package ssd0206.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import ssd0206.domain.Account;

public interface AccountDao {

  Account getAccount(int userId) throws DataAccessException;

  Account getAccount(String accountName, String password) throws DataAccessException;

  void insertAccount(Account account) throws DataAccessException;

  void updateAccount(Account account) throws DataAccessException;
  
  void deleteAccountByUserId(String userId) throws DataAccessException;

  List<Account> getAccountList() throws DataAccessException;

}
