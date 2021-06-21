package ssd0206.dao;

import java.util.List;

import ssd0206.domain.ACItem;
import ssd0206.domain.ACOrder;



public interface ACItemDao {


	void insertAcItem(ACItem acItem);

	void updateAcItem(ACItem acItem); 

	void deleteAcItem(int acItemId); 
	
	void updateAcPrice(int asbPrice, int acItemId); 
	
	
	ACItem getACItem(int acItemId); 
	
	void closeEvent(int acItemId);
	
	
	
	
	List<ACItem> getACItemList();
	
	List<ACItem> getACItemListByCatId(int catId);
		
	List<ACOrder>getACOrder(int userId);
	
	
	List<ACItem> getACItemByKeyword(String keyword);
	
	List<ACItem> getACItemBySuppId(int userId);
	
}
