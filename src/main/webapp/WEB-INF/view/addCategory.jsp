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
                            <h3 class="panel-title">Add Category</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="/kickstarter/categories/"
                                  method="post">
                                <div class="form-group">
                                    <input type="text" name="categoryName"
                                           class="form-control input-sm"
                                           placeholder="New Category Name">
                                </div>
                                <input type="submit" value="Add Category"
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