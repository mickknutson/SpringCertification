package com.baselogic.tutorials.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages =
        {
                "com.springclass.configuration",
                "com.springclass.domain",
                //"com.springclass.bo",
                "com.springclass.service",
                "com.springclass.fixture",
                "com.springclass.jdbc.dao"
        }
)
@PropertySource(value = {"classpath:test.properties"})
//@Import(JdbcEmbeddedConfig.class)
public class JavaConfig {

//    @Value("${location.id.us}")
//    private String locationUS;
//    @Value("${location.id.nl}")
//    private String locationNL;
//    @Value("${location.id.fr}")
//    private String locationFR;

//    @Autowired
//    @Qualifier("airportLocationDAOImpl")
//    AirportLocationDAO airportLocationDAO;



    /**
     * Note: If you don't want to use @PropertySource, and/or need more custom PropertySourcesPlaceholderConfigurer
     * configuration, you can create a @Bean as seen here.
     * @return
     * @throws java.io.IOException
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(Boolean.TRUE);
        propertySourcesPlaceholderConfigurer.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

    /*@Bean
    @DependsOn({ "dataSource", "airportLocationDAOImpl" })
    public KioskService kioskServiceUS() {
        return new KioskServiceImpl(
                airportLocationDAO.getLocationByID(locationNL)
        );
    }*/

}
