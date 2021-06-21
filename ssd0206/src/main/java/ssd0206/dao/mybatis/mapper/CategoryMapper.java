package ssd0206.dao.mybatis.mapper;

import java.util.List;

import ssd0206.domain.Category;

public interface CategoryMapper { 
	
	List<Category> getCategoryList(int dealId);
	
	List<Category> getCategoryListByDealName(String dealName);
	
	Category getCategory(int dealId, String catId);
	
}
