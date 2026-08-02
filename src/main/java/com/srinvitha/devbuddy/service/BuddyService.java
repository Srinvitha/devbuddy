package com.srinvitha.devbuddy.service;

import org.springframework.stereotype.Service;

@Service
public class BuddyService {

    public String askBuddy(String message){

        return "Buddy received: " + message;

    }

}