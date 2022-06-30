<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>




<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">Customer Report</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="" class="display"
							requestURI="customerReport.htm" name="sessionScope.customerReport"
							sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />

							<display:column property="customerName" title="Customer Name"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="email" title="Email"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="customerId" title="Customer ID" sortable="true"
								headerClass="sortable" style="width:180px" />
							<display:column property="phone" title="Phone"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="mobile" title="Mobile"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="address" title="Address"
								sortable="true" headerClass="sortable" style="width:180px" />
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>