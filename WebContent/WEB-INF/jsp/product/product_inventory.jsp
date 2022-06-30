<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>





<!-- Form with icon prefixes -->


<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Product in Inventory List</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="list" class="display data-table-row-grouping"
							requestURI="productInventoryList.htm"
							name="sessionScope.productInventoryList" sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							
							<display:column property="productName" title="Name"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="model" title="Model" sortable="true"
								headerClass="sortable" style="width:180px" />
								<display:column property="inventoryDate" title="Date" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="brand" title="Brand" sortable="true"
								headerClass="sortable" style="width:180px" />
								<display:column property="brand" title="Brand Name" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="colour" title="Colour" sortable="true"
								headerClass="sortable" style="width:180px" />
								
								<display:column property="quantity" title="Quantity"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column title="Actions" style="width:180px">
								<a target="_blank" class="btn waves-effect waves-light blue " 
								 href="productInventoryList.htm?inventoryView&productId=${list.productId }&inventoryDate=${list.inventoryDate }" type="submit" name="action">View </a>

							</display:column>
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>