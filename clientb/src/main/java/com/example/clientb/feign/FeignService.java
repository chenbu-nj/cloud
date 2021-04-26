package com.example.clientb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="clienta",fallback = FeignServiceFallBack.class)
public interface FeignService {

    @RequestMapping("/getClientAService")
    String getClientAService();
}
