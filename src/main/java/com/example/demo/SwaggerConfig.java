package com.example.demo;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile(value= {"dev","qa"})
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
             
    }
  @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
 
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
  /*
   * This method need to be updated appropriately
   */
  private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Demo API", //API title
	      "Description of the API's", //Description about the API's
	      "1.0.0", //API Version
	      "http://www.example.com", //Terms of Conditions URL
	      //Contact details
	      new Contact("Karthik", //Contact Name
	    		  	  "http://www.example.com", //Contact web site
	    		  	  "hkarthik86@gmail.com" //Contact Email
	    		  	  ), 
	      "License of API", //License details
	      "http://www.example.com", //License URL
	      Collections.emptyList() //Vendor details
	      );
	}
}