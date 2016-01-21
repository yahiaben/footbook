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
<link href="/resources/select2/dist/css/select2.min.css" rel="stylesheet" />
<script src="/resources/select2/js/select2.min.js"></script>
<spring:url value="/resources/css/jqvmap.css" var="jqvmapcss" />
<spring:url value="/resources/js/jquery.vmap.js" var="jqueryvmap" />
<spring:url value="/resources/js/jquery.vmap.france.js" var="jqueryvmapfrance" />
<spring:url value="/resources/select2/dist/css/select2.min.css" var="selectCss" />
<spring:url value="/resources/select2/dist/js/select2.min.js" var="selectJs" />
<link href="${selectCss}" rel="stylesheet" />
<link href="${jqvmapcss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="${jqueryvmap}"></script>
<script src="${selectJs}"></script>
<script src="${jqueryvmapfrance}"></script>
<script type="text/javascript">
  $('select').select2();
  //$(".js-example-basic-multiple").select2();
  $(".js-data-example-ajax").select2({
      ajax: {
        url: "https://api.github.com/search/repositories",
        dataType: 'json',
        delay: 250,
        data: function (params) {
          return {
            q: params.term, // search term
            page: params.page
          };
        },
        processResults: function (data, params) {
          // parse the results into the format expected by Select2
          // since we are using custom formatting functions we do not need to
          // alter the remote JSON data, except to indicate that infinite
          // scrolling can be used
          params.page = params.page || 1;
     
          return {
            results: data.items,
            pagination: {
              more: (params.page * 30) < data.total_count
            }
          };
        },
        cache: true
      },
      escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
      minimumInputLength: 1,
      templateResult: formatRepo, // omitted for brevity, see the source of this page
      templateSelection: formatRepoSelection // omitted for brevity, see the source of this page
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
<div class="container">
<div class="row">
  <div class="col-lg-6">
	<div id="francemap" style="width: 500px; height: 500px;"></div>
  </div>
  <div class="col-lg-6">	
	<div class="container-fluid">
	    <div class="row">
			<div class="span12">
				<form class="form-horizontal" action="j_spring_security_check" method="POST">
				  <fieldset>
				    <div id="legend">
				      <legend class="">Login</legend>
				    </div>
				   <div class="col-lg-4">				    
				    <div class="control-group">
				      <!-- Username -->
				      <label class="control-label"  for="username">Username</label>
				      <div class="controls">
				        <input type="text" id="username" name="j_username" placeholder="" class="input-xlarge">
				      </div>
				    </div>
				    </div>
				    <div class="col-lg-4">
				    <div class="control-group">
				      <!-- Password-->
				      <label class="control-label" for="password">Password</label>
				      <div class="controls">
				        <input type="password" id="password" name="j_password" placeholder="" class="input-xlarge">
				      </div>
				    </div>
				    </div>
				    <div class="col-lg-4">
				    <div class="control-group">
				      <!-- Button -->
				      <div class="controls">
				        <button type="submit" class="btn btn-success log">Login</button>
				      </div>
				    </div>
				    </div>
				  </fieldset>
				</form>
			</div>
		</div>
	</div>
  </div>
 </div>
 </div> 
 <div id="formJoueur">
 	<f:form modelAttribute="inscriptionDto" action="saveJoueur" method="post">
 	<table>
 		<tr>
 			<td>Nom</td>
 			<td><f:input path="nom"/></td>
 			<td><f:errors path="nom" cssClass="errors"></f:errors></td>
 		</tr>
 		<tr>
 			<td>Prenom</td>
 			<td><f:input path="prenom"/></td>
 			<td><f:errors path="prenom" cssClass="errors"></f:errors></td>
 		</tr>
 		<tr>
 			<td>Email</td>
 			<td><f:input path="email"/></td>
 			<td><f:errors path="email" cssClass="errors"></f:errors></td>
 		</tr>
 		<tr>
 			<td>Password</td>
 			<td><f:input type="password" path="password"/></td>
 			<td><f:errors path="password" cssClass="errors"></f:errors></td>
 		</tr>
 		<tr>
 			<td>Description</td>
 			<td><f:textarea path="description"/></td>
 			<td><f:errors path="description" cssClass="errors"></f:errors></td>
 		</tr>
 		<tr>
 			<td>Ville</td>
 			<td>  
 			<!--<f:select path="ville" class="js-example-basic-multiple " tabindex="-1" aria-hidden="true" id="rechercheVille">
 				<c:forEach items="${villes}" var="ville">
 					<option>${ville.ville_nom}</option>
 				</c:forEach>
 			</f:select>-->
 			<select aria-hidden="true" tabindex="-1" class="js-example-data-ajax form-control select2-hidden-accessible">
      <option value="3620194" selected="selected">select2/select2</option>
    </select><span style="width: 100%;" dir="ltr" class="select2 select2-container select2-container--default select2-container--below select2-container--open"><span class="selection"><span aria-owns="select2-jab2-results" aria-labelledby="select2-jab2-container" tabindex="0" class="select2-selection select2-selection--single" role="combobox" aria-haspopup="true" aria-expanded="true"><span title="select2/select2" id="select2-jab2-container" class="select2-selection__rendered">select2/select2</span><span class="select2-selection__arrow" role="presentation"><b role="presentation"></b></span></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
 			    
 			
 			</td>
 			
 			
 		</tr>
 		<tr>
 			<td>Niveaux Joués</td>
 			<td><f:checkbox path="mesChampionnats" value="PH"/>PH</td>
 			<td><f:checkbox path="mesChampionnats" value="PHR"/>PHR</td>
 			<td><f:checkbox path="mesChampionnats" value="DH"/>DH</td>
 		</tr>
 		<tr>
 			<td>Sexe</td>
 			<td><f:checkbox path="sexeJoueur" value="MASCULIN"/>MASCULIN</td>
 			<td><f:checkbox path="sexeJoueur" value="FEMININ"/>FEMININ</td>
 		</tr>
 		<tr>
 			<td>Photo</td>
 			<td><input type="file" name="photo"/></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><input type="submit" value="Save"/></td>
 		</tr>
 	</table>
 	</f:form>
 </div>
 <div id="">
 	<table>
 		<tr>
 			<th>Pseudo Joueur</th><th>description</th><th>Photo</th>
 		</tr>
 		<c:forEach items="${joueurs}" var="joueur">
 			<tr>
 				<td>${joueur.nom}</td>
 				<td>${joueur.description}</td>
 				<td></td>
 			</tr>
 		</c:forEach>
 	</table>
 </div>
 
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>