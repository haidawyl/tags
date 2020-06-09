package org.hdwyl.tags.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class DataSource implements Serializable {

    private static final long serialVersionUID = -3383223428399509273L;

    // 数据源ID
    private int id;

    // 存储类型
    private String storageType;

    // 主机或IP
    private String host;

    // 端口号
    private int port;

    // 用户名
    private String username;

    // 密码
    private String password;

    // Schema名称
    private String schema;

}
