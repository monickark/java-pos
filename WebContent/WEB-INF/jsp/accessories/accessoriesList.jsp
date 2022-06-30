<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
 <div class="container">
              <div class="row">
                <div class="col s10 m6 l6">
                  <h5 class="breadcrumbs-title">Inventory Add Accessories</h5>
                  
                </div>
                   <div class="col s2 m6 l6">
                  <a class="btn dropdown-settings waves-effect waves-light breadcrumbs-btn right modal-trigger" href="#modal2" data-activates="dropdown1">
                    <span class="hide-on-small-onl">Add Accessories</span>
                    <i class="material-icons right">library_add</i>
                  </a>
                  
                </div>
              </div>
            </div>
         

<div id="basic-form" class="section">

	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Accessories List</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="data-table-row-grouping" class="display"
							requestURI="accessoriesList.htm"
							name="sessionScope.accessoriesList" sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							
							<display:column property="name" title="Name"
								sortable="true" headerClass="sortable" style="width:180px" /> 
							<display:column property="brand" title="Brand"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="category" title="Category"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="quantity" title="Quantity"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="costPrice" title="Cost Price"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="sellingPrice" title="Selling Price"
								sortable="true" headerClass="sortable" style="width:180px" />
							
						
							
						</display:table>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>




<div id="modal2" class="modal modal-fixed-footer access-modal">
	<div class="modal-content">
		<div id="profile-page">
			<div id="profile-page-content" class="row">
				<!-- profile-page-sidebar-->
				<div id="profile-page-sidebar" class="col s12 m12">

					<ul id="task-card" class="collection with-header">
						<li class="collection-header gradient-45deg-purple-amber">
							<h4 class="task-card-title">Add Accesories</h4>
						</li>

					</ul>
					<form:form action="accessoriesList.htm" id="searchBar11" method="POST" commandName="accessoriesList" >
					<div class="col s12  grey lighten-4 acces-add-tab">
						
							<div class="input-field col s4">
								<form:select id="category" class="categpry-dropdown" path="category">
									<form:option value="" disabled="true" selected="true">Select Category</form:option>
									<form:options items="${category}" />
								</form:select> <label class="">Category <span>*</span>
								</label>
							</div>
							<div class="input-field col s4">
									<form:select path="brand" id="brand_model_list" class="brand-dropdown" data-placeholder="Choose a Category">
										<form:option value="" disabled="true" selected="true">Select Brand</form:option>
										<form:options items="${brandList}" />
									</form:select>
									<label>Brand <span>*</span>
									</label>
								</div>
								
							<div class="input-field col s4">
								<form:input type="text" name="name" Placeholder="Samsung Headset" class="input-field" path="name" /> <label
									class="">Name <span>*</span></label>
							</div>

							 <div class="input-field col s4">
								<form:input type="text" name="qty" Placeholder="0" class="input-field" path="quantity" /> <label
									class="">Quantity </label>
							</div>

							<div class="input-field col s4">
								<form:input type="text" name="cost-price" Placeholder="0" class="input-field" path="costPrice"/> <label
									class="">Cost Price </label>
							</div>
							<div class="input-field col s4">
								<form:input type="text" name="selling-price" Placeholder="0" class="input-field" path="sellingPrice"/> <label
									class="">Selling Price </label>
							</div>
							<div class="input-field col s12">
								<form:textarea placeholder="Few words about the product..."
									id="message2" class="materialize-textarea" rows="10" path="shortDescription"></form:textarea>
								<label for="message">Short Description</label>
								 <button class="btn cyan waves-effect waves-light right" id="submitForm" type="submit" name="action">Submit
                                  <i class="material-icons right">chevron_right</i>
                                </button>
							</div> 

						
					</div>
					</form:form>
				</div>
				

			</div>
		</div>
	</div>
	
	
</div>