<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<html>
	<body>
		<span id="pageMetadata" class="presentations-index-page"></span>
		<h1>Presentations</h1>
		<a href="presentations/new" class="presentations-new-link">Create new presentation</a>
		<div class="presentations-index">
			<ul>
				<c:forEach items="${presentations}" var="presentation">
					<li><a href="presentations/${presentation.id}">${presentation.title}</a></li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>