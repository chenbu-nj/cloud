package com.example.clienta.feign;

import com.example.clienta.Vo.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="clientb",fallback = FeignServiceFallBack.class)
public interface FeignService {

    @RequestMapping("/getTransId")
    ApiResult getTransId(@RequestParam(value = "name", required = false) String name);
}
