<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.flyingh.vo.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("a", "AAAAA");
	%>
	<%-- 	${applicationScope } --%>
	<h2>${sessionScope }</h2>
	<h3>${requestScope }</h3>
	${requestScope.a }------>${requestScope["a"] }
	<br />${pageScope }
	<br />
	<%
		pageContext.setAttribute("info", "hello world!!!");
	%>
	<h2>${info }</h2>
	<h1>${pageScope.info }</h1>
	${pageScope }
	<br /> ${pageContext }
	<br />
	<%
		pageContext.setAttribute("sex", "boy");
	%>
	<input type="radio" name="sex" value="boy" ${sex=="boy"?"checked":"" }>Boy
	<input type="radio" name="sex" value="girl" ${sex=="girl"?"checked":""}>Girl
	<input type="radio" name="sex" value="girl"
		${sex eq "girl"?"checked":""}>Girl

	<%-- 	<h1>${1>=0&&2>3?"hello world!!!":"hahaha" }</h1> --%>
	<%
		pageContext.setAttribute("obj", null);
		pageContext.setAttribute("list", new ArrayList<String>());
	%>
	${empty obj } ${empty list }

	<%
		pageContext.setAttribute("username", "flyingh");
		pageContext.setAttribute("password", "passwd");
	%>
	<h1>${username=="flyingh"&&password=="passwd" }</h1>
	<h1>${username=='flyingh'&&password=="passwd" }</h1>
	<br />
	<%
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("a", 18));
		list.add(new Person("b", 19));
		list.add(new Person("c", 20));
		request.setAttribute("persons", list);
	%>
	${persons["1"].name }
	<br />

	<%
		Person person = new Person();
		person.setId(5);
		pageContext.setAttribute("person", person);
	%>
	${person.id }

	<%
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		request.setAttribute("map", map);
	%>
	<h1>${map["e"] }</h1>
	<h1>${map['e'] }-----</h1>
	<h1>${map.e }</h1>
	<h1>${pageContext.request.contextPath }</h1>
	<h1>*******************</h1>
	<c:forEach var="item" items="${map }">
		<h1>${item.key }--->${item.value }</h1>
	</c:forEach>
</body>
</html>