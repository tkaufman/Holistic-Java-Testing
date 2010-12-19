<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title><decorator:title /></title>
		<link rel="stylesheet" type="text/css" media="all" href="/speakerrate/resources/css/main.css" />
		<decorator:head />
	</head>
	<body>
		<div id="wrap">
			<decorator:body />
		</div>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
	</body>
</html>