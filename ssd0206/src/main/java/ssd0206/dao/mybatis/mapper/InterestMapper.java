package ssd0206.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssd0206.domain.Interest;

public interface InterestMapper {
	
	int insertInterestAC(@Param("itemId") int itemId, @Param("userId") int userId);
	
	void deleteInterestAC(int itemId, int userId);
	
	List<Interest> getInterestACs(int userId);
	
	int insertInterestGB(@Param("itemId") int itemId, @Param("userId") int userId);
	
	void deleteInterestGB(int itemId, int userId);
	
	List<Interest> getInterestGBs(int userId);

}
