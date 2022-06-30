<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>



<div id="basic-form" class="section">
	<div class="row">
		<form:form action="customer.htm" id="search1" method="POST"
			commandName="customer">
			<div class="col s12 m12 ">

				<div class="card-panel">
					<h4 class="header2">Customer Details</h4>
					<div class="row">
						<div class="col s12 m6 start-row">
							<error:description code="${success}" type="success"
								result="description" />${description}
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Riyaz Ahamed" id="name2" type="text"
										path="customerName" />
									<label for="first_name">Customer Name </label>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="abc@test.com" id="display" type="text"
										path="email" />
									<label for="display">Email </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="00 61 2 9999 5555" id="battery"
										type="text" path="phone" />
									<label for="battery">Phone </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="00 61 2 9999 5555" id="battery"
										type="text" path="mobile" />
									<label for="battery">Mobile</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:textarea placeholder="Address for the customer..."
										id="message2" class="materialize-textarea" rows="10"
										path="address"></form:textarea>
									<label for="message">Address</label>
								</div>
							</div>
						</div>
						<div class="col s12 m6">
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Queensland" id="display" type="text"
										path="state" />
									<label for="display">State</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Australia" id="battery" type="text"
										path="country" />
									<label for="battery">Country</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="4116" id="battery" type="text"
										path="postCode" />
									<label for="battery">Post Code</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="32 606 717 471" id="battery" type="text"
										path="abnLicense" />
									<label for="battery">ABN License</label>
								</div>
							</div>

							<div class="row">
								<div class="file-field input-field col s12">
									<div class="btn">
										<span>Choose License</span> <input type="file">
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text">
									</div>

								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<button class="btn cyan waves-effect waves-light right"
										id="submitForm" type="submit" name="action">
										Add <i class="material-icons right">chevron_right</i>
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