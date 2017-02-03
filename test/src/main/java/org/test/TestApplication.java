package org.test;

import org.h2.server.web.WebServlet;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TestApplication {

    @Bean
    @Profile("dev")
    public ServletRegistrationBean h2Console() {
        ServletRegistrationBean reg = new ServletRegistrationBean(new WebServlet(), "/console/*");
        reg.setLoadOnStartup(1);
        return reg;
    }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TestApplication.class);
		//app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
