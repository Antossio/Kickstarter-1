<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
<%@include file="cssJs.jsp"%>
<title>Project</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div>
		<c:out value="${project.name}" />
		<br>
		<c:out value="${project.link}" />
		<br>
		<c:out value="${project.shortDesc}" />
		<br>
		<c:out value="${project.longDesc}" />
		<br>
		<c:out value="${project.users.name}" />
		<br>
		<c:out value="${project.timestamp}" />		
	</div>
</body>
</html>