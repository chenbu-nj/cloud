package com.example.clientb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TransIdController {

    @GetMapping(value = "getTransId")
    @ResponseBody
    public String getTransId(){
        return UUID.randomUUID().toString();
    }
}
