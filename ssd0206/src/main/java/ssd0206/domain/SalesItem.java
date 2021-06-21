package ssd0206.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SalesItem implements Serializable {
  /* Private Fields */
  private int itemId;
  private int listPrice;
  private int unitPrice;
  private int supplierId;
  private String status;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String name;
  private String description;
  private String catName;
  private String imgFileName;
  
  public SalesItem(String name, int listPrice, String attribute1, String attribute2, String attribute3, 
		  String catName, String description) {
	super();
	this.name = name;
	this.listPrice = listPrice;
	this.attribute1 = attribute1;
	this.attribute2 = attribute2;
	this.attribute3 = attribute3;
	this.catName = catName;
	this.description = description;
  }

  public SalesItem() {
	 super();
  }
  
  public SalesItem(String name, int listPrice, int unitPrice, int supplierId, String status, String attribute1, String attribute2, String attribute3, 
		  String catName, String description, String imgFileName) {
	super();
	this.name = name;
	this.listPrice = listPrice;
	this.unitPrice = unitPrice;
	this.supplierId = supplierId;
	this.status = status;
	this.attribute1 = attribute1;
	this.attribute2 = attribute2;
	this.attribute3 = attribute3;
	this.catName = catName;
	this.description = description;
	this.imgFileName = imgFileName;
}

/* JavaBeans Properties */

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getListPrice() {
		return listPrice;
	}

	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	@Override
	public String toString() {
		return "SalesItem [itemId=" + itemId + ", listPrice=" + listPrice + ", unitPrice=" + unitPrice + ", supplierId="
				+ supplierId + ", status=" + status + ", attribute1=" + attribute1 + ", attribute2=" + attribute2
				+ ", attribute3=" + attribute3 + ", name=" + name + ", description=" + description + ", catName="
				+ catName + ", imgFileName=" + imgFileName + "]";
	}

	
	
	
}