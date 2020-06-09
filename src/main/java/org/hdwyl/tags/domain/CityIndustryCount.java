package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class CityIndustryCount implements Serializable {

    private String name;

    private String code;

    private long count;

    private String city;

    private String province;

    private String provinceCode;

    private String cityCode;

    private String pname;
}
