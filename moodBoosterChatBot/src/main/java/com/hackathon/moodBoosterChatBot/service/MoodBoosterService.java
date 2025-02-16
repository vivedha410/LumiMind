package com.hackathon.moodBoosterChatBot.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.moodBoosterChatBot.models.ChatMessage;
import com.hackathon.moodBoosterChatBot.repository.ChatRepository;

/**
 * Service handling chatbot logic, including sentiment analysis,  
 * AI response generation, and conversation persistence.  
 *  
 * - analyzeSentiment(): Determines sentiment (positive, negative, neutral).  
 * - getAIResponse(): Sends user message to an AI API and retrieves a response.  
 * - saveConversation(): Saves chat history to the database.  
 */

@Service
public class MoodBoosterService {

	private final ChatRepository chatRepository;
	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	public MoodBoosterService(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
		this.restTemplate = new RestTemplate();
		this.objectMapper = new ObjectMapper();
	}

	public String analyzeSentiment(String userMessage) {
		if (userMessage.toLowerCase().contains("sad") || userMessage.toLowerCase().contains("depressed")) {
			return "negative";
		} else if (userMessage.toLowerCase().contains("happy") || userMessage.toLowerCase().contains("excited")) {
			return "positive";
		}
		return "neutral";
	}

	public String getAIResponse(String userMessage) {
		try {
			String url = "http://localhost:11434/api/generate";

			// Improved request body to ensure longer and better responses
			Map<String, Object> requestBody = new HashMap<>();
			requestBody.put("model", "mistral"); // You can change to a different model if needed
			requestBody.put("prompt", userMessage);
			requestBody.put("max_tokens", 50); // Ensure paragraph response
			requestBody.put("temperature", 0.5); // Adjust randomness for diverse responses
			requestBody.put("stream", false); // Ensure full response at once

			String jsonRequestBody = objectMapper.writeValueAsString(requestBody);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(jsonRequestBody, headers);

			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
	            JsonNode jsonResponse = objectMapper.readTree(response.getBody());
	            return jsonResponse.has("response") ? jsonResponse.get("response").asText() : "No response received.";
	        }
	        return "Unexpected response from AI.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Sorry, I couldn't process that request.";
		}
	}

	@Transactional
	public void saveConversation(String userMessage, String botResponse, String sentiment) {
		ChatMessage conversation = new ChatMessage(userMessage, botResponse, sentiment);
		chatRepository.save(conversation);
	}

}
