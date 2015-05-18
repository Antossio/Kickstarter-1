<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="prefixes.jsp"%>

<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="/kickstarter/login" method="post">
		Login:  <input type="text" name="login"> 
		Password:  <input type="password" name="password"> 

		 <input type=submit name=submit value="Log In" />
	</form>
	
	</body>
</html>