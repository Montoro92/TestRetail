package com.example.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config for Open Api.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Configure open api and swagger.
     *
     * @return open api conf
     */
    @Bean
    public OpenAPI openApi(@Value("${app.swagger.server.url}") String urlServer) {
        OpenAPI api = new OpenAPI();
        Info info = new Info();
        info.setTitle("Test proyect");
        info.setDescription("Technical test");
        api.addServersItem(new Server().url(urlServer));
        api.setInfo(info);
        return api;
    }

}
