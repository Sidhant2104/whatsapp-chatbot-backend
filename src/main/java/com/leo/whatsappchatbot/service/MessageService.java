package com.leo.whatsappchatbot.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.leo.whatsappchatbot.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {
    public String processMessage(MessageDTO messageDTO) {

        Firestore firestore = FirestoreClient.getFirestore();
        Map<String, Object> data = new HashMap<>();
        data.put("from", messageDTO.getFrom());
        data.put("message", messageDTO.getMessage());
        data.put("timestamp", System.currentTimeMillis());

        try {
            firestore.collection("messages").add(data);
        } catch (Exception e) {
            e.printStackTrace();
            return " Failed to save message.";
        }

        String msg = messageDTO.getMessage().toLowerCase().trim();

        switch (msg) {
            case "/hi", "hi" -> {
                return """
                        👋 Hey there! I'm your assistant bot.
                         Here's what I can help you with:
                         /hi - Greet me
                         /help - Show available commands
                         /about - Learn about me
                         /time - Get current time
                        """;
            }

            case "/help", "help" -> {
                return """
                        🧠 You're already in the help zone! Here are your commands:
                        /hi - Say hello to me
                        /help - See this list again
                        /about - Know who I am
                        /time - Check the current time
                        """;
            }

            case "/about", "about" -> {
                return "Hi, I’m Leo — your virtual assistant \uD83E\uDD16\n" +
                        "I’m a backend chatbot built using Java and Spring Boot, designed to help you with common queries and tasks through WhatsApp.\n" +
                        "Type /help to see what I can do for you.";
            }

            case "/time", "time" -> {
                return "\uD83D\uDD70\uFE0F Current server time: " + java.time.LocalTime.now().withNano(0);
            }

            case "" -> {
                return "⚠️ You sent a blank message. Please type something like /help or /hi.";
            }

            default -> {
                return "😕 I'm not sure how to respond to that. Type /help to see what I can do.";
            }
        }

    }
}
