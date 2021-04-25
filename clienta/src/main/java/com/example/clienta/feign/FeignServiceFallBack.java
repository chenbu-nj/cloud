package com.example.clienta.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallBack implements FeignService{
    @Override
    public String getTransId() {
        return "client b start fail";
    }
}
