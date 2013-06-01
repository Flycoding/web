<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" session="false"
	isThreadSafe="false" errorPage="/error.jsp" isErrorPage="true"%>
<%@ include file="1.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 		out.println(session);
		// 		int i=1/0;
	%>
	<h1>今天天气不错!</h1>
	<%=new Date()%>
	<h1>
		<%
			out.write(application.getRealPath("/"));
		%>
		<br />
		<%--Hello world!!! --%>
		aaaaaaaaaaaaaaaaaaaaaaaaaa
		<!-- this is a test! -->

		<%
			out.println(String.format("%1$tF %1$tT",
					GregorianCalendar.getInstance()));
		%>
	</h1>
</body>
</html>