package ssd0206.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

  /* Private Fields */

	private int product_id;
	private int deal_id;
	private int cat_id;
	private String name;
	private String description;
	
	//----------------경매--------------------------------------
	private ACItem acitem;
	//----------------경매---------------------------------------
  /* JavaBeans Properties */
	

	public int getProduct_id() {
		return product_id;
	}
		
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	
	
	
	
	//----------------경매---------------------------------------
	public ACItem getAcitem() {return acitem;}		
	public void setAcitem(ACItem acitem) {this.acitem = acitem;}
	//----------------경매---------------------------------------
	
	

  /* Public Methods*/

	public String toString() {
		return getName();
	}
}
