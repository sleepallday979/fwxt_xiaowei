package com.xxx.server.wb;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author tsd
 * @since 2021-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Menu对象", description="")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "path")
    private String path;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "图标")
    private String iconCls;

    @ApiModelProperty(value = "是否保持激活")
    private String keepAlive;

    @ApiModelProperty(value = "是否要求权限")
    private String requireAuth;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "是否启用")
    private String enabled;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<Menu> children;

}
