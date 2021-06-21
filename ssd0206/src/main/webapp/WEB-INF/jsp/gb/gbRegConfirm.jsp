<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="ssd0206.domain.ItemCat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<div align="center">
	<h3>[ 공동구매 상품등록 확인 ]</h3>
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
	<b><a href="gbReg.do">이전 단계로</a> &nbsp;&nbsp;</b>
	<input type="submit" value="상품 등록" />
</div>
</body>
</html>