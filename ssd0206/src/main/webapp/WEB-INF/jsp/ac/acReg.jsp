<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="ssd0206.domain.ItemCat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<div align="center">
		<form:form modelAttribute="acForm" method="post" action="acRegConfirm.do">
		
		<table class="n13">
		<tr>
      		<td colspan="2">
    	</tr>
    	<tr>
		 <td>판매자ID:</td>
		 <td><form:input path="suppName" value="${acForm.getSuppName()}"/></td>
		</tr>
		 
		<tr>
		 <td>경매품 종류:</td>
		 <td><form:select path="catName" items="${ItemCat}" /></td>		 
  		</tr>
		
		<tr>
		 <td>경매품명:</td>
		 <td><form:input path="name"/>
		 <form:errors path="name" /></td>		 
  		</tr>
		
		<tr>
		 <td>설명:</td>
		 <td><form:input path="desc"/></td>		 
  		</tr>
		
		<tr>
		 <td>경매가:</td>
		 <td><form:input path="minPrice"/>
		 <form:errors path="minPrice" /></td>		 
  		</tr>
		
		<tr>
		 <td>경매시각:</td>
		 <td><form:input path="acTime"/>
		 <form:errors path="acTime" /></td>		 
  		</tr>
		
		<tr>
		 <td>추가속성1:</td>
		 <td><form:input path="attr1"/></td>		 
  		</tr>
			
		<tr>
		 <td>추가속성2:</td>
		 <td><form:input path="attr2"/></td>		 
  		</tr>
  		
		<tr>
		 <td>추가속성3:</td>
		 <td><form:input path="attr3"/></td>		 
  		</tr>
		
		<tr>
		 <td>이미지:</td>
		 <td><form:input path="imgFile"/></td>		 
  		</tr>
		
	</table>
  <p>
    <input type="image" src="<c:url value='/images/button_submit.gif' />">
  </p>
</form:form>
</div>