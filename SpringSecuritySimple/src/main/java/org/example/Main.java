package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    //comment the whole bean to activate form auth or add .formlogin insted of httpBasic
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("hereAAAAAAAAAAAAAAAA");
        return http
                .csrf(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())//Here we specify basic auth!!!(pop up window)
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .build();
    }

}