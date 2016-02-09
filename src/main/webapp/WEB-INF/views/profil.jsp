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
                            <li><a href="signup.html">Deconnexion</a></li>
                            

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
                                    <!-- User status -->
                                    <!-- Contact -->
                                    <a href="index.html" class="btn btn-primary btn-warning btn-sm"><i class="fa fa-sign-out"></i> Déconnexion </a>
                                </div> <!-- / .profile__summary -->
                            </div>
                        </div> <!-- / .row -->
                    </div> <!-- / .container -->
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-3">
                            <div class="widget">
                                <div class="widget-header">
                                    <h3>Menu</h3>
                                </div>
                                <div class="widget-body">
                                    <ul class="author-menus">
                                        <li><a href="account_profile.html">Mon Profil</a></li>
                                        <li><a href="index.html">Déconnexion</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9 col-sm-9">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"> <a href="#collapseB1" data-toggle="collapse"> Mon Profil </a> </h4>
                                </div>

                                <form accept-charset="utf-8" method="POST" action="/app/upload-picture" onsubmit="return verifForm(this)" enctype="multipart/form-data" id="UserProfileForm" class="form-horizontal">
                                    <div class="panel-body">            
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Nom</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="nom" required="required"  value="${joueur.nom}" class="form-control" >                                   </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Prénom</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="prenom" required="required"  value="${joueur.prenom}" class="form-control" >                                   </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Email</label>
                                            <div class="col-sm-9">
                                                <input type="email" name="email" required="required"  value="${joueur.email}" maxlength="100" class="form-control" readonly >                        
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        	<label class="col-sm-3 control-label">Postes</label>
                                        	<div class="checkbox col-sm-9">
                                                <select id="postes" class="js-example-basic-multiple form-control" name="postes" multiple="multiple">
  													<option value="AG" ${joueur.hasPoste("AG")}>AG</option>
  													<option value="AD" ${joueur.hasPoste("AD")}>AD</option>
  													<option value="BU" ${joueur.hasPoste("BU")}>BU</option>
  													<option value="MG" ${joueur.hasPoste("MG")}>MG</option>
  													<option value="MD" ${joueur.hasPoste("MD")}>MD</option>
  													<option value="MC" ${joueur.hasPoste("MC")}>MC</option>
  													<option value="DG" ${joueur.hasPoste("DG")}>DG</option>
  													<option value="DD" ${joueur.hasPoste("DD")}>DD</option>
  													<option value="DC" ${joueur.hasPoste("DC")}>DC</option>
  													<option value="G" ${joueur.hasPoste("G")}>G</option>
												</select>
												<errors  />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        	<label class="col-sm-3 control-label">Championnats</label>
                                        	<div class="checkbox col-sm-9">
                                                <select id="postes" class="js-example-basic-multiple form-control" name="championnats" multiple="multiple">
  													<option value="PH" ${joueur.hasChampionnat("PH")}>PH</option>
  													<option value="DH" ${joueur.hasChampionnat("DH")}>DH</option>
												</select>
												<errors  />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Description</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="description" required="required"  value="${joueur.description}" maxlength="100" class="form-control" >                        
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Ville</label>
                                            <div class="col-sm-9">
                                                <input type="text" name="ville" value="${joueur.ville}" class="form-control" >                                 </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-3 control-label">Photo</label>
                                            <div class="col-sm-9">
                                                <input type="file" name="file" class="filestyle" >
                                                <span class="help-block"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-3 control-label">Mot de passe</label>
                                            <div class="col-sm-9">
                                                <input type="password" name="mdp" id="password" class="form-control" placeholder="" value="" >                                         <span class="help-block"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-3 control-label">Confirmation Mot de passe</label>
                                            <div class="col-sm-9">
                                                <input type="password" name="cmdp" id="vpassword" class="form-control" >                                           <span class="help-block"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9"> </div>
                                        </div>

                                    </div>
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="submit" class="btn btn-custom"><i class="fa fa-save"></i> Sauvegarder</button>
                                                <button type="submit" class="btn btn-default"><i class="fa fa-close"></i> Annuler</button>
                                            </div>
                                        </div>
                                    </div>
                                </form> 
                            </div>
                        </div>  
                    </div>
                </div>
            </section>
    </div>
    <%@include file="footer.jsp" %>
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
	
	<script>
	function verifForm(f)
	{
	   var mdp1 = f.mdp;
	   var cmdp = f.cmdp;
	   
	   if(mdp1.value == cmdp.value && (mdp1.value.length > 7 || mdp1.value.length == 0))
	      return true;
	   else
	   {
		   if(mdp1.value == cmdp.value)
			 alert("La taille du mot de passe doit etre supérieur à 7 ! ");
		   else
	     	 alert("Les mots de passes doivent être identiques ! ");
	      return false;
	   }
	}
	
	function alerte(){
		alert("coucou");
	}
	
	
    </script>
	<%@include file="footerScripts.jsp" %>
</body>
</html>
