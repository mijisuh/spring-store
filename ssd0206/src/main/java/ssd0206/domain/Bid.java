
package ssd0206.domain;

import java.util.Date;

public class Bid {

	private int bidId;
	private int acItemId;
	private int userId;
	private int isASB;
	private int bidPrice;
	private Date bidTime;
	

	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getAcItemId() {
		return acItemId;
	}
	public void setAcItemId(int acItemId) {
		this.acItemId = acItemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getIsASB() {
		return isASB;
	}
	public void setIsASB(int isASB) {
		this.isASB = isASB;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}


	public Bid(int acItemId, int userId, int bidPrice, Date bidTime) {
		this.acItemId = acItemId;
		this.userId = userId;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
	}
	
	
	public Bid(int acItemId, int userId, int isASB, int bidPrice, Date bidTime) {
		this.acItemId = acItemId;
		this.userId = userId;
		this.isASB = isASB;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
	}

	public Bid() {}
	
}
