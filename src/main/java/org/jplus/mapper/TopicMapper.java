package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.AnswerDO;
import org.jplus.pojo.PaperDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicMapper {
    List<Integer> generatePaper();

    void insertTestPaper(PaperDO testPaper);

    String getPaper(@Param("id") Integer id);

    String getTopicAnswer(@Param("topicId") int topicId);

    String getTopicType(int topicId);

    void insertAnswer(AnswerDO answerDO);
}
