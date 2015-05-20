<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="prefixes.jsp" %>
<html>
<head>
   <%@include file="cssJs.jsp"%>
    <title>Kickstarter</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" id="header">
        <%@ include file="header.jsp" %>
    </div>
    <div class="row" id="body">

        <c:forEach var="c" items="${categories}">

            <div class="col-md-4 ">
                <div class="thumbnail my_thumbnail">
                    <a href="/kickstarter/categories/<c:out value="${c.id}"/>">
                        <div id="categoryName" class="caption text-center">
                            <h3><c:out value="${c.name}"/></h3>
                        </div>
                    </a>
                </div>
            </div>

        </c:forEach>
    
    </div>
    <div class="row" id="footer">

    </div>
</div>
</body>
</html>

