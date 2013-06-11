<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="flyingh" uri="http://www.flyingh.com"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/ChangeLangServlet?lang=zh">中文</a>
	<a href="${pageContext.request.contextPath }/ChangeLangServlet?lang=en">English</a>
	<br />
	<c:set var="baseName" scope="page"
		value="com.flyingh.resources.MessageResource"></c:set>
	<form action="${pageContext.request.contextPath }/lang.jsp"
		method="post">
		<flyingh:lang key="username" baseName="${baseName }" />
		:<input type="text" name="username" value="${param.username }"><br />
		<flyingh:lang key="password" baseName="${baseName }" />
		:<input type="password" name="password"> <br /> <input
			type="submit"
			value='<flyingh:lang key="submit" baseName="${baseName }"/>'>
	</form>
</body>
</html>