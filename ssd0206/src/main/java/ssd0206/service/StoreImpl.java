package ssd0206.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssd0206.controller.ACForm;
import ssd0206.controller.BidForm;
import ssd0206.controller.GBForm;
import ssd0206.controller.SalesForm;
import ssd0206.dao.ACItemDao;
import ssd0206.dao.AccountDao;
import ssd0206.dao.BidDao;
import ssd0206.dao.CategoryDao;
import ssd0206.dao.DealTypeDao;
import ssd0206.dao.GBItemDao;
import ssd0206.dao.InterestDao;
import ssd0206.dao.OrderDao;
import ssd0206.domain.ACItem;
import ssd0206.domain.ACOrder;
import ssd0206.domain.Account;
import ssd0206.domain.Bid;
import ssd0206.domain.Card;
import ssd0206.domain.Category;
import ssd0206.domain.DealType;
import ssd0206.domain.GBItem;
import ssd0206.domain.Interest;
import ssd0206.domain.Order;
import ssd0206.domain.Product;
import ssd0206.domain.SalesItem;
import ssd0206.dao.SalesItemDao;

@Service
@Transactional
public class StoreImpl implements StoreFacade {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private DealTypeDao dealTypeDao;
	
	@Autowired
	private InterestDao interestDao;
	
	@Autowired
	private ACItemDao acItemDao;
	
	@Autowired
	private BidDao bidDao;	

	@Autowired
	private ThreadPoolTaskScheduler scheduler;

	@Autowired
	private SalesItemDao salesItemDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private GBItemDao gbItemDao;

	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------

	public Account getAccount(int userId) {
		return accountDao.getAccount(userId);
	}

