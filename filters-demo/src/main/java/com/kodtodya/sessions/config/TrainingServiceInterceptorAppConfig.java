package com.kodtodya.sessions.config;

import com.kodtodya.sessions.interceptor.TrainingServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class TrainingServiceInterceptorAppConfig implements WebMvcConfigurer {
   @Autowired
   TrainingServiceInterceptor trainingServiceInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(trainingServiceInterceptor);
   }

   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/trainings").allowedOrigins("http://localhost:8080");
         }
      };
   }
}