package ssd0206.controller;

public class BidForm {
	
	private String ACItemId;
	private String bidPrice;
	private int UserId;
	
	
	public String getACItemId() {
		return ACItemId;
	}
	public void setACItemId(String aCItemId) {
		ACItemId = aCItemId;
	}
	public String getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	
	
	
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public BidForm(String aCItemId, String bidPrice) {
		ACItemId = aCItemId;
		this.bidPrice = bidPrice;}

	public BidForm(String aCItemId) {
		ACItemId = aCItemId;}
	
	
	
	public BidForm(String aCItemId, String bidPrice, int userId) {
		ACItemId = aCItemId;
		this.bidPrice = bidPrice;
		UserId = userId;
	}
	public BidForm(int userId) {
		UserId = userId;
	}
	public BidForm() {}

}
