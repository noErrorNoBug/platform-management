package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 菜单树
 * @date 2022/7/18 09:30
 */
@Getter
@Setter
public class MenuNode extends UmsMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<MenuNode> children;
}
