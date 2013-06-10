<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="flyingh" uri="http://www.flyingh.com"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		pageContext.setAttribute("a", a);
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		request.setAttribute("list", list);
		Set<String> set = new LinkedHashSet<String>(Arrays.asList("a1",
				"b2", "c3", "d4", "e5"));
		request.setAttribute("set", set);
		pageContext.setAttribute("headNames", request.getHeaderNames());
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		map.put("d", "4");
		map.put("e", "5");
		pageContext.setAttribute("map", map);
	%>
	<h1>
		<flyingh:forEach items="${a }" var="mem">
			${mem }<br />
		</flyingh:forEach>
		---------------<br />
		<flyingh:forEach items="${list }" var="mem">
			${mem }<br />
		</flyingh:forEach>
		---------------<br />
		<flyingh:forEach items="${set }" var="mem">
			${mem }<br />
		</flyingh:forEach>
		---------------<br />
		<flyingh:forEach items="${headNames }" var="mem">
			${mem }<br />
		</flyingh:forEach>
		---------------<br />
		<flyingh:forEach items="${map }" var="me">
			${me.key }--->${me.value }<br />
		</flyingh:forEach>
	</h1>

</body>
</html>