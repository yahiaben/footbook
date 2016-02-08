<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Footbook Profil</title>
	<%@include file="headLiens.jsp" %>
</head>
<body>
<div class="wrapper">
		<header  class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container">
                    <div class="navbar-header">
                        <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="index.html" class="navbar-brand"><span class="logo"><i class="fa"></i> Footbook</span></a>
                    </div>

                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="new-ads"><a href="/app/accueil" class="btn btn-ads btn-block">Accueil</a></li>
                        </ul>
                    </div>
                </div>
            </header>
            
            <section class="main no-padding">
                <div class="account-header">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-4 col-md-3 col-lg-2">
                                <!-- User avatar -->
                                <div class="profile_avatar">
                                    <img src="http://localhost:8888/img/${joueur.nomPhoto}" alt="avatar" class="img-responsive">
                                </div>
                            </div>
                            <div class="col-sm-8 col-md-9 col-lg-10">
                                <div class="profile_summary">
                                    <!-- User name --> 
                                    <h3 class="profile_name">${joueur.nom} ${joueur.prenom} </h3>
                                    <!-- Contact -->
                                    <a href="#contact" class="btn btn-primary btn-warning btn-sm"><i class="fa fa-sign-out"></i>Contactez</a>
                                </div> <!-- / .profile__summary -->
                            </div>
                        </div> <!-- / .row -->
                    </div> <!-- / .container -->
                </div>
                </section>
                <section class="main">
                <div class="container">
                     <div class="row">
                        <div class="col-md-4 col-sm-4">
                            <div class="widget">
                                <div class="widget-header">
                                    <h3>Description</h3>
                                </div>
                                <div class="widget-body">
                                    <address>
                                        <strong>${joueur.nom} ${joueur.prenom}</strong><br/>
                                        ${joueur.description}
                                    </address>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 col-sm-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="widget" id="contact">
                                        <div class="widget-header">
                                            <h3>Envoyer Message</h3>
                                        </div>
                                        <div class="widget-body">
                                        
                                        <c:url var="urlPost" value="/contacterJoueur"/>
                                      
                                            <f:form modelAttribute="envoiMailDto" action="${urlPost}" method="post">
                                                <div class="row">
                                                    <div class="col-xs-4">
                                                        <f:input type="text" path="nom" placeholder="Nom" class="form-control input-lg"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <f:input type="text" path="emailEnvoyeur" placeholder="Email" class="form-control input-lg"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <f:input type="text" path="objet" placeholder="Objet" class="form-control input-lg"/>
                                                    </div>
                                                    <f:input type="text" path="emailReceveur" placeholder="Objet" class="form-control input-lg" value="${joueur.email}" style="display:none;"/>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <f:textarea rows="5" path="contenu" placeholder="Ecrire votre message ici..." class="form-control"></f:textarea>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <button class="btn btn-lg btn-custom pull-right" type="submit">Envoyer</button>
                                                    </div>
                                                </div>
                                            </f:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
</div>

</body>
</html>