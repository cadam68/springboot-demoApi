package com.example.demo.config;

import com.example.demo.entity.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.awt.print.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    // private String theAllowedOrigins = "https://localhost:3000";
    private String theAllowedOrigins = "*";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.PUT};
        config.exposeIdsFor(Student.class);        // Expose the PK (Spring Boot automatically hide the id of the entities)
        disableHttpMethods(Student.class, config, theUnsupportedActions);

        /* Configuration CORS Mapping */
        cors.addMapping(config.getBasePath()+"/**")
                .allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
