<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap slate theme CSS -->
<link href="${css}/bootstrap-spacelab-theme.css" rel="stylesheet">

<!-- Data Table Boostrap ja file -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<!-- <link href="css/shop-homepage.css" rel="stylesheet"> -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation bar -->
		<%@include file="./common/navbar.jsp"%>


		<!-- /.container -->
		<!-- Page Content -->
		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12 col-md-12">
						<div class="jumbotron">

							<h1>${errorTitle}</h1>
							<hr />
							<blockquote>${errorDescription}</blockquote>
						</div>

					</div>
				</div>
			</div>


		</div>
		<!-- Footer -->
		<%@include file="./common/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<%-- <script src="${js}/bootstrap.bundle.min.js"></script> --%>

		<%-- <script src="${js}/jquery.dataTables.js"></script> --%>
		<!-- DataTable Bootstrap js file -->
		<%-- <script src="${js}/dataTables.bootstrap.js"></script> --%>


		<!-- Self COded js FIle -->
		<%-- <script src="${js}/myapp.js"></script> --%>

	</div>
</body>

</html>
