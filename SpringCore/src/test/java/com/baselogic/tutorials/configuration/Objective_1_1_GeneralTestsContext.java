package com.baselogic.tutorials.configuration;

import com.baselogic.tutorials.components.ConstructorInjectionComponent;
import com.baselogic.tutorials.components.MultipleConstructorInjectionComponent;
import com.baselogic.tutorials.components.PropertyInjectionComponent;
import com.baselogic.tutorials.components.SimpleComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"com.baselogic.tutorials.components"})
@PropertySource(value = {"classpath:test.properties"})
public class Objective_1_1_GeneralTestsContext {

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
     * @throws IOException
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(Boolean.TRUE);
        propertySourcesPlaceholderConfigurer.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

    /*

    @Bean
    @DependsOn({ "dataSource", "airportLocationDAOImpl" })
    public KioskService kioskServiceUS() {
        return new KioskServiceImpl(
                airportLocationDAO.getLocationByID(locationNL)
        );
    }*/

    @Bean(name = {"simpleComponent", "simpleComponentAlias"})
    public SimpleComponent simpleComponent() {
        SimpleComponent simple = new SimpleComponent();
        simple.setMessage(simpleMessage);
        return simple;
    }

    @Bean
    public SimpleComponent simpleComponentTwo() {
        SimpleComponent simple = new SimpleComponent();
        simple.setMessage(messageName);
        return simple;
    }

    @Bean
    public ConstructorInjectionComponent constructorInjectionComponent() {
        return new ConstructorInjectionComponent(messageName);
    }

    @Bean
    public MultipleConstructorInjectionComponent multipleConstructorInjectionComponent() {
        return new MultipleConstructorInjectionComponent(constructorArg1, constructorArg2);
    }

    @Bean
    public MultipleConstructorInjectionComponent multipleConstructorInjectionComponentByIndex() {
        return new MultipleConstructorInjectionComponent(constructorArg1, constructorArg2);
    }

    @Bean
    public PropertyInjectionComponent propertyInjectionComponent() {
        PropertyInjectionComponent pic = new PropertyInjectionComponent();
        pic.setMessage(messageName);
        pic.setSomeInt(someInt);
        pic.setSomeDouble(someDouble);
        return pic;
    }

    @Bean
    @Scope("prototype")
    public PropertyInjectionComponent prototypePropertyInjectionComponent() {
        PropertyInjectionComponent pic = new PropertyInjectionComponent();
        pic.setMessage(prototypeMessage);
        pic.setSomeInt(someInt);
        pic.setSomeDouble(anotherDouble);
        return pic;
    }

}
