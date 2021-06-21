package ssd0206.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.SalesItemDao;
import ssd0206.dao.mybatis.mapper.SalesItemMapper;
import ssd0206.domain.SalesItem;
import ssd0206.domain.LineItem;
import ssd0206.domain.Order;

@Repository
public class MybatisSalesItemDao implements SalesItemDao {
	@Autowired
	private SalesItemMapper itemMapper;
	
	public void updateQuantity(Order order) throws DataAccessException {
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			int itemId = lineItem.getItemId();
			Integer increment = new Integer(lineItem.getQuantity());
			Map<String, Object> param = new HashMap<String, Object>(2);
			param.put("itemId", itemId);
			param.put("increment", increment);
			itemMapper.updateInventoryQuantity(param);
		}
	}

	public boolean isItemInStock(int itemId) throws DataAccessException {
		return (itemMapper.getInventoryQuantity(itemId) > 0);
	}

	public List<SalesItem> getSalesItemList() 
			throws DataAccessException {
		return itemMapper.getSalesItemList();
	}

	@Override
	public SalesItem getItem(int itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}
	
	public List<SalesItem> getSalesItemListByCatId(int catId) throws DataAccessException {
		return itemMapper.getSalesItemListByCatId(catId);
	}

	@Override
	public void insertSalesItem(SalesItem item) {
		itemMapper.insertSalesItem(item);
	}

	@Override
	public void updateSalesItem(SalesItem item) {
		itemMapper.updateSalesItem(item);
	}

	@Override
	public void deleteSalesItem(int itemId) {
		itemMapper.deleteSalesItem(itemId);
	}
	
	public List<SalesItem> getSalesItemByKeyword(String keyword) {
		return itemMapper.getSalesItemByKeyword("%" + keyword + "%");
	}
	
	public List<SalesItem> getSalesItemBySuppId(int userId) {
		return itemMapper.getSalesItemBySuppId(userId);
	}
}
