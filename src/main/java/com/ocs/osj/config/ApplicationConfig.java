package com.ocs.osj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(basePackages = {"com.ocs.osj.model.impl","com.ocs.osj.model"} )
@Import({DBconfig.class})	
public class ApplicationConfig {

}
