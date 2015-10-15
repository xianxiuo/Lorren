package com.lorren.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class UserVO implements Serializable {

    private static final long serialVersionUID = -5292152017366715375L;
    
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public JSONObject toJSON() {
        JSONObject userJSONObject = new JSONObject();
        userJSONObject.put("id", id);
        userJSONObject.put("name", name);
        return userJSONObject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserVO [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

}
