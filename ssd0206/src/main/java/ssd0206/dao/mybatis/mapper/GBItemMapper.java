/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ssd0206.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import ssd0206.domain.GBItem;

public interface GBItemMapper {
	GBItem getGBItem(int gbItemId);
	void insertGBItem(GBItem gbItemId);
	void updateGBItem(GBItem gbItemId);
	void deleteGBItem(int gbItem);

	void updateGBItemState(GBItem gbItem);	
	List<GBItem> getGBItemListByCatId(int catId);
	List<GBItem> getGBItemList();
	
	List<GBItem> getGBItemByKeyword(String keyword) throws DataAccessException; 
	
	List<GBItem> getGBItemBySuppId(int userId);
}