package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
public class DictIndustry implements Serializable {

    private static final long serialVersionUID = 8331911241520860887L;

    //
    private int cCorp;

    //
    private String trid;

    //
    private String type0;

    //
    private String type1;

    //
    private String type2;

    //
    private String type3;

    //
    private String name;

    //
    private String tren;

    //
    private Date moditime;

    //
    private String remark;

    //
    private int lev;

    //
    private String pid;

    private String value;
    private String text;

    private String pvalue;
    private String ptext;
}
