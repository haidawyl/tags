package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
public class Favorites implements Serializable {

    private String username;

    private int favId;

    private int category;

    private String title;

    private Date createdTime;

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

    private String themeName;

    private String createDate;

    private String favCreateDate;

}
