<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/login.css' />">

<div class="membership_wrap">
		<div class="membership_body">
			 <c:if test="${!empty message}">
  				<b><font color="red"><c:url value="${message}" /></font></b>
  			</c:if>
			<!--  name: loginForm    -->
			<form class="userBox" autocomplete="on" name="loginForm" method="POST" action='<c:url value="/shop/signon.do"/>'>
			 	<c:if test="${!empty signonForwardAction}">
     				<input type="hidden" name="forwardAction" value='<c:url value="${signonForwardAction}"/>' />
    			</c:if>
				<label class="signIn" for="login">아이디</label>

				<!-- 이메일  name: email -->
				<input type="text" class="inputTag" placeholder="아이디 입력"
					name="accountName" value=''>
					
				<label class="signIn" for="password">비밀번호</label>

				<!-- 비밀번호  name: pwd-->
				<input type="password" class="inputTag" name="password" value='' placeholder="비밀번호 입력" autocomplete="current-password"
					autocapitalize="off" autocorrect="off" spellcheck="off">

				<!-- 로그인 버튼! loginCheck() 메소드로-->
				<button class="loginButton" type="submit" label="로그인하기"
					onclick="login()" style="margin: 20px 0; height: 45px;">로그인</button>

				<a class="idExist" href="<c:url value='/shop/newAccount.do' />"><span
					style="color: #757575;" data-reactid="57">아직 계정이 없으신가요?</span> 회원 가입하기
				</a>
			</form>

			<div style="text-align: center; margin-top: 40px;" data-reactid="59">
				<a style="text-decoration: none; color: #ff4543;"
					href="/forgot-password" data-reactid="60">혹시 비밀번호를 잊으셨나요?</a>
			</div>
		</div>
	</div>
