package com.lorren.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "account")
public class Account extends Base {

    @XmlElement(name = "userid")
    private Long userid;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "token")
    private String token;
    @XmlElement(name = "enabled")
    private Boolean enabled;
    
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
