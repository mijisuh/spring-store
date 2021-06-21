<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/item.css' />" media="all" />

<script>


</script>

<form method='GET' action='<c:url value="/shop/newOrder.do" />'>
<table class='itemTable'>
	<tr>
		<td class='itemImg'>
			<img src="<c:url value='/upload/${item.imgFileName}' />" style="width: 100%; height: 100%;" onerror="this.src='<c:url value='/upload/aa.jpg' />'"/>
		</td>
		<td>
			<h1>${item.name }</h1>
			${item.status }<br>
			판매자: ${item.supplierId }<br>
			가격: ${item.listPrice }원<br>
			설명: ${item.description }<br>
			
			<c:if test="${item.attribute1 ne '-'}">
				옵션:
				<select id="attr">
						<option value="${item.attribute1 }" selected>${item.attribute1 }</option>
						<option value="${item.attribute2 }">${item.attribute2 }</option>
						<option value="${item.attribute3 }">${item.attribute3 }</option>
				</select>
			</c:if><br><br>
			<c:if test="${item.status ne '품절'}" >
				<input type='hidden' value='${item.itemId }' name='itemId' />
				<input type='submit' value='주문하기' />
				<input type='button' value='장바구니 담기'/>
			</c:if>
		</td>
	</tr>
</table>
</form>