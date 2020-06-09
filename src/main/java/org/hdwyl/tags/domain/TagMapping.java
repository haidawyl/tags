package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class TagMapping implements Serializable {

    private static final long serialVersionUID = 3028797423971163538L;

    // 标签ID
    private int id;

    // 标签名称
    private String name;

    // 值类型
    private String valueType;

    // 主题ID
    private int themeId;

    // 类型ID
    private int typeId;

    // 定位ID
    private int locationId;
}
