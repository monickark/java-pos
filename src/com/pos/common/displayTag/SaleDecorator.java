package com.pos.common.displayTag;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.TableDecorator;
import org.displaytag.model.TableModel;

import com.pos.sale.controller.PosVO;

public class SaleDecorator extends TableDecorator{
	
	@Override
	public void init(PageContext pageContext, Object decorated,
			TableModel tableModel) {
		super.init(pageContext, decorated, tableModel);
	}

	public String getDiscount() {

		PosVO posVO = (PosVO) getCurrentRowObject();
		StringBuffer buffer = new StringBuffer();
		buffer.append("<input type=\"text\" name=\"discount\" class=\"center discount\" value=\"");
		if(posVO.getDiscount()!=null && posVO.getDiscount()!=""){
			buffer.append(posVO.getDiscount());
		}else{
			buffer.append(0);
		}

		buffer.append("\"");
		buffer.append("/>");
		buffer.append("<span class=\"errors\"></span>");
		return buffer.toString();
	}

}
