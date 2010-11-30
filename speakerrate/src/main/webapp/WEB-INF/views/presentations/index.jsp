<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<html>
	<body>
		<a href="presentations/new">Create new presentation</a>
		<ul>
		<c:forEach items="${presentations}" var="presentation">
			<li><a href="presentations/${presentation.id}">${presentation.title}</a></li>
		</c:forEach>
		</ul>
	</body>
</html>