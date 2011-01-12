<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<form:form action="create" method="post" modelAttribute="speaker">
	<fieldset>
		<ul>
			<li>
				<form:label path="firstName">First: </form:label>
				<form:input path="firstName"/>
				<form:errors path="firstName"/>
			</li>
			<li>
				<form:label path="lastName">Last: </form:label>
				<form:input path="lastName"/>
				<form:errors path="lastName"/>
			</li>
			<li>
				<form:label path="email">Email: </form:label>
				<form:input path="email"/>
				<form:errors path="email"/>
			</li>
		</ul>
	</fieldset>
	<button type="submit">Submit</button>
</form:form>