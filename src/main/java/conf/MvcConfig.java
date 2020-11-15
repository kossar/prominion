package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"app", "conf"})
@PropertySource("classpath:/application.properties")
public class MvcConfig {

    @Bean
    public JdbcTemplate getTemplate(DataSource ds) {

        return new JdbcTemplate(ds);
    }
}
