<header class="navbar navbar-default navbar-fixed-top navbar-top">
                <div class="container">
                    <div class="navbar-header">
                        <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="accueil" class="navbar-brand"><span class="logo"><i class=""></i> FootBook</span></a>
                    </div>	
					
					<c:if test="${connecte == 'false'}">
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
					</c:if>
                  
                  	<c:if test="${connecte == 'true'}">
						<div class="navbar-collapse collapse">
	                        <ul class="nav navbar-nav navbar-right">
	                            <li class="dropdown">
                                    	<a href="/app/profil">
                                    		<button class="btn btn-block btn-custom">Mon compte</button>
                                    	</a>
                                    	<a href="/app/logout">
                                    		<button class="btn btn-block btn-custom">Deconnexion</button>
                                    	</a>
                                  
	                            </li>
	
	                        </ul>
	                    </div>
					</c:if>
					
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