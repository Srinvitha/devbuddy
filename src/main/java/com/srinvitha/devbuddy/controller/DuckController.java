package com.srinvitha.devbuddy.controller;

import com.srinvitha.devbuddy.dto.ChatResponse;
import com.srinvitha.devbuddy.dto.DebugRequest;
import com.srinvitha.devbuddy.service.DuckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/duck")
@RequiredArgsConstructor
public class DuckController {

    private final DuckService duckService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody DebugRequest request){

        return new ChatResponse(
                duckService.debug(request.getHistory())
        );

    }

}