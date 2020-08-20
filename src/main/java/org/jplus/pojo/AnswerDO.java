package org.jplus.pojo;

import java.sql.Timestamp;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
public class AnswerDO {
    private Integer aid;
    private Integer id;
    private Integer tid;
    private String type;
    private Integer right_or_wrong;
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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public Integer getRight_or_wrong() {
        return right_or_wrong;
    }

    public void setRight_or_wrong(Integer right_or_wrong) {
        this.right_or_wrong = right_or_wrong;
    }

    private String user_answer;
}
