<jsp:include page="../IncludeTop.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${!empty userSession ? true : false}">
	<%@ include file="../IncludeAccountInfo.jsp"%>
</c:if>

<div class="accountForm">
<form:form modelAttribute="accountForm" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  <table id="account" align="center">
    <tr>
      <td>
        <h3><font color="darkgreen">User Information</font></h3>
        <table class="n13">
          <tr>
            <td>Account Name:</td>
            <td>
              <form:input path="account.accountName" readonly="${userSession != null ? 'true' : '' }" /><br>
              <B><form:errors path="account.accountName" cssClass="error" /></B>
            </td>
          </tr>
          <tr>
            <td>Password:</td>
            <td>
              <form:password path="account.password" /><br>
              <B><form:errors path="account.password" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Repeat password:</td>
            <td>
              <form:password path="repeatedPassword" /><br>
              <B><form:errors path="repeatedPassword" cssClass="error" /></B></td>
          </tr>
        </table> 
        
        <%@ include file="IncludeAccountFields.jsp"%>

      </td>
    </tr>
  </table>
  <br />
    <input type="image" src="../images/button_submit.gif" name="submit"
      value="Save Account Information" />
</form:form>
</div>