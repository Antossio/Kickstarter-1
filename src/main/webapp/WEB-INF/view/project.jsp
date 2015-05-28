<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="cssJs.jsp"%>
<title>Project</title>
<style>
    .author { 
     color: #337ab7;
     font-weight: bold;        
    }
  </style> 
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<c:out value="${project.name}" />
						</h3>
					</div>
					<div class="panel-body">
						<c:out value="${project.link}" />
					</div>
					<ul class="list-group">
						<li class="list-group-item"><c:out
								value="${project.shortDesc}" /></li>
						<li class="list-group-item">Author: <c:out
								value="${project.user.name}" /></li>
						<li class="list-group-item">Creation date: <c:out
								value="${project.timestamp}" /></li>
						<li class="list-group-item">About the project<br> <c:out
								value="${project.longDesc}" /></li>

					</ul>
				</div>

				<form role="form" action="/kickstarter/addComments" method="post">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<textarea name="comment" class="form-control"
									placeholder="Enter comment for project" rows="4">
						</textarea>
							</div>
						</div>
					</div>
					<input type="hidden" name="userID"
						value="<c:out value="${userID}"/>"> 
						<input type="hidden" name="projectID" value="<c:out value="${project.id}"/>">
					<div class="row">
						<div class="col-md-3">
							<input type="submit" value="Add Comment"
								class="btn btn-primary btn-block">
						</div>
					</div>
				</form>
					<br>
					<ul class="list-group">
					<c:forEach var="comment" items="${comments}">
						<li class="list-group-item"> <span class="author"><c:out
								value="${comment.user.name}" /></span> <c:out
								value="${comment.comment}" /><br><c:out
								value="${comment.timestamp}" /></li>	
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>