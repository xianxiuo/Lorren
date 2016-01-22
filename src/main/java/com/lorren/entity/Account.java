package com.lorren.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable {

    private static final long serialVersionUID = -4892498096183992787L;
    
    protected Long id;
    protected Timestamp createtime;
    protected Timestamp updatetime;
    protected Long creator;
    private Long userid;
    private String username;
    private String password;
    private String token;
    private Boolean enabled;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Timestamp getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
    public Timestamp getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
    public Long getCreator() {
        return creator;
    }
    public void setCreator(Long creator) {
        this.creator = creator;
    }
    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Account [userid=");
        builder.append(userid);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", token=");
        builder.append(token);
        builder.append(", enabled=");
        builder.append(enabled);
        builder.append(", id=");
        builder.append(id);
        builder.append(", createtime=");
        builder.append(createtime);
        builder.append(", updatetime=");
        builder.append(updatetime);
        builder.append(", creator=");
        builder.append(creator);
        builder.append("]");
        return builder.toString();
    }

}
