package com.gs.subproject.user.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class GetUserAO {

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull
    @Max(value = 100, message = "超出最大限制")
    @Min(value = 1, message = "超出最小限制")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
