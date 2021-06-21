package ssd0206.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import ssd0206.domain.SalesItem;

@SuppressWarnings("serial")
public class SalesForm implements Serializable {
private SalesItem salesItem;
	
	private String name;
	private int listPrice;
	private int supplierId;
	private String attr1;
	private String attr2;
	private String attr3;
	private String status;
	private String catName;
	private String description;
	private String imgFileName;
	
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public SalesForm(SalesItem salesItem) {
		name = salesItem.getName();
		listPrice = salesItem.getListPrice();
		supplierId = salesItem.getSupplierId();
		attr1 = salesItem.getAttribute1();
		attr2 = salesItem.getAttribute2();
		attr3 = salesItem.getAttribute3();
		catName = salesItem.getCatName();
		description = salesItem.getDescription();
		imgFileName = salesItem.getImgFileName();
	}
	
	public SalesForm() {}
	
	public SalesItem getSalesItem() {
		return salesItem;
	}
}
