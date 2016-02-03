<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FootBook - ${region}</title>
	

<spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin" type="text/css" />
<!-- Custom CSS -->

<spring:url value="/resources/css/style1.css" var="style1" />
<link href="${style1}" rel="stylesheet" />
<spring:url value="/resources/js/scriptJS.js" var="scriptJS" />
<script src="${scriptJS}"></script>
</head>
<body>
	
	<div class="wrapper">
		<%@include file="head.jsp" %>

		<div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-3"><br><br>
                            <div class="widget">
                                <div class="widget-header">
                                    <h3>Critères de recherche</h3>
                                </div>
                                <div class="widget-body">
                                    <ul class="author-menus">
                                        <li><button id="some_id">Sexe</button></li>
                                        <li><a href="account_create_post.html">Create New Ads</a></li>
                                        <li><a href="account_profile.html">My Profile</a></li>
                                        <li><a href="/app/accueil">Accueil</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9 col-sm-9">

							<h2 class="hero-title">Les joueurs de la région ${region}</h2><br>
						<div class="row">
							<c:forEach items="${joueurs}" var="joueur">
								<% String championnats = ""; %>
								<% String postes = ""; %>
								<c:forEach items="${joueur.mesChampionnats}" var="championnat">
									<c:set var="championnats" value="${championnats} ${championnat}"/>
								</c:forEach>
								<c:forEach items="${joueur.mesPostes}" var="poste">
									<c:set var="postes" value="${postes} ${poste}"/>
								</c:forEach>
							    <div class="col-sm-3  ${joueur.sexeJoueur} ${championnats} ${postes}">
						            <div class="card">
						                <canvas class="header-bg" width="250" height="70" id="header-blur" style="background-image:url(http://localhost:8888/img/yahia2.png);"></canvas>
						                <div class="avatar">
						                	<img class="src-image"  src="http://localhost:8888/img/${joueur.nomPhoto}" style="width:90px;height:90px;"></img>    
	
						                </div>
						                <div class="content">

						                    <p style="color:white;">${joueur.nom} ${joueur.prenom} <br/>
						                       <c:forEach items="${joueur.mesPostes}" var="poste">
						                       		${poste}
						                       </c:forEach>
						                     </p>

						                    <p><button type="button" class="btn btn-default">Détails</button></p>
						                </div>
						            	</div>
						        	</div>
						        	<c:set var="championnats" value=""/>
						        	<c:set var="postes" value=""/>
						    	</c:forEach>
						    </div>
						</div>
						  
                    </div>
                </div>
                    </div><br>

	                
                
	               
    	<%@include file="footer.jsp" %>
    </div>
	<script type="text/javascript">
			String.prototype.endsWith = function(suffix) {
				return this.indexOf(suffix, this.length - suffix.length) !== -1;
			};
			function upload(){
				var filename = $("#file").val();
				if(filename.endsWith(".jpg")){
					$("#sendUpload").click();
				}
				else{
					alert("Accept only .jpg file !");
				}
			}
			$("#file").on("change",function(){upload();});
			$("#uploadButton").on("click",function(){$("#file").click()});
	</script>
	<script type="text/javascript">
    var theButton = document.getElementById('some_id');

    theButton.onclick = function() { 
    	var elems = document.getElementsByClassName('MASCULIN');   
    	for(var i = 0; i < elems.length; i++)
    	{
    	console.log("tessssst " + elems.length);
    	//elems[i].remove(); // hidden has to be a string
    	elems[i].style.visibility = "hidden";
    	}
    	//elems[elems.length-1].remove();
    }

</script>
	
	<%@include file="footerScripts.jsp" %>
</body>
</html>
