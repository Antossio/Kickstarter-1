<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Add post</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="/kickstarter/addPost/" method="post">
                                <div class="form-group">
								<textarea name="post" class="form-control"
									placeholder="Enter post's text" rows="4">
						</textarea>
						<input type="hidden" name="userID"
						value="<c:out value="${userID}"/>"> 
						<input type="hidden" name="projectID" value="<c:out value="${projectID}"/>">
							</div>
                                <input type="submit" value="Add post"
                                       class="btn btn-info btn-block">
                            </form>
                        </div>
            </div>
        </div>
    </div>
    <div class="row" id="footer">

    </div>
</div>
</body>
</html>