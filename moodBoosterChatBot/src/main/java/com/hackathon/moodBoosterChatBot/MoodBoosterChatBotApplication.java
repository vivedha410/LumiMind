package com.hackathon.moodBoosterChatBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main entry point for the Mood Booster ChatBot application.
 * This Spring Boot app powers an AI chatbot for mental health support.  
 * Uses Spring Boot for backend logic and Spring Data JPA for persistence.  
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.hackathon.moodBoosterChatBot")
public class MoodBoosterChatBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodBoosterChatBotApplication.class, args);
	}
}
