package com.user.demo.Microservicecrud.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Demo Bank Service",
                version = "V12.0.12",
                title = "Customer Banking API",
                contact = @Contact(
                   name = "Vijay Gharal", 
                   email = "vj3112thanekar@gmail.com", 
                   url = "http://www.google.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://in28minutes.com")
)
public interface ApiDocumentationConfig {

}