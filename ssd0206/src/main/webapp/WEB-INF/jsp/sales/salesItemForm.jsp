<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
<form:form modelAttribute="salesForm" action="salesRegConfirm.do" method="post">
	<form:errors cssClass="error" /><br><br>
		 <table class="n13">
		   <tr>
		     <td colspan="2">
		       <font color="GREEN" size="4"><b>일반 판매 상품 등록</b></font></td>
		   </tr>
		   <tr>
		     <td>상품명:</td>
		     <td><form:input path="name" /></td>
		   </tr>
		   <tr>
		     <td>상품 가격:</td>
		     <td><form:input path="listPrice" /></td>
		   </tr>
		   <tr>
		     <td>판매자 ID:</td>
		     <td><form:input path="supplierId" /></td>
		   </tr>
		   <tr>
		     <td>속성1:</td>
		     <td><form:input path="attr1" /></td>
		   </tr>
		   <tr>
		     <td>속성2:</td>
		     <td><form:input path="attr2" /></td>
		   </tr>
		   <tr>
		     <td>속성3:</td>
		     <td><form:input path="attr3" /></td>
		   </tr>
		   <tr>
		     <td>상품 종류:</td>
		     <td><form:select path="catName" items="${ItemCat}"/></td>
		   </tr>
		   <tr>
		     <td>이미지:</td>
		     <td><form:input path="imgFileName" /></td>
		   </tr>
		   <tr>
		     <td>설명:</td>
		     <td><form:input path="description" /></td>
		   </tr>
		 </table>
		 <p>
		  
		   <input type="image" src="<c:url value='/images/button_submit.gif' />">
		 </p>
</form:form>
</div>