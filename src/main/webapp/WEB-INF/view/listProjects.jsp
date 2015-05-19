<%@ include file="prefixes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="cssJs.jsp"%>
<title>Add project</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<%@include file="menu.jsp"%>
	<a href="/kickstarter/addProject">Add project</a>
	<c:forEach var="project" items="${projects}">
		<li><c:out value="${project.name}" /></li>
	</c:forEach>
</body>
</html>