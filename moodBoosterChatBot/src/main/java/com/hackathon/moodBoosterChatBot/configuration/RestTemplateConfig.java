package com.hackathon.moodBoosterChatBot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for RestTemplate bean.  
 * Sets up a RestTemplate with custom connection and read timeouts  
 * (3s for connection, 5s for reading response).  
 */ 
@Configuration
public class RestTemplateConfig {
	@Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000); // 3 sec connection timeout
        factory.setReadTimeout(5000); // 5 sec read timeout
        return new RestTemplate(factory);
    }
}
