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
                                               	 	<f:radiobutton path="sexeJoueur" value="MASCULIN" checked="checked"/>  Mr
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
                                            <div class="checkbox">
                                                <!--<label class="string optional" for="terms">
                                               	 	<f:checkbox path="mesChampionnats" value="DH"/>DH
                                                </label>-->
                                                <f:select path="mesPostes" class="js-example-basic-multiple form-control" multiple="multiple">
  													<option value="AG">AG</option>
  													<option value="AD">AD</option>
  													<option value="BU">BU</option>
  													<option value="MG">MG</option>
  													<option value="MD">MD</option>
  													<option value="MC">MC</option>
  													<option value="DG">DG</option>
  													<option value="DD">DD</option>
  													<option value="DC">DC</option>
  													<option value="G">G</option>
												</f:select>
												<f:errors path="mesPostes" />
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