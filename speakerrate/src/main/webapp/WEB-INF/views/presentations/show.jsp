<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<h1>Presentation</h1> 

<h2>Summary</h2>
<div>
	<ul>
		<li>
			<span>ID:</span> <span>${presentation.id}</span>
		</li>
		<li>
			<span>Title:</span> <span>${presentation.title}</span>
		</li>
		<li>
			<span>Date:</span> <span>${presentation.presentedAt}</span>
		</li>
	</ul>
</div>

<h2>Ratings</h2>
<div>
	<a href="${presentation.id}/ratings/new">Rate this presentation</a>
	<br/>
	<span>Average Content Score: ${presentation.averageContentScore}</span>
	<span>Average Delivery Score: ${presentation.averageDeliveryScore}</span>
</div>
<c:forEach items="${presentation.ratings}" var="rating">
	<div>
		<ul>
			<li>Submitted by: ${rating.email}</li>
			<li>Content Score: ${rating.contentScore}</li>
			<li>Delivery Score: ${rating.deliveryScore}</li>
			<li>Comments: ${rating.comment}</li>
		</ul>
	</div>
</c:forEach>