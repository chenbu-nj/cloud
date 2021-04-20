package com.example.clientb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RefreshScope
@RestController
public class TransIdController {

    @Value("${test.flag}")
    String flag;

    @GetMapping(value = "getTransId")
    @ResponseBody
    public String getTransId(){
        return "服务B接口：" + UUID.randomUUID().toString() + "，标识：" + flag;
    }
}
