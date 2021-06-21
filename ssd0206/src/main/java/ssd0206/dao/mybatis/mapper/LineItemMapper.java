package ssd0206.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import ssd0206.domain.LineItem;

public interface LineItemMapper {

  List<LineItem> getLineItemsByOrderId(int orderId);

  void insertLineItem(LineItem lineItem);

  @Delete("delete from LINEITEM where ORDERID = #{orderId}")
  int deleteLineItems(int orderId);
}
