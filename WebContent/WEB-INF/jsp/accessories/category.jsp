<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>

<div class="row">
	<div id="basic-form" class="section col s6">
	<error:description code="${success}" type="success"
						result="description" />${description}
		<form:form action="category.htm" id="searchBar21" method="POST"
			commandName="category">
			<h5>Add New Category</h5>
			<div class="row">
				<div class="input-field col s12">
					<form:input placeholder="  " id="name2" type="text"
						path="categoryName" />
					<label for="categoryName">Category Name <span>*</span></label>


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