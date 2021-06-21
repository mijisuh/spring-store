package ssd0206.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineItem implements Serializable {

  /* Private Fields */

  private int orderId;
  private int lineNumber;
  private int quantity;
  private int itemId;
  
  private double unitPrice;
  private SalesItem item;

  /* Constructors */

  public LineItem() {}

  public LineItem(int lineNumber, CartItem cartItem) {
    this.lineNumber = lineNumber;
    this.quantity = cartItem.getQuantity();
    this.itemId = cartItem.getItem().getItemId();
    this.unitPrice = cartItem.getItem().getListPrice();
    this.item = cartItem.getItem();
  }

  /* JavaBeans Properties */

  public int getOrderId() { return orderId; }
  public void setOrderId(int orderId) { this.orderId = orderId; }

  public int getLineNumber() { return lineNumber; }
  public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }

  public int getItemId() { return itemId; }
  public void setItemId(int itemId) { this.itemId = itemId; }

  public double getUnitPrice() { return unitPrice; }
  public void setUnitPrice(double unitprice) { this.unitPrice = unitprice; }

  public SalesItem getItem() { return item; }
  public void setItem(SalesItem item) {
    this.item = item;
  }

  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalPrice() {
	return this.unitPrice * this.quantity;
  }
}
