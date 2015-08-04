package com.baselogic.demos.configuration;

import org.springframework.context.annotation.*;

/**
 * Created by mickknutson on 4/12/15.
 */
@Configuration
@ComponentScan(basePackages =
        {"com.baselogic.demos"}
)
@Import({HibernateConfiguration.class, JdbcEmbeddedConfig.class})
@ImportResource({"classpath:applicationContext*.xml"})
//@PropertySource({"classpath:test.properties"})
public class JavaConfig {
}
