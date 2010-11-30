<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<h1>Presentation Details</h1> 

<span>ID:</span> <span>${presentation.id}</span>
<br/>
<span>Title:</span> <span>${presentation.title}</span>
<br/>
<span>Date:</span> <span>${presentation.presentedAt}</span>
