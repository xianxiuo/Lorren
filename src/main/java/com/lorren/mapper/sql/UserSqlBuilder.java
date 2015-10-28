package com.lorren.mapper.sql;

import org.apache.ibatis.jdbc.SqlBuilder;

public class UserSqlBuilder {
    
    public String selectAll() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("id, name, email, address, phone, enabled, createtime, updatetime, creator");
        SqlBuilder.FROM("tb_user");
        return SqlBuilder.SQL();
    }
    
    public String selectOneByID() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("id, name, email, address, phone, enabled, createtime, updatetime, creator");
        SqlBuilder.FROM("tb_user");
        SqlBuilder.WHERE("id = #{id}");
        return SqlBuilder.SQL();
    }
    
    public String insert() {
        SqlBuilder.BEGIN();
        SqlBuilder.INSERT_INTO("tb_user");
        SqlBuilder.VALUES("name", "#{name, javaType=String, jdbcType=VARCHAR}");
        SqlBuilder.VALUES("email", "#{email, javaType=String, jdbcType=VARCHAR}");
        SqlBuilder.VALUES("address", "#{address, javaType=String, jdbcType=VARCHAR}");
        SqlBuilder.VALUES("phone", "#{phone, javaType=String, jdbcType=VARCHAR}");
        SqlBuilder.VALUES("enabled", "#{enabled, javaType=Boolean, jdbcType=BOOLEAN}");
        SqlBuilder.VALUES("createtime", "#{createtime, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP}");
        SqlBuilder.VALUES("updatetime", "#{updatetime, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP}");
        SqlBuilder.VALUES("creator", "#{creator, javaType=Long, jdbcType=BIGINT}");
        return SqlBuilder.SQL();
    }

}
