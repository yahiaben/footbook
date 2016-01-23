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
<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin" type="text/css" />
<!-- Custom CSS -->

<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
<spring:url value="/resources/css/font-awesome.css" var="fontawesome" />
<spring:url value="/resources/css/style1.css" var="style1" />
<spring:url value="/resources/css/owl.carousel.css" var="owlcar" />
<spring:url value="/resources/css/owl.theme.css" var="owlth" />
<spring:url value="/resources/js/owl.carousel.js" var="owlcarJS" />
<spring:url value="/resources/js/jquery.countTo.js" var="jquCount" />
<spring:url value="/resources/css/jqvmap.css" var="jqvmapcss" />
<spring:url value="/resources/js/jquery.vmap.js" var="jqueryvmap" />
<spring:url value="/resources/js/jquery.vmap.france.js" var="jqueryvmapfrance" />
<spring:url value="/resources/select2/dist/css/select2.min.css" var="selectCss" />
<spring:url value="/resources/select2/dist/js/select2.min.js" var="selectJs" />
<link href="${selectCss}" rel="stylesheet" />
<link href="${fontawesome}" rel="stylesheet" />
<link href="${style1}" rel="stylesheet" />
<link href="${owlcar}" rel="stylesheet" />
<link href="${owlth}" rel="stylesheet" />
<script src="${selectJs}"></script>
<link href="${jqvmapcss}" rel="stylesheet" />
<script src="${jqueryvmap}"></script>
<script src="${jqueryvmapfrance}"></script>
<script type="text/javascript">
  $('select').select2();
  $(document).ready(function() {
	  $(".js-example-basic-single").select2();
	  $(".js-example-basic-multiple").select2();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#francemap').vectorMap({
		    map: 'france_fr',
			hoverOpacity: 0.5,
			hoverColor: "#EC0000",
			backgroundColor: "#ffffff",
			color: "#FACC2E",
			borderColor: "#000000",
			selectedColor: "#EC0000",
			enableZoom: true,
			showTooltip: true,
		    onRegionClick: function(element, code, region)
		    {
		        var message = 'Région : "'
		            + region 
		            + '" || Id : "'
		            + code
					+ '"';
             window.location.href = "joueurs/" + region;
		        //alert(message);
		    }
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<header class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container">
                    <div class="navbar-header">
                        <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="index.html" class="navbar-brand"><span class="logo"><i class=""></i> FootBook</span></a>
                    </div>	
					
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
			                   <form id="signin" class="navbar-form navbar-right" action="j_spring_security_check" method="POST">
			                        <div class="input-group">
			                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			                            <input id="email" type="email" class="form-control" name="j_username" value="" placeholder="Email Address">                                        
			                        </div>
			
			                        <div class="input-group">
			                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			                            <input id="password" type="password" class="form-control" name="j_password" value="" placeholder="Password">                                        
			                        </div>
			
			                        <div class="form-group">
                                            <button type="submit" class="btn btn-block btn-custom">Login</button>
                                    </div>
			                   </form>
                            </li>

                        </ul>
                    </div>
                </div>
            </header>
            <section class="hero">
                <div class="container text-center">
                    <h2 class="hero-title">Trouver votre futur joueur star ici</h2>
                    <p class="hero-description hidden-xs">Le football c'est simple, c'est footbook</p>
                    <div class="row hero-search-box">
                        <form>
                            <div class="col-md-4 col-sm-4 search-input">
                                <input type="text" class="form-control input-lg search-first" placeholder="J'ai de la chance...">
                            </div>
                            <div class="col-md-4 col-sm-4 search-input">
                                        <select class="form-control input-lg search-second">
                                            <option selected="">All Location</option>
                                            <option>New York</option>
                                            <option>Washington</option>
                                            <option>California</option>
                                        </select>
                            </div>
                            <div class="col-md-4 col-sm-4 search-input">
                                <button class="btn btn-custom btn-block btn-lg"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
            <section class="main">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-sm-8">
                            <div class="row">
                            	<div class="section-header">
                                	<h2>Simplicé et efficacité : la map Footbook</h2>
                                </div>
                                    <div class="shortcut">
                                        <i class="fa shortcut-icon icon-blue"><div id="francemap" style="width: 500px; height: 500px;"></div></i>
                                        <h3>Selectionner une région</h3>
                                    </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-4">
                            	<div class="section-header">
                                	<h2>Inscription</h2>
                                </div>
                            <div class="widget">
                                <div class="widget-header">
                                    <h3>Le foot c'est simple</h3>
                                </div>
                                <div class="widget-body">
                                    <f:form modelAttribute="inscriptionDto" action="saveJoueur" method="post">
                                       <div class="form-group">
                                            <div class="checkbox">
                                                <label class="string optional" for="terms">
                                               	 	<f:radiobutton path="sexeJoueur" value="MASCULIN"/>  Mr
                                                </label>
                                                <label class="string optional" for="terms">
                                               	 	<f:radiobutton path="sexeJoueur" value="FEMININ"/>  Mme
                                                </label>
                                                <f:errors path="sexeJoueur" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <f:input class="form-control input-lg" path="nom" placeholder="Nom"/>
                                            <f:errors path="nom" />
                                        </div>
                                        <div class="form-group">
                                            <f:input class="form-control input-lg" path="prenom" placeholder="Prenom"/>
                                            <f:errors path="prenom"/>
                                        </div>
                                        <div class="form-group">
                                            <f:input type="text" class="form-control input-lg" path="email" placeholder="Email"/>
                                            <f:errors path="email" />
                                        </div>
                                        <div class="form-group">
                                            <f:input type="password" class="form-control input-lg" path="password" placeholder="Password"/>
                                            <f:errors path="password" />
                                        </div>
                                        <div class="form-group">
                                            <f:textarea class="form-control input-lg" path="description" placeholder="Description"/>
                                            <f:errors path="description" />
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <!--<label class="string optional" for="terms">
                                               	 	<f:checkbox path="mesChampionnats" value="DH"/>DH
                                                </label>-->
                                                <f:select path="mesChampionnats" class="js-example-basic-multiple form-control" multiple="multiple">
  													<option value="DH">DH</option>
  													<option value="PH">PH</option>
												</f:select>
												<f:errors path="mesChampionnats" />
                                            </div>
                                        </div>
                                        <div class="form-group">
 											<div class="widget-header">
                                   				<h3>Votre ville</h3>
                                			</div>
 											<f:select path="ville" class="js-example-basic-single form-control" >
												<c:forEach items="${villes}" var="ville">
 													<option value="${ville.ville_nom}">${ville.ville_nom}</option>
 												</c:forEach>
											</f:select>
											<f:errors path="ville" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label class="string optional" for="terms">
                                                    <input type="checkbox" id="terms" style="">
                                                    <a href="#">I Agree with Term and Conditions</a>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-block btn-custom">S'inscrire</button>
                                        </div>
                                    </f:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <div class="counter">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-database"></i></span>
                                <div data-refresh-interval="100" data-speed="3000" data-to="7803" data-from="0" class="item-count">7803</div>
                                <span class="item-info">Inscrit Aujourd'hui</span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-user-plus"></i></span>
                                <div data-refresh-interval="50" data-speed="5000" data-to="427" data-from="0" class="item-count">427</div>
                                <span class="item-info">Sellers</span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-map-marker"></i></span>
                                <div data-refresh-interval="80" data-speed="5000" data-to="639" data-from="0" class="item-count">639</div>
                                <span class="item-info">Clubs Partenaire</span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="item-counter">
                                <span class="item-icon"><i class="fa fa-users"></i></span>
                                <div data-refresh-interval="80" data-speed="5000" data-to="1548" data-from="0" class="item-count">1548</div>
                                <span class="item-info">Joueurs Membre</span>
                            </div>
                        </div>
                    </div>
                </div> <!-- / .counter -->
    </div>
    <div class="footer">
        <div class="container">
        <ul class="pull-left footer-menu">
            <li>
                <a href="index.html"> Accueil </a>
                <a href="about.html"> A propos de nous </a>
                <a href="contact.html"> Contactez-nous </a>
            </li>
        </ul>
        <ul class="pull-right footer-menu">
            <li> &copy; 2016 Footbook </li>
        </ul>
        </div>
    </div>
	</div>
	
	
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="${owlcarJS}"></script>
	<script src="${jquCount}"></script>
	<script type="text/javascript">
    $(document).ready(function () {

        // ===========Featured Owl Carousel============
        if ($(".owl-carousel-featured").length > 0) {
            $(".owl-carousel-featured").owlCarousel({
                items: 3,
                lazyLoad: true,
                pagination: true,
                autoPlay: 5000,
                stopOnHover: true
            });
        }

        // ==================Counter====================
        $('.item-count').countTo({
            formatter: function (value, options) {
                return value.toFixed(options.decimals);
            },
            onUpdate: function (value) {
                console.debug(this);
            },
            onComplete: function (value) {
                console.debug(this);
            }
        });
    });
</script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-68907527-1', 'auto');
  ga('send', 'pageview');

</script>

</body>
</html>