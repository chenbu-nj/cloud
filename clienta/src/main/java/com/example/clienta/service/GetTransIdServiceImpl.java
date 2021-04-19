package com.example.clienta.service;

import com.example.clienta.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTransIdServiceImpl implements GetTransIdService {

    @Autowired
    private FeignService feignService;

    @Override
    public String getTransId() {
        return feignService.getTransId();
    }
}
