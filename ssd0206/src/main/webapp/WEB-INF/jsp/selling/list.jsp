<%@ include file="../IncludeTop.jsp"%>
<%@ include file="../IncludeAccountInfo.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="accountInfoOrder">
  <p>
    <font size="4"><b>일반 판매</b></font>
  </p>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>ITEM NAME</b></td> <td><b>STATUS</b></td>
    </tr>
    <c:forEach var="item" items="${selligSalesItems}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><font color="black"><c:out value="${item.name}" /></font></b></td>
		<td>${item.status }</td>
      </tr>
    </c:forEach>
  </table>
  
   <p>
    <font size="4"><b>경매</b></font>
  </p>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>ITEM NAME</b></td> <td><b>DATE</b></td>
    </tr>
    <c:forEach var="item" items="${selligACItems}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><font color="black"><c:out value="${item.name}" /></font></b></td>
        <td><fmt:formatDate value="${item.acTime}"
            pattern="yyyy/MM/dd hh:mm:ss" /></td>
      </tr>
    </c:forEach>
  </table>
  
  <p>
    <font size="4"><b>공동구매</b></font>
  </p>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>ITEM NAME</b></td> <td><b>DATE</b></td>
    </tr>
    <c:forEach var="item" items="${selligGBItems}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><font color="black"><c:out value="${item.name}" /></font></b></td>
        <td><fmt:formatDate value="${item.period}"
            pattern="yyyy/MM/dd hh:mm:ss" /></td>
    </c:forEach>
  </table>
</div>