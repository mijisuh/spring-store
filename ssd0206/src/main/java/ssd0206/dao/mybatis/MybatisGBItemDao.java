package ssd0206.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.GBItemDao;
import ssd0206.dao.mybatis.mapper.GBItemMapper;
import ssd0206.domain.GBItem;

@Repository
public class MybatisGBItemDao implements GBItemDao {
	@Autowired
	GBItemMapper gbItemMapper;

	@Override
	public GBItem getGBItem(int gbItemId) {
		return gbItemMapper.getGBItem(gbItemId);
	}

	@Override
	public void insertGBItem(GBItem gbItem) {
		gbItemMapper.insertGBItem(gbItem);
	}

	@Override
	public void updateGBItem(GBItem gbItem) {
		gbItemMapper.updateGBItem(gbItem);
	}

	@Override
	public void deleteGBItem(int gbItemId) {
		gbItemMapper.deleteGBItem(gbItemId);
	}

	@Override
	public void updateGBItemState(GBItem gbItem) {
		gbItemMapper.updateGBItemState(gbItem);
	}	
	
	public List<GBItem> getGBItemList() {
		return gbItemMapper.getGBItemList();
	}
	
	public List<GBItem> getGBItemListByCatId(int catId) {
		return gbItemMapper.getGBItemListByCatId(catId);
	}

	@Override
	public void updateGBItem(int gbItemId) {
		// TODO Auto-generated method stub
		
	}
	
	public List<GBItem> getGBItemByKeyword(String keyword) {
		return gbItemMapper.getGBItemByKeyword("%" + keyword +"%");
	}
	
	public List<GBItem> getGBItemBySuppId(int userId) {
		return gbItemMapper.getGBItemBySuppId(userId);
	}
}