<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>calc</title>
</head>
<body>
	<h1>Result Info:${resultInfo }</h1>
	<form action="/web/CalcServlet" method="post">
		first:<input type="text" name="firstNum"><br /> operator:<select
			name="operator">
			<option value="+" selected="selected">+
			<option value="-">-
			<option value="*">*
			<option value="/">/
		</select><br /> second:<input type="text" name="secondNum"><br /> <input
			type="submit" value="calc">
	</form>
</body>
</html>