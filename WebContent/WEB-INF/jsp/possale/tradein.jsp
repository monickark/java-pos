<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>

<form:form action="tradein.htm" id="searchBar15" method="POST"
	commandName="tradein">

	<div id="basic-form" class="section">

		<div class="row">
			<div class="col s12 m12 ">
				<div class="card-panel">
					<h4 class="header2">Trade In Details</h4>
					<div class="row">
						<div class="col s6 m6 ">
							<error:description code="${error}" type="error"
								result="description" />${description}
							<error:description code="${success}" type="success"
								result="description" />${description}
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Riyaz Ahamed" id="name2" type="text"
										path="customerName" />
									<label for="name2">Customer Name </label>
								</div>
							</div>


							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="1111111111" id="display" type="text"
										path="contactNo" />
									<label for="display">Contact No </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="AX345SR67" id="license" type="text"
										path="lisenceNumber" />
									<label for="license">Lisence Number </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Apple" id="brand" type="text"
										path="brand" />
									<label for="brand">Brand</label>
								</div>
							</div>



							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="iphone 6s" id="display" type="text"
										path="modelNo" />
									<label for="display">Model</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="Black" id="color" type="text"
										path="color" />
									<label for="color">Color</label>
								</div>
							</div>
						</div>
						<div class="col s6 m6 ">

							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="12" id="capacity" type="text"
										path="capacity" />
									<label for="capacity">Capacity</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="123456789" id="imei" type="text"
										path="imei" />
									<label for="imei">IMEI</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input placeholder="100" id="resaleValue" type="text"
										path="resaleValue" />
									<label for="resaleValue">Resale Value</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:textarea placeholder="Few words about the product..."
										id="message2" class="materialize-textarea" rows="10"
										path="description"></form:textarea>
									<label for="message2">Description</label>
								</div>
							</div>
							<div class="row">
								<div id="radio" class="col s12 m12">
									<div class="section-radio"></div>
									<p style="display: inline">
										<input type="checkbox" class="filled-in term-check"
											id="filled-in-box1" name="terms" value="term" /> <label
											for="filled-in-box1">I agree the terms and Conditions</label>
									</p>
									<div class="pad-bot-20"></div>
								</div>
							</div>
							<input class="sign-hid" type="hidden" name="sign-hid"/>
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
	</div>


	<div id="modal1"
		class="modal-discount modal-terms sweet-alert show-input showSweetAlert visible"
		data-custom-class="" data-has-cancel-button="true"
		data-has-confirm-button="true" data-allow-outside-click="false"
		data-has-done-function="true" data-animation="slide-from-top"
		data-timer="null" style="display: block; margin-top: -206px;">
		<div class="sa-icon sa-error" style="display: none;">
			<span class="sa-x-mark"> <span class="sa-line sa-left"></span>
				<span class="sa-line sa-right"></span>
			</span>
		</div>
		<div class="sa-icon sa-warning" style="display: none;">
			<span class="sa-body"></span> <span class="sa-dot"></span>
		</div>
		<div class="sa-icon sa-info" style="display: none;"></div>
		<div class="sa-icon sa-success" style="display: none;">
			<span class="sa-line sa-tip"></span> <span class="sa-line sa-long"></span>

			<div class="sa-placeholder"></div>
			<div class="sa-fix"></div>
		</div>
		<div class="sa-icon sa-custom" style="display: none;"></div>
		<h2>Terms & Conditions</h2>
		<fieldset>
			<p>I am the Legal owner of the Property, I am selling this
				property at my own will, Its Neither on Finance nor a stolen
				Property</p>
		</fieldset>

		<fieldset>
			<div class="row">
				<div class="input-field col s12">
					<div id="sig"></div>
				</div>
			</div>
		</fieldset>
		<textarea id="signatureJSON" class="sign-mod" hidden="true" rows="5"
			cols="50" readonly="" class="ui-state-active"></textarea>
		<div class="sa-button-container">
			<div class="sa-confirm-button-container">
				<button TYPE="BUTTON" id="clear">Clear Sign</button>
				
				<button class="cancel cancel-btn" tabindex="1" type="button"
					style="display: inline-block; background-color: rgb(160, 160, 160); box-shadow: rgba(140, 212, 245, 0.8) 0px 0px 2px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px inset;">Close</button>
				<button class="confirm-btn" tabindex="1" type="button" 
					style="display: inline-block; background-color: rgb(0, 188, 212); box-shadow: rgba(140, 212, 245, 0.8) 0px 0px 2px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px inset;">I
					Agree</button>
			</div>
		</div>
	</div>
</form:form>