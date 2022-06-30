
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<script type="text/javascript" src="js/admin/insm.js"></script>

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
					Institute Master <small></small>
				</h3>
				<%-- ${message} --%>
				<bc:description output="result" />
				${result}
				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>
		</div>



		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<form:form commandName="inst" class="form-horizontal" method="POST"
			id="UpdateIMForm" action="instMaster.htm"
			enctype="multipart/form-data">
			<%--  ${exception.message}   --%>

			<c:if test="${success ne null }">
				<div id="success">
					<error:description code="${success}" type="success"
						result="description" />
					${description}
				</div>

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
								<i class="icon-reorder"></i>Institute Details
							</h4>
							<div class="tools">
								<a href="javascript:;" class="expand" id="expandId"></a>

							</div>
						</div>
						<div class="portlet-body form">

							<!-- BEGIN FORM-->
							<!-- <div class="control-group">
								<label class="control-label" for="inputSuccess">Institute
									Id<span class="comp">*</span>
								</label>
								<div class="controls"> -->
							<form:input path="dbTs" type="hidden" readonly="true"
								class="span6 m-wrap" maxlength="8" />
							<form:input path="instId" type="hidden" readonly="true"
								class="span6 m-wrap" maxlength="8" />
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Institute
									Name<span class="comp">*</span>
								</label>
								<div class="controls">
									<form:input path="instName" class="span6 m-wrap" maxlength="45" />
									<span class="help-inline"></span>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Institute Logo</label>
								<div class="controls">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<!--  <div class="fileupload-new thumbnail"
											style="max-width: 200px; max-height: 150px; line-height: 20px;">
											 -->
										 	<div class="fileupload-new thumbnail" style="width:200px;height: 150px; line-height: 20px;"> 
											
											<c:set var="type" value="PH_LOGO"></c:set>
											<img src="image.htm?photo=${inst.instId}&type=${type}" alt="" />
										</div>
										<div class="fileupload-preview fileupload-exists thumbnail"
											style="width: 200px; height: 150px; line-height: 20px;"></div>
										<div>
											<span class="btn btn-file"><span
												class="fileupload-new">Select image</span> <span
												class="fileupload-exists">Change</span> <form:input
													type="file" path="instLogo" class="default" /><span
												class="help-inline"></span></span> <a href="#"
												class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
										</div>
									</div>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Address
									1<span class="comp">*</span>
								</label>
								<div class="controls">
									<form:input path="add1" class="span6 m-wrap" maxlength="45" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Address
									2</label>
								<div class="controls">
									<form:input path="add2" class="span6 m-wrap" maxlength="45" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Address
									3</label>
								<div class="controls">
									<form:input path="add3" class="span6 m-wrap" maxlength="45" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">City<span
									class="comp">*</span></label>
								<div class="controls">
									<form:input path="city" class="span6 m-wrap" maxlength="45" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Pincode<span
									class="comp">*</span></label>
								<div class="controls">
									<form:input path="pincode" class="span6 m-wrap" maxlength="16" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">State<span
									class="comp">*</span></label>
								<div class="controls">
									<form:input path="state" class="span6 m-wrap" maxlength="45" />
									<span class="help-inline"></span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputSuccess">E-mail</label>
								<div class="controls">
									<form:input path="email" class="span6 m-wrap" maxlength="50" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Fax</label>
								<div class="controls">
									<form:input path="fax" class="span6 m-wrap" maxlength="16" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Contact
									1<span class="comp">*</span>
								</label>
								<div class="controls">
									<form:input path="contact1" class="span6 m-wrap" maxlength="16" />
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Contact
									2</label>
								<div class="controls">
									<form:input path="contact2" class="span6 m-wrap" maxlength="16" />
									<span class="help-inline"></span>
								</div>
							</div>							
							<c:set var="singleBranch" value="${inst.singleBranch}"></c:set>		
										<input type='hidden' value="${singleBranch}" id="singleBranchOrNot"/>	
							<c:if test="${singleBranch eq 'Y'}">
								<div class="control-group">
									<label class="control-label" for="inputSuccess">Institute
										Category <span class="comp">*</span></label>
									<div class="controls">
										<form:select path="instCategory"
											class="span4 m-wrap  academicYear"
											data-placeholder="Choose a Category" tabindex="1">
											<test:commoncode codeType="IBCAT" output="res" />
											<form:option value="">Choose a Category</form:option>
											<c:forEach items="${res}" var="hel">
												<form:option value="${hel.commonCode}">${hel.codeDescription}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputSuccess">Affiliate
										Id</label>
									<div class="controls">
										<form:input path="affId" class="span6 m-wrap" maxlength="16" />
										<span class="help-inline"></span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputSuccess">Affiliate
										Details</label>
									<div class="controls">
										<form:input path="affDetails" class="span6 m-wrap"
											maxlength="45" />
										<span class="help-inline"></span>
									</div>
								</div>
							</c:if>

							<div class="control-group" style="text-align: right;">

								<div class="controls">

									<input type="submit" name="actionUpdate" class="btn blue"
										id="UpdateIM" value="Update"> <input type="submit"
										name="actionReset" class="btn blue cancel" id="ResetIM"
										value="Reset">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form:form>

	</div>

</div>
<!-- END PAGE CONTAINER-->
