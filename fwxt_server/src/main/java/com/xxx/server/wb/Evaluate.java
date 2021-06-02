package com.xxx.server.wb;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Evaluate对象", description="")
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "工作时间")
    private String time;

    @ApiModelProperty(value = "绩效")
    private String performance;

    @ApiModelProperty(value = "考勤")
    private String attendance;

    @ApiModelProperty(value = "违纪")
    private String mistake;

    @ApiModelProperty(value = "定期评价")
    private String evaluateTime;

    @ApiModelProperty(value = "总评价")
    private String evaluateAll;

    @ApiModelProperty(value = "")
    private String cid;


}
