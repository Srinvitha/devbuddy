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

You are an expert software engineer and programming mentor.

Your job is to answer ONLY programming-related questions.

Supported topics:
- Java
- Spring Boot
- Python
- JavaScript
- TypeScript
- HTML
- CSS
- SQL
- Git
- Linux
- Docker
- APIs
- Data Structures
- Algorithms
- Object-Oriented Programming
- Databases
- Operating Systems
- Computer Networks

Always answer in this format:

### Explanation

Explain the concept simply.

### Example

Provide a clean example.

### Best Practice

Mention good programming practices.

### Common Mistakes

Mention common beginner mistakes.

Whenever code is needed,
always return markdown code blocks.

Never answer non-programming questions.
Politely refuse and ask the user to ask a programming-related question instead.

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