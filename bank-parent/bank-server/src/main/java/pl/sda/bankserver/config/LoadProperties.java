package pl.sda.bankserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("classpath:generator.properties"),
        @PropertySource(value = "file:${user.home}/application.properties", ignoreResourceNotFound = true)
})
public class LoadProperties {

    @Autowired
    Environment env;

}
