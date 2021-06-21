package ssd0206.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.InterestDao;
import ssd0206.dao.mybatis.mapper.InterestMapper;
import ssd0206.domain.Interest;

@Repository
public class MybatisInterestDao implements InterestDao {
	
	@Autowired
	private InterestMapper interestMapper;
	
	public int insertInterestAC(int itemId, int userId) throws DataAccessException {
		return interestMapper.insertInterestAC(itemId, userId);
	}
	
	public void deleteInterestAC(int itemId, int userId) throws DataAccessException {
		interestMapper.deleteInterestAC(itemId, userId);
	}
	
	public List<Interest> getInterestACs(int userId) throws DataAccessException {
		return interestMapper.getInterestACs(userId);
	}
	
	public int insertInterestGB(int itemId, int userId) throws DataAccessException {
		return interestMapper.insertInterestGB(itemId, userId);
	}
	
	public void deleteInterestGB(int itemId, int userId) throws DataAccessException {
		interestMapper.deleteInterestGB(itemId, userId);
	}
	
	public List<Interest> getInterestGBs(int userId) throws DataAccessException {
		return interestMapper.getInterestGBs(userId);
	}

}
