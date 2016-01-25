<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@include file="headLiens.jsp" %>
</head>
<body>
	<div class="wrapper">
		<%@include file="head.jsp" %>
            <section class="main">
                <%@include file="bodyAccueil.jsp" %>
   	        </section>
    	<%@include file="footer.jsp" %>
    </div>
	
	
	<%@include file="footerScripts.jsp" %>

</body>
</html>