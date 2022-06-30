<!DOCTYPE html>
<html lang="en">
<!--================================================================================
  Item Name: Materialize - Material Design Admin Template
  Version: 4.0
  Author: PIXINVENT
  Author URL: https://themeforest.net/user/pixinvent/portfolio
  ================================================================================ -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control"  content="no-cache">
<meta http-equiv="Expires" content="timestamp">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="msapplication-tap-highlight" content="no">
<meta name="description"
	content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
<meta name="keywords"
	content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
<title>Retail POS</title>
<!-- Favicons-->
<link rel="icon" href="images/favicon/favicon.png" sizes="32x32">
<!-- Favicons-->
<link rel="apple-touch-icon-precomposed"
	href="images/favicon/apple-touch-icon-152x152.png">
<!-- For iPhone -->
<meta name="msapplication-TileColor" content="#00bcd4">
<meta name="msapplication-TileImage"
	content="images/favicon/mstile-144x144.png">
<!-- For Windows Phone -->
<!-- CORE CSS-->
<link href="css/themes/fixed-menu/materialize.css" type="text/css"
	rel="stylesheet">
<link href="css/themes/fixed-menu/style.css" type="text/css"
	rel="stylesheet">
<link href="vendors/data-tables/css/jquery.dataTables.min.css"
	type="text/css" rel="stylesheet">
<!-- Custome CSS-->
<link href="css/custom/custom.css" type="text/css" rel="stylesheet">
<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="vendors/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet">
<link href="vendors/flag-icon/css/flag-icon.min.css" type="text/css"
	rel="stylesheet">
<link href="vendors/sweetalert/dist/sweetalert.css" type="text/css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="vendors/signature/css/jquery.signature.css" type="text/css"
	rel="stylesheet">
</head>




<body>
	<!-- Start Page Loading -->
	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>
	</div>
	<!-- End Page Loading -->
	<!-- //////////////////////////////////////////////////////////////////////////// -->

	<tiles:insertAttribute name="header" />

	<!-- //////////////////////////////////////////////////////////////////////////// -->
	<!-- START MAIN -->
	<div id="main">
		<!-- START WRAPPER -->
		<div class="wrapper">
			<tiles:insertAttribute name="menu" />
			<!-- //////////////////////////////////////////////////////////////////////////// -->
			<!-- START CONTENT -->
			<section id="content">

				<div id="breadcrumbs-wrapper">
					<div class="container">
						<div class="row">
							<div class="col s10 m6 l6">
								<h5 class="breadcrumbs-title">
									<tiles:insertAttribute name="title" />
								</h5>
								<bc:description node="currentNode" output="breadcrumbs" />
								<div style="display: none" class="bc">${currentNode}</div>
								${breadcrumbs}
							</div>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="section">
						<tiles:insertAttribute name="body" />
					</div>
				</div>

			</section>
			<!-- END CONTENT -->
			<!-- //////////////////////////////////////////////////////////////////////////// -->
		</div>
		<!-- END WRAPPER -->
	</div>
	<!-- END MAIN -->
	<!-- //////////////////////////////////////////////////////////////////////////// -->

	<tiles:insertAttribute name="footer" />

	<!-- ================================================
        Scripts
  ================================================ -->
	<!-- jQuery Library -->
	<script type="text/javascript" src="vendors/jquery-3.2.1.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<!--scrollbar-->
	<script type="text/javascript"
		src="vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<!--plugins.js - Some Specific JS codes for Plugin Settings-->
	<script type="text/javascript" src="js/plugins.js"></script>
	<!--custom-script.js - Add your own theme custom JS-->
	<script type="text/javascript" src="js/custom-script.js"></script>
	<!--angularjs-->
	<script type="text/javascript" src="vendors/angular.min.js"></script>
	<!--prism -->
	<script type="text/javascript" src="vendors/prism/prism.js"></script>
	<!-- chartist -->
	<script type="text/javascript"
		src="vendors/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="vendors/jquery-validation/additional-methods.min.js"></script>
	<!--form-validation.js - Page Specific JS codes-->
	<script type="text/javascript" src="js/scripts/form-validation.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="vendors/signature/js/jquery.signature.min.js"></script>
	<!-- data-tables -->
	<script type="text/javascript"
		src="vendors/data-tables/js/jquery.dataTables.min.js"></script>
	<!--sweetalert -->
	<script type="text/javascript"
		src="vendors/sweetalert/dist/sweetalert.min.js"></script>
	<!--data-tables.js - Page Specific JS codes -->
	<script type="text/javascript" src="js/scripts/data-tables.js"></script>
	<!--extra-components-sweetalert.js - Some Specific JS-->
	<script type="text/javascript"
		src="js/scripts/extra-components-sweetalert.js"></script>
	<!--advanced-ui-modals.js - Some Specific JS codes -->
	<script type="text/javascript" src="js/scripts/advanced-ui-modals.js"></script>

	<script src="js/common.js"></script>
	<script src="js/till.js"></script>
	<script src="js/addproduct.js"></script>
	<script src="js/productlist.js"></script>
	<script src="js/brandmodel.js"></script>
	<script src="js/otherbrand.js"></script>
	<script src="js/setting.js"></script>
	<script src="js/customer.js"></script>
	<script src="js/tradein.js"></script>
	<script src="js/pos-accessories.js"></script>	
	<script src="js/accessories.js"></script>
	<script src="js/category.js"></script>
	<script>
		$(document).ready(function() {
			console.log("ready!");
		});
	</script>
</body>
</html>


