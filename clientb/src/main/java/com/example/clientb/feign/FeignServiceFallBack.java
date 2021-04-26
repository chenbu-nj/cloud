package com.example.clientb.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallBack implements FeignService{
    @Override
    public String getClientAService() {
        return "client a start fail";
    }
}
