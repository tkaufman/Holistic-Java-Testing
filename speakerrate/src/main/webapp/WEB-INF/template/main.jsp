<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title><decorator:title /></title>
		<link rel="stylesheet" type="text/css" media="all" href="/speakerrate/resources/css/main.css" />
		<link rel="stylesheet" type="text/css" media="all" href="/speakerrate/resources/css/smoothness/jquery-ui-1.8.7.custom.css" />

		<script type="text/javascript" src="/speakerrate/resources/js/vendor/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="/speakerrate/resources/js/vendor/jquery-ui-1.8.7.custom.min.js"></script>
		<script type="text/javascript" src="/speakerrate/resources/js/sliderfy.js"></script>
		<decorator:head />
	</head>
	<body>
		<div id="wrap">
			<decorator:body />
		</div>
	</body>
</html>