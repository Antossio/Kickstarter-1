<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="prefixes.jsp"%>
<html>
<head>
<%@include file="cssJs.jsp"%>
<title>Projects</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div class="row" id="body">

			<c:forEach var="project" items="${projects}">
				<div class="col-md-4">
					<div class="thumbnail my_thumbnail">
						<img src="/resources/image/images.jpg" alt="">

						<div class="caption">
							<h3>
								<c:out value="${project.name}" />
							</h3>

							<p>
								<c:out value="${project.shortDesc}" />
							</p>

							<p>
								<a href="/kickstarter/projects/<c:out value="${project.id}"/>"
									class="btn btn-success" role="button">Open Project</a>
							</p>
							<p>
								<c:if test="${empty project.likeList && not empty userID}">
								<a href="/kickstarter/like/<c:out value="${project.id}"/>"
												title="Like it">Like </a>										
								</c:if>
								<c:forEach var="userLike" items="${project.likeList}">																
									<c:choose>
										<c:when test="${userLike.user.id == user.id}">
											<a href="/kickstarter/unlike/<c:out value="${project.id}"/>"
												title="Unlike it">Unlike </a>
											</c:when>
										<c:otherwise>
											<a href="/kickstarter/like/<c:out value="${project.id}"/>"
												title="Like it">Like </a>
											</c:otherwise>
											
									</c:choose>
								</c:forEach>								
								<br><c:out value="${project.likesQty}" /> people like this project
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