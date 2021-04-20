package com.example.clienta.controller;

import com.example.clienta.service.GetTransIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RedirectController {

    @Autowired
    private GetTransIdService getTransIdService;

    @GetMapping(value = "straightGetTransId")
    @ResponseBody
    public String straightGetTransId(){
        return "服务A接口：" + UUID.randomUUID().toString();
    }

    @GetMapping(value = "redirectGetTransId")
    @ResponseBody
    public String redirectGetTransId(){
        return "服务A调用：" + getTransIdService.getTransId();
    }
}