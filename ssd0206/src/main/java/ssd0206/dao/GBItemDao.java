package ssd0206.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ssd0206.domain.GBItem;

public interface GBItemDao {
	GBItem getGBItem(int gbItemId) throws DataAccessException;
	void insertGBItem(GBItem gbItem) throws DataAccessException;
	void updateGBItem(GBItem gbItem) throws DataAccessException;
	void deleteGBItem(int gbItemId) throws DataAccessException; 
	void updateGBItemState(GBItem gbItem);
	List<GBItem> getGBItemList();
	List<GBItem> getGBItemListByCatId(int catId);
	void updateGBItem(int gbItemId);
	
	List<GBItem> getGBItemByKeyword(String keyword) throws DataAccessException; 
	
	List<GBItem> getGBItemBySuppId(int userId);
}