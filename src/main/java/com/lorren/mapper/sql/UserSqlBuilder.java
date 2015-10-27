package com.lorren.mapper.sql;

import org.apache.ibatis.jdbc.SqlBuilder;

public class UserSqlBuilder {
    
    public String selectAll() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("u.id, u.name, u.email, u.address, u.phone, u.enabled, u.createtime, u.updatetime, u.creator");
        SqlBuilder.FROM("tb_user u");
        return SqlBuilder.SQL();
    }
    
    public String selectOneByID() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("u.id, u.name, u.email, u.address, u.phone, u.enabled, u.createtime, u.updatetime, u.creator");
        SqlBuilder.FROM("tb_user u");
        SqlBuilder.WHERE("u.id = #{id}");
        return SqlBuilder.SQL();
    }
    
    public String insert() {
        SqlBuilder.BEGIN();
        SqlBuilder.INSERT_INTO("tb_user u");
        SqlBuilder.VALUES("id, name, email, address, phone, archived, enabled, createtime, updatetime, creator", "#{id}, #{name}, #{email}, #{address}, #{phone}, #{archived}, #{enabled}, #{createtime}, #{updatetime}, #{creator}");
        return SqlBuilder.SQL();
    }

}
