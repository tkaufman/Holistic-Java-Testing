<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<head>
	<script type="text/javascript" src="/speakerrate/resources/js/ratings/new.js"></script>	
</head>
<body>
	<span id="pageMetadata" class="ratings-new-page"></span>
	<form:form action="create" method="post" modelAttribute="rating">
		<fieldset>
			<ul>
				<li>
					<form:label path="email">E-mail:</form:label>
					<form:input path="email"/>
					<form:errors path="email"/>
				</li>
				<li>
					<form:label path="contentScore">Content Score:</form:label>
					<form:errors path="contentScore"/>
					<div id="contentScoreScale">
						<form:radiobuttons path="contentScore" items="${fn:split('0,10,20,30,40,50,60,70,80,90,100',',')}"/>					
					</div>
				</li>
				<li>
					<form:label path="deliveryScore">Delivery Score:</form:label>
					<form:errors path="deliveryScore"/>
					<div id="deliveryScoreScale">
						<form:radiobuttons path="deliveryScore" items="${fn:split('0,10,20,30,40,50,60,70,80,90,100',',')}"/>
					</div>
				</li>
				<li>
					<form:label path="comment">Comments:</form:label>
					<form:textarea path="comment"/>
					<form:errors path="comment"/>
				</li>
			</ul>
		</fieldset>
		<button type="submit">Create</button>
	</form:form>
</body>