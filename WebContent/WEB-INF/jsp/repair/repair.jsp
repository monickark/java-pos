<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>



<div id="basic-form" class="section">
	<form:form action="repair.htm" id="search4" method="POST"
		commandName="repair">
		<div class="row">
			<div class="col s12 m12 ">
				<div class="card-panel">
					<h4 class="header2">Repair Details</h4>
					<div class="row">
						<div class="col s6 m6 ">

							<error:description code="${success}" type="success"
								result="description" />${description}
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Riyaz Ahamed" id="name" type="text"
										path="name" />
									<label for="first_name"> Name </label>
								</div>
							</div>

							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="1111111111" id="contactNo" type="text"
										path="contactNo" />
									<label for="display">Contact No </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Apple 6s" id="productName" type="text"
										path="productName" />
									<label for="battery">Product Name </label>
								</div>
							</div>
						</div>
						<div class="col s6 m6 ">
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="100" id="repairValue" type="text"
										path="repairValue" />
									<label for="display">Repair Value</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:textarea placeholder="Few words about the customer..."
										id="reason" class="materialize-textarea" rows="10"
										path="reason"></form:textarea>
									<label for="message">Reason</label>
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
			</div>
		</div>
	</form:form>
</div>