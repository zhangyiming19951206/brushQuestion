package org.jplus.service;

import org.jplus.pojo.AnswerDO;
import org.jplus.pojo.PaperDO;

import java.util.List;

public interface TopicService {
    List<Integer> generatePaper();

    void insertTestPaper(PaperDO testPaper);

    String getPaper(Integer id);

    String getTopicAnswer(int topicId);

    String getTopicType(int parseInt);

    void insertAnswer(AnswerDO answerDO);
}
