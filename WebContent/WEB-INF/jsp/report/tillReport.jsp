<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<div id="basic-form" class="section">
	<div class="row">
		<div class="col s12 m12 ">
			<div class="card-panel">
				<h4 class="header2">TILL Report</h4>
				<div class="row">
					<div class="col s12">
						<display:table id="" class="display"
							requestURI="tillReport.htm"
							name="sessionScope.tillReport" sort="list" cellspacing="0">
							<display:setProperty name="basic.msg.empty_list" value="" />
							
							<display:column property="date" title="Date" sortable="true"
								headerClass="sortable" style="width:180px" /> 
							<display:column property="open_balance" title="Open Balance"
								sortable="true" headerClass="sortable" style="width:180px" />
							<display:column property="sales" title="Sales Amount" sortable="true"
								headerClass="sortable" style="width:180px" /> 
							
							<display:column property="close_balance" title="Close Balance" sortable="true"
								headerClass="sortable" style="width:180px" /> 
							
						</display:table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>