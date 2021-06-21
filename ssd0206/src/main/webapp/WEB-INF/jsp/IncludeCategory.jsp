<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="<c:url value='/style/includeCategory1.css' />" type="text/css" media="all"/>
<div class="divCat">
<table class="itemcat">
	<tr>
		<td class="desc">카테고리</td>
	</tr>
	<c:forEach var="category" items="${categories }">
		<tr>
			<td><a href="<c:url value='/shop/${dealName }/list.do' >
							<c:param value='${category.dealId }' name='dealId' />
							<c:param value='${category.catId }' name='catId' />
						</c:url>">${category.name }</a></td>
		</tr>
	</c:forEach>
</table>
</div>