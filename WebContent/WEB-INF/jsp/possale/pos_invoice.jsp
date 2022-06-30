<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<div id="invoice">
		<form:form id="searchBar6" method="GET"
			commandName="possale">
			<div id="printableArea">
				<div class="invoice-header">
					<div class="row section">

						<div class="col s12 m6 l6">
							<img src="images/logo/logo_retail.png" width="200px"
								alt="company logo">
							<c:if test="${customerVO ne null && customerVO.customerId ne 'CU000'}">
								<p>
									To,
								</p>
								<p class="customer-details">
									<span class="strong">${customerVO.customerName}</span>
								</p>
								<p class="customer-details"> 
									<span>${customerVO.email}</span>
								</p>
								<p class="customer-details">
									<span>${customerVO.phone}</span>
								</p>
								<p class="customer-details">
									<span>${customerVO.address}</span>
								</p>
								<p class="customer-details">
									<span>${customerVO.state}</span>
								</p>
								<p class="customer-details">
									<span>${customerVO.country}</span> 
								</p>
								<p class="customer-details">
									<span>${customerVO.postCode}</span>	
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
									<h4 class="header ">$ 
									<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${salesVO.amountPayable}" /></h4>
								</div>
								<div class="col s12 m3 l3">
									<p class="strong">Invoice No</p>
									<h4 class="header">${salesVO.invoiceNo}</h4>
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
							<display:table class="striped" requestURI="possale.htm"
								name="sessionScope.pos_list" sort="list">
								<display:setProperty name="basic.msg.empty_list" value="" />
								<display:column property="productName" title="Item"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="quantity" title="Quantity"
									sortable="true" headerClass="sortable" style="width:180px">1</display:column>
								<display:column property="price" title="Unit Price" 
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column property="discount" title="Discount"
									sortable="true" headerClass="sortable" style="width:180px">0</display:column>
								<display:column property="amount" title="Amount" sortable="true"
									headerClass="sortable" style="width:180px" />
							</display:table>
							<ul id="profile-page-about-details "
								class="collection pos-cons z-depth-1 col s12 m12">
								
								<li class="collection-item">
									<div class="row">
										<div class="col s9" align="right">Promo Discount :</div>
										<div class="col s3 right-align">
											(-) $<span class="promoAmount">
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${salesVO.promoDiscount}" /></span>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row">
										<div class="col s9" align="right">Sub Total :</div>
										<div class="col s3 right-align">
											$<span class="netAmount"> 
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${salesVO.netAmount}" /></span>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row">
										<div class="col s9" align="right">Tax (10%) :</div>
										<div class="col s3 right-align">
											$<span class="taxAmount"> 
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${salesVO.tax}" /></span>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row total">
										<div class="col s9" align="right">
											<strong>Total : </strong>
										</div>
										<div class="col s3 right-align">
											<strong>$<span class="payableAmount">
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${salesVO.amountPayable}" /></span>

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
		</form:form>
	</div>
	<!-- Floating Action Button -->
</div>