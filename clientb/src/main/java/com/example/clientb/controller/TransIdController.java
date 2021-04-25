package com.example.clientb.controller;

import com.example.clientb.Vo.ApiResult;
import com.example.clientb.Vo.ViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RefreshScope
@RestController
@Api(tags = "流水号生成器")//controller在swagger中的中文名称
public class TransIdController {

    @Value("${test.flag}")
    String flag;

    @ApiOperation(value = "获取流水号", httpMethod = "GET")//方法中文名称
    @ApiImplicitParam(name = "name", value = "姓名", dataType = "string")//参数（值-中文名称-数据类型）
    @GetMapping(value = "getTransId")
    @ResponseBody
    public ApiResult getTransId(@RequestParam(value = "name", required = false) String name){
        return ApiResult.success(name + "服务B接口：" + UUID.randomUUID().toString() + "，标识：" + flag);
    }

    @ApiOperation(value = "获取其他业务流水号", httpMethod = "GET")//方法中文名称
    @ApiImplicitParam(name = "name", value = "名称", dataType = "string")//参数（值-中文名称-数据类型）
    @GetMapping(value = "testOther")
    @ResponseBody
    public ViewVo testOther(@RequestParam(value = "name", required = false) String name){
        ViewVo vo = new ViewVo();
        vo.setName(name);
        vo.setTransId(UUID.randomUUID().toString());
        return vo;
    }
}
