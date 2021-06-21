<jsp:include page="IncludeTop.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value='/style/itemList.css' />" media="all" />

<script>
	function viewSalesItem(vs) {
		var hidden = document.getElementById(vs);
		var str = "<input type='hidden' value='" + vs + "' name='itemId' />";
		hidden.innerHTML += str;
		form.action="<c:url value='/shop/sales/item.do' />"
		form.submit();
	}

	function viewACItem(vs) {
		var hidden = document.getElementById(vs);
		var str = "<input type='hidden' value='" + vs + "' name='itemId' />";
		hidden.innerHTML += str;
		form.action="<c:url value='/shop/ac/item.do' />"
		form.submit();
	}

	function viewGBItem(vs) {
		var hidden = document.getElementById(vs);
		var str = "<input type='hidden' value='" + vs + "' name='itemId' />";
		hidden.innerHTML += str;
		form.action="<c:url value='/shop/gb/item.do' />"
		form.submit();
	}
	
</script>

<form name="form" method="POST" >
	<div align='center'><h3>일반 상품 목록</h3></div>
	<div class="kind_1_project">
		<table>
			<tr>
				<c:forEach var="i" items="${salesItems }" begin="0" end="3" varStatus="vs">
					<td>
						<div class="project_card_1" onClick="viewSalesItem('${i.itemId}')">
							<div class="imgbox">
								<img src="<c:url value='/upload/${i.imgFileName}' />" style="width: 100%; height: 100%;" onerror="this.src='<c:url value='/upload/aa.jpg' />'"/>
							</div>
							<div class="textbox">
								<h5>${i.name}</h5>
								<div id="${i.itemId}"></div>
							</div>
							<div class="textbox">
								<span>${i.description }</span>
								<span style="float: right;">${i.listPrice }원</span><br>
								<span style="float: right;">${i.status }</span>
							</div>
						</div>
					</td>
				</c:forEach>
		</table>
	</div>
	
	<div align='center'><h3>경매 목록</h3></div>
	<div class="kind_1_project">
		<table>
			<tr>
				<c:forEach var="i" items="${acItems }" begin="0" end="3" varStatus="vs">
					<td>
						<div class="project_card_1" onClick="viewACItem('${i.acItemId}')">
							<div class="imgbox">
								<img src="<c:url value='/upload/aa.jpg' />" style="width: 100%; height: 100%;" alt="">
							</div>
							<div class="textbox">
								<h5>${i.name}</h5>
								<div id="${i.acItemId}"></div>
							</div>
							<div class="textbox">
								<span>${i.suppName }</span>
								<span style="float: right;">${i.minPrice }원 ~</span>
							</div>
							<div class="textbox">
								<span>${i.acTime }</span>
							</div>
						</div>
					</td>
				</c:forEach>
		</table>
	</div>
	
	<div align='center'><h3>공동구매 목록</h3></div>
	<div class="kind_1_project">
		<table>
			<tr>
				<c:forEach var="i" items="${gbItems }" begin="0" end="3" varStatus="vs">
					<td>
						<div class="project_card_1" onClick="viewGBItem('${i.itemId}')">
							<div class="imgbox">
								<img src="<c:url value='/upload/aa.jpg' />" style="width: 100%; height: 100%;" alt="">
							</div>
							<div class="textbox">
								<h5>${i.name}</h5>
								<div id="${i.itemId}"></div>
							</div>
							<div class="textbox">
								<span>${i.description }</span>
							</div>
							<div class="textbox">
								<span>원가 : ${i.listPrice }원</span>
							</div>
							<div class="textbox">
								<span>마감일 : ${i.period }</span>
							</div>
						</div>
					</td>
				</c:forEach>
		</table>
	</div>
</form>