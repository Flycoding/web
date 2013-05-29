<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book's detail information</title>
</head>
<body>
	<h1>Book's information:</h1>
	<h1>${book.id }</h1>
	<h1>${book.name }</h1>
	<h1>${book.author }</h1>
	<h1>${book.price }</h1>
	<a href="/web/ListAllServlet">return</a>
</body>
</html>