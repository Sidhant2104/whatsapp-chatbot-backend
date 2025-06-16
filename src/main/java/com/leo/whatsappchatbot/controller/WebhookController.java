package com.leo.whatsappchatbot.controller;

import com.leo.whatsappchatbot.dto.MessageDTO;
import com.leo.whatsappchatbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody MessageDTO messageDTO) {
        String reply = messageService.processMessage(messageDTO);
        return ResponseEntity.ok(reply);
    }
}
