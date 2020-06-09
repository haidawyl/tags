package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class TagLocation implements Serializable {

    private static final long serialVersionUID = 2445487160249961175L;

    // 定位ID
    private int id;

    // 数据源ID
    private int dsId;

    // 表名
    private String table;

    // 列名
    private String column;

}
