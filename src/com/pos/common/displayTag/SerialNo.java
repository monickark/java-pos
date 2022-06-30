package com.pos.common.displayTag;


import org.displaytag.decorator.TableDecorator;



public class SerialNo  extends TableDecorator{
	
	 public Integer getSerialNo() {
			return getListIndex()+1;
		    }
	 
	 
	
}
