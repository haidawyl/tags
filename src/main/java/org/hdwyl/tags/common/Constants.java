package org.hdwyl.tags.common;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final String DATE_FORMATTER = "yyyy-MM-dd";
    public static final String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    public static final String KEY_LOGIN_USER = "loginUser";

    public static final Map<Integer, Object> DATASOURCE = new HashMap<Integer, Object>();

    public static final Map<String, Object> INDUSTRY = new HashMap<String, Object>();

    public static final String MSG_ERROR_1 = "账号不存在";
    public static final String MSG_ERROR_2 = "密码错误";
    public static final String MSG_ERROR_3 = "账号不能为空";

    // 存储类型
    public enum StorageType {
        SOLR("Solr"), MONGODB("MongoDB"), MYSQL("MySQL"), HBASE("HBase");

        private String name;

        private StorageType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    // 值类型
    public enum ValueType {
        STRING("String"), INTEGER("Integer"), DOUBLE("Double"), DATE("Date"), DICT("Dict");

        private String name;

        private ValueType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    // 状态
    public enum Status {
        INVALID(0), VALID(1);

        private Integer value;

        private Status(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }
    }

    // 是否
    public enum Whether {
        No(0), YES(1);

        private Integer value;

        private Whether(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }
    }
}
