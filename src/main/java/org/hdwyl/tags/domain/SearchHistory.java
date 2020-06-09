package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
public class SearchHistory implements Serializable {

    private static final long serialVersionUID = 7645631189012637732L;

    // 历史记录ID
    private int id;

    // 主题ID
    private int themeId;

    // 查询列
    private String columns;

    // 查询条件
    private String conditions;

    // 排序
    private String sort;

    // 数据量
    private int limit;

    // 查询条件注解
    private String remark;

    // 创建者
    private String createdUser;

    //创建时间
    private Date createdTime;

    private String themeName;

    private String createDate;

    //0:允许删除 1：不允许删除
    private int isDelete;

    //0:允许收藏 1：不允许收藏
    private int isFav;
}
