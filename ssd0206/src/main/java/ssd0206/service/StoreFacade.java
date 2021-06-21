package ssd0206.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import ssd0206.controller.ACForm;
import ssd0206.controller.BidForm;
import ssd0206.controller.GBForm;
import ssd0206.controller.SalesForm;
import ssd0206.domain.ACItem;
import ssd0206.domain.ACOrder;
import ssd0206.domain.Account;
import ssd0206.domain.Bid;
import ssd0206.domain.Category;
import ssd0206.domain.DealType;
import ssd0206.domain.GBItem;
import ssd0206.domain.Interest;
import ssd0206.domain.Order;
import ssd0206.domain.Product;
import ssd0206.domain.SalesItem;

public interface StoreFacade {

	Account getAccount(int userId);

	Account getAccount(String accountName, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	void deleteAccountByUserId(String userId);

	List<Account> getAccountList();

	List<Category> getCategoryList(int dealId);
	
	List<Category> getCategoryListByDealName(String dealName);

	Category getCategory(int dealId, String catId);
	
	DealType getDealType();
	
	List<DealType> getDealTypeList();
	
//  SalesItem 
	SalesItem getSalesItem(int itemId);	
		
	List<SalesItem> getSalesItemList();	
	
	List<SalesItem> getSalesItemListByCatId(int catId);
	
	void insertSalesItem(SalesItem item);	
	
	void updateSalesItem(SalesItem item);	
	
	void deleteSalesItem(int itemId);	
	
	SalesItem salesItem(SalesForm salesForm);
	
	// 二쇰Ц
	boolean isItemInStock(int itemId);

	void insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);

	// wish list
	int insertInterestAC(int itemId, int userId);
	void deleteInterestAC(int itemId, int userId);
	List<Interest> getInterestACs(int userId);
	
	int insertInterestGB(int itemId, int userId);
	void deleteInterestGB(int itemId, int userId);
	List<Interest> getInterestGBs(int userId);
	
	boolean isRegisteredInterestAC(int itemId, int userId);
	boolean isRegisteredInterestGB(int itemId, int userId);
	
	// search
	List<SalesItem> searchSalesItemByKeyword(String keyword);
	List<ACItem> searchACItemByKeyword(String keyword);
	List<GBItem> searchGBItemByKeyword(String keyword);
	
	// supplier
	List<SalesItem> getSalesItemBySuppId(int userId);
	List<ACItem> getACItemBySuppId(int userId);
	List<GBItem> getGBItemBySuppId(int userId);

//----------------경매----------------------------------------
	void insertAcItem(ACItem acItem);

	void updateAcItem(ACItem acItem); 

	void deleteAcItem(int acItemId); 
	
	ACItem getItem(int acItemId); 
	
	void updateAcPrice(int asbPrice, int acItemId);
	
	ACItem acItem(ACForm acForm) throws ParseException;
	
	Bid bid(BidForm bidForm);	
	
	List<Bid>getBidsListByACItemId(int acItemId)throws DataAccessException;
	
	void insertBid(Bid bid); 
	
	void ConfirmASB(int acItemId, int userId);
	
	List<ACItem> getACItemList();
	
	List<ACItem> getACItemListByCatId(int catId);
	
	void ACScheduler(Date ACTime, int acItemId);

	List<ACOrder> getACOrder(int userId);
	

//----------------경매------------------------------------------

	
	
	
	// 공동구매
	GBItem getGBItem(int gbitemId); 
	void insertGBItem(GBItem gbItem);
	void updateGBItem(GBItem gbItem); 
	void deleteGBItem(int gbItemId); 
	void updateGBItemState(int gbItemId);
	GBItem gbItem(GBForm gbForm) throws ParseException;
	void updateGBItemState(GBItem gbItem);
	List<GBItem> getGBItemList();
	
	List<GBItem> getGBItemListByCatId(int catId);
	
	List<GBItem> getGBItemList(int gbItemId);
}