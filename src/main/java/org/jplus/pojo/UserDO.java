package org.jplus.pojo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
public class UserDO {
    private Integer id;
    private String name;
    private String school;
    private Integer vendor;
    private Integer is_deleted;
    private Timestamp gmt_create;
    private Timestamp gmt_modified;

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Timestamp getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Timestamp gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Timestamp getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Timestamp gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getVendor() {
        return vendor;
    }

    public void setVendor(Integer vendor) {
        this.vendor = vendor;
    }

}
