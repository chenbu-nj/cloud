package com.example.clienta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="clientb",fallback = FeignServiceFallBack.class)
public interface FeignService {

    @RequestMapping("/getTransId")
    String getTransId();
}
