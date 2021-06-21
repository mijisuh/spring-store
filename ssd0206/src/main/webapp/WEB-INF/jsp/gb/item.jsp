<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/item.css' />" media="all" />

<div align="center">
	<h3>[ 공동구매 상품 상세보기 ]</h3>
</div>
<form method='GET' action='<c:url value="/shop/gb/gb.do" />'>
<table class='itemTable'>
	<tr>
		<td class='itemImg'>
			<img src="<c:url value='/upload/aa.jpg' />" style="width: 100%; height: 100%;" alt="">
		</td>
		<td>
			상품명 : ${item.name } - ${item.description }<br>
			원가 : ${item.listPrice }원<br>
			마감일: ${item.period } <br><br>
			<input type='hidden' value='${item.itemId }' name='itemId' />
			<input type='submit' value='공동구매 참여' />
			<input type='button' value='관심 공동구매 등록' onClick='location.href="<c:url value="/shop/gb/addWishlist.do" >
																				<c:param value="${item.itemId }" name="itemId" /></c:url>"'/>
		</td>
	</tr>
</table>
</form>