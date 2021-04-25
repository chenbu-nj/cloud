package com.example.clienta.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("响应类")
@Data
public class ApiResult<T> {
	@ApiModelProperty(value = "通讯标识")
	private int status = 200;
	@ApiModelProperty(value = "通讯返回信息")
	private String message = "通讯成功";
	@ApiModelProperty(value = "业务标识")
	private String code = "0000";
	@ApiModelProperty(value = "业务返回信息")
	private String codeMsg;// 业务返回信息
	@ApiModelProperty(value = "返回数据")
	private T data;

	public ApiResult() {
	}

	// 成功无返回数据
	public static ApiResult success() {
		ApiResult apiResult = new ApiResult();
		apiResult.setStatus(200);
		apiResult.setMessage("通讯成功");
		apiResult.setCode("0000");
		apiResult.setCodeMsg("交易成功");
		return apiResult;
	}

	// 成功有返回数据
	public static <T> ApiResult success(T data) {
		ApiResult apiResult = new ApiResult();
		apiResult.setStatus(200);
		apiResult.setMessage("通讯成功");
		apiResult.setCode("0000");
		apiResult.setCodeMsg("交易成功");
		apiResult.setData(data);
		return apiResult;
	}

	// 失败返回code码和错误提示
	public static ApiResult error(String code, String codeMsg) {
		ApiResult apiResult = new ApiResult();
		apiResult.setStatus(200);
		apiResult.setMessage("通讯成功");
		apiResult.setCode(code);
		apiResult.setCodeMsg(codeMsg);
		return apiResult;
	}

}
