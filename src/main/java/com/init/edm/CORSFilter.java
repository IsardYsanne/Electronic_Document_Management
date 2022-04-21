package com.init.edm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс создания пользовательского фильтра, который будет вставлять заголовок Access-Control-Allow-* в каждый исходящий запрос и включать механизм CORS
 * (совместное использование ресурсов между источниками).
 *
 * @author GKordyukova
 */
@Configuration
public class CORSFilter implements WebMvcConfigurer {

    /**
     * Ссылка на frontend с портом
     */
    private final String URL = "http://192.168.1.41:8080/";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/ecm/document/**").allowedMethods("GET")
                .allowedOrigins(URL);
        registry.addMapping("/ecm/employees/**").allowedMethods("GET", "PUT", "DELETE", "POST")
                .allowedOrigins(URL);
        registry.addMapping("/ecm/post/**").allowedMethods("GET", "PUT", "POST")
                .allowedOrigins(URL);
    }
}