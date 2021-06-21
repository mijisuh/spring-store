<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="ssd0206.domain.ItemCat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<font color="green" size="4"><b>경매품 확인</b></font></td>
<body>
	
<h2>경매품 등록 확인</h2>

<form:form modelAttribute="acForm" method="post" action="acRegisterd.do">

다음 정보로 신청하시겠습니까?<br/><br/>

경매품 종류: ${acForm.catName} <br/>
경매품명: ${acForm.name} <br/>
경매시각: ${acForm.acTime} <br/>
경매가: ${acForm.minPrice} <br/>
설명: ${acForm.desc}<br/> 
추가속성1:${acForm.attr1}

 <br/>
추가속성2:${acForm.attr2} <br/>
추가속성3:${acForm.attr3} <br/>

<br>
<a href="acReg.do">[이전 단계로]</a> &nbsp;&nbsp;
<input type="submit" value="등록" />

</form:form>
	
</body>
</html>


</body>
</html>