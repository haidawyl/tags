package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class DictArea implements Serializable {

    private static final long serialVersionUID = -1297633397154473569L;

    // 区域代码
    private String areaCode;

    // 区域名称
    private String areaName;

    // 父区域代码
    private String parent;

    // 区域简称
    private String shortName;

    // 经度
    private float longitude;

    // 纬度
    private float latitude;

    // 是否是计划单列市
    private boolean isCsdip;

    // 等级
    private int level;

    // 排序
    private int sort;

    //
    private int isLeaf;

    //
    private int isEnabled;

    //
    private int isValid;

    private String value;
    private String text;
}
