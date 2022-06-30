<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>





<!-- Form with icon prefixes -->


<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Product Inventory Details</h4>
				<div class="row">
					<div class="col s12">

						<display:table id="list" class="display data-table-row-grouping"
							requestURI="viewInventory.htm"
							name="sessionScope.productInventoryView" sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							
							<display:column property="inventoryId" title="Inventory ID"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="inventoryDate" title="Inventory Date" sortable="true"
								headerClass="sortable" style="width:180px" />
								<display:column property="productId" title="Product Id" sortable="true"
								headerClass="sortable" style="width:180px" />
							 <display:column property="productName" title="Product Name" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="colour" title="Colour" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="imei" title="IMEI" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="costPrice" title="Cost Price" sortable="true"
								headerClass="sortable" style="width:180px" />
								
								<display:column property="sellPrice" title="Sell Price"
								sortable="true" headerClass="sortable" style="width:180px" />
							
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>