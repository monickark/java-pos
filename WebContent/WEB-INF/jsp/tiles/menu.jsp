<!-- <aside id="left-sidebar-nav">
          <ul id="slide-out" class="side-nav fixed leftside-navigation">
            
            <li class="no-padding">
				
				
              <ul class="collapsible" data-collapsible="accordion">
				<li class="bold"><a href="dashboard.htm" class="waves-effect waves-cyan"><i class="material-icons">dashboard</i> Dashboard</a>
				</li>
				<li class="bold"><a href="welcome.htm" class="waves-effect waves-cyan"><i class="material-icons">dashboard</i>  Till</a>
				</li>
				
				<li class="bold">
                  <a class="collapsible-header waves-effect waves-cyan">
                    <i class="material-icons">dvr</i>
                    <span class="nav-text">POS</span>
                  </a>
                  <div class="collapsible-body">
                    <ul>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Refund</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Resale</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Repair</span>
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
				<li class="bold">
                  <a class="collapsible-header waves-effect waves-cyan">
                    <i class="material-icons">dvr</i>
                    <span class="nav-text">Report</span>
                  </a>
                  <div class="collapsible-body">
                    <ul>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Till Report</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> POS Report</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Product Report</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span>Customer Report</span>
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
				
				<li class="bold">
                  <a class="collapsible-header waves-effect waves-cyan">
                    <i class="material-icons">dvr</i>
                    <span class="nav-text">Product</span>
                  </a>
                  <div class="collapsible-body">
                    <ul>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Add Product</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Add Accessories</span>
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
                
				<li class="bold"><a href="welcome.htm" class="waves-effect waves-cyan"><i class="material-icons">dashboard</i>  Customer</a>
				</li>
				<li class="bold">
                  <a class="collapsible-header waves-effect waves-cyan">
                    <i class="material-icons">dvr</i>
                    <span class="nav-text">Inventory</span>
                  </a>
                  <div class="collapsible-body">
                    <ul>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Add Product</span>
                        </a>
                      </li>
                      <li>
                        <a href="">
                          <i class="material-icons">keyboard_arrow_right</i>
                          <span> Add Accessories</span>
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
				<li class="bold"><a href="welcome.htm" class="waves-effect waves-cyan"><i class="material-icons">dashboard</i>  Settings</a>
				</li>
				<li class="bold"><a href="logout.htm" class="waves-effect waves-cyan"><i class="material-icons">dashboard</i>  Logout</a>
				</li>
                
              </ul>
            </li>
            
            
          </ul>
          <a href="#" data-activates="slide-out" class="sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only">
            <i class="material-icons">menu</i>
          </a>
        </aside> -->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- START LEFT SIDEBAR NAV-->
        <aside id="left-sidebar-nav">
          <ul id="slide-out" class="side-nav fixed leftside-navigation">
          <li class="user-details cyan darken-2">
              <div class="row">
                <div class="col col s4 m4 l4">
                  <img src="images/avatar/avatar-7.png" alt="" class="circle responsive-img valign profile-image cyan">
                </div>
                <div class="col col s8 m8 l8">
                  <a class="btn-flat dropdown-button waves-effect waves-light white-text profile-btn" href="#" data-activates="profile-dropdown-nav">Riyaz<i class="mdi-navigation-arrow-drop-down right"></i></a>
                  <p class="user-roal">Administrator</p>
                </div>
              </div>
            </li>
            <li class="no-padding">
              <ul class="collapsible" data-collapsible="accordion">                
                <c:set var="node" value="-1" />
				<c:set var="level" value="-1" />
				<c:set var="compa" value="LOUT" />
				<c:forEach items="${sessionScope.session.optionLinkings}" var="menu">
					<c:if test="${menu.menuNode eq node && menu.menuLevel eq level}">
						<c:url value="${menu.menuUrl}" var="myURL">

						</c:url>
						<c:choose>
							<c:when test="${menu.menuOption ne compa}">
								<li class="bold"><a class="collapsible-header waves-effect waves-cyan" href="${myURL}"><i
										class="material-icons" id='${menu.menuOption}'>${menu.menuIcon}</i>
										<span class="nav-text">${menu.menuDescription}</span>
										</a></li>
								<br />
							</c:when>
							<c:otherwise>
								<li class="divider"></li>
								<li class="bold"><a class=" waves-effect waves-cyan" href="${myURL}"><i
										class="material-icons" id='${menu.menuOption}'>${menu.menuIcon}</i>
										<span class="nav-text">${menu.menuDescription}</span>
										</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
              </ul>
            </li>

          <c:set var="node" value="0" />
	<c:set var="compa" value="Y" />
			 <li class="no-padding">
				<ul class="collapsible" data-collapsible="accordion">
		<c:forEach items="${sessionScope.session.optionLinkings}" var="menu">

			<c:if test="${menu.menuNode eq node}">

				<li class="bold" id="${menu.menuNode}k"><c:choose>
						<c:when test="${menu.slmFlg ne compa}">

							<a href="javascript:;" class="collapsible-header waves-effect waves-cyan" id="${menu.slmFlg }"> <i
								class="material-icons" id='${menu.menuOption}'>${menu.menuIcon}</i>
								<span class="nav-text">${menu.menuDescription}</span><span
								class="arrow" id="${menu.menuNode}r"></span>

							</a>
						</c:when>

						<c:otherwise>
							<c:url value="${menu.menuUrl}" var="URL">

							</c:url>

							<a href="${URL}" class="waves-effect waves-cyan"> <i class="material-icons"
								id='${menu.menuOption}'>${menu.menuIcon}</i><span class="nav-text">${menu.menuDescription}</span> <span
								class="samt" id="${menu.menuNode}r"></span>
							</a>
						</c:otherwise>
					</c:choose> 
					<c:if test="${menu.slmFlg ne  compa }">
					<div class="collapsible-body">
						<ul>
							<c:set var="level" value="1" />
							<c:forEach items="${sessionScope.session.optionLinkings}"
								var="lev">
								<c:if test="${lev.menuNode eq node && lev.menuLevel eq level}">
									<c:set var="curURL" value="/${lev.menuUrl}" />
									<c:if
										test="${curURL eq requestScope['javax.servlet.forward.servlet_path']}">
										<c:set var="dd" value="${lev.menuNode}" />
									</c:if>
									<li><c:url value="${lev.menuUrl}" var="myURL">

										</c:url> <a class="" href="${myURL}">
										<i class="material-icons">${lev.menuIcon}</i>
										<span> ${lev.menuDescription} </span></a></li>

								</c:if>

							</c:forEach>

						</ul>
						</div>
					</c:if>
				</li>

				<c:set var="node" value="${node+1}" />
				

			</c:if>

		</c:forEach>
		</ul>
            </li>
	</ul>
          
          <a href="#" data-activates="slide-out" class="sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only">
            <i class="material-icons">menu</i>
          </a>
        </aside>
        <!-- END LEFT SIDEBAR NAV-->