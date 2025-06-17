package com.leo.whatsappchatbot.controller;

import com.leo.whatsappchatbot.dto.MessageDTO;
import com.leo.whatsappchatbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
                                                @RequestParam("hub.verify_token") String token,
                                                @RequestParam("hub.challenge") String challenge) {
        if ("subscribe".equals(mode) && "salvatoken012".equals(token)) {
            return ResponseEntity.ok(challenge);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Verification failed");
        }
    }

}
