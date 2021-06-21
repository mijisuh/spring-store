<jsp:include page="../IncludeTop.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<div align="center">
	<h3>[ 공동구매 상품등록 ]</h3>
	<form:form modelAttribute="gbForm" method="post" action="gbRegConfirm.do">
	<table id="list">
		<tr>
			<th>상품명</th>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<th>원가</th>
			<td><form:input path="listPrice" /></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td><form:input path="catName" items="${ItemCat}" /></td>		
		</tr>
		<tr>
			<th>신청기한</th>
			<td><form:input path="period" /></td>
		</tr>
		<tr>
			<th>최소인원</th>
			<td><form:input path="minNum" /></td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td><form:input path="imgFile" /></td>
		</tr>
		<tr>
			<th>상세설명</th>
			<td><form:input path="desc" /></td>
		</tr>
	</table>
	<b><a href="list.do?dealId=2&catId=-1">이전 단계로</a> &nbsp;&nbsp;</b>
	<input type="submit" value="다음 단계로" />
	</form:form> 
</div>
</body>
</html>