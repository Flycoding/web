<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reg</title>
</head>
<body>
	<h1>${error }</h1>
	<form action="/web/RegServlet" method="post">
		username:<input type="text" name="username" /><br /> password:<input
			type="password" name="password" /><br /> code:<input type="text"
			name="code" /><br /> <img alt="change validation code"
			src="/web/ValidateCodeServlet"
			onclick="this.src=this.src+'?'+new Date()"
			style="cursor: pointer; cursor: hand;" /><br /> <input
			type="submit" value="submit">
	</form>
</body>
</html>