package ssd0206.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssd0206.dao.ACItemDao;
import ssd0206.dao.mybatis.mapper.ACItemMapper;
import ssd0206.domain.ACItem;
import ssd0206.domain.ACOrder;

@Repository
public class MyBatisACItemDao implements ACItemDao{

	@Autowired
	ACItemMapper acItemMapper;
	public void insertAcItem(ACItem acItem) {
		acItemMapper.insertAcItem(acItem);	}

	public void updateAcItem(ACItem acItem) {
		acItemMapper.updateAcItem(acItem);}


	public void deleteAcItem(int acItemId) {
		acItemMapper.deleteAcItem(acItemId);}


	public ACItem getACItem(int acItemId) {
		return acItemMapper.getItem(acItemId);}
	
	public void closeEvent(int acItemId) {
		acItemMapper.closeEvent(acItemId);
		
	}
	
	public void updateAcPrice(int asbPrice, int acItemId) {
		acItemMapper.updateAcPrice(asbPrice, acItemId);
		
	}	
	
	public List<ACItem> getACItemList() {
		return acItemMapper.getACItemList();
	}
	
	public List<ACItem> getACItemListByCatId(int catId) {
		return acItemMapper.getACItemListByCatId(catId);
	}
	
	public List<ACOrder>getACOrder(int userId){
		return acItemMapper.getACOrder(userId);
	}

	
	public List<ACItem> getACItemByKeyword(String keyword) {
		return acItemMapper.getACItemByKeyword("%" + keyword + "%");
	}
	public List<ACItem> getACItemBySuppId(int userId) {
		return acItemMapper.getACItemBySuppId(userId);
	}


}
