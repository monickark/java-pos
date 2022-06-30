
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="cocd" uri="CommonCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<script type="text/javascript" src="js/admin/brcmedit.js"></script>
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
				<div class="styler-panel hidden-phone">
					<i class="icon-cog"></i> <i class="icon-remove"></i> <span
						class="settings"> <span class="text">Style:</span> <span
						class="colors"> <span class="color-default"
							data-style="default"></span> <span class="color-blue"
							data-style="blue"></span> <span class="color-light"
							data-style="light"></span>
					</span> <span class="layout"> <label class="hidden-phone">
								<input type="checkbox" class="header" value="" />Fixed Header
						</label>
					</span>
					</span>
				</div>
				<!-- END STYLE CUSTOMIZER-->
				<!-- BEGIN PAGE TITLE & BREADCRUMB-->
				<h3 class="page-title">
					Branch Master Edit<small></small>
				</h3>
				<bc:description output="result" />
				${result}
				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>
		</div>




		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<form:form class="form-horizontal" method="POST"
			commandName="branchVo" id="branchDetailsEdit"
			action="editBranchMasterView.htm" enctype="multipart/form-data">

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
								<i class="icon-reorder"></i>Branch Master Edit
							</h4>
							<div class="tools">
								<a href="javascript:;" class="expand" id="branchMasExpand"></a>

							</div>
						</div>
						<!-- requestURI="rollnogen.htm" -->
						<div class="portlet-body form">
							<input type="hidden" id="checktable" value="${expand}">
							<form:hidden path="rowid" />
							<form:hidden path="dbTs" />

							<form:input path="instId" type="hidden" readonly="true"
								class="span6 m-wrap" maxlength="8" />

							<form:input path="branchId" type="hidden" readonly="true"
								class="span6 m-wrap" maxlength="8" />




							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Name<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="branchName" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Branch Logo</label>
								<div class="controls">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<div class="fileupload-new thumbnail"
											style="width: 200px; height: 150px;">
											<c:set var="type" value="PH_LOGO"></c:set>
											<img src="image.htm?photo=${branchVo.branchId}&type=${type}"
												alt="" />
										</div>
										<div class="fileupload-preview fileupload-exists thumbnail"
											style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
										<div>
											<span class="btn btn-file"><span
												class="fileupload-new">Select image</span> <span
												class="fileupload-exists">Change</span> <form:input
													type="file" path="branchLogo" class="default" /><span
												class="help-inline"></span></span> <a href="#"
												class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
										</div>
									</div>

								</div>
							</div>




							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Address 1<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address1" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Address 2</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address2" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Address 3</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address3" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									City<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="city" class="span6 m-wrap" maxlength="45" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Pincode<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="pincode" class="span6 m-wrap" maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									State</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="state" class="span6 m-wrap" maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									E-Mail</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="email" class="span6 m-wrap" maxlength="50" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Fax</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="fax" class="span6 m-wrap" maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Contact 1<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="contact1" class="span6 m-wrap"
											maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Contact 2</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="contact2" class="span6 m-wrap"
											maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Category<span class="comp">*</span></label>
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
										<form:input path="affId" class="span6 m-wrap" maxlength="16" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning">Affiliated
									Details</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="affDetails" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
<div class="control-group" >

				<div class="controls" style="text-align: right;">
					<!-- 	<input class="btn blue" name="editPageBttn" type="submit" value="Back" /> -->
					<input class="btn blue updateBttn" name="editPageBttn"
						type="submit" value="Update" /> <input class="btn grey"
						name="editPageBttn" type="submit" value="Reset" />
				</div>
			</div>





							<!-- END FORM-->
						</div>
					</div>
				</div>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
			
			<!-- END VALIDATION STATES-->

		</form:form>
	</div>
</div>

<!-- END PAGE CONTAINER-->
