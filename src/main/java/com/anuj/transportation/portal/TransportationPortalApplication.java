package com.anuj.transportation.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = {"com.anuj.entities"})  // scan JPA entities
@EnableJpaRepositories("com.anuj.repository")
@ComponentScans(value = {@ComponentScan(value="com.anuj.transportation.portal"),
						 @ComponentScan(value="com.anuj.controllers"),
						 @ComponentScan(value="com.anuj.services"),
						 @ComponentScan(value="com.anuj.repository")})
public class TransportationPortalApplication {

	  @Bean
	    public Docket api(){
	        return new Docket(DocumentationType.SWAGGER_2).groupName("Transportation").select()
	                .apis(RequestHandlerSelectors.basePackage("com.anuj.controllers"))
	                .paths(any()).build().apiInfo(new ApiInfo("Transportation Portal",
	                        "A set of services to provide data access to Customer", "1.0.0", null,
	                        new Contact("Anuj Parmar", "https://github.com/anujparmar545/Transportation-Portal", null),null, null));
	    }
	  
	
	  @SuppressWarnings("deprecation")
	@Bean
	  public WebMvcConfigurer corsConfigurer() {
	     return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	           registry.addMapping("/**").allowedOrigins("http://localhost:8100");
	        }    
	     };
	  }
	  
	public static void main(String[] args) {
		SpringApplication.run(TransportationPortalApplication.class, args);
	}

}
