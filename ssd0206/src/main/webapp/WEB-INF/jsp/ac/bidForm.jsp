<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="ssd0206.domain.Card_company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>��� ������</title>
</head>
<body>
	<form:form modelAttribute="bidForm" action="bidComplete.do">
		
		<label for="bidPrice">������</label>:
		<form:input path="bidPrice" />
		
		
		<input type="submit" value="���� �Ϸ�" />
	</form:form>
</body>
</html>