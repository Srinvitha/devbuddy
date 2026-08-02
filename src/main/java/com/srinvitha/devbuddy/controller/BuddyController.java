package com.srinvitha.devbuddy.controller;

import com.srinvitha.devbuddy.dto.ChatRequest;
import com.srinvitha.devbuddy.dto.ChatResponse;
import com.srinvitha.devbuddy.service.BuddyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buddy")
@RequiredArgsConstructor
public class BuddyController {

    private final BuddyService buddyService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request){

        String reply = buddyService.askBuddy(request.getMessage());

        return new ChatResponse(reply);

    }

}