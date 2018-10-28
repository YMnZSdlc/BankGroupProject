package pl.sda.bankserver.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadExternalizePropertiesTest {

    @Autowired
    private Environment env;

    @Autowired
    LoadExternalizeProperties loadExternalizeProperties;

    @Test
    public void chechLoadProperties() {

        loadExternalizeProperties.load();

        String property = env.getProperty("spring.datasource.driver-class-name");
        System.out.println(property);
    }
}
