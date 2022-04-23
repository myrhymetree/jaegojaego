package com.greedy.jaegojaego.config;

import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ComponentScan(basePackages = "com.greedy.jaegojaego")
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    @Bean
    public ModelAndView mv() {

        return new ModelAndView();
    }

    @Bean
    MappingJackson2JsonView jsonView() {

        return new MappingJackson2JsonView();
    }
}
