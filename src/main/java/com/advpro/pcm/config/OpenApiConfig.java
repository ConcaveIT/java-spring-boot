package com.advpro.pcm.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Muhammad Jaber",
            email = "skmdjaber@gmail.com",
            url = "https://skmdjaber.com"
        ),
        description = "Java Spring Boot Tutorial - Topic03",
        title = "Project Cost Management",
        version = "1.0",
        license = @License(
            name = "MIT",
            url = "https://opensource.org/license/mit/"
        ),
        termsOfService = "Terms of service"
    ),
    servers = {
        @Server(
            description = "Local ENV",
            url = "http://localhost:8080"
        ),
        @Server(
            description = "PROD ENV",
            url = "https://skmdjaber.com"
        )
    },
    security = {
        @SecurityRequirement(
            name = "bearerAuth"
        )
    }
)

@SecurityScheme(
    name = "bearerAuth",
    description = "JWT auth token",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig {
    
}