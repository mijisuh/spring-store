package ssd0206.dao.mybatis;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.BidDao;
import ssd0206.dao.mybatis.mapper.BidMapper;
import ssd0206.domain.Account;
import ssd0206.domain.Bid;
import ssd0206.domain.Card;

@Repository
public class MybaitsBidDao implements BidDao{

	@Autowired
	protected BidMapper bidMapper;
	
	public List<Bid>getBidsListByACItemId(int acItemId)throws DataAccessException
	//경매 아이템 Id를 조회한 해당 경매 아이템 입찰서 정보 리스트(SELECT)
	{
		return bidMapper.getBidsListByACItemId(acItemId);}
	
	
	public void insertBid(Bid bid)
	{
		bidMapper.insertBid(bid);}
	
	
	public int getASBUserId(int acItemId, int asbPrice) 
	{
		return bidMapper.getASBUserId(acItemId, asbPrice);}
	
	public void ConfirmASB(int acItemId, int userId) 
	{
		bidMapper.ConfirmASB(acItemId, userId);
	}
	
	public Bid getBid(int acItemId)
	
	{
		return bidMapper.getBid(acItemId);
	}
	

	public void insertACOrder(Bid bid) {
		bidMapper.insertACOrder(bid);
		
	}
	
	

}
