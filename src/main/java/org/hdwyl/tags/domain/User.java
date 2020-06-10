package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String email;

    // 激活状态 0 未激活 1 已激活
    private Integer activeStatus;

    // 激活码
    private String activeCode;

    // 角色
    private String roles;

}
