<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <h3>
                            <c:out value="${project.name}"/>
                        </h3>

                        <p>
                            <c:out value="${project.shortDesc}"/>
                        </p>

                        <p>
                            <a href="/kickstarter/projects/<c:out value="${project.id}"/>"
                               class="btn btn-success" role="button">Open
                                Project</a>
                        </p>

                        <p>
                            <security:authorize access="isAuthenticated()">
                                <security:authentication var="principal"
                                                         property="principal"/>

                            <c:if test="${empty project.likeList}">

                        <form action="/kickstarter/like" method="post">
                            <input type="hidden" name="userName" ,
                                   value="<c:out value="${principal.username}"/>"/>
                            <input type="hidden" name="projectId" ,
                                   value="<c:out value="${project.id}"/>"/>
                            <input type=submit name=submit value="Like"/>
                        </form>
                        </c:if>
                        <c:forEach var="userLike"
                                   items="${project.likeList}">
                            <c:choose>

                                <c:when test="${userLike.users.login eq principal.username}">
                                    <form action="/kickstarter/unlike"
                                          method="post">
                                        <input type="hidden" name="userName" ,
                                               value="<c:out value="${principal.username}"/>"/>
                                        <input type="hidden" name="projectId" ,
                                               value="<c:out value="${project.id}"/>"/>
                                        <input type=submit name=submit
                                               value="Unlike it"/>

                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/kickstarter/like"
                                          method="post">
                                        <input type="hidden" name="userName" ,
                                               value="<c:out value="${principal.username}"/>"/>
                                        <input type="hidden" name="projectId" ,
                                               value="<c:out value="${project.id}"/>"/>
                                        <input type=text name=submit
                                               value="Like it"/>
                                    </form>
                                </c:otherwise>

                            </c:choose>
                        </c:forEach>
                        </security:authorize>
                        <br><c:out value="${project.likesQty}"/> people like
                        this project
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row" id="footer"></div>
</div>
</body>
</html>