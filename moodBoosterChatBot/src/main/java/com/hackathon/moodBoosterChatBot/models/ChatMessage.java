package com.hackathon.moodBoosterChatBot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing a chat message in the database.  
 * Stores the user's message, AI-generated response, and sentiment analysis result.  
 *  
 * - id: Unique identifier (auto-generated).  
 * - userMessage: The message sent by the user.  
 * - botResponse: The chatbot's reply (stored as LONGTEXT).  
 * - sentiment: The analyzed sentiment of the user's message.  
 */

@Entity
@Table(name = "chat_messages")
public class ChatMessage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userMessage;
    @Column(columnDefinition = "LONGTEXT")
    private String botResponse;
    private String sentiment;
    
    
	public ChatMessage(String userMessage, String botResponse, String sentiment) {
		this.userMessage = userMessage;
		this.botResponse = botResponse;
		this.sentiment = sentiment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getBotResponse() {
		return botResponse;
	}
	public void setBotResponse(String botResponse) {
		this.botResponse = botResponse;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

}

