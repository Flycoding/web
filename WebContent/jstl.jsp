<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.even {
	background: orange;
}

.odd {
	background: yellow;
}
</style>
</head>
<body>
	<%
		pageContext.setAttribute("strs", "a,b,c,de,fgh,ijk");
	%>
	<c:forTokens var="str" items="${strs }" delims=",">
		<h1>${str }</h1>
	</c:forTokens>

	<a href='<c:url value="/1.jsp"></c:url>'>hello</a>

	<c:url var="url" scope="page" value="/index.jsp">
		<c:param name="name" value="世界"></c:param>
	</c:url>
	<a href="${url }">click me</a>

	<br />
	<c:forEach var="num" begin="1" end="10" step="1" varStatus="status">
		<span class="${status.count%2==0?'even':'odd' }">${num }</span>
	</c:forEach>

	<%
		request.setAttribute("map", new HashMap<String, String>());
	%>
	<c:set property="a" value="A" target="${map }"></c:set>
	<h1>${map.a }</h1>
	<h1>${map["a"] }</h1>
	<c:forEach var="me" items="${map }">
		${me.key }--${me.value }<br />
	</c:forEach>
	<br />
	<c:set var="data" value="hello world!!!!!" scope="page"></c:set>
	${data }
	<br />
	<c:out value="${null }" escapeXml="true"
		default="<h1>hello world!!!</h1>"></c:out>
</body>
</html>