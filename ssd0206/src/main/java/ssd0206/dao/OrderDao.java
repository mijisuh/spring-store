package ssd0206.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ssd0206.domain.Order;

public interface OrderDao {

  List<Order> getOrdersByUsername(String username) throws DataAccessException;

  Order getOrder(int orderId) throws DataAccessException;

  void insertOrder(Order order) throws DataAccessException;

  Order removeOrder(int orderId);

}
