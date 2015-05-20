<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="prefixes.jsp" %>
<html>
<head>
    <%@include file="cssJs.jsp" %>
    <title>Projects</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" id="header">
        <%@ include file="header.jsp" %>
    </div>
    <div class="row" id="body">

        <c:forEach var="project" items="${projects}">
            <div class="col-md-4">
                <div class="thumbnail my_thumbnail">
                    <img src="/resources/image/images.jpg" alt="">

                    <div class="caption">
                        <h3><c:out value="${project.name}"/></h3>

                        <p><c:out value="${project.shortDesc}"/></p>

                        <p><a href="/kickstarter/projects/<c:out value="${project.id}"/>" class="btn btn-success" role="button">Open
                            Project</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row" id="footer">

    </div>
</div>
</body>
</html>