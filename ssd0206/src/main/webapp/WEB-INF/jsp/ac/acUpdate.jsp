<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="ssd0206.domain.ItemCat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<div align="center">
		<form:form modelAttribute="acUpdateForm" method="post" action="acUpdateDone.do">
		
		<table class="n13">
		<tr>
      		<td colspan="2">
    	</tr>
    	<tr>
		 <td>판매자ID:</td>
		 <td><form:input path="suppName" value="${acUpdateForm.getSuppName()}" /></td>
		</tr>
		 
		<tr>
		 <td>경매품 종류:</td>
		 <td><form:select path="catName" items="${ItemCat}" /></td>		 
  		</tr>
		
		<tr>
		 <td>경매품명:</td>
		 <td><form:input path="name" value="${acUpdateForm.getName()}"/></td>		 
  		</tr>
		
		<tr>
		 <td>설명:</td>
		 <td><form:input path="desc" value="${acUpdateForm.getDesc()}"/></td>		 
  		</tr>
		
		
		<tr>
		 <td>경매가:</td>
		 <td><form:input path="minPrice" value="${acUpdateForm.getMinPrice()}"/>
		 <form:errors path="minPrice" /></td>		 
  		</tr>
		
		<tr>
		 <td>경매시각:</td>
		 <td><form:input path="acTime" value="${acUpdateForm.getAcTime()}"/></td>		 
  		</tr>
		
		
		<tr>
		 <td>추가속성1:</td>
		 <td><form:input path="attr1" value="${acUpdateForm.getAttr1()}"/></td>		 
  		</tr>
		
			
		<tr>
		 <td>추가속성2:</td>
		 <td><form:input path="attr2" value="${acUpdateForm.getAttr2()}"/></td>		 
  		</tr>
  		
  			
		<tr>
		 <td>추가속성3:</td>
		 <td><form:input path="attr3" value="${acUpdateForm.getAttr3()}"/></td>		 
  		</tr>
		
		
		<tr>
		 <td>이미지:</td>
		 <td><form:input path="imgFile" value="${acUpdateForm.getImgFile()}"/></td>		 
  		</tr>
		
	</table>
  <p>
    <input type="image" src="../images/button_submit.gif">
  </p>
</form:form>
</div>
