<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>

<div class="row">
	<div id="basic-form" class="section col s6">
	<error:description code="${success}" type="success"
						result="description" />${description}
		<form:form action="brandModelSetup.htm" id="searchBar8" method="POST"
			commandName="brandmodel">
			<h5>Add New Brand</h5>
			<div class="row">
				<div class="input-field col s12">
					<form:input placeholder="Apple" id="name2" type="text"
						path="brandVO.brandName" />
					<label for="first_name">Brand Name <span>*</span></label>


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
		</form:form>
	</div>
</div>
<div class="row">
	<div id="basic-form" class="section col s6">
		<form:form action="brandModelSetup.htm" id="searchBar9" method="POST"
			commandName="brandmodel">
			<h5>Add New Model</h5>

			<div class="row">
				<div class="input-field col s12">
					<form:select path="modelVO.brandId" id="brand_model_list"
						class="brand-dropdown" data-placeholder="Choose a Category">
						<form:option value="" disabled="true" selected="true">Select Brand</form:option>
						<form:options items="${brandList}" />
					</form:select>
					<label>Brand <span>*</span>
					</label>
				</div>
				<div class="input-field col s12">
					<form:input placeholder="iphone 6s" id="name2" type="text"
						path="modelVO.modelValue" />
					<label for="first_name">Brand Model Name <span>*</span></label>
				</div>
				
				<div class="input-field col s12">
					<button class="btn cyan waves-effect waves-light right"
						id="submitForm" type="submit" name="model_action">
						Submit <i class="material-icons right">chevron_right</i>
					</button>
				</div>
			</div>
		</form:form>
	</div>
</div>