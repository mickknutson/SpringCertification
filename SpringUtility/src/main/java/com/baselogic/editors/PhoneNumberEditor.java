package com.baselogic.editors;

import java.beans.PropertyEditorSupport;

public class PhoneNumberEditor extends PropertyEditorSupport {


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		PhoneNumber pn = new PhoneNumber();
		pn.setAreaCode(text.substring(0,3));
		pn.setPrefix(text.substring(3,6));
		pn.setSuffix(text.substring(6));
		
		setValue(pn);
	}

}
