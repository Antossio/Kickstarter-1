<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add project</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" id="header">
        <%@ include file="header.jsp" %>
    </div>
    <div class="row" id="body">
        <div class="col-md-3" id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <div class="col-md-6 context">
            <div class="row-fluid">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Add Project</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="/kickstarter/projects"
                                  method="post" enctype=multipart/form-data>
                                <div class="form-group">
                                    <select name="categories"
                                            class="form-control input-sm selectpicker">
                                        <option value="" disabled selected>
                                            Select
                                            category
                                        </option>
                                        <c:forEach var="category"
                                                   items="${categories}">
                                            <option value="<c:out value="${category.id}"/>">
                                                <c:out value="${category.name}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input type="input" name="projectName"
                                           class="form-control input-sm"
                                           placeholder="Enter project name">
                                </div>
                                <div class="form-group">
                        <textarea placeholder="Enter project short description"
                                  class="form-control" name="projectShortDesc"
                                  rows="3"></textarea>
                                </div>
                                <div class="form-group">
                        <textarea placeholder="Enter project long description"
                                  class="form-control" name="projectLongDesc"
                                  rows="10"></textarea>                                
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">Choose
                                        image</label>
                                    <input type="file" id="exampleInputFile"
                                           accept="image/*" name="img">
                                    <p class="help-block">Choose image to your
                                        project</p>
                                </div>
                                <input type="hidden" name="userID" value="<c:out value="${userID}"/>">
                                <input type="submit" value="Create Project"
                                       class="btn btn-info btn-block">
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>