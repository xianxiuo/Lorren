package com.lorren.entity;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Base {
    
    @XmlAttribute(name = "id")
    protected Long id;
    @XmlElement(name = "createtime")
    protected Timestamp createtime;
    @XmlElement(name = "updatetime")
    protected Timestamp updatetime;
    @XmlElement(name = "creator")
    protected Long creator;
    
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

}
