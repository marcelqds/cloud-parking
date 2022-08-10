package com.mqds.cloudpark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Parking Rest API")
                .description("Gerenciamento de vagas de estacionamento")
                //.license("Apache License Version 2.0")
                //.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket getDocApi(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mqds.cloudpark.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(basicAuthScheme()))
                .securityContexts(Arrays.asList(getSecurityContext()));

    }

    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityContext getSecurityContext() {
        return SecurityContext
                .builder()
                .securityReferences(Arrays.asList(basicAuthReference ()))
                .build();
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

}
