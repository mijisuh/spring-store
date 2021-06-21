<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="max-age=0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="<c:url value='/style/includeTop.css' />" type="text/css" media="all"/>
</head>

<body bgcolor="white">
	<table class="top">
		<tr>
			<td style="text-align:right">
				<a href="<c:url value="/shop/viewCart.do" />"><img border="0" name="img_cart" src="<c:url value='/images/cart.gif' />" /></a>
				<img border="0" src="<c:url value='/images/separator.gif' />" />
				<c:if test="${empty userSession.account}">
					<a href="<c:url value="/shop/signonForm.do"/>">로그인</a>
					<img border="0" src="<c:url value='/images/separator.gif' />" />
					<a href="<c:url value="/shop/newAccount.do"/>">회원가입</a>
				</c:if>
				
				<c:if test="${!empty userSession.account}">
					<a href="<c:url value="/shop/signoff.do"/>">
						<img border="0" name="img_signout" src="<c:url value='/images/sign-out.gif' />" />
					</a>
					<img border="0" src="<c:url value='/images/separator.gif' />" />
					<a href="<c:url value="/shop/myAccountInfo.do"/>">
						<img border="0" name="img_myaccount" src="<c:url value='/images/my_account.gif' />" />
					</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td style="text-align:center">
				<a href="<c:url value="/shop/home.do"/>">
					<b>메인 로고</b>
				</a>
			</td>
		</tr>
		<tr>	
			<td style="text-align: right">
				<form action="<c:url value="/shop/searchItems.do"/>" method="post">
					<input type="hidden" name="search" value="true" />
					<input type="text" name="keyword" size="14" />&nbsp;
					<input src="<c:url value='/images/search.gif' />" type="image" />
				</form>
			</td>
		</tr>
	</table>
	<table class="cat">
		<tr>
			<td><a href="<c:url value="/shop/home.do" />">HOME</a></td>
			<c:forEach var="dealType" items="${dealTypes }">
				<td><a href="<c:url value='/shop/${dealType.dealName }/list.do' >
								<c:param value='${dealType.dealId }' name='dealId' />
								<c:param value='-1' name='catId' />
							</c:url>">${dealType.dealDesc }</a></td>
			</c:forEach>
		</tr>
	</table>
</body>