package com.example.customermanager.config;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.ICRUDCore;
import com.example.customermanager.service.impl.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

//annotation @Configuration đánh dấu đây là 1 class dùng để config (cài đặt)
@Configuration
//annotation @EnableWebMvc cho phép sử dụng các annotation khác trong dự án MVC
@EnableWebMvc
//annotations @ComponentScan dùng để quét qua các package, nhằm tìm các Bean
//được định danh bằng các annotation khác, đưa về IoCContainer khởi tạo trước
@ComponentScan("com.example.customermanager")
public class AppConfig implements WebMvcConfigurer {
    //cấu hình Thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

//    @Bean
//    public ICRUDCore<Customer, Long> customerService() {
//        return new CustomerService();
//    }
}
