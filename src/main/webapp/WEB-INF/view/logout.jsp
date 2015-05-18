<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="prefixes.jsp"%>

<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="/kickstarter/logout" method="post">
		<input type=submit name=submit value="Log Out" />
	</form>
</body>
</html>