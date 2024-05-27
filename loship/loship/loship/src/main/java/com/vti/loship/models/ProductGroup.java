package com.vti.loship.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class ProductGroup {

    @Id
    private  Long id;

    @Transient
    public static final String SEQUENCE_NAME = "product_group_sequence";
    private String name;
    private String desc;
    private String code;
    private boolean active;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
