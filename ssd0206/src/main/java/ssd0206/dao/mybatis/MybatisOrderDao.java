package ssd0206.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ssd0206.dao.OrderDao;
import ssd0206.dao.mybatis.mapper.LineItemMapper;
import ssd0206.dao.mybatis.mapper.OrderMapper;
import ssd0206.domain.LineItem;
import ssd0206.domain.Order;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	@Autowired
	protected LineItemMapper lineItemMapper;
	

	public List<Order> getOrdersByUsername(String username) 
			throws DataAccessException {
	    return orderMapper.getOrdersByUsername(username);
	}
	
	@Transactional
	public Order getOrder(int orderId) throws DataAccessException {
		Order order = orderMapper.getOrder(orderId);
		if (order != null) {
			order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
		}
	    return order;
	}
	
	@Transactional
	public void insertOrder(Order order) throws DataAccessException {  
		// use Oracle sequence in the definition of insertOrder query in OrderMapper.xml
			
		// order.setOrderId(sequenceDao.getNextId("ordernum"));
    	orderMapper.insertOrder(order);
    	orderMapper.insertOrderStatus(order);
    	for (int i = 0; i < order.getLineItems().size(); i++) {
    		LineItem lineItem = (LineItem) order.getLineItems().get(i);
    		lineItem.setOrderId(order.getOrderId());
    		lineItemMapper.insertLineItem(lineItem);
    	}
	}

	@Transactional
	public Order removeOrder(int orderId) {
		Order order = null;
		order = orderMapper.getOrder(orderId);
		if (order != null) {
			lineItemMapper.deleteLineItems(orderId);
			orderMapper.deleteOrderStatus(orderId);
			orderMapper.deleteOrder(orderId);
		}
		return order;
	}
}