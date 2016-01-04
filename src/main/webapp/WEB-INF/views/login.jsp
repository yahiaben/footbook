<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<spring:url value="/resources/css/jqvmap.css" var="jqvmapcss" />
<spring:url value="/resources/js/jquery.vmap.js" var="jqueryvmap" />
<spring:url value="/resources/js/jquery.vmap.france.js" var="jqueryvmapfrance" />
<link href="${jqvmapcss}" rel="stylesheet" />
	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>

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
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>