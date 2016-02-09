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
			                   <form id="signin" class="navbar-form navbar-right" action="/app/j_spring_security_check" method="POST">
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
                    <h2 class="hero-title">Trouvez votre futur joueur star ici</h2>
                    <p class="hero-description hidden-xs">Le football c'est simple, c'est footbook</p>
                    <div class="row hero-search-box">
                        <form action="/app/joueursVille/" method="get">
                            <div class="col-md-8 col-sm-8 search-input">
                                <input id="ville" name ="ville" type="text" class="form-control input-lg search-first" placeholder="Entrer une ville...">
                            </div>
                            <div class="col-md-4 col-sm-4 search-input">
                                <button class="btn btn-custom btn-block btn-lg">Rechercher</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>