package com.hackathon.moodBoosterChatBot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hackathon.moodBoosterChatBot.service.MoodBoosterService;

/**
 * Controller for handling chatbot interactions.  
 * Manages chat page rendering and processes user messages.  
 *  
 * - GET /chat: Loads the chat interface.  
 * - POST /chat/send: Processes user input, analyzes sentiment,  
 *   generates a response, and updates the model for view rendering.  
 */

@Controller
@RequestMapping("/chat")
public class MoodBoosterController {

    private final MoodBoosterService moodBoosterService;

    public MoodBoosterController(MoodBoosterService moodBoosterService) {
        this.moodBoosterService = moodBoosterService;
    }

    @GetMapping
    public String chatPage() {
        return "chat";
    }

    @PostMapping("/send")
    public String chat(@RequestParam String message, Model model) {
        String sentiment = moodBoosterService.analyzeSentiment(message);
        String response = moodBoosterService.getAIResponse(message);
        moodBoosterService.saveConversation(message, response, sentiment);

        model.addAttribute("userMessage", message);
        model.addAttribute("botResponse", response);
        model.addAttribute("sentiment", sentiment);

        return "chat";
    }

}
