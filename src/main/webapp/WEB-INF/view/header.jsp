<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title></title>
</head>
<body>
<%request.getAttribute("isLogged"); %>
	<c:choose>
		<c:when test="${isLogged}">
			<%@ include file="logout.jsp"%>
		</c:when>
		 
		 <c:otherwise >
			<%@ include file="loginIn.jsp"%>
		</c:otherwise>
				
	</c:choose>
HEADER BODY 
</body>
</html>