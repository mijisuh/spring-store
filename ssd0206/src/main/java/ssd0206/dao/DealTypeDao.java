package ssd0206.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ssd0206.domain.DealType;

public interface DealTypeDao {
	
	DealType getDealType() throws DataAccessException;
	
	List<DealType> getDealTypeList() throws DataAccessException;
	
}
