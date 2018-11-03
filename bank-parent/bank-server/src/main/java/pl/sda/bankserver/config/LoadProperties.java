package pl.sda.bankserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:generator.properties"),
        @PropertySource(value = "file:${user.home}/application.properties", ignoreResourceNotFound = true)
})
public class LoadProperties {
}
