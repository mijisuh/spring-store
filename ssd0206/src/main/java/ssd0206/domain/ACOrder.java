package ssd0206.domain;

public class ACOrder {

	private int userId;
	private int acItemId;
	private int BidId;
	private int acPrice;
	private String name;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAcItemId() {
		return acItemId;
	}
	public void setAcItemId(int acItemId) {
		this.acItemId = acItemId;
	}
	public int getBidId() {
		return BidId;
	}
	public void setBidId(int bidId) {
		BidId = bidId;
	}
	public int getAcPrice() {
		return acPrice;
	}
	public void setAcPrice(int acPrice) {
		this.acPrice = acPrice;
	
	}
	
	
	public ACOrder(int userId, int acItemId, int bidId, int acPrice, String name) {
	
		this.userId = userId;
		this.acItemId = acItemId;
		BidId = bidId;
		this.acPrice = acPrice;
		this.name = name;
	}


	public ACOrder() {}
	


}
