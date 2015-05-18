<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="cssJs.jsp" %>
    <title>Sign up</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="row-fluid">
    <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please sign up</h3>
            </div>
            <div class="panel-body">
                <form role="form" action="/kickstarter/signup" method="post">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="name"
                                       class="form-control input-sm"
                                       placeholder="Имя">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="login"
                                       class="form-control input-sm"
                                       placeholder="Логин">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="email" name="email"
                               class="form-control input-sm"
                               placeholder="Email Адрес">
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="password" name="password"
                                       class="form-control input-sm"
                                       placeholder="Пароль">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="password"
                                       name="password_confirmation"
                                       class="form-control input-sm"
                                       placeholder="Подтверждение пароля">
                            </div>
                        </div>
                    </div>

                    <input type="submit" value="Регистрация"
                           class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
