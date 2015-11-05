package com.lorren.mapper.sql;

import org.apache.ibatis.jdbc.SqlBuilder;

import com.lorren.util.ConstantValue;

public class AccountSqlBuilder {
    
    public String selectAllByUserID() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("id, userid, username, password, token, enabled, createtime, updatetime, creator");
        SqlBuilder.FROM(ConstantValue.TABLE_ACCOUNT);
        SqlBuilder.WHERE("userid = #{userid}");
        return SqlBuilder.SQL();
    }
    
    public String insert() {
        SqlBuilder.BEGIN();
        SqlBuilder.INSERT_INTO(ConstantValue.TABLE_ACCOUNT);
        SqlBuilder.VALUES("userid", "#{userid, javaType=Long, jdbcType=BIGINT}");
        SqlBuilder.VALUES("username", "#{username, javaType=String, jdbcType=VARCHAR}");
        SqlBuilder.VALUES("password", "#{password, javaType=String, jdbcType=VARCHAR}");
        SqlBuilder.VALUES("token", "#{token, javaType=String, jdbcType=CLOB}");
        SqlBuilder.VALUES("enabled", "#{enabled, javaType=Boolean, jdbcType=BOOLEAN}");
        SqlBuilder.VALUES("createtime", "#{createtime, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP}");
        SqlBuilder.VALUES("updatetime", "#{updatetime, javaType=java.sql.Timestamp, jdbcType=TIMESTAMP}");
        SqlBuilder.VALUES("creator", "#{creator, javaType=Long, jdbcType=BIGINT}");
        return SqlBuilder.SQL();
    }

}