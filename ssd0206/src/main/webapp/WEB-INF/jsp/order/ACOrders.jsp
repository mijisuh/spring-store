<%@ include file="../IncludeTop.jsp"%>
<%@ include file="../IncludeAccountInfo.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	
	<div align="center">
  <p>
    <font size="4"><b>ACOrderList</b></font>
  </p>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>상품명</b></td>
		<td><b>낙찰가</b></td> 

    
    <c:forEach var="acOrderList" items="${acOrderList}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><font color="black"><c:out value="${acOrderList.getName()}" /></font></b></td>
         <td>
          <b><font color="black"><c:out value="${acOrderList.getAcPrice()}" /></font></b></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>