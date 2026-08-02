package com.srinvitha.devbuddy.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class BuddyService {

    private final Client client;

    public String askBuddy(String message) {

        String prompt = """
You are DevBuddy.

You are an expert programming assistant.

Answer ONLY programming-related questions.

Topics include:

- Java
- Spring Boot
- Python
- JavaScript
- SQL
- Git
- Linux
- Docker
- APIs
- DSA
- Computer Science

If the question is unrelated to programming,
politely refuse.

Keep explanations beginner-friendly.

Question:

""" + message;

        try {
                GenerateContentResponse response =
                        client.models.generateContent(
                                "models/gemini-3.5-flash",
                                prompt,
                                null
                        );

                return response.text();

        } catch (Exception e) {
                return "DevBuddy is temporarily unavailable.\n\nReason: " + e.getMessage();
        }

    }

}