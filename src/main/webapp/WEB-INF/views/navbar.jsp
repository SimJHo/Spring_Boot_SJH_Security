<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		[<a href="<c:url value="/" />">홈으로</a>]
	    [<a href="<c:url value="/add/addForm" />">회원가입</a>]
	    [<a href="<c:url value="/user/userHome" />">유저 홈</a>]
	    
	    <sec:authorize access="hasRole('ADMIN')">
		    [<a href="<c:url value="/member/memberHome" />">멤버 홈</a>]
		    [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
	    </sec:authorize>
	    
	    <sec:authorize access="isAuthenticated()">
			<form:form action="/logout" method="post" onsubmit="confirm('로그아웃 하시겠습니까?')">
				<input type="submit" value="로그아웃">
			</form:form>
		</sec:authorize>
	    
	</h3>
</body>
</html>