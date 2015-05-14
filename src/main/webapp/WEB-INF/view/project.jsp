<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Project</title>
  <link href="/WEB-INF/view/style.css" rel="stylesheet">
</head>
<body>

<%@include file="menu.jsp"%>

<div class="main">
  <p>Project</p><br>
  <c:out value="${project.name}"/>
</div>
</body>
</html>