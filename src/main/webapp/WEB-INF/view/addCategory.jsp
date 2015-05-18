<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="cssJs.jsp"%>
  <title>Add category</title>

</head>
<body>
<%@include file="header.jsp"%>
<%@include file="menu.jsp"%>

<div>
  <form action="/kickstarter/categories/" method="post">
    <label>Category name<br><input type="text" name="categoryName"></label><br>
    <input type="submit" value="Add">
  </form>
</div>
</body>
</html>