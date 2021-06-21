package ssd0206.service;

import java.util.List;
import ssd0206.domain.Order;

//@WebService(name = "OrderService") 
public interface OrderService {
	Order getOrder(int orderId);
	public List<Order> getOrdersByUsername(String username);
	public Order removeOrder(int orderId);
}