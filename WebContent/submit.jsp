<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/web/SubmitServlet" method="post">
		<textarea rows="3" cols="50" name="info"></textarea>
		<br /> <input type="hidden" name="token" value="${token }"><br />
		<input type="submit" value="submit">
	</form>
</body>
</html>