<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="cssJs.jsp" %>
</head>
<body>
<nav class="navbar navbar-inverse fix">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/kickstarter/home">Kickstarter</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <c:choose>
                <c:when test="${isLoggedIn}">
                    <ul class="nav navbar-nav navbar-right">
                    <li><a href="/kickstarter/profile"><span
                            class="glyphicon glyphicon-user"></span><c:out
                            value="${user.name}"/></a></li>
                    <li><a href="/kickstarter/logout">Log out</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/kickstarter/signup"><span
                                class="glyphicon glyphicon-user"></span> Sign Up</a>
                        </li>
                        <li><a href="/kickstarter/loginIn"><span
                                class="glyphicon glyphicon-log-in"></span> Login</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>
</body>

