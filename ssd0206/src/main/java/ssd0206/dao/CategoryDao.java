package ssd0206.dao;

import java.util.List;

import ssd0206.domain.Category;

public interface CategoryDao {
	
	List<Category> getCategoryList(int dealId);
	
	List<Category> getCategoryListByDealName(String dealName);
	
	Category getCategory(int dealId, String catId);
	
}
