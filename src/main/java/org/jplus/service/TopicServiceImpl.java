package org.jplus.service;

import org.jplus.mapper.TopicMapper;
import org.jplus.pojo.AnswerDO;
import org.jplus.pojo.PaperDO;
import org.jplus.pojo.TopicDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<TopicDO> generatePaper() {
        return topicMapper.generatePaper();
    }

    @Override
    public void insertTestPaper(PaperDO testPaper) {
        topicMapper.insertTestPaper(testPaper);
    }

    @Override
    public String getPaper(Integer id) {
        return topicMapper.getPaper(id);
    }

    @Override
    public String getTopicAnswer(int topicId) {
        return topicMapper.getTopicAnswer(topicId);
    }

    @Override
    public String getTopicType(int topicId) {
        return topicMapper.getTopicType(topicId);
    }

    @Override
    public void insertAnswer(AnswerDO answerDO) {
        topicMapper.insertAnswer(answerDO);
    }
}
