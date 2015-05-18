<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="prefixes.jsp"%>
<head>
<%@include file="cssJs.jsp"%>
<title>Login In</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="row-fluid">
		<div
			class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Please login In</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="/kickstarter/login" method="post">

						<div class="form-group">
							<input type="text" name="login" class="form-control input-sm"
								placeholder="Login">
						</div>
						<div class="form-group">
							<input type="password" name="password"
								class="form-control input-sm" placeholder="Пароль">
						</div>
						<div class="form-inline">
							<label class="checkbox"> <input type="checkbox"
								value="remember-me"> Remember me
							</label>
						</div>
						<input type="submit" value="Login In"
							class="btn btn-info btn-block">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>