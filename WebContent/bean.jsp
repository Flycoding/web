<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="com.flyingh.vo.Person" scope="session">
		Hello world!!!
	</jsp:useBean>
	<jsp:setProperty property="name" name="person" value="flycoding" />
	<jsp:setProperty property="age" name="person" value="22" />
	<h1>${person.name }-->${person.age }</h1>
	<font color="green"> <jsp:getProperty property="name"
			name="person" /> <jsp:getProperty property="age" name="person" />

	</font>
	<jsp:setProperty property="name" name="person" param="name" />
	<jsp:setProperty property="age" name="person" param="age" />
	${person.name } ${person.age }
	<%-- 	<%=person.getName()%> --%>
	<br />**************************************************************
	<br />
	<jsp:setProperty property="*" name="person" />
	<h1>${person.name }--->${person.age }</h1>
</body>
</html>