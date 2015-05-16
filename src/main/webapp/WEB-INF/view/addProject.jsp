<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add project</title>
<link href="/WEB-INF/view/style.css" rel="stylesheet">
</head>
<body>
	
	<%@include file="menu.jsp"%>
	
	<div class="main">
<<<<<<< HEAD
	<form action="/kickstarter/project" method="post">
=======
	<form action="/project/" method="post">
>>>>>>> 8c9c0bd3a1c40fa313bbf74e263ec2f02ecf312a
		<label>Category<br>
		<select name="categories">
		 <c:forEach var="category" items="${categories}">
        	<option value="<c:out value="${category.id}"/>"><c:out value="${category.categoryName}"/></option>
        	   </c:forEach>					
		</select></label><br> 
		<label>Project name<br><input type="text" name="projectName"></label><br>
		<label>Short description<br><textarea name="projectShortDesc" rows=5 cols=30></textarea></label><br>
		<label>Full description<br><textarea name="projectLongDesc" rows=10 cols=30></textarea></label><br>
		<label>Picture<br><input type="file" accept="image/*" enctype=multipart/form-data name="img"></label>
		<input type="hidden" name="userID" value="<c:out value="${userID}"/>"/>
		<input type="submit" value="Add">
	</form>
	</div>
</body>
</html>