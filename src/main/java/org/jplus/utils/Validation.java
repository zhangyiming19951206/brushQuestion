package org.jplus.utils;

/**
 * @author Joker Ye
 * @date 2020/8/20
 */
public class Validation {

    public static boolean validateQuestionType(String type) {
        if (type == null || type.length() == 0) {
            return false;
        }
        switch (type) {
            case "选择题" :
            case "填空题":
                return true;
            default:return false;
        }
    }
}
