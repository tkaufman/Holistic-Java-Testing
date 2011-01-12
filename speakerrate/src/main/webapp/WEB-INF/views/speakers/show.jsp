<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<h1>Speaker</h1> 

<h2>Summary</h2>
<div>
	<ul>
		<li>
			<span>ID:</span> <span>${speaker.id}</span>
		</li>
		<li>
			<span>First:</span> <span>${speaker.firstName}</span>
		</li>
		<li>
			<span>Last:</span> <span>${speaker.lastName}</span>
		</li>
		<li>
			<span>Email:</span> <span>${speaker.email}</span>
		</li>
	</ul>
</div>