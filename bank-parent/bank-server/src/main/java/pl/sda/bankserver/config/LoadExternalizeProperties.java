package pl.sda.bankserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "file:${user.home}/newProperties.properties")
})
public class LoadExternalizeProperties {

    @Autowired
    private Environment env;

    public void load() {

//        String property = System.getProperty("user.home");
//        System.setProperty("app.home", property);

    }

    @PostConstruct
    public void log(){

        String driver = env.getProperty("spring.datasource.driver-class-name");
        String driver1 = env.getProperty("spring.jpa.generate-ddl");
        String driver2 = env.getProperty("custom");
        String driver3 = env.getProperty("dupa");

        System.out.println(driver);
        System.out.println(driver1);
        System.out.println(driver2);
        System.out.println(driver3);

    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}


