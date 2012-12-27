package com.baselogic.editors;

import java.beans.PropertyEditorSupport;

import com.baselogic.domain.PhoneNumber;

/**
 * PhoneNumberEditor
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * @author Mick Knutson
 * @see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * @see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * @see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * @see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 *
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
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