	public Account getAccount(String accountNme, String password) {
		return accountDao.getAccount(accountNme, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}
	
	public void deleteAccountByUserId(String userId) {
		accountDao.deleteAccountByUserId(userId);
	}

	public List<Account> getAccountList() {
		return accountDao.getAccountList();
	}

	public List<Category> getCategoryList(int dealId) {
		return categoryDao.getCategoryList(dealId);
	}
	
	public List<Category> getCategoryListByDealName(String dealName) {
		return categoryDao.getCategoryListByDealName(dealName);
	}

	public Category getCategory(int dealId, String catId) {
		return categoryDao.getCategory(dealId, catId);
	}

	public DealType getDealType() {
		return dealTypeDao.getDealType();
	}
	
	public List<DealType> getDealTypeList() {
		return dealTypeDao.getDealTypeList();
	}
	
	//wish list
	public int insertInterestAC(int itemId, int userId) {
		return interestDao.insertInterestAC(itemId, userId);
	}
	
	public void deleteInterestAC(int itemId, int userId) {
		interestDao.deleteInterestAC(itemId, userId);
	}
	
	public List<Interest> getInterestACs(int userId) {
		return interestDao.getInterestACs(userId);
	}
	
	public int insertInterestGB(int itemId, int userId) {
		return interestDao.insertInterestGB(itemId, userId);
	}
	
	public void deleteInterestGB(int itemId, int userId) {
		interestDao.deleteInterestGB(itemId, userId);
	}
	
	public List<Interest> getInterestGBs(int userId) {
		return interestDao.getInterestGBs(userId);
	}
	
	public boolean isRegisteredInterestAC(int itemId, int userId) {
		List<Interest> interestACs = getInterestACs(userId);
		
		for(Interest i : interestACs){
		    if (i.getItemId() == itemId)
		    	return true;
		}
		return false;
	}
	
	public boolean isRegisteredInterestGB(int itemId, int userId) {
		List<Interest> interestGBs = getInterestGBs(userId);
		
		for(Interest i : interestGBs){
		    if (i.getItemId() == itemId)
		    	return true;
		}
		return false;
	}
	
	// search
	public List<SalesItem> searchSalesItemByKeyword(String keyword) {
		return salesItemDao.getSalesItemByKeyword(keyword);
	}
	
	public List<ACItem> searchACItemByKeyword(String keyword) {
		return acItemDao.getACItemByKeyword(keyword);
	}
	
	public List<GBItem> searchGBItemByKeyword(String keyword) {
		return gbItemDao.getGBItemByKeyword(keyword);
	}
	
	// supplier
	public List<SalesItem> getSalesItemBySuppId(int userId) {
		return salesItemDao.getSalesItemBySuppId(userId);
	}
	
	public List<ACItem> getACItemBySuppId(int userId) {
		return acItemDao.getACItemBySuppId(userId);
	}
	
	public List<GBItem> getGBItemBySuppId(int userId) {
		return gbItemDao.getGBItemBySuppId(userId);
	}
	
//----------------寃쎈ℓ---------------------------------------

	public void insertAcItem(ACItem acItem) {
		acItemDao.insertAcItem(acItem);
	}
			
	public void updateAcItem(ACItem acItem) {
		acItemDao.updateAcItem(acItem);}
		
	public void deleteAcItem(int acItemId) {
		acItemDao.deleteAcItem(acItemId);}

	public ACItem getItem(int acItemId) {
		return acItemDao.getACItem(acItemId); 
	}
	
	public void updateAcPrice(int asbPrice, int acItemId) {
		acItemDao.updateAcPrice(asbPrice, acItemId);
	}
	
	public List<Bid> getBidsListByACItemId(int acItemId) throws DataAccessException {
		return bidDao.getBidsListByACItemId(acItemId);}


	public int getASBUserId(int acItemId, int asbPrice) {
		return bidDao.getASBUserId(acItemId, asbPrice);}
	
	public void insertBid(Bid bid) {
		bidDao.insertBid(bid);}
	

	public void ConfirmASB(int acItemId, int userId) {
		bidDao.ConfirmASB(acItemId, userId);}
	
	
	public Bid getBid(int acItemId) {
		return bidDao.getBid(acItemId);
	}
	
	public void insertACOrder(Bid bid) {
		bidDao.insertACOrder(bid);
		
	}
	
	public List<ACOrder> getACOrder(int userId) {
		
		return acItemDao.getACOrder(userId);
	}
	
	public List<ACItem> getACItemList() {
		return acItemDao.getACItemList();
	}
	
	public List<ACItem> getACItemListByCatId(int catId) {
		return acItemDao.getACItemListByCatId(catId);
	}
	
	
	
	
	public ACItem acItem(ACForm acForm) throws ParseException {
		
		DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ACItem acItem;
			acItem = new ACItem(
					acForm.getSuppName(),
					acForm.getName(), 
					acForm.getDesc(), 
					"경매 등록",
					fm.parse(acForm.getAcTime()),
					acForm.getMinPrice(), 
					acForm.getAttr1(), 
					acForm.getAttr2(),
					acForm.getAttr3(),
					new Date(), 
					acForm.getCatName(),
					acForm.getImgFile());

			return acItem;
	}
	
	public Bid bid(BidForm bidForm){
		Bid bid;

		bid = new Bid(
				Integer.parseInt(bidForm.getACItemId()),
				bidForm.getUserId(), //session, userId넣어 놓기
				0,
				Integer.parseInt(bidForm.getBidPrice()),
				new Date());
		
		insertBid(bid);
		return bid;
	}


	public void ACScheduler(Date ACTime, int acItemId) {
		
		Runnable updateTableRunner = new Runnable() {	
			public void run() {
				acItemDao.closeEvent(acItemId);
				
				List<Bid>bids=bidDao.getBidsListByACItemId(acItemId);
				
				int asbPrice= bids.get(0).getBidPrice();
				for(int i= 1; i<bids.size(); i++) {
					if(bids.get(i).getBidPrice() > asbPrice)
						asbPrice = bids.get(i).getBidPrice();
				}
			
				int userId= getASBUserId(acItemId, asbPrice);
				ConfirmASB(acItemId, userId);
				Bid bid = getBid(acItemId);
				insertACOrder(bid);
				
			
				updateAcPrice(asbPrice, acItemId);
			}
		};
		scheduler.schedule(updateTableRunner, ACTime);
	}

	
	//----------------寃쎈ℓ--------------------------------------	
	
	
	//SalesItem
			@Override
			public SalesItem getSalesItem(int itemId) {
				return salesItemDao.getItem(itemId);
			}

			@Override
			public List<SalesItem> getSalesItemList() {
				return salesItemDao.getSalesItemList();
			}
			
			public List<SalesItem> getSalesItemListByCatId(int catId) {
				return salesItemDao.getSalesItemListByCatId(catId);
			}
			
			public SalesItem salesItem(SalesForm salesForm) {
				
				SalesItem salesItem;
					salesItem = new SalesItem(
										salesForm.getName(), 
										salesForm.getListPrice(),
										salesForm.getListPrice(),
										salesForm.getSupplierId(),
										"판매중",
										salesForm.getAttr1(), 
										salesForm.getAttr2(),
										salesForm.getAttr3(),
										salesForm.getCatName(),
										salesForm.getDescription(),
										salesForm.getImgFileName()
										);
					
					insertSalesItem(salesItem);
					return salesItem;
			}
			
			@Override
			public void insertSalesItem(SalesItem item) {
				salesItemDao.insertSalesItem(item);
			}

			@Override
			public void updateSalesItem(SalesItem item) {
				salesItemDao.updateSalesItem(item);
			}

			@Override
			public void deleteSalesItem(int itemId) {
				salesItemDao.deleteSalesItem(itemId);
			}

			public boolean isItemInStock(int itemId) {
				return salesItemDao.isItemInStock(itemId);
			}

			public void insertOrder(Order order) {
				salesItemDao.updateQuantity(order);	    
				orderDao.insertOrder(order);
			}
			
			public Order getOrder(int orderId) {
				return orderDao.getOrder(orderId);
			}

			public List<Order> getOrdersByUsername(String username) {
				return orderDao.getOrdersByUsername(username);
			}

		
		// 공동구매
		@Override
		public GBItem getGBItem(int itemId) {
			return gbItemDao.getGBItem(itemId);
		}
		
		public GBItem gbItem(GBForm gbForm) {				
			GBItem gbItem;
			gbItem = new GBItem(
					gbForm.getName(), 
					gbForm.getListPrice(), 
					gbForm.getAttribute1(), 
					gbForm.getAttribute2(),
					gbForm.getAttribute3(),
					gbForm.getCatName(),
					gbForm.getDesc());
			insertGBItem(gbItem);
			return gbItem;
		}
		@Override
		public void insertGBItem(GBItem item) {
			gbItemDao.insertGBItem(item);
		}

		@Override
		public void updateGBItem(GBItem item) {
			gbItemDao.updateGBItem(item);
		}

		@Override
		public void deleteGBItem(int itemId) {
			gbItemDao.deleteGBItem(itemId);
		}

		@Override
		public void updateGBItemState(GBItem gbItem) {
			gbItemDao.updateGBItem(gbItem);
		}

		@Override
		public void updateGBItemState(int itemId) {
			gbItemDao.updateGBItem(itemId);
		}
		public List<GBItem> getGBItemList() {
			return gbItemDao.getGBItemList();
		}
		
		public List<GBItem> getGBItemListByCatId(int catId) {
			return gbItemDao.getGBItemListByCatId(catId);
		}

		@Override
		public List<GBItem> getGBItemList(int itemId) {
			return gbItemDao.getGBItemListByCatId(itemId);
		}
}