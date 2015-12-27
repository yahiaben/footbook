<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>
<body>
	
	<div class="container">
	    <div class="row">
			<div class="span12">
				<form class="form-horizontal" action="j_spring_security_check" method="POST">
				  <fieldset>
				    <div id="legend">
				      <legend class="">Login</legend>
				    </div>
				    <div class="control-group">
				      <!-- Username -->
				      <label class="control-label"  for="username">Username</label>
				      <div class="controls">
				        <input type="text" id="username" name="j_username" placeholder="" class="input-xlarge">
				      </div>
				    </div>
				    <div class="control-group">
				      <!-- Password-->
				      <label class="control-label" for="password">Password</label>
				      <div class="controls">
				        <input type="password" id="password" name="j_password" placeholder="" class="input-xlarge">
				      </div>
				    </div>
				    <div class="control-group">
				      <!-- Button -->
				      <div class="controls">
				        <button type="submit" class="btn btn-success">Login</button>
				      </div>
				    </div>
				  </fieldset>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
</body>
</html>