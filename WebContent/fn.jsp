<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${fn:escapeXml("<a href='http://www.google.com/ncr'>Google</a>") }</h1>
	<h1><c:out value="<a href=''>click me</a>"></c:out> </h1>
	<h1>${fn:substring("hello world!!!",7,9) }</h1>
	<h1>${fn:substring("hello world!!!",7,-3) }</h1>
	<h1>${fn:toUpperCase("hello world!!!") }</h1>
	<%
		pageContext.setAttribute("info", new String[] { "a", "c", "e" });
	%>
	<input type="checkbox" name="info" value="a"
		${fn:containsIgnoreCase(fn:join(info,"-"),"a") ?"checked":""}>a
	<input type="checkbox" name="info" value="b"
		${fn:containsIgnoreCase(fn:join(info,"-"),"b") ?"checked":""}>b
	<input type="checkbox" name="info" value="c"
		${fn:containsIgnoreCase(fn:join(info,"-"),"c") ?"checked":""}>c
	<input type="checkbox" name="info" value="d"
		${fn:containsIgnoreCase(fn:join(info,"-"),"d") ?"checked":""}>d
	<input type="checkbox" name="info" value="e"
		${fn:containsIgnoreCase(fn:join(info,"-"),"e") ?"checked":""}>e


	<h1>${fn:toLowerCase("Hello World!!!") }</h1>
	<h1>${fn:substringBefore("Hello world!!!","or") }</h1>
	<h1>${fn:substringAfter("Hello world!!!","or") }</h1>
	<h1>${fn:containsIgnoreCase("Hello world!!!","LL") }</h1>
	<h1>${fn:replace("Hello world!!!","or","OR") }</h1>
	<h1>${fn:trim(" hello world!!!") }</h1>
	<%
		request.setAttribute("array", new String[] { "a", "b", "c" });
	%>
	<h1>${fn:length(array) }</h1>
	<%
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		pageContext.setAttribute("list", list);
	%>
	<h1>${fn:length(list) }</h1>
	<h1>
		<c:forEach var="mem" items="${list }">
			${mem }
		</c:forEach>
		<br />
		<c:forEach begin="0" end="${fn:length(list) }" var="index">
			${list[index] }
		</c:forEach>
	</h1>
	<h1>${fn:split("http://www.google.com","\\.")[1] }</h1>
	<h1>${fn:split("http://www.google.com",".")[1] }</h1>
	<h1>${fn:join(fn:split("http://www,google,com",","),".") }</h1>
	<h1>${fn:indexOf("hello world!!!","o") }</h1>
</body>
</html>