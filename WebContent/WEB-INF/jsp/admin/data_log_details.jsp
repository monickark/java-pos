
<%@taglib prefix="test" uri="/WEB-INF/tlds/CommonCode.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="cocd" uri="CommonCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@taglib prefix="bc" uri="BreadCrumbs"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="js/admin/dataLog.js"></script>

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
					Data Log Details<small></small>
				</h3>
				<%-- ${message} --%>
				<bc:description output="result" />
				${result}
				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>
		</div>




		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<form:form class="form-horizontal" method="GET"
			commandName="dataLogVO" id="branchDetailsView" action="#"
			enctype="multipart/form-data">

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
								<i class="icon-reorder"></i>Data Log Details
							</h4>
							<div class="tools">
								<a href="javascript:;" class="expand" id="dataLogDetailsExpand"></a>

							</div>
						</div>
						<!-- requestURI="rollnogen.htm" -->
						<div class="portlet-body form">
							<input type="hidden" id="checktable" value="${expand}">

							<!-- BEGIN FORM-->
							<%-- <div class="control-group">
								<label class="control-label" for="inputWarning">Institute
									Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="instId" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div> --%>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Branch
									Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="branchId" class="span6 m-wrap"
											readonly="true" />
										<%-- <input type="text" class="m-wrap"  readonly="readonly" name="lname" value="${batchStatusRec.branchId}"  >
									 --%>
									</div>
								</div>
							</div>


							<div class="control-group">
								<label class="control-label" for="inputWarning">Record
									No</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="auditSrlNo" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning">Table
									Name</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="tableName" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Application
									User Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="userId" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Link Id</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="linkId" class="span6 m-wrap" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Type of
									Operation</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="typeOfOperation" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputWarning">Date</label>
								<div class="control-group">
									<div class="controls">
										<form:input path="rCreTime" class="span6 m-wrap"
											readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputWarning">Table
									Key</label>
							</div>

							<div class="control-group">
								<div align="center">
									<table class="table table-striped table-bordered" id="sample_1">
										<thead>
											<tr>
												<!--  <th style="width:8px;">S.No</th>  -->
												<th class="hidden-phone">Coulmun Name</th>
												<th class="hidden-phone">Value</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${tableKeyValues}" var="entry">
												<tr class="odd gradeX">
													<td>${entry.key}</td>
													<c:choose>
														<c:when test="${fn:length(entry.value) eq 0}">
															<td class="hidden-phone" align="right"></td>
														</c:when>
														<c:otherwise>
															<c:if test="${i.index == 0}">
																<c:set var="firstIndex" value="${item}"></c:set>
															</c:if>
															<c:choose>
																<c:when test="${fn:length(entry.value) eq 2}">
																	<cocd:description code="${firstIndex}" type="${item}"
																		output="res1" />
																	<td class="hidden-phone" align="right">${res1}</td>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${entry.value}" var="item">
																		<td class="hidden-phone" align="right">${item}</td>
																	</c:forEach>
																</c:otherwise>
															</c:choose>

														</c:otherwise>
													</c:choose>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>


							<div class="control-group">
								<label class="control-label" for="inputWarning">Record
									Details</label>
							</div>
							<div class="control-group">
								<div align="center">
									<table class="table table-striped table-bordered" id="sample_1">
										<thead>
											<tr>
												<!-- <th style="width:8px;">S.No</th> -->
												<th class="hidden-phone">Coulmun Name</th>
												<th class="hidden-phone">New Record</th>
												<th class="hidden-phone">Old Record</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${columnAndRecords}" var="entry">
												<tr class="odd gradeX">
													<td>${entry.key}</td>
													<c:set var="lengthOfList" value="${fn:length(entry.value)}"></c:set>
													<c:forEach items="${entry.value}" var="item" varStatus="i">

														<c:choose>
															<c:when test="${fn:length(entry.value) le 1}">

																<td class="hidden-phone" align="right">${item}</td>
																<td class="hidden-phone" align="right"></td>
															</c:when>
															<c:otherwise>
																<c:if test="${i.index == 0}">
																	<c:set var="firstIndex" value="${item}"></c:set>
																</c:if>
																<c:if test="${i.index == 1}">
																	<c:set var="secIndex" value="${item}"></c:set>
																</c:if>
																<c:choose>
																	<c:when test="${fn:length(entry.value) eq 3}">
																		<c:if test="${i.index == 2}">
																			<cocd:description code="${firstIndex}" type="${item}"
																				output="res1" />
																			<td class="hidden-phone" align="right">${res1}</td>
																			<cocd:description code="${secIndex}" type="${item}"
																				output="res2" />
																			<td class="hidden-phone" align="right">${res2}</td>
																		</c:if>
																	</c:when>
																	<c:otherwise>
																		<c:if test="${fn:length(entry.value) eq 2}">
																			<c:set var="lengthOfList"
																				value="${fn:length(entry.value)}"></c:set>
																			<c:choose>
																				<c:when test="${i.index == 0}">
																					<c:set var="firstValue" value="${item}"></c:set>
																				</c:when>
																				<c:otherwise>
																					<c:set var="secValue" value="${item}"></c:set>
																				</c:otherwise>
																			</c:choose>
																		</c:if>
																	</c:otherwise>
																</c:choose>


															</c:otherwise>
														</c:choose>





													</c:forEach>

													<c:if test="${lengthOfList eq 2}">
														<c:choose>
															<c:when test="${firstValue ne secValue}">
																<td class="hidden-phone" style="color: #FF0000"
																	align="right">${firstValue}</td>
																<td class="hidden-phone" style="color: #FF0000"
																	align="right">${secValue}</td>
															</c:when>
															<c:otherwise>
																<td class="hidden-phone" align="right">${firstValue}</td>
																<td class="hidden-phone" align="right">${secValue}</td>
															</c:otherwise>
														</c:choose>
													</c:if>


												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<!-- END FORM-->
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<!-- END EXAMPLE TABLE PORTLET-->
		<form:form class="form-horizontal" method="GET" commandName="dataLog"
			id="branchDetailsView" action="dataLogDetails.htm"
			enctype="multipart/form-data">
			<div class="control-group" id="get">
				<div class="controls">
					<input class="btn blue" name="action" id="g" type="submit"
						value="Back" />
				</div>
			</div>

			<!-- END VALIDATION STATES-->

		</form:form>
	</div>
</div>

<!-- END PAGE CONTAINER-->
