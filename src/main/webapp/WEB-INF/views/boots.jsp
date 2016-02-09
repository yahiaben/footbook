<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Footbook</title>
	<%@include file="headLiens.jsp" %>
</head>
<body>
	<div class="wrapper">
		<%@include file="head.jsp" %>
            <section class="main">
                <%@include file="bodyAccueil.jsp" %>
                <p> ${connecte}</p>
                <c:set var="salary" scope="session" value="${2000*2}"/>
                <c:if test="${connecte == 'true'}">
  					 <p>test <c:out value="${salary}"/><p>
				</c:if>
				<c:if test="${connecte == 'false'}">
  					 <p>My salary : <c:out value="${salary}"/><p>
				</c:if>
   	        </section>
    	<%@include file="footer.jsp" %>
    </div>
	
	
	<%@include file="footerScripts.jsp" %>

</body>
</html>