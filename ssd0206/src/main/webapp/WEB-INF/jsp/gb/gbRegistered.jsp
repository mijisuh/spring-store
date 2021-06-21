<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<div align="center">
	<h3>[ 공동구매 상품등록 완료 ]</h3>
	<table id="list">
		<tr>
			<th>상품명</th>
			<td>${gbForm.name}</td>
		</tr>
		<tr>
			<th>원가</th>
			<td>${gbForm.listPrice}</td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td>${gbForm.catName}</td>	
		</tr>
		<tr>
			<th>신청기한</th>
			<td>${gbForm.period}</td>
		</tr>
		<tr>
			<th>최소인원</th>
			<td>${gbForm.minNum}</td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td>${gbForm.imgFile}</td> 
		</tr>
		<tr>
			<th>상세설명</th>
			<td>${gbForm.desc}</td>
		</tr>
	</table>
	<a href="<c:url value="shop/gb/list.do?dealId=2&catId=-1"/>">공동구매 상품 목록</a>
</div>
</body>
</html>