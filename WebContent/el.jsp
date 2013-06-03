<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		request.setAttribute("map", map);
	%>
	<h1>${map["e"] }</h1>
	<h1>${map['e'] }-----</h1>
	<h1>${map.e }</h1>
	<h1>${pageContext.request.contextPath }</h1>
	<h1>*******************</h1>
	<c:forEach var="item" items="${map }">
		<h1>${item.key }--->${item.value }</h1>
	</c:forEach>

</body>
</html>