
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<%@taglib prefix="property" uri="PropertyManagementValue"%>

<script type="text/javascript" src="js/admin/studentPromotion.js"></script>
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
					Student Promotion <small></small>
				</h3>
				<%-- ${message} --%>
				<bc:description output="result" />
				${result}
				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>
		</div>



		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<form:form commandName="studentProVo" class="form-horizontal"
			method="POST" id="studentPromotion" action="studentPromotion.htm"
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
								<i class="icon-reorder"></i>Student Promotion
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
							<property:value propertyId="SINGLE_BRANCH" result="singleBranch" />
							<c:if test="${singleBranch == 'N'}">
								<div class="control-group">
									<label class="control-label">Branch<span class="comp">*</span>
									</label>

									<div class="controls">
										<form:select path="branchId" class="span4 m-wrap "
											data-placeholder="Choose a Category" tabindex="1"
											id="branchname">
											<form:option value="">--Select--</form:option>
											<form:options items="${branchList}" />
										</form:select>
										<span class="help-inline"></span>
									</div>

								</div>
							</c:if>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">From
									Academic Term<span class="comp">*</span>
								</label>
								<div class="controls">


									<form:select path="fromAcademicTerm" class="span4 m-wrap "
										data-placeholder="Choose a Category" tabindex="1"
										id="fromAcademicTerm">
										<form:option value="">--Select--</form:option>
									</form:select>
									<span class="help-inline" id="acadTrmErFrom"></span>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">To
									Academic Term<span class="comp">*</span>
								</label>
								<div class="controls">


									<form:select path="toAcademicTerm" class="span4 m-wrap "
										data-placeholder="Choose a Category" tabindex="1"
										id="toAcademicTerm">
										<form:option value="">--Select--</form:option>
									</form:select>
									<span class="help-inline" id="acadTrmErTo"></span>

								</div>
							</div>







							<div class="control-group" style="text-align: right;">

								<div class="controls">
									<input type="hidden" value="${requestScope.threadID}"
										id="ThreadID" /> <input type="submit" name="actionGenerate"
										class="btn blue" id="studentProId" value="Generate">
								</div>
							</div>

							<div style="clear: both;"></div>

							<div class="control-group successMsg" id="std">
								<div class="progress progress-striped active progresss">
									<div style="width: 160%;" class="bar"></div>
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
