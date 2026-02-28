package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AiRequestDTO;
import com.example.demo.service.AiService;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins="http://localhost:5173")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateResponse(@RequestBody AiRequestDTO request) {
        try {
            String responseAi = aiService.getResponse(request);
            return ResponseEntity.ok(responseAi);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request with AI");
        }
    }
}
