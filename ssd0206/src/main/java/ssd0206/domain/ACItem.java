package ssd0206.domain;

import java.util.Date;

public class ACItem {
	
	private int acItemId;
	private int minPrice;
	private String suppName;
	private String status;
	private Date acTime;
	private String attr1;
	private String attr2;
	private String attr3;
	private int imgId;
	private String name;
	private String desc;
	private Date regTime;
	private String catName;
	private String imgFile;


	//»ç¿ë ACITEM
	public ACItem(String suppName, String name, String desc, String status, Date acTime, int minPrice,
			String attr1, String attr2, String attr3, Date regTime, String catName, String imgFile) {
			
		this.suppName = suppName;
		this.name = name;
		this.desc = desc;
		this.status = status;
		this.acTime = acTime;
		this.minPrice = minPrice;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.regTime = regTime;
		this.catName = catName;
		this.imgFile = imgFile;

		}


	public ACItem() {}
	

	public String getImgFile() {
		return imgFile;
	}


	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	
	
	public Date getRegTime() {
		return regTime;
		}
	
	public String getCatName() {
		return catName;
	}



	public void setCatName(String catName) {
		this.catName = catName;
	}



	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	
	}

	
	public int getAcItemId() {
		return acItemId;
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
	public void setAcItemId(int acItemId) {
		this.acItemId = acItemId;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public Date getAcTime() {
		return acTime;
	}
	public void setAcTime(Date acTime) {
		this.acTime = acTime;
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
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	

	
	

}
