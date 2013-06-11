<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>--------------------------forEach
		cookie--------------------------------</h1>
	<c:forEach var="me" items="${cookie }">
		${me.key }-------:${me.value.name }---->${me.value.value }<br/>
	</c:forEach>
	<h1>--------------------forEach header-------------------------</h1>
	<h1>
		<c:forEach var="me" items="${header }">
			${me.key }---->${me.value }<br />
		</c:forEach>
	</h1>
	--------------------------------------------------------

	<h1>${initParam.msg }</h1>
	${header.host }
	<h2>${header["host"] }</h2>
	<br /> ${cookie.JSESSIONID.value }
	<h1>-------------------header----------------------------</h1>
	${header}
	<h1>-----------------header.cookie-----------------------</h1>
	<h1>${header.cookie }</h1>
	<br />
	<br />
	<br />
	<br />
	<br /> ${header.cookie}
	<br />${header["Accept-Language"] }
	<br />
	<br /> ${paramValues.name["0"] } ${paramValues.name[1] }
	<br />
	<br />
	<%-- 	<%=pageContext.getServletContext().getRealPath("/")%><br /> --%>
	${param.name }----${param.age }
	<form action="${pageContext.request.contextPath }/el2.jsp"
		method="post">
		name:<input type="text" name="name" value="${param.name }"><br />
		age:<input type="text" name="age" value="${param.age }"><br />
		<input type="submit" value="submit">
	</form>
</body>
</html>