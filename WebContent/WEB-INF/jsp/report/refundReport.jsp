<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Refund Report</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="" class="display data-table-row-grouping"
							requestURI="refundReport.htm" name="sessionScope.refundReport"
							sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />

							<display:column property="invoiceNo" title="Invoice No"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="productId" title="Product Id"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="refundDate" title="Refund Date" sortable="true"
								headerClass="sortable" style="width:180px" />
								<display:column property="productName" title="Product Name"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="refundAmount" title="Refund Amount"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="refundReason" title="Refund Reason"
								sortable="true" headerClass="sortable" style="width:180px" />
							
							<display:column title="Actions" style="width:180px">
								<a class="modal-trigger viewProd" href="#"> <i
									class="material-icons action-icons orange" title="View Invoice">pageview</i></a>
							</display:column>
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>