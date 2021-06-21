<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>입찰완료</title>
</head>
<body>
	입찰이 완료되었습니다.
		<ul>
		<li>입찰가: ${newBid.bidPrice}</li>	
		<li>입찰시간: ${newBid.bidTime}</li>	
		</ul>	
	<p><a href="<c:url value="/index"/>">경매 목록</a></p>
	
</body>
</html>