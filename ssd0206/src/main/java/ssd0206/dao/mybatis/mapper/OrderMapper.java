package ssd0206.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import ssd0206.domain.Order;

public interface OrderMapper {

  List<Order> getOrdersByUsername(String username);

  Order getOrder(int orderId);
  
  void insertOrder(Order order);
  
  void insertOrderStatus(Order order);

  int msSqlServerInsertOrder(Order order);
  
  @Delete("delete from ORDERS where ORDERID = #{orderId}")
  void deleteOrder(int orderId);
  
  @Delete("delete from ORDERSTATUS where ORDERID = #{orderId}")
  void deleteOrderStatus(int orderId);
}
