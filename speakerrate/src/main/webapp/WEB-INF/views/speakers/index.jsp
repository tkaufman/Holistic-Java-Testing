<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<html>
	<body>
		<h1>Speakers</h1>
		<a href="speakers/new">Create new speaker</a>
		<div class="speakers-index">
			<ul>
				<c:forEach items="${speakers}" var="speaker">
					<li><a href="speakers/${speaker.id}">${speaker.firstName} ${speaker.lastName}</a></li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>