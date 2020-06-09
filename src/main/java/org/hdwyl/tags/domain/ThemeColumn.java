package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class ThemeColumn implements Serializable {

    private static final long serialVersionUID = 5263586394527356176L;

    // 主题ID
    private int themeId;

    // 列名
    private String column;

    // 是否多数据源的关联列（0:否,1:是）
    private int relatedKey;

    // 数据源ID
    private int dsId;

    // 表名
    private String table;

    // 列表头名称
    private String title;

    // 显示宽度
    private int width;

    // 是否隐藏（0:否;1:是）
    private int visible;

    // 默认是否显示（0:否;1:是）
    private int defaultDisplay;

    // 排序
    private int sort;

    // 状态（0:废弃;1:在用）
    private int status;

}
