<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item" id="about">
              <a class="nav-link" href="${contextRoot}/about">About</a>
            </li>
            <li class="nav-item" id="listproduct">
              <a class="nav-link" href="${contextRoot}/show/all/products">View Products</a>
            </li>
            <li class="nav-item" id="manageproducts">
              <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
            </li>
            <li class="nav-item" id="contact">
              <a class="nav-link" href="${contextRoot}/contact">Contact</a>
            </li>
          </ul>
          
          <!-- Right Hand side Menu -->
          
          <ul class="nav navbar-nav navbar-right">
          
          		 <li class="nav-item" id="regiser">
              		<a class="nav-link" href="${contextRoot}/register">Sign Up</a>
           		 </li>
           		 
           		 <li class="nav-item" id="login">
              		<a class="nav-link" href="${contextRoot}/login">Login</a>
           		 </li>
          </ul>
        </div>
      </div>
    </nav>

</body>
</html>