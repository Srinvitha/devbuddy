package com.srinvitha.devbuddy.controller;

import com.srinvitha.devbuddy.dto.ChatRequest;
import com.srinvitha.devbuddy.dto.ChatResponse;
import com.srinvitha.devbuddy.service.DuckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/duck")
@RequiredArgsConstructor
public class DuckController {

    private final DuckService duckService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request){

        String reply = duckService.askDuck(request.getMessage());

        return new ChatResponse(reply);

    }

}