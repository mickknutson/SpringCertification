package com.baselogic.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * LegacyComponentFactory
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
public class LegacySingletonComponent {

	private LegacySingletonComponent () {
		name = "default LegacySingletonComponent Name";
	}

	// Factory Methods
    private static class LegacySingletonComponentHolder {
        private static final LegacySingletonComponent INSTANCE = new LegacySingletonComponent();
    }

    public static LegacySingletonComponent getInstance() {
        return LegacySingletonComponentHolder.INSTANCE;
    }

    private String name;

	public String getName() {
		return name;
	}

	/* non-mutable:
	public void setName(String name) {
		this.name = name;
	}*/

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
