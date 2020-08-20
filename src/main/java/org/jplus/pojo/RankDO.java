package org.jplus.pojo;

import java.sql.Timestamp;

/**
 * @author Joker Ye
 * @date 2020/8/17
 */
public class RankDO {
    private Integer rid;
    private Integer userid;
    private String type;
    private String school;
    private Integer count;
    private Integer correct;
    private Integer is_deleted;
    private Timestamp gmt_create;
    private Timestamp gmt_modified;

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
