<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page import="com.pos.common.displayTag.SaleDecorator" />
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:scriptlet><![CDATA[SaleDecorator decorator = new SaleDecorator();
			//decorator.getTableDecorator().setTotalLabel("Total Fee");
			pageContext.setAttribute("saleDecorator", decorator);]]></jsp:scriptlet>

<%-- <form:form action="possale.htm" id="searchBar4" method="POST"
								commandName="possale"> --%>
<div id="basic-form" class="section pos-sale">
	<div class="row">
		<div class="col s12 m6 ">
			<div class="card-panel">
				<div class="row">
					<h4>Mobile</h4>
					<div class="col s12 m12">
						<div class="row">
							<form:form action="possale.htm" id="searchBar4" method="POST"
								commandName="possale">
								<div class="input-field col s10">
									<form:input placeholder="Scan IMEI Number..." id="imeiNumber"
										type="text" path="imei" />
									<label for="first_name">Scan IMEI </label>
									<c:if test="${imeierror ne null}">
										<error:description code="${imeierror}" type="error"
											result="description" />${description}</c:if>
								</div>
								<div class="input-field col s2">
									<button class="btn cyan waves-effect waves-light right"
										id="submitForm" type="submit" name="imeino">
										<i class="material-icons right">chevron_right</i>
									</button>
								</div>
							</form:form>
						</div>
						<!-- UpdateStatus-->

						<div id="UpdateStatus"
							class="tab-content col s12  grey lighten-4 active modal-inventory-prod-tab">
							<form:form action="possale.htm" id="searchBarAcc" method="POST"
								commandName="possale">
								<div id="basic-form" class="">
									<div class="row">
										<h4>Accessories</h4>
										<div class="custom-select col s6">
											<label>Category <span>*</span></label>
											<form:select path="accessories.category"
												class="browser-default category" name="category"
												id="categoryClass" data-placeholder="Choose a Category">
												<form:option value="" disabled="true" selected="true">Select Category</form:option>
												<form:options items="${category}" />
											</form:select>
										</div>
										<div class="custom-select col s6">
											<label>Brand Model <span>*</span></label>
											<form:select path="accessories.brand" id="brandList"
												class="browser-default brand" name="brand">
												<form:option value="" disabled="true" selected="true">Select Brand</form:option>
											</form:select>
											<span class="brandSpan"></span>
										</div>

										<div class="custom-select col s6">
											<label>Accessory Name <span>*</span></label>
											<form:select path="accessories.accessoriesId" id="nameList"
												class="browser-default" name="name"
												data-placeholder="Choose a Accessory">
												<form:option value="" disabled="true" selected="true">Select Accessory</form:option>
											</form:select>
											<form:input type="hidden" value="${posVO.accessories.name}"
												path="accessories.name" id="accessoryName" />
											<div class="errors"></div>
											<span class="accessorySpan"></span> <span
												class="inventorySpan"></span>
										</div>
										<div class="input-field col s6">
											<form:input  id="stock"
												path="accessories.inStock" type="text" placeholder="0" />
											<label for="display">In Stock</label>
										</div>
										<div id="radio" class="col s12 m12">
											<div class="row">
												<div class="input-field col s6">
													<form:input  id="costprice" type="text" placeholder="0"
														path="accessories.costPrice" />
													<label for="display">Cost Price</label>
												</div>
												<div class="input-field col s6">
													<form:input  id="sellingprice" type="text" placeholder="0"
														path="accessories.sellingPrice" />
													<label for="display">Selling Price</label>
												</div>
												<div class="input-field col s6">
													<form:input  id="qty" type="text" placeholder="0"
														path="accessories.quantity" />
													<label for="display">Quantity</label> <span
														class="qtyerror"></span>
												</div>

												<div class="input-field col s6" align="right">
													<button class="btn cyan waves-effect waves-light right"
														type="submit" name="addaccessory">
														<i class="material-icons right">chevron_right</i>
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form:form>
						</div>

						<div id="UpdateStatus2"
							class="tab-content col s12  grey lighten-4 active modal-inventory-prod-tab">
							<form:form action="possale.htm" id="searchBarTrade" method="POST"
								commandName="possale">
								<div id="basic-form" class="">

									<div class="row">
										<h4>Tradein</h4>
										<div class="input-field col s7">
											<form:input placeholder="" id="tradeinimei" type="text"
												path="tradein.imei" />
											<label for="display">IMEI</label>
											<c:if test="${tradeinimeierror ne null}">
												<error:description code="${tradeinimeierror}" type="error"
													result="description" />${description}</c:if>
										</div>
										<div class="input-field col s5" align="right">
											<button class="btn cyan waves-effect waves-light right"
												type="submit" name="addtradein">
												<i class="material-icons right">chevron_right</i>
											</button>
										</div>

									</div>
								</div>
							</form:form>
						</div>

					</div>
				</div>
			</div>
		</div>
		<error:description code="${success}" type="success"
			refNos="${errorParam}" result="description" />${description}
		<form:form action="possale.htm" id="searchBar0" method="POST"
			commandName="possale">
			<div class="col s12 m6 ">
				<div class="card-panel">

					<div class="row">
						<div class="input-field col s8" id="newcustomerId">
							<form:select path="customer.customerId" id="customer_list"
								class="brand-dropdown" name="customerId"
								data-placeholder="Choose a Category">
								<form:option value="" disabled="true" selected="true">Select Customer</form:option>
								<form:options items="${customer}" />
							</form:select>
						</div>
						<div class="input-field col s8" id="newcustomerName">
							<input placeholder="Customer Name" id="newcustomerNamevalue"
								type="text" readonly />
						</div>
						<div class="input-field col s4">
							<a
								class="btn-floating btn-large waves-effect waves-light cust-icons modal-trigger"
								href="#modal3"> <i class="material-icons">supervisor_account</i>
							</a> <a
								class="btn-floating cyan btn-large waves-effect waves-light  cust-icons modal-trigger"
								href="#modal2"> <i class="material-icons">phone_iphone</i>
							</a>
						</div>
					</div>

					<div class="row">
						<div class="col s12 m12 l12">
							<display:table id="poslist" class="striped pos-table"
								decorator="saleDecorator" requestURI="possale.htm"
								name="sessionScope.pos_list" sort="list">
								<display:setProperty name="basic.msg.empty_list" value="" />
								<display:column property="productName" title="Name" class="productName"
									sortable="true" headerClass="sortable" style="width:180px" />
								<display:column class="center quantity" title="Qty"
									property='quantity' style="width:50px">
								</display:column>
								<display:column property="price" class="center price" 
									title="Price" sortable="true" headerClass="sortable" />
								<display:column property="amount" class="center amount"
									title="Amt" sortable="true" headerClass="sortable" />
								<display:column property="discount" class="center" title="Disc" />
								<display:column title="Action" style="width:50px">
									<a class="btn-floating clear-icon waves-effect waves-light " id="delete-prod">
										<i class="material-icons">clear</i>
									</a>
								</display:column>
							</display:table>
							<div class="divider"></div>
							<ul id="profile-page-about-details "
								class="collection pos-cons z-depth-1 col s12 m12">
								<li class="collection-item pos-total">
									<div class="row">
										<div class="col s9" align="right">
											<strong> Total Amount :</strong>
										</div>
										<div class="col s3 right-align">
											<strong>$ <span class="totalAmount">
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${totalAmount}" /></span>
											</strong>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row text-red">
										<div class="col s9" align="right">Promo Discount :</div>
										<div class="col s3 right-align">
											$ <span class="promoAmount">0</span>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row">
										<div class="col s9" align="right">Sub Total :</div>
										<div class="col s3 right-align">
											$ <span class="netAmount">
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${netAmount}" /></span>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row">
										<div class="col s9" align="right">Tax (10%) :</div>
										<div class="col s3 right-align">
											$ <span class="taxAmount">
											<fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${tax}" /></span>
										</div>
									</div>
								</li>
								<li class="collection-item">
									<div class="row total">
										<div class="col s9" align="right">
											<strong>Total :</strong>
										</div>
										<div class="col s3 right-align">
											<strong> $<span class="payableAmount"><fmt:formatNumber minFractionDigits = "2" maxFractionDigits = "2" value = "${amountPayable}" />
											</span>

											</strong>
										</div>
									</div>
								</li>

								<li class="collection-item">
									<div class="row total">
										<div class="col s7">
											<a
												class="btn btn-warning waves-effect waves-light btn-discount  modal-trigger"
												href="#modal1">Promo Discount </a>
										</div>
										<div class="col s5 right-align">
											<button class="btn green waves-effect waves-light right"
												type="submit">Save & Print</button>
										</div>
									</div>
								</li>
							</ul>

							<div id="modal2" class="modal modal-fixed-footer">
								<div class="modal-content ">
									<div class="pos-page">
										<div id="profile-page-content" class="row">

											<!-- profile-page-sidebar-->
											<div id="profile-page-sidebar" class="col s12 m12">

												<!-- UpdateStatus-->
												<div class="row">
													<div class="input-field col s12 heading-form">
														<h4>Other Brand</h4>
													</div>

													<div class="input-field col s6">
														<form:input path="otherBrand.productId" placeholder="Name"
															class="input-field" />
														<label class="">Brand Name </label>
													</div>
													<div class="input-field col s6">
														<form:input path="otherBrand.quantity" placeholder="1"
															class="input-field oqty" />
														<label class="">Quantity </label>
													</div>
													<div class="input-field col s6">
														<form:input path="otherBrand.costPrice" placeholder="10"
															class="input-field ocp" />
														<label class="">Price </label>
													</div>
													<div class="input-field col s6">
														<form:input path="otherBrand.sellPrice" placeholder="10"
															class="input-field oamt" />
														<label class="">Amount </label>
													</div>
												</div>
											</div>
											<!-- profile-page-sidebar-->

										</div>
									</div>
								</div>
								<div class="modal-footer">
									<div class="row">
										<div class="input-field col s6" align="left">
											<a class="footer-success-col"></a>
										</div>
										<div class="input-field col s6 text-right">
											<button class="btn green waves-effect waves-light right"
												type="submit" name="action">SAVE</button>
										</div>

									</div>
								</div>
							</div>


							<div id="modal3" class="modal modal-fixed-footer">
								<div class="modal-content modal-new-customer">
									<div class="pos-page">
										<div id="profile-page-content" class="row">

											<!-- profile-page-sidebar-->
											<div id="profile-page-sidebar" class="col s12 m12">

												<div class="input-field col s12 m12 heading-form">
													<h4>New Customer</h4>
												</div>


												<div class="input-field col s12">
													<input type="text" name="customer.customerName"
														class="input-field getcustomername" /> <label class="">Name
													</label>
												</div>
												<div class="input-field col s6">
													<input type="text" name="customer.email"
														class="input-field" /> <label class="">Email </label>
												</div>
												<div class="input-field col s6">
													<input type="text" name="customer.mobile"
														class="input-field" /> <label class="">Mobile
														Number </label>
												</div>
												<div class="input-field col s12">
													<textarea placeholder="" id="message2"
														class="materialize-textarea" rows="10"
														name="customer.address"></textarea>
													<label for="message">Address</label>
												</div>
											</div>
											<!-- profile-page-sidebar-->

										</div>
									</div>
								</div>
								<div class="modal-footer pos-page">
									<div class="row">
										<div class="input-field col s6" align="left">
											<a class="footer-success-col"></a>
										</div>
										<div class="input-field col s6 text-right">
											<a href="#!"
												class="btn btn-warning modal-action modal-close waves-effect waves-green"
												id="newcustomerbtn">Ok</a>
										</div>

									</div>
								</div>
							</div>
							<form id="discount-form">
								<div id="modal1"
									class="modal-discount sweet-alert show-input showSweetAlert visible"
									data-custom-class="" data-has-cancel-button="true"
									data-has-confirm-button="true" data-allow-outside-click="false"
									data-has-done-function="true" data-animation="slide-from-top"
									data-timer="null" style="display: block; margin-top: -206px;">
									<div class="sa-icon sa-error" style="display: none;">
										<span class="sa-x-mark"> <span class="sa-line sa-left"></span>
											<span class="sa-line sa-right"></span>
										</span>
									</div>
									<div class="sa-icon sa-warning" style="display: none;">
										<span class="sa-body"></span> <span class="sa-dot"></span>
									</div>
									<div class="sa-icon sa-info" style="display: none;"></div>
									<div class="sa-icon sa-success" style="display: none;">
										<span class="sa-line sa-tip"></span> <span
											class="sa-line sa-long"></span>

										<div class="sa-placeholder"></div>
										<div class="sa-fix"></div>
									</div>
									<div class="sa-icon sa-custom" style="display: none;"></div>
									<h2>Promo Discount</h2>
									<fieldset>
										<input type="text" class="disc" name="percentage"
											placeholder="Enter Discount Percentage" class="model-text"
											tabindex="3" placeholder="">
										<div class="sa-input-error"></div>
									</fieldset>

									<fieldset>
										<form:input path="promoDiscount" name="promo"
											class="model-text disc-amount"
											placeholder="Enter Discount Amount" tabindex="3"
											id="promoDiscount" />
										<div class="sa-input-error"></div>
									</fieldset>

									<div class="sa-error-container">
										<div class="icon">!</div>
										<p>You need to write something!</p>
									</div>
									<div class="sa-button-container">
										<!-- <button class="cancel cancel-btn" tabindex="2" type ="button"
											style="display: inline-block; box-shadow: none;">Cancel</button> -->
										<div class="sa-confirm-button-container">
											<button class="confirm confirm-btn" tabindex="1"
												id="disc-btn" type="button"
												style="display: inline-block; background-color: rgb(140, 212, 245); box-shadow: rgba(140, 212, 245, 0.8) 0px 0px 2px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px inset;">OK</button>
											<div class="la-ball-fall">
												<div></div>
												<div></div>
												<div></div>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
			</div>
		</form:form>
	</div>
</div>
<%-- </form:form> --%>
