package com.lorren.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 8911644044381638640L;
    
    @XmlAttribute(name = "id")
    protected Long id;
    @XmlElement(name = "createtime")
    protected Timestamp createtime;
    @XmlElement(name = "updatetime")
    protected Timestamp updatetime;
    @XmlElement(name = "creator")
    protected Long creator;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "phone")
    private String phone;
    @XmlElement(name = "enabled")
    private Boolean enabled;
    @XmlElementRef(type = Account.class, name = "accounts")
    private List<Account> accounts = new ArrayList<>();
    
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [name=");
        builder.append(name);
        builder.append(", email=");
        builder.append(email);
        builder.append(", address=");
        builder.append(address);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", enabled=");
        builder.append(enabled);
        builder.append(", accounts=");
        builder.append(accounts);
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
