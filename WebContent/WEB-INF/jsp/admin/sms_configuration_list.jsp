
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<%@taglib prefix="property" uri="PropertyManagementValue"%>
<%@taglib prefix="cocd" uri="CommonCodeDescription"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:directive.page import="com.pos.common.displayTag.*" />

<jsp:directive.page import="com.pos.common.displayTag.*" />
<script type="text/javascript" src="js/admin/smsConfiguration.js"></script> >
<jsp:scriptlet>
	<![CDATA[/*  if (request.getSession().getAttribute( "courseClassesList")==null){
			 request.getSession().setAttribute( "courseClassesList", new TestList(30, false) );
			 } */
			 SMSConfigurationTableDecorator decorator = new SMSConfigurationTableDecorator();
			decorator.setId("rowid");
			decorator.setFieldName("_chk");
			pageContext.setAttribute("decorator", decorator);]]>
</jsp:scriptlet>
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
					SMS Configuration <small></small>
				</h3>
				<%-- ${message} --%>
				<bc:description output="result" />
				${result}
				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>
		</div>


<property:value propertyId="SINGLE_BRANCH" result="value" />

		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<form:form commandName="smsConfig" class="form-horizontal"
			method="GET" id="SMSConfigForm" action="smsConfiguration.htm"
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
					<div class="portlet box yellow">
						<div class="portlet-title">
							<h4>
								<i class="icon-reorder"></i>Search
							</h4>
							<div class="tools">
								<a href="javascript:;" class="expand" id="searchsmsconfig"></a>

							</div>
						</div>
						<div class="portlet-body form">

							<!-- BEGIN FORM-->
							<!-- <div class="control-group">
								<label class="control-label" for="inputSuccess">Institute
									Id<span class="comp">*</span>
								</label>
								<div class="controls"> -->
	<c:if test="${value == 'N'}">

							<div class="control-group">
								<label class="control-label">Branch<span class="comp">*</span>
								</label>

								<div class="controls">
									<form:select path="smsConfigVO.branchId" class="span4 m-wrap "
										data-placeholder="Choose a Category" tabindex="1" id="branchname">
										<form:option value="">--Select--</form:option>
										<form:options items="${branchList}" />
									</form:select>
									<span class="help-inline" id="BranchNameErrorId"></span>
								</div>

							</div>
							</c:if>
							<div class="control-group">
								<label class="control-label" for="inputSuccess">Property Type<span class="comp">*</span>
								</label>
								<div class="controls">

									<form:select path="smsConfigVO.propertyType"
										class="span4 m-wrap  academicYear"
										data-placeholder="Choose a Category" tabindex="1" id="smsPropertyType">
										<test:commoncode codeType="SMSPT" output="result" branchId="${smsConfigVO.branchId}"/>
										<form:option value="">--Select--</form:option>
										<c:forEach items="${result}" var="hel">
											<form:option value="${hel.commonCode}">${hel.codeDescription}</form:option>
										</c:forEach>>
										</form:select>		<span
											class="help-inline"></span>

								</div>
							</div>


							<div class="control-group" style="text-align: right;">

								<div class="controls">

									<input type="submit" name="Get" class="btn blue"
										id="GenerateHG" value="Get">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form:form>
	<div class="row-fluid">
								<div class="span12">
									<!-- BEGIN EXAMPLE TABLE PORTLET-->
									<div class="portlet box grey">
										<div class="portlet-title">
											<h4>
												<i class="icon-reorder"></i>Result
											</h4>
											<div class="tools">
												<a href="javascript:;" id="listsmsconfig" class="expand"></a>

											</div>
										</div>

										<div class="portlet-body">

<input type="text" value="dsffddsfdfds" class="branchClass"/>
											<div id="result1" class="smsConfiglist">
												<form:form method="get" commandName="smsConfig"
													action="smsConfiguration.htm?data" id="formId" name="displ">
													<!-- Display Tag -->
													<display:table id="distable"
														class="table table-striped table-bordered"
														name="sessionScope.display_tbl"
														requestURI="courseClasses.htm?data"
														pagesize="${smsConfig.pageSize}" keepStatus="true"
														clearStatus="${status}" decorator="decorator" form="displ"
														excludedParams="_chk rowid textboxview labSessNo pano data  selectall pageSize"
														sort="list" defaultsort="2">
														<display:column
															title="<input type='checkbox' class='simpleq' name='selectall' id='selectall' value='true'/>"
															property="checkBox" />

														<display:column property="serialno" title="SI.No" />

														<display:column title="Branch Id" sortable="true"
															property="branchId" headerClass="branchClass" class="branchClass"/>
                                                   <cocd:description code="${distable.propertyType}" type="SMSPT"
																	output="result" />
																<display:column title="Property Type" sortable="true"
																	value="${result}" />
                                                          
														<display:column title="Property Type"
															sortable="true" property="propertyType" class="propertyTypeClass" headerClass="propertyTypeClass"/>
															
															<display:column title="Parameter Name" sortable="true"
															property="propertyDesc" />
															
														 <display:column title="Property Name"
															sortable="true" property="propertyName"  class="propertyNameClass" headerClass="propertyNameClass" /> 

														
															<display:column title="Value"  sortable="true"
															property="propertyValueTable" />
															
															


                                                         <display:column title="Update" sortable="true"
															property="hrefIcon" />
														


													</display:table>

													<c:if test="${fn:length(sessionScope.display_tbl) gt 0}">
														<!-- <div id="result1" class="datLogResult"> -->
														<div class="control-group">
															<label class="control-label"></label>
															<div class="controls">
																<form:select path="pageSize" class="smallno m-wrap"
																	tabindex="1" id="pageSize">
																	<form:option value="5">5</form:option>
																	<form:option value="10">10</form:option>
																	<form:option value="15">15</form:option>
																</form:select>
																Records per page

															</div>
														</div>

														<div class="control-group " style="text-align: right;">

															<div class="controls">
																<input type="submit" name="actionSave" class="btn blue"
																	id="saveSMSC" value="Save">
															</div><span
											class="help-inline" id="SaveButtonError"></span>
														</div>
													</c:if>

												</form:form>

											</div>
										</div>

									</div>
								</div>
							</div>
	</div>

</div>
<!-- END PAGE CONTAINER-->
