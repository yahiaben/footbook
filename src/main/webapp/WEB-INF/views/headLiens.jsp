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