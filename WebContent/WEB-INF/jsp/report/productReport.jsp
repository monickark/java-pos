<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">SOLD PRODUCT LIST</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="list" class="display data-table-row-grouping"
							requestURI="productReport.htm" name="sessionScope.productReport"
							sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							<display:column property="invoiceNo" title="Invoice No"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="imei" title="IMEI" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="productId" title="Product Id"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="quantity" title="Quantity"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="price" title="Price" sortable="true"
								headerClass="sortable" style="width:180px" />

							<display:column property="amount" title="Amount" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="discount" title="Discount"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="category" title="Category"
								sortable="true" headerClass="sortable" style="width:180px" />
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>