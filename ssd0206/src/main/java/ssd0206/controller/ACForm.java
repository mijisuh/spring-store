package ssd0206.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import ssd0206.domain.ACItem;

public class ACForm {
	private String catName;
	@NotEmpty
	private String name;
	private String desc;
	private String attr1;
	private String attr2;
	private String attr3;	
	@NotEmpty 
	private String acTime; 
	@Min(500)
	private int minPrice;
	private String suppName;
	private Date regTime;
	private String imgFile;
	
	
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
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
	public String getAcTime() {
		return acTime;
	}
	public void setAcTime(String acTime) {
		this.acTime = acTime;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	
	public ACForm(String suppName) {
		this.suppName = suppName;
	}
	public ACForm(ACItem acItem) {
		
		DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (acItem != null) {
			catName = acItem.getCatName();  
			name = acItem.getName();
			desc = acItem.getDesc();
			acTime = fm.format(acItem.getAcTime());
			attr1 = acItem.getAttr1();
			attr2 = acItem.getAttr2();
			attr3 = acItem.getAttr3();
			regTime= acItem.getRegTime();
			minPrice = acItem.getMinPrice();
			suppName = acItem.getSuppName();
			imgFile = acItem.getImgFile();
			
		}
	}

	
	public ACForm() {} 
	

}
