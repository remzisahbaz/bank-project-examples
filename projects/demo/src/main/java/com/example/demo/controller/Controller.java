package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;

@RequestMapping("/")
@RestController
@RequestScope
public class Controller {
    @GetMapping
    public String index(){

        return "Merhaba remzi! PostgreSQL bağlantısı başarılı" +
                "\n\n.properties------\n" +
                "spring.jpa.hibernate.ddl-auto=update\n" +
                "spring.datasource.url=jdbc:postgresql://localhost:5432/userdatabase\n" +
                "spring.datasource.username = postgres\n" +
                "spring.datasource.password =password\n" +
                "spring.jpa.show-sql=true\n" +
                "spring.jpa.generate-ddl=true\n" +
                "spring.jpa.properties.hibernate.format_sql=true\n" +
                "spring.jpa.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect\n" +
                "spring.datasource.driver-class-name=org.postgresql.Driver\n" +
                "\n" +
                "\n";
    }
}
