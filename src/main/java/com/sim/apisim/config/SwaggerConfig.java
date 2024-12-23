package com.sim.apisim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENSE_TEXT = "License";
	private static final String title = "S.I.M REST API";
	private static final String description = "RESTful API sistema integrado de materiais";

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title)
				.contact(new Contact("Elias Araujo", "https://www.linkedin.com/in/elias-ara%C3%BAjo-20b677a5/",
						"elias.dvlpr@gmail.com"))
				.description(description).license(LICENSE_TEXT).version(SWAGGER_API_VERSION).build();

	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sim.apisim.controller"))
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

}
