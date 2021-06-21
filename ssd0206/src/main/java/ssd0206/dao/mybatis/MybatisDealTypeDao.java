package ssd0206.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ssd0206.dao.DealTypeDao;
import ssd0206.dao.mybatis.mapper.DealTypeMapper;
import ssd0206.domain.DealType;

@Repository
public class MybatisDealTypeDao implements DealTypeDao {

	@Autowired
	private DealTypeMapper dealTypeMapper;
	
	public DealType getDealType() throws DataAccessException {
		return dealTypeMapper.getDealType();
	}
	
	public List<DealType> getDealTypeList() throws DataAccessException {
		return dealTypeMapper.getDealTypeList();
	}
	
}
