package com.pos.framework.sessCache;

import java.io.Serializable;
import java.util.List;

import com.pos.framework.appCache.dao.MenuProfileOptionLinking;

public class SessionCache implements Serializable {
	private UserSessionDetails userSessionDetails;
	List<MenuProfileOptionLinking> optionLinkings;
	List<MenuProfileOptionLinking> userBreadCrumbs;
	List<String> allowedUrl;

	public List<String> getAllowedUrl() {
		return allowedUrl;
	}

	public void setAllowedUrl(List<String> allowedUrl) {
		this.allowedUrl = allowedUrl;
	}

	public List<MenuProfileOptionLinking> getUserBreadCrumbs() {
		return userBreadCrumbs;
	}

	public void setUserBreadCrumbs(List<MenuProfileOptionLinking> menus) {
		userBreadCrumbs = menus;
	}

	public List<MenuProfileOptionLinking> getOptionLinkings() {
		return optionLinkings;
	}

	public void setOptionLinkings(List<MenuProfileOptionLinking> optionLinkings) {
		this.optionLinkings = optionLinkings;
	}

	public UserSessionDetails getUserSessionDetails() {
		return userSessionDetails;
	}

	public void setUserSessionDetails(UserSessionDetails userSessionDetails) {
		this.userSessionDetails = userSessionDetails;
	}

}
