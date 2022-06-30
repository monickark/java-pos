
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

		<h3 class="page-title">
			New Branch<small></small>
		</h3>

		<bc:description output="result" />
		${result}
		<!-- BEGIN PAGE CONTENT-->
		<form:form class="form-horizontal branchAddForm" method="POST"
			commandName="branchVO" id="branchMasterAdd"
			action="branchMasterAdd.htm" enctype="multipart/form-data">

			<div id="errorMsg">
				<c:if test="${success ne null }">
					<error:description code="${success}" type="success"
						result="description" />${description}
			</c:if>
				<c:if test="${error ne null }">
					<error:description code="${error}" type="error"
						result="description" />${description}
			</c:if>
			</div>


			<div class="row-fluid">
				<div class="span12">

					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box green">
						<div class="portlet-title">
							<h4>
								<i class="icon-reorder"></i>Add Branch
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
							<!-- BEGIN FORM-->
							<div class="control-group">
								<label class="control-label" for="inputWarning"> Name<span
									class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="branchName" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label"> Logo</label>
								<div class="controls">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<div class="fileupload-new thumbnail"
											style="width: 200px; height: 150px;">
											<c:set var="type" value="PH_LOGO"></c:set>
											<img
												src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image"
												alt="" />
										</div>
										<div class="fileupload-preview fileupload-exists thumbnail"
											style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
										<div>
											<span class="btn btn-file"><span
												class="fileupload-new">Select image</span> <span
												class="fileupload-exists">Change</span> <form:input
													type="file" path="branchLogo" class="default"
													id="fileUpload" /><span class="help-inline"></span></span> <a
												href="#" id="reomveBttn" class="btn fileupload-exists"
												data-dismiss="fileupload">Remove</a>
										</div>
									</div>

								</div>
							</div>



							<div class="control-group">
								<label class="control-label" for="inputWarning"> Address
									1<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address1" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> Address
									2<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address2" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> Address
									3</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="address3" class="span6 m-wrap"
											maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> City<span
									class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="city" class="span6 m-wrap" maxlength="45" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning"> Pincode<span
									class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="pincode" class="span6 m-wrap" maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> State<span
									class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="state" class="span6 m-wrap" maxlength="45" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> E-Mail</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="email" class="span6 m-wrap" maxlength="50" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> Fax</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="fax" class="span6 m-wrap" maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> Contact
									1<span class="comp">*</span>
								</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="contact1" class="span6 m-wrap"
											maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning"> Contact
									2</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="contact2" class="span6 m-wrap"
											maxlength="16" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Category<span class="comp">*</span>
								</label>
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
								<%-- <div class="control-group">
									<div class="controls">
										<form:input path="branchCategory" class="span6 m-wrap" />
									</div>
								</div> --%>
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
							<div class="control-group">

								<div class="controls" style="text-align: right;">
									<input class="btn AddInAddBranch blue" name="addPageBttn"
										id="nonEdit" type="submit" value="Add" /> <input
										class="btn ClearInAddBranch grey" name="addPageBttn"
										id="nonEdit" type="button" value="Clear" />
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
