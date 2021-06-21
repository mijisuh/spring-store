package ssd0206.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.CategoryDao;
import ssd0206.dao.mybatis.mapper.CategoryMapper;
import ssd0206.domain.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getCategoryList(int dealId) throws DataAccessException {
		return categoryMapper.getCategoryList(dealId);
	}
	
	public List<Category> getCategoryListByDealName(String dealName) throws DataAccessException {
		return categoryMapper.getCategoryListByDealName(dealName);
	}

	public Category getCategory(int dealId, String catId) throws DataAccessException {
		return categoryMapper.getCategory(dealId, catId);
	}
}
