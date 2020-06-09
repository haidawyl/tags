package org.hdwyl.tags.datasource;

import lombok.Data;

@Data
public class DataSourceConfig {

    protected String host;

    protected int port;

    protected String username;

    protected String password;

    protected String schema;

    public DataSourceConfig(String host, int port, String username, String password, String schema) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.schema = schema;
    }
}
