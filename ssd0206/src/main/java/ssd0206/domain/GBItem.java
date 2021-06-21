package ssd0206.domain;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class GBItem {
  /* Private Fields */
  private int itemId;
  private double listPrice;
  private double discountrate;
  private int minNum;
  private int finalQuantity;
  private Date period;
  private String suppname;
  private String status;
  private double fianlPrice;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private int imgId;
  private String catName;
  private int catId;
  private String name;
  private String description;
  private int dealId;
	
  public GBItem(String name, double listPrice, String attribute1, String attribute2, String attribute3, String catName,
		String description) {
	  this.name = name;
	  this.listPrice = listPrice;
	  this.attribute1 = attribute1;
	  this.attribute2 = attribute2;
	  this.attribute3 = attribute3;
	  this.catName = catName;
	  this.description = description;
}
  

  public int getMinNum() {
	return minNum;
}


public void setMinNum(int minNum) {
	this.minNum = minNum;
}


public String getSuppname() {
	return suppname;
}


public void setSuppname(String suppname) {
	this.suppname = suppname;
}


public double getListPrice() { return listPrice; }
  public void setListPrice(double listPrice) { this.listPrice = listPrice; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }

  public String getAttribute1() { return attribute1; }
  public void setAttribute1(String attribute1) { this.attribute1 = attribute1; }
  
  public String getAttribute2() { return attribute2; }
  public void setAttribute2(String attribute2) { this.attribute2 = attribute2; }
  
  public String getAttribute3() { return attribute3; }
  public void setAttribute3(String attribute3) { this.attribute3 = attribute3; }

  public double getDiscountrate() {	return discountrate; }
  public void setDiscountrate(double discountrate) { this.discountrate = discountrate; }
   
  public int getMinnum() { return minNum; }
  public void setMinnum(int minNum) { this.minNum = minNum; } 
   
  public Date getPeriod() { return period; }
  public void setPeriod(Date period) { this.period = period; }
 
  public int getFinalQuantity() { return finalQuantity; }
  public void setFinalQuantity(int finalQuantity) { this.finalQuantity = finalQuantity; }
  
  public double getFianlPrice() { return fianlPrice; }
  public void setFianlPrice(double fianlPrice) { this.fianlPrice = fianlPrice; } 
  public int getImgId() { return imgId; }
  public void setImgId(int imgId) { this.imgId = imgId; }

  public String getName() {	return name; }
  public void setName(String name) { this.name = name; }
  
  public String getCatName() {	return catName; }
  public void setCatName(String catName) {	this.catName = catName; }
  public int getCatId() { return catId; }
  public void setCatId(int catId) { this.catId = catId; }
public int getDealId() {
	return dealId;
}
public void setDealId(int dealId) {
	this.dealId = dealId;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
}