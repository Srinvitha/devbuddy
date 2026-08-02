package com.srinvitha.devbuddy.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.srinvitha.devbuddy.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuckService {

    private final Client client;

    public String debug(List<ChatMessage> history){

        if(history==null || history.size()==1){

            return """
Let's debug this together.

Before we jump to conclusions, I'd like to understand the problem.

1. What were you expecting?

2. What actually happened?

3. Can you paste the relevant code?

We'll solve it step by step instead of immediately jumping to the answer.
""";

        }

        StringBuilder conversation=new StringBuilder();

        for(ChatMessage message:history){

            conversation
                    .append(message.getRole())
                    .append(": ")
                    .append(message.getMessage())
                    .append("\n\n");

        }

        String prompt="""
You are Rubber Duck.

You are NOT a coding assistant.

You are a debugging mentor.

Continue this debugging conversation.

Rules:

1. Never immediately solve the bug.

2. Never dump the complete code.

3. Ask ONE logical debugging question.

4. Guide the user.

5. Help them discover the solution.

Conversation:

"""
                +conversation;

        try{

            GenerateContentResponse response=
                    client.models.generateContent(
                            "models/gemini-flash-latest",
                            prompt,
                            null
                    );

            return response.text();

        }

        catch(Exception e){

            return "Rubber Duck is unavailable.\n\n"+e.getMessage();

        }

    }

}