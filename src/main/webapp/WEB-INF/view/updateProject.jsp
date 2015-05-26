<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add project</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div class="row" id="body">
			<div class="col-md-3" id="menu">
				<%@include file="menu.jsp"%>
			</div>
			<div class="col-md-6 context">
				<div class="row-fluid">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Update Project</h3>
						</div>
						<div class="panel-body">
							<form role="form" action="/kickstarter/updateProject/<c:out value="${project.id}"/>"
								method="post" enctype=multipart/form-data>
								<div class="form-group">
									<select name="categories"
										class="form-control input-sm selectpicker">
										<option value="" disabled selected>Select category</option>
										<c:forEach var="category" items="${categories}">
											<c:choose>
												<c:when test="${category.id == project.category.id}">
													<option selected value="<c:out value="${category.id}"/>">
												</c:when>
												<c:otherwise>
													<option value="<c:out value="${category.id}"/>">
												</c:otherwise>
											</c:choose>
											<c:out value="${category.name}" />
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<input type="input" name="projectName"
										value="<c:out value="${project.name}" />"
										class="form-control input-sm">
								</div>
								<div class="form-group">
									<textarea class="form-control" name="projectShortDesc" rows="3"><c:out
											value="${project.shortDesc}" /></textarea>
								</div>
								<div class="form-group">
									<textarea class="form-control" name="projectLongDesc" rows="10"><c:out
											value="${project.longDesc}" /></textarea>
								</div>
								<div class="form-group">
									<label for="exampleInputFile">Choose image</label> <input
										type="file" id="exampleInputFile" accept="image/*" name="img">
									<p class="help-block">Choose image to your project</p>
								</div>
								<input type="hidden" name="userID"
									value="<c:out value="${userID}"/>">
								<input type="hidden" name="linkToFile"
									value="<c:out value="${project.link}"/>">									 
									<input type="submit" value="Update Project" class="btn btn-info btn-block">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>