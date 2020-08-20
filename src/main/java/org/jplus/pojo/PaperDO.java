package org.jplus.pojo;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author Joker Ye
 * @date 2020/8/14
 */
public class PaperDO {
    @NotNull
    private Integer pid;

    private Integer uid;
    private String topic_numbers;
    private Integer is_deleted;
    private Timestamp gmt_create;

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

    private Timestamp gmt_modified;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTopic_numbers() {
        return topic_numbers;
    }

    public void setTopic_numbers(String topic_numbers) {
        this.topic_numbers = topic_numbers;
    }
}
