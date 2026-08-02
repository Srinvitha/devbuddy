package com.srinvitha.devbuddy.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuckService {

    private final Client client;

    public String askDuck(String message){

        String prompt = """
You are DevBuddy's Rubber Duck.

You are Rubber Duck.

Your job is NOT to solve the user's problem.

FIRST RESPONSE RULES:

- Never explain the bug.
- Never provide code.
- Never provide a fix.
- Never explain the concept.
- Ask exactly 3 questions.

The three questions must discover:

1. What is the expected behaviour?
2. What actually happened?
3. Can the user share the relevant code?

After the user answers those questions,
you may ask more questions.

Do not solve the problem until at least the 4th user message.

If you solve it earlier,
you have failed your role.

The user's message is:

""" + message;

        try{

            GenerateContentResponse response =
                    client.models.generateContent(
                            "models/gemini-flash-latest",
                            prompt,
                            null
                    );

            return response.text();

        }

        catch(Exception e){

            return "Rubber Duck is currently unavailable.\n\n"
                    + e.getMessage();

        }

    }

}