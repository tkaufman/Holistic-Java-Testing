<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<form:form action="/speakerrate/presentations" method="post" modelAttribute="presentation">
	
	
	<fieldset>
		<form:label path="title">Title: </form:label>
		<form:input path="title"/>
		
		<form:label path="presentedAt">Date: </form:label>
		<form:input path="presentedAt"/>
	</fieldset>
	<button type="submit">Submit</button>
</form:form>