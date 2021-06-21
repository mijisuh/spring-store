package ssd0206.dao.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import ssd0206.domain.ACItem;
import ssd0206.domain.ACOrder;
import ssd0206.domain.Bid;

public interface ACItemMapper {
	
	
	void insertAcItem(ACItem acItem);
		
	void updateAcItem(ACItem acItem); 
	
	void deleteAcItem(int acItem); 
		
	ACItem getItem(int acItemId); 
	
	List<ACItem> getACItemList();
	
	List<ACItem> getACItemListByCatId(int catId);
	
	List<ACOrder> getACOrder(int userId);
	
	void closeEvent(int acItemId);

	void updateAcPrice(int asbPrice, int acItemId);
	
	List<ACItem> getACItemByKeyword(String keyword);
	
	List<ACItem> getACItemBySuppId(int userId);
}
