package ssd0206.dao.mybatis.mapper;

import java.util.List;

import ssd0206.domain.DealType;

public interface DealTypeMapper {
	
	DealType getDealType();
	
	List<DealType> getDealTypeList();

}
