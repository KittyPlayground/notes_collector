package org.example.notescollector.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.example.notescollector")
@EnableWebMvc
@MultipartConfig(
    fileSizeThreshold =  1024 * 1024 * 2, //
    maxFileSize = 1024 * 1024 * 5, // 10 MB bytes chunks
    maxRequestSize = 1024 * 1024 * 10 // 100 MB
)
public class WebAppConfig {
}
