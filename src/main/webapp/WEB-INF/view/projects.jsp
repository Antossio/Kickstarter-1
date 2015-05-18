<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Projects</title>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div>
		<p>List of projects</p><br>
		<c:forEach var="project" items="${projects}">
			<div>
			<ul>
				<li><img src="<c:out value="${project.link}"/>"></li>
				<li><a href="/kickstarter/projects/<c:out value="${project.id}"/>"><c:out value="${project.name}"/></a></li>
				<li><c:out value="${project.shortDesc}"/></li>
			</ul>
			</div>
		</c:forEach>
	</div>
</body>
</html>