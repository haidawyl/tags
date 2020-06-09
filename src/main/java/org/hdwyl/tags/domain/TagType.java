package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class TagType implements Serializable {

    private static final long serialVersionUID = -4796549038882907298L;

    // 类型ID
    private int id;

    // 类型名称
    private String name;
}
