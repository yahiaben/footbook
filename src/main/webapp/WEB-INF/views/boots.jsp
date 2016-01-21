<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin" type="text/css" />
<!-- Custom CSS -->
<spring:url value="/resources/css/font-awesome.css" var="fontawesome" />
<spring:url value="/resources/css/style1.css" var="style1" />
<spring:url value="/resources/css/owl.carousel.css" var="owlcar" />
<spring:url value="/resources/css/owl.theme.css" var="owlth" />
<spring:url value="/resources/js/owl.carousel.js" var="owlcarJS" />
<spring:url value="/resources/js/jquery.countTo.js" var="jquCount" />
<spring:url value="/resources/css/jqvmap.css" var="jqvmapcss" />
<spring:url value="/resources/js/jquery.vmap.js" var="jqueryvmap" />
<spring:url value="/resources/js/jquery.vmap.france.js" var="jqueryvmapfrance" />
<link href="${fontawesome}" rel="stylesheet" />
<link href="${style1}" rel="stylesheet" />
<link href="${owlcar}" rel="stylesheet" />
<link href="${owlth}" rel="stylesheet" />
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
<link href="${jqvmapcss}" rel="stylesheet" />
<script src="${jqueryvmap}"></script>
<script src="${jqueryvmapfrance}"></script>
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
                            <li class="new-ads"><a href="account_create_post.html" class="btn btn-ads btn-block">Advertise</a></li>
                            <li><a href="signup.html">Signup</a></li>
                            <li class="dropdown">
                                <a class="dropdown-toggle" href="#" data-toggle="dropdown"><strong class="caret"></strong>&nbsp;Pages</a>
                                <ul class="dropdown-menu">
                                    <li><a href="account_posts.html">My Ads</a></li>
                                    <li><a href="account_create_post.html">Create Ads</a></li>
                                    <li><a href="account_profile.html">My Profile</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a class="dropdown-toggle" href="#" data-toggle="dropdown"><i class="fa fa-user"></i> <strong class="caret"></strong>&nbsp;</a>
                                <div class="dropdown-menu dropdown-login" style="padding:15px;min-width:250px">
                                    <form>                       
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon addon-login"><i class="fa fa-user"></i></span>
                                                <input type="text" placeholder="Username or email" required="required" class="form-control input-login">                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon addon-login"><i class="addon fa fa-lock"></i></span>
                                                <input type="password" placeholder="Password" required="required" class="form-control input-login">                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label class="string optional" for="user_remember_me">
                                                    <input type="checkbox" id="user_remember_me" style="">
                                                    Remember me
                                                </label>
                                            </div>
                                        </div>
                                        <input type="submit" class="btn btn-custom btn-block" value="Sign In">
                                        <a href="forgot_password.html" class="btn-block text-center">Forgot password?</a>
                                    </form>                                    
                                </div>
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
                                        <a href="category.html"><i class="fa shortcut-icon icon-blue"><div id="francemap" style="width: 500px; height: 500px;"></div></i></a>
                                        <a href="category.html"><h3>Selectionner une région</h3></a>
                                    </div>
                                
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="section-header">
                                        <h2>Featured</h2>
                                    </div>
                                    <div id="featured-products" class="owl-carousel owl-carousel-featured">
                                        <div class="item">
                                            <div class="item-ads-grid">
                                                <div class="item-badge-grid featured-ads">
                                                    <a href="#">Featured Ads</a>
                                                </div>
                                                <div class="item-img-grid">
                                                    <img alt="" src="assets/img/products/product-1.jpg" class="img-responsive img-center">
                                                </div>
                                                <div class="item-title">
                                                    <a href="detail.html"><h4>Lenovo A326 Black 4GB RAM</h4></a>
                                                </div>
                                                <div class="item-meta">
                                                    <ul>
                                                        <li class="item-date"><i class="fa fa-clock-o"></i> Today 10.35 am</li>
                                                        <li class="item-cat"><i class="fa fa-bars"></i> <a href="category.html">Electronics</a> , <a href="category.html">Smartphone</a></li>
                                                        <li class="item-location"><a href="category.html"><i class="fa fa-map-marker"></i> Manchester</a></li>
                                                        <li class="item-type"><i class="fa fa-bookmark"></i> New</li>
                                                    </ul>
                                                </div>
                                                <div class="product-footer">
                                                    <div class="item-price-grid pull-left">
                                                        <h3>$ 100</h3>
                                                        <span>Negotiable</span>
                                                    </div>
                                                    <div class="item-action-grid pull-right">
                                                        <ul>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="top" title="Save Favorite" class="btn btn-default btn-sm"><i class="fa fa-heart"></i></a></li>
                                                            <li><a href="detail.html" data-toggle="tooltip" data-placement="top" title="Show Details" class="btn btn-success btn-sm"><i class="fa fa-eye"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>   
                                        </div>
                                    </div>
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
                                            <f:input class="form-control input-lg" path="nom" placeholder="Nom"/>
                                        </div>
                                        <div class="form-group">
                                            <f:input class="form-control input-lg" path="prenom" placeholder="Prenom"/>
                                        </div>
                                        <div class="form-group">
                                            <f:input type="text" class="form-control input-lg" path="email" placeholder="Email"/>
                                        </div>
                                        <div class="form-group">
                                            <f:input type="password" class="form-control input-lg" path="password" placeholder="Password"/>
                                        </div>
                                        <div class="form-group">
                                            <f:textarea class="form-control input-lg" path="description" placeholder="Description"/>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label class="string optional" for="terms">
                                               	 	<f:checkbox path="mesChampionnats" value="DH"/>DH
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label class="string optional" for="terms">
                                               	 	<f:checkbox path="sexeJoueur" value="MASCULIN"/>Masculin
                                                </label>
                                            </div>
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
                                            <button class="btn btn-block btn-custom">Sign Up</button>
                                        </div>
                                    </f:form>
                                </div>
                            </div>
                            <div class="widget">
                                <div class="widget-header">
                                    <h3>Trends</h3>
                                </div>
                                <div class="widget-body">
                                    <ul class="trends">
                                        <li><a href="#">Smartphone &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                        <li><a href="#">Watch &amp; Jewelry &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                        <li><a href="#">Clothes &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                        <li><a href="#">Shoes &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                        <li><a href="#">Music &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                        <li><a href="#">Furniture &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                        <li><a href="#">Photography &nbsp;<span class="item-numbers">(242)</span></a></li>
                                        <li><a href="#">Web Development &nbsp;<span class="item-numbers">(2,342)</span></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="banner-widget">
                                <img src="http://placehold.it/600x275" alt="banner" class="img-responsive">
                            </div>
                        </div>
                    </div>
                </div>
            </section>
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