<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<h1>Rating Details</h1> 

<span>ID:</span> <span>${rating.id}</span>
<br/>
<span>Presentation:</span> <span>${rating.presentation.title}</span>
<br/>
<span>Submitter:</span> <span>${rating.email}</span>
<br/>
<span>Status:</span> <span>${rating.status}</span>
<br/>
<span>Content:</span> <span>${rating.contentScore}</span>
<br/>
<span>Delivery:</span> <span>${rating.deliveryScore}</span>
<br/>
<span>Comment:</span> <span>${rating.comment}</span>
