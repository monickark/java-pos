
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="cocd" uri="CommonCodeDescription"%>
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
		<!-- BEGIN PAGE HEADER-->
		<div class="row-fluid">
			<div class="span12">
				<!-- BEGIN STYLE CUSTOMIZER-->
				
				<!-- END STYLE CUSTOMIZER-->
				<!-- BEGIN PAGE TITLE & BREADCRUMB-->
				<h3 class="page-title">
					Branch Master Details<small></small>
				</h3>
				<%-- ${message} --%>
				<bc:description output="result" />
				${result}
				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>
		</div>




		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<%-- id="UpdateIMForm" action="returnToStatus.htm" --%>
		<!-- commandName="batchStatus" -->
		<form:form class="form-horizontal" method="GET" commandName="branchVO"
			id="branchDetailsView" action="#" enctype="multipart/form-data">

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
					<div class="portlet box green">
						<div class="portlet-title">
							<h4>
								<i class="icon-reorder"></i>Branch Master Details
							</h4>
							<div class="tools">
								<a href="javascript:;" class="expand" id="branchMasExpand"></a>

							</div>
						</div>
						<div class="portlet-body form">
							<input type="hidden" id="checktable" value="${expand}">

							<!-- BEGIN FORM-->
							<div class="control-group">
								<label class="control-label" for="inputWarning">Institute
									Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="instId" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="branchId" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>


							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Name<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="branchName" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Branch Logo<span
									class="comp">*</span></label>
								<div class="controls">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<div class="fileupload-new thumbnail"
											style="width: 200px; height: 150px;">
											<c:set var="type" value="PH_LOGO"></c:set>
											<img src="image.htm?photo=${branchVO.branchId}&type=${type}"
												alt="" />
										</div>
										<div class="fileupload-preview fileupload-exists thumbnail"
											style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
									</div>

								</div>
							</div>




							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Address 1</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address1" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Address 2</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address2" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Address 3</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address3" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									City</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="city" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Pincode</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="pincode" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									State</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="state" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									E-Mail</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="email" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Fax</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="fax" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Contact 1</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="contact1" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Contact 2</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="contact2" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Category</label>
								<div class="control-group">
									<div class="controls">
										<form:select path="branchCategory" class="span6 m-wrap"
											data-placeholder="Choose a Category" tabindex="1">
											<form:option value="" selected="selected">Select a Category</form:option>
											<test:commoncode codeType="IBCAT" output="res" />
											<c:forEach items="${res}" var="hel">
												<form:option value="${hel.commonCode}">${hel.codeDescription}</form:option>
											</c:forEach>>
										</form:select>
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Affiliated
									Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="affId" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning">Affiliated
									Details</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="affDetails" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<!-- END FORM-->
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<!-- END EXAMPLE TABLE PORTLET-->
		<form:form class="form-horizontal" method="GET" commandName="branch"
			id="branchDetailsView" action="viewBranchMaster.htm"
			enctype="multipart/form-data">
			<div class="control-group" id="get">

				<div class="controls">

					<input class="btn blue" name="action1" id="g" type="submit"
						value="Back" />
				</div>
			</div>
			<!-- </div>
		</div> -->

			<!-- END VALIDATION STATES-->

		</form:form>
	</div>
</div>

<!-- END PAGE CONTAINER-->
