<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<c:out value="${project.user.name}" />
		<br>
		<c:out value="${project.timestamp}" />		
	</div>
</body>
</html>