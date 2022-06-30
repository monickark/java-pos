<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
	<div id="invoice">
		<form:form action="#" id="searchBar6" method="GET"
			commandName="tradein">
			<div id="printableArea">
				<div class="invoice-header">
					<div class="row section">

						<div class="col s12 m6 l6">
							<img src="images/logo/logo_retail.png" width="200px"
								alt="company logo">
							<c:if test="${tradeinVO ne null}">
								<p class="customer">
									From, <br /> <span class="strong">${tradeinVO.customerName}</span><br /> 
									<span>${tradeinVO.contactNo}</span> <br/> ${tradeinVO.lisenceNumber}								
								</p>
							</c:if>
						</div>
						<div class="col s12 m6 l6">
							<div class="invoce-company-address right-align">
								<span class="invoice-icon"> <i
									class="material-icons cyan-text">location_city</i>
								</span>


								<p class="company">
									<span class="strong">53/662 Compton Road, </span> <br /> <span>Calamvale
										QLD 4116, AU</span> <br /> <span>ABN No : 32 606 717 471</span> <br />
									<span>(07) 37114440</span> <br /> <span>info@cellaphone.com.au</span>
								</p>
							</div>

						</div>
					</div>
				</div>
				<div class="invoice-lable">
					<div class="row">
						<div class="col s12 m3 l3 cyan">
							<h4 class="white-text invoice-text">INVOICE</h4>
						</div>
						<div class="col s12 m9 l9 invoice-brief cyan white-text">
							<div class="row">
								<div class="col s12 m3 l3">
									<p class="strong">Total Due</p>
									<h4 class="header ">$ ${tradeinVO.resaleValue}</h4>
								</div>
								<div class="col s12 m3 l3">
									<p class="strong">Invoice No</p>
									<h4 class="header">${tradeinVO.t_invoiceId}</h4>
								</div>
								<div class="col s12 m3 l3">
									<p class="strong">Date</p>
									<h4 class="header">${today}</h4>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="invoice-table">
					<div class="row">
						<div class="col s12 m12 l12">
							<display:table class="striped" requestURI="tradein.htm"
								name="sessionScope.tradeinVO" sort="list">
								<display:setProperty name="basic.msg.empty_list" value="" />
								<display:column property="brand" title="Brand" sortable="true"
	   								headerClass="sortable" style="width:180px" />
								<display:column property="modelNo" title="Model No"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="color" title="Color"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="capacity" title="Capacity"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="imei" title="IMEI"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="resaleValue" title="Resale Value"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="description" title="Description"
									sortable="true" headerClass="sortable" style="width:180px" />
							</display:table>
							<ul id="profile-page-about-details "
								class="collection pos-cons z-depth-1 col s12 m12">

								<li class="collection-item">
									<div class="row total">
										<div class="col s9" align="right">
											<strong>Total : </strong>
										</div>
										<div class="col s3 right-align">
											<strong>$<span class="payableAmount">
													${tradeinVO.resaleValue}</span>
											</strong>
										</div>
									</div>
								</li>

							</ul>

						</div>
					</div>
				</div>
			</div>
			<div class="mar-top-20"></div>
			<div class="invoice-footer " align="right">
				<div class="row ">
					<div class="col s12 m12 l12">
						<button class="btn btn-warning waves-effect waves-light "
							type="submit" name="print">Print
						</button>
					</div>

				</div>
				<div class="mar-bot-20"></div>
			</div>
			<div class="row">
				<div class="col s12 m4 l4">
					<h4 class="customer-sign">Customer Signature</h4>
				</div>
			</div>

			<div id="redrawSignature" class="kbw-signature kbw-signature-disabled"></div>
		</form:form>
	</div>
	<!-- Floating Action Button -->
</div>