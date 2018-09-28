package com.gs.subproject.user.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel
public class UserListAO {

    @ApiModelProperty(value = "页码", required = true)
    @NotNull
    private Integer page;

    @ApiModelProperty(value = "限制大小", required = true)
    @NotNull
    private Integer limit;

    @ApiModelProperty(value = "文本", required = false)
    private String text;

    @ApiModelProperty(value = "时间 格式yyyy-MM-dd HH:mm:ss", required = false)
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
