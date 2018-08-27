<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
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

		
<%-- <link href="${css}/bootstrap.css" rel="stylesheet"> --%>
<!-- Bootstrap slate theme CSS -->
<link href="${css}/bootstrap.lux_theme.css" rel="stylesheet">

<!-- Data Table Boostrap ja file -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<script src="${js}/jquery.js"></script>

<!-- Custom styles for this template -->
<!-- <link href="css/shop-homepage.css" rel="stylesheet"> -->
<link href="${css}/myapp.css" rel="stylesheet">

<script>
	window.menu = '${title}'
	window.contextRoot = '${pageContext.request.contextPath}'
	window.categoryId = '${category.id}'
</script>
</head>

<body>
	<div class="wrapper">
		<!-- Navigation bar -->
					<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
						  <div class="container">
						    	<div class="navbar-header">
						      		<a class="navbar-brand" href="${flowExecutionUrl}&_eventId_home">Home</a>
						    	</div>
						   </div>
					</nav>


		<!-- /.container -->
		<!-- Page Content -->
		<div class="content parent_content" >
			
						<div class="container">
						   <h3>this will be trigerred by flow</h3>
						</div>
				
			
		</div>
		<!-- Footer -->
		<%@include file="../../common/footer.jsp"%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/bootstrap.js"></script>
		
		<script src="${js}/jquery.dataTables.js"></script>
		<!-- DataTable Bootstrap js file -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- Bootbox js file -->
		<%-- <script src="${js}/bootbox.js"></script> --%>
		<script src="${js}/bootbox.min.js"></script>
		
		
		<!-- Self COded js FIle -->
		<script src="${js}/myapp.js"></script>
		
	</div>
</body>

</html>
