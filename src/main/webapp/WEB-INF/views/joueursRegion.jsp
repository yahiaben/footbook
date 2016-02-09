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
<spring:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
<script src="${jquery}"></script>
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
                                    	<c:set var="homme" value= "false"/>
                                    	<c:set var="femme" value= "false"/>
                                    	<c:set var="dh" value= "false"/>
                                    	<c:set var="ph" value= "false"/>
                                    	<c:set var="ag" value= "false"/>
                                    	<c:set var="ad" value= "false"/>
                                    	<c:set var="bu" value= "false"/>
                                    	<c:set var="mg" value= "false"/>
                                    	<c:set var="md" value= "false"/>
                                    	<c:set var="mc" value= "false"/>
                                    	<c:set var="dg" value= "false"/>
                                    	<c:set var="dd" value= "false"/>
                                    	<c:set var="dc" value= "false"/>
                                    	<c:set var="g" value= "false"/>
                                    	
                                    	<c:forEach items="${joueurs}" var="joueur">
                                    		<c:if test="${joueur.sexeJoueur == 'MASCULIN'}">
													<c:set var="homme" value= "true"/>
											</c:if>
											<c:if test="${joueur.sexeJoueur == 'FEMININ'}">
													<c:set var="femme" value= "true"/>
											</c:if>
											<c:forEach items="${joueur.mesChampionnats}" var="championnat">
												<c:if test="${championnat == 'DH'}">
													<c:set var="dh" value= "true"/>
												</c:if>
												<c:if test="${championnat == 'PH'}">
													<c:set var="ph" value= "true"/>
												</c:if>
											</c:forEach>
										</c:forEach>
										
                                    	<c:forEach items="${joueurs}" var="joueur">
											<c:forEach items="${joueur.mesPostes}" var="poste">
												<c:if test="${poste == 'AG'}">
													<c:set var="ag" value= "true"/>
												</c:if>
												<c:if test="${poste == 'AD'}">
													<c:set var="ad" value= "true"/>
												</c:if>
												<c:if test="${poste == 'BU'}">
													<c:set var="bu" value= "true"/>
												</c:if>
												<c:if test="${poste == 'MG'}">
													<c:set var="mg" value= "true"/>
												</c:if>
												<c:if test="${poste == 'MD'}">
													<c:set var="md" value= "true"/>
												</c:if>
												<c:if test="${poste == 'MC'}">
													<c:set var="mc" value= "true"/>
												</c:if>
												<c:if test="${poste == 'DG'}">
													<c:set var="dg" value= "true"/>
												</c:if>
												<c:if test="${poste == 'DD'}">
													<c:set var="dd" value= "true"/>
												</c:if>
												<c:if test="${poste == 'DC'}">
													<c:set var="dc" value= "true"/>
												</c:if>
												<c:if test="${poste == 'G'}">
													<c:set var="g" value= "true"/>
												</c:if>
											</c:forEach>
										</c:forEach>
                                    	<p>Sexe</p>
                                    	<c:if test="${homme}">
                                    		<input type="checkbox" class="btnChecked" id="MASCULIN" value="value" checked="checked"> Homme </input>
                                    	</c:if>
                                    	<c:if test="${femme}">
                                    	<input type="checkbox" class="btnChecked" id="FEMININ" value="value" checked="checked"> Femme </input>
                                    	</c:if><br/><br/>
                                    	
                                    	<p>Championnats</p>
                                    	<c:if test="${dh}">
                                    	<input type="checkbox" class="btnChecked" id="DH" value="value" checked="checked"> DH </input>
                                    	</c:if>
                                    	<c:if test="${ph}">
                                    	<input type="checkbox" class="btnChecked" id="PH" value="value" checked="checked"> PH </input>
                                    	</c:if><br /><br/>
                                    	
                                    	<p>Postes</p>
                                    	<c:if test="${ag}">
                                    	<input type="checkbox" class="btnChecked" id="AG" value="value" checked="checked"> AG </input>
                                    	</c:if>
                                    	<c:if test="${ad}">
                                    	<input type="checkbox" class="btnChecked" id="AD" value="value" checked="checked"> AD </input>
                                    	</c:if>
                                    	<c:if test="${bu}">
                                    	<input type="checkbox" class="btnChecked" id="BU" value="value" checked="checked"> BU </input>
                                    	</c:if>
                                    	<c:if test="${mg}">
                                    	<input type="checkbox" class="btnChecked" id="MG" value="value" checked="checked"> MG </input>
                                    	</c:if>
                                    	<c:if test="${md}">
                                    	<input type="checkbox" class="btnChecked" id="MD" value="value" checked="checked"> MD </input>
                                    	</c:if>
                                    	<c:if test="${mc}">
                                    	<input type="checkbox" class="btnChecked" id="MC" value="value" checked="checked"> MC </input>
                                    	</c:if>
                                    	<c:if test="${dg}">
                                    	<input type="checkbox" class="btnChecked" id="DG" value="value" checked="checked"> DG </input>
                                    	</c:if>
                                    	<c:if test="${dd}">
                                    	<input type="checkbox" class="btnChecked" id="DD" value="value" checked="checked"> DD </input>
                                    	</c:if>
                                    	<c:if test="${dc}">
                                    	<input type="checkbox" class="btnChecked" id="DC" value="value" checked="checked"> DC </input>
                                    	</c:if>
                                    	<c:if test="${g}">
                                    	<input type="checkbox" class="btnChecked" id="G" value="value" checked="checked"> G </input>
                                        </c:if>
                                        <!--  <li><button id="some_id">FEMININ</button></li>
                                        <li><button id="some_id2">MASCULIN</button></li>
>>>>>>> 4ae95a84e3fd75621d04d5f5e460d25cd2666fa0
                                        <li><a href="account_create_post.html">Create New Ads</a></li>
                                        <li><a href="account_profile.html">My Profile</a></li>-->
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
							    <div class="col-sm-3  ${joueur.sexeJoueur} ${championnats} ${postes}" onmouseover="showDetailPlayer(this);" onmouseout="hideDetailPlayer(this);">
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
						                    <p><a href="/app/profilJoueur/${joueur.idJoueur}" class="btn btn-default">Détails</a></p>
						                </div>
						            	</div>
						            	<div class=detailPlayer>
						            		<div class="avatar">
						                		<img class="src-image"  src="http://localhost:8888/img/${joueur.nomPhoto}" style="width:90px;height:90px;"></img>    
											</div>
						            		<p style="color:white;"></p>
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

	$(document).ready(function(){
		$('.btnChecked').change(function(){
			$('.btnChecked').each(function(){
				if($(this).is(":checked")){
					var id = $(this).attr('id');
					$("."+id).css({'display': 'block'});
				}
			})
			$('.btnChecked').each(function(){
				if(!($(this).is(":checked"))){
					var id = $(this).attr('id');
					$("."+id).css({'display': 'none'});
				}
			})
			return;
		})
	});
   
	function showDetailPlayer(div){
		$(div).find(".detailPlayer").show();
	}
	function hideDetailPlayer(div){
		$(div).find(".detailPlayer").hide();
	}
</script>
	
	<%@include file="footerScripts.jsp" %>
</body>
</html>
