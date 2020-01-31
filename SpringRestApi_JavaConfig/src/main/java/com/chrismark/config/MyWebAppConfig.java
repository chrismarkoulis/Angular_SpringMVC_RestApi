package com.chrismark.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 *
 * @author chris
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.chrismark")
class MyWebAppConfig implements WebMvcConfigurer {
    
}
