package com.srinvitha.devbuddy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DebugRequest {

    private List<ChatMessage> history;

}