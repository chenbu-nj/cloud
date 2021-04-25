package com.example.clienta.feign;

import com.example.clienta.Vo.ApiResult;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallBack implements FeignService{
    @Override
    public ApiResult getTransId(String name) {
        return ApiResult.error("99999", "client b start fail");
    }
}
