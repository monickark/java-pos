package com.pos.common.displayTag;

import java.util.List;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.util.CommonCodeNotFoundException;
import com.pos.common.util.CommonCodeUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.appCache.dao.CommonCode;
import com.pos.framework.sessCache.SessionCache;

public class ComboxDecorator implements DisplaytagColumnDecorator {

	@Override
	public Object decorate(Object arg0, PageContext pageContext,
			MediaTypeEnum arg2) throws DecoratorException {
		StringBuffer buffer = new StringBuffer();
		CommonCodeUtil commonCodeUtil = new CommonCodeUtil();
		ApplicationCache applicationCache = (ApplicationCache) pageContext
				.findAttribute(ApplicationConstant.APPLICATION_CACHE);
		SessionCache sessionCache = (SessionCache) pageContext
				.findAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		List<CommonCode> commonCode = null;
		try {
			commonCode = commonCodeUtil.getCommonCodeListByType(
					applicationCache, "Lang2", sessionCache
							.getUserSessionDetails().getInstId(), sessionCache
							.getUserSessionDetails().getBranchId());
		} catch (CommonCodeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buffer.append("<div class='control-group'>");
		buffer.append("<div class='controls'>");
		buffer.append("<select class='span12 m-wrap' data-placeholder='Choose a Category' name='combosam' tabindex='1'>");
		for (CommonCode code : commonCode) {
			if (arg0.toString().equals(code.getCommonCode())) {
				buffer.append("<option value='" + code.getCommonCode()
						+ "' selected='selected'/>" + code.getCodeDescription()
						+ "");
			} else {
				buffer.append("<option value='" + code.getCommonCode() + "' />"
						+ code.getCodeDescription() + "");
			}
		}

		buffer.append("</select>");
		buffer.append("</div>");
		buffer.append("</div>");

		return buffer;
	}

}
