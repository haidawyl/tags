package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class DictCommon implements Serializable {

    private static final long serialVersionUID = -6175783192171131672L;

    // ID
    private int id;

    // 所属类型
    private String category;

    // 字典编码
    private int code;

    // 字典名称
    private String name;

    // 状态（0:废弃;1:在用）
    private int status;

    private String value;
    private String text;
}
