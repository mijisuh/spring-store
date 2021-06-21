package ssd0206.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import ssd0206.domain.SalesItem;

public interface SalesItemMapper {

  void updateInventoryQuantity(Map<String, Object> param);

  int getInventoryQuantity(int itemId);

  List<SalesItem> getSalesItemList();
  
  List<SalesItem> getSalesItemListByCatId(int catId);

  SalesItem getItem(int itemId);
  
  boolean isItemInStock(String itemId);
  
  void insertSalesItem(SalesItem item);
  
  void updateSalesItem(SalesItem item);
  
  void deleteSalesItem(int itemId);
  
  List<SalesItem> getSalesItemByKeyword(String keyword);
  
  List<SalesItem> getSalesItemBySuppId(int userId);
}
