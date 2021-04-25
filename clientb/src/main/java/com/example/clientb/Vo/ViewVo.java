package com.example.clientb.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("展示类")
@Data
public class ViewVo {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "其他业务流水号")
    private String transId;
}
