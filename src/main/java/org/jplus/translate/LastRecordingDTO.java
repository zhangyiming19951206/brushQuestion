package org.jplus.translate;

import org.jplus.pojo.AnswerDO;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
public class LastRecordingDTO {
    private Integer pid;
    private AnswerDO answerDO;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public AnswerDO getAnswerDO() {
        return answerDO;
    }

    public void setAnswerDO(AnswerDO answerDO) {
        this.answerDO = answerDO;
    }
}
