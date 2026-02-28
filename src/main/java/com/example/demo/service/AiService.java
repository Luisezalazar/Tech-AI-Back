package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AiRequestDTO;

@Service
public class AiService {

    @Value("${ia.api.key}")
    private String apiKey;

    @Value("${ia.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public AiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getResponse(AiRequestDTO request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-goog-api-key", apiKey);

        //Assemble a request body for gemini
        List<Map<String, Object>> parts = new ArrayList<>();

        //Create the text part
        Map<String, Object> textPart = new HashMap<>();
        textPart.put("text", request.getPrompt());
        parts.add(textPart);

        //Image in request
        if (request.getBase64Image() != null && !request.getBase64Image().isEmpty()) {
            Map<String, Object> inlineData = new HashMap<>();
            inlineData.put("mime_type", request.getMimeType());
            inlineData.put("data", request.getBase64Image());

            Map<String, Object> imagePart = new HashMap<>();
            imagePart.put("inline_data", inlineData);
            parts.add(imagePart);
        }

        //Insert content
        Map<String, Object> content = new HashMap<>();
        content.put("parts", parts);

        //Add final body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("contents", List.of(content));

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        //Call Http
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Error with API: " + e.getMessage());
            throw new RuntimeException("Communication with the API failed");
        }
    }
}
