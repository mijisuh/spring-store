package ssd0206.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ssd0206.domain.Order;
import ssd0206.domain.SalesItem;

public interface SalesItemDao {

  public void updateQuantity(Order order) throws DataAccessException;

  boolean isItemInStock(int itemId) throws DataAccessException;

  List<SalesItem> getSalesItemList() throws DataAccessException;
  
  List<SalesItem> getSalesItemListByCatId(int catId) throws DataAccessException;

  SalesItem getItem(int itemId) throws DataAccessException;

  public void insertSalesItem(SalesItem item);
  
  public void updateSalesItem(SalesItem item);
  
  public void deleteSalesItem(int itemId);
  
  public List<SalesItem> getSalesItemByKeyword(String keyword) throws DataAccessException;
  
  List<SalesItem> getSalesItemBySuppId(int userId);

}
