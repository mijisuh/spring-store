package ssd0206.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import ssd0206.domain.Account;
import ssd0206.domain.Bid;
import ssd0206.domain.Card;

public interface BidDao {
	
	List<Bid>getBidsListByACItemId(int acItemId)throws DataAccessException;
	
	void insertBid(Bid bid); 
	
	int getASBUserId(int acItemId, int asbPrice);
	
	Bid getBid(int acItemId);
	
	void ConfirmASB(int acItemId, int userId);

	void insertACOrder(Bid bid);
	
}
