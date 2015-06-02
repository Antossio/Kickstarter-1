<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<html>
<head>    
    <%@include file="cssJs.jsp" %>
</head>
<body>
<nav class="navbar navbar-inverse fix">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/kickstarter/home">Kickstarter</a>
        </div>

        <div class="collapse navbar-collapse" id="myNavbar">
            <security:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/kickstarter/profile"><span
                            class="glyphicon glyphicon-user"></span>
                        <security:authentication property="principal.username"/></a>
                    </li>
                    <li><a href="/logout">Log out</a></li>

                </ul>
            </security:authorize>
            <security:authorize access="! isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/kickstarter/signup"><span
                            class="glyphicon glyphicon-user"></span> Sign Up</a>
                    </li>
                    <li><a href="/kickstarter/login"><span
                            class="glyphicon glyphicon-log-in"></span> Login</a>
                    </li>
                </ul>
            </security:authorize>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
            <security:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/kickstarter/addProject">Add Project</a></li>
                </ul>
           </security:authorize>
        </div>
    </div>
</nav>
</body>