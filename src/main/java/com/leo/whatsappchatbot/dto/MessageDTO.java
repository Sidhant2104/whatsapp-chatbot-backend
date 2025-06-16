package com.leo.whatsappchatbot.dto;

public class MessageDTO {
    private String from;
    private String message;

    // Constructors
    public MessageDTO() {}
    public MessageDTO(String from, String message) {
        this.from = from;
        this.message = message;
    }

    // Getters and Setters
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
