package com.hackathon.moodBoosterChatBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.moodBoosterChatBot.models.ChatMessage;

/**
 * Repository interface for managing ChatMessage entities.  
 * Extends JpaRepository to provide CRUD operations for chat messages.  
 */

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Long> {

}
