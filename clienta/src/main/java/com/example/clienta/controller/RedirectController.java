package com.example.clienta.controller;

import com.example.clienta.Vo.ApiResult;
import com.example.clienta.service.GetTransIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RefreshScope
@RestController
@Api(tags = "测试业务")//controller在swagger中的中文名称
public class RedirectController {

    @Autowired
    private GetTransIdService getTransIdService;

    @Value("${server.port}")
    String port;

    @Value("${test.flag}")
    String flag;

    @ApiOperation(value = "直接获取业务流水号", httpMethod = "GET")//方法中文名称
//    @ApiImplicitParam(name = "name", value = "姓名", dataType = "string")//参数（值-中文名称-数据类型）
    @GetMapping(value = "straightGetTransId")
    @ResponseBody
    public String straightGetTransId(){
        return "服务A:" + port + "接口：" + UUID.randomUUID().toString() + ",标识：" + flag;
    }

    @ApiOperation(value = "间接获取业务流水号", httpMethod = "GET")//方法中文名称
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "string"),
            @ApiImplicitParam(name = "msg", value = "要传递的信息", dataType = "string")
    })//参数（值-中文名称-数据类型）
    @GetMapping(value = "redirectGetTransId")
    @ResponseBody
    public String redirectGetTransId(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "msg",required = false) String msg){
        String serialno = "";
        ApiResult apiResult = getTransIdService.getTransId(name);
        if(apiResult != null && apiResult.getStatus() == HttpStatus.SC_OK){
            serialno = String.valueOf(apiResult.getData());
        }
        return "服务A调用：" + serialno + ",传递的信息是：" + msg;
    }

    @ApiOperation(value = "CLIENTSERVICE测试方法", httpMethod = "GET")//方法中文名称
    @GetMapping(value = "getClientAService")
    @ResponseBody
    public String getClientAService(){
        return "端口为" + port + "，返回的结果";
    }
}
