<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="error" uri="ErrorCodeDescription"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="basic-form" class="section">
	<div class="row">

		<div class="col s12 m6 ">
			<form:form action="till.htm" id="tillForm" method="POST"
				commandName="till">
				<div class="card-panel">
					<h4 class="header2">Date: ${today}</h4>
					<h6 class="store-status">Store: ${status}</h6>
					<div class="mar-bot-20"></div>
					<div class="row">
						<div class="col s12 m12 start-row">
							<error:description code="${success}" type="success"
								result="description" />
							${description}

							<error:description code="${success1}" type="error"
								result="description1" />
							${description1}
							<div class="row">

								<div class="input-field col s12">
									<form:input placeholder="" id="name2" type="text" path="amount" class="till-amount"/>
									<label for="amount">Amount <span>*</span></label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:textarea placeholder="" id="message2"
										class="materialize-textarea" rows="10" path="description"></form:textarea>
									<label for="description">Description</label>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<button class="btn cyan waves-effect waves-light right"
											id="submitForm1" name="action">
											Add Amount <i class="material-icons right">chevron_right</i>
										</button>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		
			<div class="col s12 m6 ">
				<form:form action="till.htm" id="searchBar2" method="POST"
					commandName="till">
					<div class="card-panel">
						<h4 class="header2">Till Summary</h4>
						<div class="invoice-table pad-top-10">
							<div class="row">
								<div class="col s12 m12 l12">
								<c:if test="${sessionScope.till ne null }">
									<display:table id="till-table" class="striped" requestURI="till.htm"
										name="sessionScope.till" sort="list" cellspacing="0">
										<display:setProperty name="basic.msg.empty_list" value="" />
										<display:column property="description" title="Description"
											sortable="true" headerClass="sortable" style="width:180px" />
										<display:column property="amount" title="Amount" format="$ {0,number,00.00}"
											sortable="true" headerClass="sortable" style="width:180px"/>

									</display:table>
									</c:if>
									</br>
									<button class="btn btn-warning waves-effect waves-light "
										name="open_counter">Open Counter</button>
									<button class="btn grey waves-effect waves-light right"
										name="close_counter">Close Counter</button>

								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		
	</div>


</div>