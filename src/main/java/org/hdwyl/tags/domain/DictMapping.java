package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class DictMapping implements Serializable {

    private static final long serialVersionUID = 3906557882978742210L;

    // 关键字
    private String keyword;

    // 表名
    private String table;

    // 查询条件
    private String condition;

}
