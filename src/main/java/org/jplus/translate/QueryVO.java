package org.jplus.translate;

/**
 * @author Joker Ye
 * @date 2020/8/20
 */
public class QueryVO {
    private String type;
    private String school;
    private Integer[] tids;
    private String[] user_answer;

    public Integer[] getTids() {
        return tids;
    }

    public void setTids(Integer[] tids) {
        this.tids = tids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(String[] user_answer) {
        this.user_answer = user_answer;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
