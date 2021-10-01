package com.example.demo.config;

import java.util.Arrays;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
	}

	@Bean
    public DozerBeanMapper dozerMapper() {
        final DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(Arrays.asList("dozer-custom-converters.xml"));
        return dozerBeanMapper;
    }


}
