<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="ssd0206.domain.ItemCat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
<form:form modelAttribute="salesForm" action="salesRegistered.do" method="post">
	<form:errors cssClass="error" /><br><br>
		 <table class="n13">
		   	<tr>
		     <td colspan="2">
		       <font color="GREEN" size="4"><b>일반 판매 상품 등록 확인</b></font></td>
		   	</tr>
 			<tr>
		     <td>상품명:</td>
		     <td>${salesForm.name}</td>
		   </tr>
		   <tr>
		     <td>상품 가격:</td>
		     <td>${salesForm.listPrice}</td>
		   </tr>
		   <tr>
		     <td>판매자 ID:</td>
		     <td><${salesForm.supplierId}</td>
		   </tr>
		   <tr>
		     <td>속성1:</td>
		     <td>${salesForm.attr1}</td>
		   </tr>
		   <tr>
		     <td>속성2:</td>
		     <td>${salesForm.attr2}</td>
		   </tr>
		   <tr>
		     <td>속성3:</td>
		     <td>${salesForm.attr3}</td>
		   </tr>
		   <tr>
		     <td>상품 종류:</td>
		     <td>${salesForm.catName}</td>
		   </tr>
		   <tr>
		     <td>설명:</td>
		     <td>${salesForm.description}</td>
		   </tr>
		 </table>
	<a href="insert.do">[이전 단계로]</a> &nbsp;&nbsp;
	<input type="image" src="<c:url value='/images/button_submit.gif' />">

</form:form>
</div>