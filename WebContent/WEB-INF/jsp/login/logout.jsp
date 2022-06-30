<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8" />
<title>Retail POS</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/metro.css" rel="stylesheet" />
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/style_responsive.css" rel="stylesheet" />
<link href="assets/css/style_default.css" rel="stylesheet"
	id="style_color" />
<link rel="stylesheet" type="text/css"
	href="assets/uniform/css/uniform.default.css" />
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
	
	<c:choose>
	<c:when test="${param.B eq '0'}">
	Sample School
	</c:when>
	<c:when test="${param.B eq '1'}">
	<img src="images/BR001_LOGO.png"
			style="margin-right: 10px; width: 150px; height: 80px;" alt="Logo" />
	</c:when>
	<c:when test="${param.B eq '2'}">
	<img src="images/BR002_LOGO.png"
			style="margin-right: 10px; width: 150px; height: 80px;" alt="Logo" />
	</c:when>
	<c:otherwise>
	SAMPLE <span>SCHOOL</span>
	</c:otherwise>
	</c:choose>
		
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<h3>
			<u>Log Out</u>
		</h3>

		<h5>
			You are successfully logout. <br /> Click <a href="login.htm">here</a>
			to login again
		</h5>
		
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">2015 &copy; ENKALVI.</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS -->
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/uniform/jquery.uniform.min.js"></script>
	<script src="assets/js/jquery.blockui.js"></script>
	<script src="assets/js/app.js"></script>
	<script>
    jQuery(document).ready(function() {     
      App.initLogin();
    });
  </script>

	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>