package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin
public class BillingSfotwareApplication extends SpringBootServletInitializer {

	 // You MUST add this method to support WAR deployment
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BillingSfotwareApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(BillingSfotwareApplication.class, args);
	}

}
