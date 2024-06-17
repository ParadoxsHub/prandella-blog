package com.github.paradoxshub.prandellablog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.github.paradoxshub.prandellablog", annotationClass = Mapper.class)
public class PrandellaBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrandellaBlogApplication.class, args);
    }

}
