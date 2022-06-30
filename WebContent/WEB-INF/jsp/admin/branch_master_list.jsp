
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<script type="text/javascript" src="js/admin/brcm.js"></script>
<div class="page-content">
	<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
	<div id="portlet-config" class="modal hide"></div>
	<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
	<!-- BEGIN PAGE CONTAINER-->
	<div class="container-fluid">

		<h3 class="page-title">
			Branch Master<small></small>
		</h3>

		<bc:description output="result" />
		${result}
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<c:if test="${success ne null }">
			<error:description code="${success}" type="success"
				result="description" />${description}
			</c:if>
		<c:if test="${error ne null }">
			<error:description code="${error}" type="error" result="description" />${description}
			</c:if>
		<div class="row-fluid">
			<div class="span12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey">
					<div class="portlet-title">
						<h4>
							<i class="icon-reorder"></i>Branch List
						</h4>
						<div class="tools">
							<a href="javascript:;" class="expand" id="branchMasExpand"></a>

						</div>
					</div>
					<div class="portlet-body">
						<form:form name="displ" id="listOfBranchMaster"
							modelAttribute="branch" class="form-horizontal"
							action="branchMaster.htm" method="GET">
							<input type="hidden" id="hiddenBranchId" name="branchID" />
							<input type="hidden" id="hiddenRowId" name="rowID" />
							<c:if test="${not empty display_tbl}">
								<!-- Display Tag -->
								<div id="listOfRec">

									<display:table id="list" keepStatus="true"
										clearStatus="${status}" pagesize="${branch.pageNo}"
										class="table table-striped table-bordered"
										name="sessionScope.display_tbl" form="displ"
										decorator="com.pos.common.displayTag.DisplayTableDecorator"
										excludedParams="pageNo pano rowId branchId" sort="list"
										defaultsort="2">

										<display:column property="serialno" title="S.No"
											style="text-align:center;" />

										<display:column property="branchName" class="branchName"
											sortable="true" title="Branch Name" />

										<display:column property="address1" class="branchAdd1"
											title="Address 1">
										</display:column>


										<display:column property="address2" class="branchAdd2"
											title="Address 2">
										</display:column>

										<display:column property="city" class="branchCity"
											sortable="true" title="City" />
										<display:column property="state" class="branchState"
											sortable="true" title="State" />

										<display:column title="Contact 1" class="branchContact1"
											property="contact1" paramId="rowid" />

										<c:set var="stat" value="BFAIL"></c:set>

										<display:column>
											<a href="editBranchMasterView.htm?rowid=${list.rowid}"
												class="icon-edit edit-info" title="Edit"
												style="float: right; text-decoration: none;"></a>
											<a href="viewBranchMaster.htm?rowid=${list.rowid}"
												class="icon-file details-info" title="Details"
												style="float: right; text-decoration: none;"></a>
											<a href="deleteBranchMaster.htm?rowid=${list.rowid}"
												class="icon-remove" title="Delete"
												style="float: right; text-decoration: none;"></a>
										</display:column>




									</display:table>
								</div>
								<div class="control-group">
									<label class="control-label"></label>
									<div class="controls">
										<form:select path="pageNo" class="smallno m-wrap" tabindex="1">
											<form:option value="5">5</form:option>
											<form:option value="10">10</form:option>
										</form:select>
										Records per page

									</div>


								</div>

							</c:if>



						</form:form>

					</div>

				</div>
			</div>
		</div>



		<!-- END EXAMPLE TABLE PORTLET-->

	</div>

</div>
<!-- END PAGE CONTAINER-->
