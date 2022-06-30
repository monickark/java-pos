<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<div class="row">
					<div class="col s12">
						<display:table id="list" class="display data-table-row-grouping"
							requestURI="tradeinList.htm" name="sessionScope.tradeinList"
							sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							<display:column property="t_invoiceId" title="Invoice Id"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="customerName" title="Customer Name"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="invoiceDate" title="Invoice Date"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="contactNo" title="Contact No"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="brand" title="Brand" sortable="true"
	   						headerClass="sortable" style="width:180px" />
							<display:column property="modelNo" title="Model No"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="imei" title="IMEI"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="resaleValue" title="Resale Value"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="status" title="Status"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column title="Actions" style="width:180px">
								<a href="tradeinList.htm?invoice&id=${list.imei}"> <i
									class="material-icons action-icons orange" title="View Invoice">pageview</i></a>
							</display:column>
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>