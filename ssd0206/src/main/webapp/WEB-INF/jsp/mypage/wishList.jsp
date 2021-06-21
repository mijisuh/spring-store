<%@ include file="../IncludeTop.jsp"%>
<%@ include file="../IncludeAccountInfo.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/wishList1.css' />" media="all" />
<script>
	function viewProj(vs) {
		var hidden = document.getElementById(vs);
		var str = "<input type='hidden' value='" + vs + "' name='itemId' />";
		hidden.innerHTML += str;
		form.submit();
	}
	
	function selectSorting(){
	    var obj = document.getElementById("sort");
	    var selectValue = obj.options[obj.selectedIndex].value;
	    
	    if (selectValue == "ac") {
	    	form.action = "<c:url value='/shop/ac/wishList.do' />";
	    } else {
	    	form.action = "<c:url value='/shop/gb/wishList.do' />";
	    }
	    
	    form.method = "GET";
		form.submit();
	}
</script>
</head>
<body>
<form name="form" method="POST" action="<c:url value='/shop/${deal}/item.do' />">
	<div class="selectbox">
		<select id="sort" onchange="selectSorting()">
			<option value="ac" <c:if test="${deal=='ac'}"> selected </c:if>>경매</option>
			<option value="gb"<c:if test="${deal=='gb'}"> selected </c:if>>공동구매</option>
		</select>
	</div>

	<div class="kind_1_project">
		<table>
			<tr>
				<c:forEach var="i" items="${interests }" varStatus="vs">
					<td>
						<div class="project_card_1" onClick="viewProj('${i.itemId}')">
							<div class="imgbox">
								<img src="<c:url value='/upload/aa.jpg' />" style="width: 100%; height: 100%;" alt="">
							</div>
							<div class="textbox">
								<h5>${i.name}</h5>
								<div id="${i.itemId}"></div>
							</div>
							<div class="textbox">
								<span>${i.regDt }</span>
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