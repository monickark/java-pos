<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Invoice Report</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="list" class="display data-table-row-grouping"
							requestURI="salesReport.htm" name="sessionScope.salesReport"
							sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />

							<display:column property="invoiceNo" title="Invoice No"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="customerName" title="Customer Id"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="date" title="Date" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="promoDiscount" title="Promo Discount"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="amountPayable" title="Amount"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="qty" title="Qty" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="imei" title="Product Details" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column title="Actions" style="width:180px">
								<a class="modal-trigger viewProd" href="possale.htm?invoiceNo&Id=${list.invoiceNo}"> <i
									class="material-icons action-icons orange" title="View Invoice">pageview</i></a>


							</display:column>
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>