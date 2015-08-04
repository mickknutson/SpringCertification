package com.baselogic.demos;

import com.baselogic.tutorials.aspects.BeforeAdvice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {
        "com.baselogic.tutorials.dao",
        "com.baselogic.tutorials.domain",
        "com.baselogic.tutorials.service"
}/*,
        includeFilters = {
                @ComponentScan.Filter(pattern = "com.baselogic.*.Component*"),
                @ComponentScan.Filter(pattern = "com.baselogic.*.ExampleServiceInitializingBean*") },
        excludeFilters = {
                @ComponentScan.Filter(pattern = "com.baselogic.*.ExampleServiceImpl*"),
                @ComponentScan.Filter(pattern = "com.baselogic.*.OrderServiceImpl*") }*/
)
@TestPropertySource(value = {"classpath:test.properties"})
public class AfterAdviceTestsContext {

    @Value("${message.name}")
    private String message;

    @Value("Simple p namespaced Java Configuration")
    private String simpleMessage;

    @Value("${message.name}")
    private String messageName;

    @Value("${prototype.message}")
    private String prototypeMessage;

    @Value("${message.name}")
    private String message1;

    @Value("${message.name}")
    private String message2;

    @Value("${constructor.arg.1}")
    private String constructorArg1;

    @Value("${constructor.arg.2}")
    private String constructorArg2;

    @Value("#{ T(java.lang.Math).random() * 10}")
    private int someInt;

    @Value("#{ T(java.lang.Math).random() * 100.0}")
    private Double someDouble;

    @Value("#{ T(java.lang.Math).random() * 200.0}")
    private Double anotherDouble;




    /**
     * Note: If you don't want to use @PropertySource, and/or need more custom PropertySourcesPlaceholderConfigurer
     * configuration, you can create a @Bean as seen here.
     * @return
     * @throws IOException
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(Boolean.TRUE);
        propertySourcesPlaceholderConfigurer.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public BeforeAdvice beforeAdvice(){
        return new BeforeAdvice();
    }


    /*@Bean
    @DependsOn({ "dataSource", "airportLocationDAOImpl" })
    public KioskService kioskServiceUS() {
        return new KioskServiceImpl(
                airportLocationDAO.getLocationByID(locationNL)
        );
    }*/

}
