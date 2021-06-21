<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/item.css' />" media="all" />

<form method='GET' action='<c:url value="/shop/ac/bidReg.do" />'>
<table class='itemTable'>
	<tr>
		<td class='itemImg'>
			<img src="<c:url value='/upload/aa.jpg' />" style="width: 100%; height: 100%;" alt="">
		</td>
		<td>
			<h1>${item.name }</h1>
			판매자: ${item.suppName }<br>
			${item.status }<br>
			최소 가격: ${item.minPrice }원<br>
			설명: ${item.desc }<br>
			마감일: ${item.acTime } <br><br>
			<input type='hidden' value='${item.acItemId }' name='acItemId' />
			<input type='submit' value='입찰하기' onClick='location.href= "<c:url value="/shop/ac/bidReg.do" >
																			<c:param value="${item.acItemId }" name="acItemId" /></c:url>"'/>
			<input type='button' value='관심 경매 등록' onClick='location.href="<c:url value="/shop/ac/addWishlist.do" >
																				<c:param value="${item.acItemId }" name="itemId" /></c:url>"'/>
		</td>
	</tr>
</table>
</form>