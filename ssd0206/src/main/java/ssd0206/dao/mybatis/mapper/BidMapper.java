package ssd0206.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import ssd0206.domain.Card;
import ssd0206.domain.Account;
import ssd0206.domain.Bid;

public interface BidMapper {
	
	List<Bid>getBidsListByACItemId(int acItemId)throws DataAccessException;//입찰 신청자 리스트
		
	int getASBUserId(int acItemId, int asbPrice);
	
	Bid getBid(int acItemId, int userId);
	
	void insertBid(Bid bid); 

	void ConfirmASB(int acItemId, int userId);
	
	Bid getBid(int acItemId);
	
	void insertACOrder(Bid bid);
}