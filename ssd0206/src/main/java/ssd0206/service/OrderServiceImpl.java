package ssd0206.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssd0206.dao.OrderDao;
import ssd0206.domain.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public List<Order> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}
	
	public Order removeOrder(int orderId) {
		return orderDao.removeOrder(orderId);
	}
}