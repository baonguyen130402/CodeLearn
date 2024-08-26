package com.env.gs.configuration.Jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.http.WebSocket;
@Configuration
public class WebSecurityConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://usstudy-be:8080"
                        , "https://usstudy.monoinfinity.net/swagger-ui/index.html"
                        , "http://localhost:3000"
                        , "http://localhost:8080"
                        , "https://usstudy.monoinfinity.net"
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .maxAge(-1);
    }
}
