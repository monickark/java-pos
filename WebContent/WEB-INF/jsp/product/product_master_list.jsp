<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div id="basic-form" class="section">
	<%-- <form:form action="productMasterList.htm" id="searchBar1" method="GET" commandName="product_master_list"> --%>


	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Product List</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="list" class="display data-table-row-grouping"
							requestURI="productMasterList.htm"
							name="sessionScope.productMasterList" sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							<display:column class="id" property="productId"
								title="Product Id" sortable="true" headerClass="sortable"
								style="width:180px" />
							<display:column property="productName" title="Name"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="brand" title="Brand" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="model" title="Model" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="colour" title="Colour" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="description" title="Description"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column title="Actions" style="width:180px">
								<a class="modal-trigger viewProd" href="#modal2"> <i
									class="material-icons action-icons orange" title="View">pageview</i></a>
								<a target="_blank"
									href="editProduct.htm?productId=${list.productId}"> <i
									class="material-icons action-icons blue" title="Edit">edit</i></a>
								<a class="modal-trigger" href="#modal3" title="View"> <i
									class="material-icons inventory action-icons green"
									title="Add to Inventory"> control_point_duplicate</i></a>

								<i
									class="material-icons action-icons red btn-warning-confirm-delete waves-light"
									title="Delete">delete_forever</i>

							</display:column>
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
	<%-- </form:form> --%>
</div>

<div id="modal2" class="modal modal-fixed-footer">
	<div class="modal-content">
		<div id="profile-page">
			<div id="profile-page-content" class="row">
				<!-- profile-page-sidebar-->
				<div id="profile-page-sidebar" class="col s12 m12">

					<ul id="task-card" class="collection with-header">
						<li class="collection-header gradient-45deg-light-blue-cyan">
							<h4 class="task-card-title productNameModel"></h4>
							<p class="task-card-date descriptionModel">Apple iPhone 8
								Plus smartphone was launched in September 2017. The phone comes
								with a 5.50-inch touchscreen display with a resolution of 1080
								pixels by 1920 pixels.</p> <span
							class="task-cat red darken-4 accent-2 brandModel">Micro
								Sim</span> <span class="task-cat cyan ramCapacityModel">4 GB RAM</span>
							<span class="task-cat brown darken-4  accent-2 batteryModel">12
								mAh Battery</span> <span
							class="task-cat purple darken-4 accent-2 displayModel">Retina
								Display</span> <span
							class="task-cat  orange darken-4 accent-2 simTypeModel">Single
								Sim</span>

						</li>

					</ul>
					<!-- task-card -->
					<ul id="profile-page-about-details"
						class="collection z-depth-1 col s12 m6">
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">card_travel</i> Brand
								</div>
								<div class="col s7 right-align brandModel"></div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">poll</i> Model
								</div>
								<div class="col s7 right-align modelmodel"></div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">color_lens</i> Colour
								</div>
								<div class="col s7 right-align colourModel"></div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">memory</i> OS
								</div>
								<div class="col s7 right-align osModel"></div>
							</div>
						</li>
					</ul>
					<!-- task-card -->
					<ul id="profile-page-about-details"
						class="collection z-depth-1 col s12 m6">
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">graphic_eq</i> Dimensions
								</div>
								<div class="col s7 right-align dimensionsModel"></div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">phone_iphone</i> Display
								</div>
								<div class="col s7 right-align displayModel"></div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s5">
									<i class="material-icons left">art_track</i> Category
								</div>
								<div class="col s7 right-align categoryModel"></div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s8">
									<i class="material-icons left">battery_charging_full</i> Non
									Removable
								</div>
								<div class="col s4 right-align nonRemovalBatteryModel"></div>
							</div>
						</li>
					</ul>
				</div>
				<!-- profile-page-sidebar-->

			</div>
		</div>
	</div>
	<div class="modal-footer">

		<a href="#!"
			class="btn btn-warning modal-action modal-close waves-effect waves-green">Close</a>
	</div>
</div>

<form:form action="productMasterList.htm" id="search" method="POST"
	commandName="product_master_list">
	<div id="modal3" class="modal modal-fixed-footer">
		<div class="modal-content">
			<div id="profile-page">
				<div id="profile-page-content" class="row">
					<!-- profile-page-sidebar-->
					<div id="profile-page-sidebar" class="col s12 m12">

						<ul id="task-card" class="collection with-header">
							<li class="collection-header gradient-45deg-light-blue-cyan">
								<h4 class="task-card-title productNameModel"></h4>
								<p class="task-card-date descriptionModel">Apple iPhone 8
									Plus smartphone was launched in September 2017. The phone comes
									with a 5.50-inch touchscreen display with a resolution of 1080
									pixels by 1920 pixels.</p> <span
								class="task-cat red darken-4 accent-2 brandModel">Micro
									Sim</span> <span class="task-cat cyan ramCapacityModel">4 GB
									RAM</span> <span
								class="task-cat brown darken-4  accent-2 batteryModel">12
									mAh Battery</span> <span
								class="task-cat purple darken-4 accent-2 displayModel">Retina
									Display</span> <span
								class="task-cat  orange darken-4 accent-2 simTypeModel">Single
									Sim</span>

							</li>

						</ul>


						<div class="tab-colours">
							<ul class="tabs tab-profile z-depth-1 deep-orange accent-2">
								<li class="tab col s3 "><a
									class="white-text waves-effect waves-light "
									href="#UpdateStatus1"> Black</a></li>
								<li class="tab col s3"><a
									class="white-text waves-effect waves-light active"
									href="#UpdateStatus1"> White</a></li>
								<li class="tab col s3"><a
									class="white-text waves-effect waves-light"
									href="#UpdateStatus1"> Grey</a></li>
								<li class="tab col s3"><a
									class="white-text waves-effect waves-light"
									href="#UpdateStatus1"> Gold</a></li>
							</ul>
						</div>
						<!-- UpdateStatus-->
						<div id="UpdateStatus1"
							class="tab-content col s12  grey lighten-4 active">
							<input type="hidden" name="product-id" class="idInvAdd" /> 
							<input type="hidden" name="colour" class="colour" />
							<div class="row">
								<div class="input-field col s6">
									<form:input type="text" name="cost-price"
										class="input-field cp-add" path="costPrice" />
									<label class="">Cost Price </label>
								</div>
								<div class="input-field col s6">
									<form:input type="text" name="selling-price"
										class="input-field sp-add" path="sellPrice" />
									<label class="">Selling Price </label>
								</div>
								<div class="input-field col s12">
									<form:input type="text" name="imei"
										class="input-field imei-add" path="imei" />
									<label class="">Scan IMEI </label>
								</div>

							</div>
						</div>
					</div>
					<!-- profile-page-sidebar-->

				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a class="footer-success"></a> <a class="footer-fail"></a> <a
				href="#!"
				class="btn btn-warning modal-action modal-close waves-effect waves-green close-btn">Close</a>

		</div>
	</div>

</form:form>
