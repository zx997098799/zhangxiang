package com.taikang.imageservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan("com.taikang.imageservice")
@MapperScan("com.taikang.imageservice.mapper")
@EnableTransactionManagement
public class ImageserviceApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ImageserviceApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return  applicationBuilder.sources(ImageserviceApplication.class);
    }

}
