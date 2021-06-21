<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<font color="green" size="4"><b>경매품 등록완료</b></font>
</head>
<body>
		<ul>
		<li>경매품 종류: ${newACItem.catName}</li>		
		<li>경매품명: ${newACItem.name}</li>			
		<li>경매시각: ${newACItem.acTime}</li>		
		<li>경매가: ${newACItem.minPrice} </li>		
		<li>설명: ${newACItem.desc}</li>
		<li>추가속성1:${newACItem.attr1}</li>		
		<li>추가속성2:${newACItem.attr2}</li>
		<li>추가속성3:${newACItem.attr3} </li>
		</ul>	
	<p><a href="<c:url value="acGoview.do"/>">경매 목록</a></p>
	
</body>
</html>