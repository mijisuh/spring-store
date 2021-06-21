<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function deleteAccount(userId) {
		var hidden = document.getElementById(userId);
		var str = "<input type='hidden' value='" + userId + "' name='userId' />";
		hidden.innerHTML += str;
		form.submit();
	}
</script>
<body>
<form name="form" method="POST" action="<c:url value='/shop/admin/accountList.do' />">
	<table border="1">
		<tr>
			<td>회원 ID</td>
			<td>회원 PWD</td>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>-</td>
		</tr>
		<c:forEach var="account" items="${accounts }" varStatus="vs">
			<tr>
				<td>${account.accountName }</td>
				<td>${account.password }</td>
				<td>${account.username }</td>
				<td>${account.email }</td>
				<td>${account.phone }</td>
				<td>${account.address1 }</td>
				<td>
				<input type="button" value="삭제" onClick="deleteAccount('${account.userId }')">
				<div id="${account.userId }" ></div>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
<a href='<c:url value="/shop/admin/home.do"/>'>메인으로</a>
</body>