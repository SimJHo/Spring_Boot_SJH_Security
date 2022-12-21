<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   	<title>main</title>
</head>
<body>

	<h1>메인 페이지 입니다.</h1>
	
	<c:import url="navbar.jsp"></c:import>
	
	<sec:authorize access="isAnonymous()">
		<p>로그인이 필요합니다</p>
		[<a href="<c:url value="/login" />">로그인</a>]
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<p>principal: <sec:authentication property="principal"/></p>
		<p>principal: <sec:authentication property="principal.username"/> 님 환영합니다</p>
	</sec:authorize>
	
</body>
</html>