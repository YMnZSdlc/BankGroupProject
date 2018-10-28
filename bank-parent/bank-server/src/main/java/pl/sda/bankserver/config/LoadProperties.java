package pl.sda.bankserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("file:${user.home}/newProperties.properties")
})
public class LoadProperties {

    @Autowired
    Environment env;


    @PostConstruct
    public void log() {

        String dupa = env.getProperty("dupa");
        System.out.println(dupa);
    }
}
