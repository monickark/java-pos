<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>

<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<form:form action="settings.htm" id="searchBar10" method="POST"
				commandName="settings">
				<div class="card-panel">
					<error:description code="${success}" type="success"
						result="description" />

					<h4 class="header2">Company Details</h4>

					<div class="green-text ">
						<p>${description}</p>

					</div>
					<form:hidden path="companyId"/>
			
					
					<div class="row">
						<div class="col s6">
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Address" id="address1"
										type="text" path="address1" />
									<label for="first_name">Address 1 </label>
								</div>
							</div>
							
														
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Address" id="address2" type="text"
										path="address2" />
									<label for="address2">Address 2</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="License No" id="licenseNo" type="text"
										path="licenseNo" />
									<label for="licenseNo">License No </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Mobile No" id="mobileNo" type="text"
										path="mobileNo" />
									<label for="mobileNo">Mobile No</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Email" id="email" type="text"
										path="email" />
									<label for="email">Email</label>
								</div>
							</div>

						</div>
						
						<div class="col s6">
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Promo Discount" id="promoDiscount" type="text"
										path="promoDiscount" />
									<label for="promoDiscount">Promo Discount</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Tax" id="tax" type="text"
										 path="tax"/>
									<label for="tax">Tax (%) </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Printer Name" id="printerName" type="text"
										path="printerName" />
									<label for="printerName">Printer Name</label>
								</div>
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
			</form:form>
		</div>
	</div>
</div>


