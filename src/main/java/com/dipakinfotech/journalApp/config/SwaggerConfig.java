package com.dipakinfotech.journalApp.config;

import io.swagger.v3.oas.annotations.servers.Servers;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    //    http://localhost:8081/journal/swagger-ui/index.html
    @Bean
    public OpenAPI myCustomConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Journal App Api's")
                        .description("by Dipak Borkhatariya")
                )
                .servers(List.of(
                                new Server()
                                        .url("http://localhost:8081")
                                        .description("local"),
                                new Server()
                                        .url("http://localhost:8082")
                                        .description("live")
                        )
                )
                .tags(
                        List.of(
                                new Tag().name("Public APIs"),
                                new Tag().name("UserDTO APIs"),
                                new Tag().name("Journal APIs"),
                                new Tag().name("Admin APIs")
                        )
                )
                .addSecurityItem(
                        new SecurityRequirement().addList("bearerAuth")
                )
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization")
                        )
                );

    }
}
