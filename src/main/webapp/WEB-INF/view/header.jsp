<div>
	<c:choose>
		<c:when test="${isLoggedIn}">
			<li><a href="/kickstarter/profile">Welcome, <c:out value="${user.name}" /></a></li>
			<li><a href="/kickstarter/logout">Log out</a></li>
			<li><c:out value="${isLoggedIn}" /></li>
		</c:when>
		<c:otherwise>
			<form action="/kickstarter/loginIn" method="post">
				Login: <input type="text" name="login"> Password: <input
					type="password" name="password"> <input type=submit
					name=submit value="Log In" />
			</form>
			<a href="/kickstarter/signup">Sign up</a>
		</c:otherwise>
	</c:choose>
</div>