<%@ include file="../IncludeTop.jsp"%>
<%@ include file="../IncludeCategory.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/itemList.css' />" media="all" />
<script>
	function viewProj(vs) {
		var hidden = document.getElementById(vs);
		var str = "<input type='hidden' value='" + vs + "' name='itemId' />";
		hidden.innerHTML += str;
		form.submit();
	}
</script>
</head>
<body>
<form name="form" method="POST" action="<c:url value='/shop/sales/item.do' />">
	<div class="kind_1_project">
		<div style="text-align: right; margin-top: 2%; margin-right: 2%; ">
			<input type='button' value='일반상품등록' onClick="location.href='<c:url value="/shop/sales/insert.do"/>'" />
		</div>
		<table>
			<tr>
				<c:forEach var="i" items="${itemList }" varStatus="vs">
					<td>
						<div class="project_card_1" onClick="viewProj('${i.itemId}')">
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
					<c:if test="${vs.count % 4 == 0}">
						<c:out value="</tr><tr>" escapeXml="false" />
					</c:if>
					<c:if test="${vs.last }">
						<c:out value="</tr>" escapeXml="false" />
					</c:if>
				</c:forEach>
		</table>
	</div>
</form>
</body>
</html>