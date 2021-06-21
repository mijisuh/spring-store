package ssd0206.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ssd0206.domain.Interest;

public interface InterestDao {
	
	int insertInterestAC(int itemId, int userId) throws DataAccessException;
	
	void deleteInterestAC(int itemId, int userId) throws DataAccessException;
	
	List<Interest> getInterestACs(int userId) throws DataAccessException;
	
	int insertInterestGB(int itemId, int userId) throws DataAccessException;
	
	void deleteInterestGB(int itemId, int userId) throws DataAccessException;
	
	List<Interest> getInterestGBs(int userId) throws DataAccessException;


}
