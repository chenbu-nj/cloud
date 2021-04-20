package com.example.clienta.controller;

import com.example.clienta.service.GetTransIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RefreshScope
@RestController
public class RedirectController {

    @Autowired
    private GetTransIdService getTransIdService;

    @Value("${server.port}")
    String port;

    @Value("${test.flag}")
    String flag;

    @GetMapping(value = "straightGetTransId")
    @ResponseBody
    public String straightGetTransId(){
        return "服务A:" + port + "接口：" + UUID.randomUUID().toString() + ",标识：" + flag;
    }

    @GetMapping(value = "redirectGetTransId")
    @ResponseBody
    public String redirectGetTransId(){
        return "服务A调用：" + getTransIdService.getTransId();
    }
}
