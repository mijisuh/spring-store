  
package ssd0206.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ssd0206.domain.GBItem;

public class GBForm {

	private int itemId;
	private double listPrice;
	private double discountrate;
	private int minNum;
	private int finalQuantity;
	private Date period;
	private int supplierId;
	private String status;
	private double fianlPrice;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String imgFile;
	private String catName;
	private int catId;
	private String name;
	private String desc;
	private int dealId;

	public double getListPrice() {
		return listPrice;
	}
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	public double getDiscountrate() {
		return discountrate;
	}
	public void setDiscountrate(double discountrate) {
		this.discountrate = discountrate;
	}
	public int getMinNum() {
		return minNum;
	}
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	public int getFinalQuantity() {
		return finalQuantity;
	}
	public void setFinalQuantity(int finalQuantity) {
		this.finalQuantity = finalQuantity;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getFianlPrice() {
		return fianlPrice;
	}
	public void setFianlPrice(double fianlPrice) {
		this.fianlPrice = fianlPrice;
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
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
public GBForm(GBForm gbItem) {
		
		if (gbItem != null) {
			itemId = gbItem.getItemId();
			listPrice = gbItem.getListPrice();
			discountrate = gbItem.getDiscountrate();
			minNum = gbItem.getMinNum();
			finalQuantity = gbItem.getFinalQuantity();
			period = gbItem.getPeriod();
			supplierId = gbItem.getSupplierId();
			status = gbItem.getStatus();
			fianlPrice = gbItem.getFianlPrice();
			attribute1 = gbItem.getAttribute1();
			attribute2 = gbItem.getAttribute2();
			attribute3 = gbItem.getAttribute3();
			imgFile = gbItem.getImgFile();
			catName = gbItem.getCatName(); 
			catId = gbItem.getCatId(); 
			name = gbItem.getName();
			desc = gbItem.getDesc();
			dealId = gbItem.getDealId();			
		}
	}

	
	public GBForm() {}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	} 
	
}