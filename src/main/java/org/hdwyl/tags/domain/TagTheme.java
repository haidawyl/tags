package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class TagTheme implements Serializable {

    private static final long serialVersionUID = -1210906700554777119L;

    // 主题ID
    private int id;

    // 主题名称
    private String name;

    // 主题类型
    private String type;
}
