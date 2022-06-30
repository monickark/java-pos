<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>

<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<form:form action="editProduct.htm" id="searchBar" method="POST"
				commandName="editProduct">
				<div class="card-panel">
					<error:description code="${success}" type="success"
						result="description" />


					<h4 class="header2">Product Details</h4>

					<div class="green-text ">
						<p>${description}</p>

					</div>
					<div class="row">
						<div class="col s6">
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Apple iphone 6s 32GB" id="name2"
										type="text" path="productName" readonly="true" />
									<label for="first_name">Product Name <span>*</span></label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="" id="name2" type="text" path="brand"
										readonly="true" />
									<label for="first_name">Brand </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="" id="name2" type="text" path="model"
										readonly="true" />
									<label>Brand Model <span>*</span>
									</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:select path="ramCapacity">
										<form:option value="" disabled="true" selected="true">Select RAM</form:option>
										<form:option value="16" path="ramCapacity">16 GB</form:option>
										<form:option value="32" path="ramCapacity">32 GB</form:option>
										<form:option value="64" path="ramCapacity">64 GB</form:option>
										<form:option value="128" path="ramCapacity">128 GB</form:option>
										<form:option value="256" path="ramCapacity">256 GB</form:option>
										<form:option value="512" path="ramCapacity">512 GB</form:option>
										<form:option value="1tb" path="ramCapacity">1 TB</form:option>
									</form:select>
									<label>RAM Size</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12 m12">
									<form:select multiple="true" path="colour">
										<form:option value="" disabled="true" selected="true">Select Colour</form:option>
										<form:option value="Black" path="colour">Black</form:option>
										<form:option value="Matte Black" path="colour">Matte Black</form:option>
										<form:option value="Jet Black" path="colour">Jet Black</form:option>
										<form:option value="White" path="colour">White</form:option>
										<form:option value="Grey" path="colour">Grey</form:option>
										<form:option value="Gold" path="colour">Gold</form:option>
										<form:option value="Blue" path="colour">Blue</form:option>
										<form:option value="Purple" path="colour">Purple</form:option>
										<form:option value="Silver" path="colour">Silver</form:option>
										<form:option value="Rose Gold" path="colour">Rose Gold</form:option>
										<form:option value="Space Grey" path="colour">Space Grey</form:option>
									</form:select>
									<label class="multiple-label">Colour <span>*</span>
									</label>
								</div>
							<%-- <form:hidden path="colour" class="multi-colour" />
								<div class="input-field col s12 m12">
									<select multiple name="colour1" class=".select-color">
										<option value="" disabled selected>Select Colour</option>
										<option value="Black" >Black</option>
										<option value="Matte Black">Matte Black</option>
										<option value="Jet Black" >Jet Black</option>
										<option value="White">White</option>
										<option value="Grey">Grey</option>
										<option value="Gold">Gold</option>
										<option value="Blue">Blue</option>
										<option value="Purple">Purple</option>
										<option value="Silver">Silver</option>
										<option value="Rose Gold">Rose Gold</option>
										<option value="Space Grey">Space Grey</option>
									</select>
									<label class="multiple-label">Colour <span>*</span>
									</label>
								</div> --%>
								
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="5.2 inch" id="dimensions" type="text"
										path="dimensions" />
									<label for="dimensions">Dimensions</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Retina eye" id="display" type="text"
										path="display" />
									<label for="display">Display</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="12mAh" id="battery" type="text"
										path="battery" />
									<label for="battery">Battery</label>
								</div>
							</div>

						</div>
						<div class="col s6">
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio">
										<label>Sim Type</label>
									</div>
									<p style="display: inline">

										<form:radiobutton class="with-gap" name="simType"
											value="Single Sim" id="test1" path="simType" />
										<label for="test1">Single Sim</label>
									</p>
									<p style="display: inline">
										<form:radiobutton class="with-gap" name="simType"
											value="Dual Sim" id="test2" path="simType" />
										<label for="test2">Dual Sim</label>
									</p>
									<div class="pad-bot-20"></div>
								</div>
							</div>
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio">
										<label>OS</label>
									</div>
									<p style="display: inline">

										<form:radiobutton class="with-gap" name="os" value="Apple"
											id="test3" path="os" />
										<label for="test3">Apple</label>
									</p>
									<p style="display: inline">
										<form:radiobutton class="with-gap" name="os" value="Android"
											id="test4" path="os" />
										<label for="test4">Android</label>
									</p>
									<p style="display: inline">
										<form:radiobutton class="with-gap" name="os"
											value="Blackberry" id="test5" path="os" />
										<label for="test5">Blackberry</label>
									</p>
									<div class="pad-bot-20"></div>
								</div>
							</div>
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio">
										<label>Choose Category</label>
									</div>
									<p style="display: inline">

										<form:radiobutton class="with-gap" name="category"
											value="New Brand" id="testa" path="category" /> <label
											for="testa">New Brand</label>
									</p>
									<p style="display: inline">
										<form:radiobutton class="with-gap" name="category"
											value="New Never Used" id="testb" path="category" /> <label
											for="testb">New Never Used</label>
									</p>
									<p style="display: inline">
										<form:radiobutton class="with-gap" name="category"
											value="Used" id="testc" path="category" /> <label
											for="testc">Used</label>
									</p>
									<div class="pad-bot-20"></div>
								</div>
							</div>
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio">
										<label>Sim card size</label>
									</div>
									<form:hidden path="simCardSize" class="simCardSize" />
									<p style="display: inline">
										<input type="checkbox" class="filled-in" id="filled-in-box1"
											name="simCard" value="Nano Sim" /> <label
											for="filled-in-box1">Nano Sim</label>
									</p>
									<p style="display: inline">
										<input type="checkbox" class="filled-in" id="filled-in-box2"
											name="simCard" value="Micro Sim" /> <label
											for="filled-in-box2">Micro Sim</label>
									</p>
									<div class="pad-bot-20"></div>
								</div>
							</div>
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio">
										<label>Non Removable Battery</label>
									</div>
									<form:hidden path="nonRemovalBattery" class="batterytype" />
									<div class="switch ">
										<label> No <input type="checkbox"
											name="nonRemovalBattery1" /> <span class="lever"></span> Yes
										</label>
									</div>
								</div>

							</div>
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio">
										<label>Published</label>
									</div>
									<form:hidden path="published" class="publishtype" />
									<div class="switch ">
										<label> No <input type="checkbox" name="published1" />
											<span class="lever"></span> Yes
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:textarea placeholder="Few words about the product..."
										id="message2" class="materialize-textarea" rows="10"
										path="description"></form:textarea>
									<label for="message">Description</label>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<button class="btn cyan waves-effect waves-light right"
											id="submitForm" type="submit" name="action">
											Submit <i class="material-icons right">chevron_right</i>
										</button>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>

