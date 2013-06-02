<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<jsp:forward page="/yf.jpg"></jsp:forward> --%>
	<%-- 	<jsp:include page="/1.jsp"></jsp:include> --%>
	<%
		// 		response.sendRedirect("/web/yf.jpg");
		String password = "password";
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:forward page="/ParamServlet">
		<jsp:param value="张三" name="username" />
		<jsp:param value="<%=password%>" name="password" />
	</jsp:forward>
</body>
</html>