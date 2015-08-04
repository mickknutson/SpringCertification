package com.baselogic.tutorials.common;

import com.baselogic.tutorials.components.ConstructorInjectionComponent;

/**
 * LegacyComponentFactory
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * @author Mick Knutson
 * at_see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * at_see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * at_see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * at_see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
public class LegacyComponentFactory {

	private LegacyComponentFactory () {}

    private static class ConstructorInjectionComponentHolder {
        private static final ConstructorInjectionComponent INSTANCE =
        		new ConstructorInjectionComponent("default legacyConstructorInjectionComponent from LegacyComponentFactory");
    }

    public ConstructorInjectionComponent getInstance() {
        return ConstructorInjectionComponentHolder.INSTANCE;
    }

}
