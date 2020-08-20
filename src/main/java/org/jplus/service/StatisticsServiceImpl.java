package org.jplus.service;

import org.jplus.pojo.UserDO;
import org.jplus.translate.LastRecordingDTO;
import org.jplus.mapper.StatisticsMapper;
import org.jplus.pojo.AnswerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public List<UserDO> getCountSort(String type) {
        return statisticsMapper.getCountSort(type);
    }

    @Override
    public List<UserDO> getCorrectRateSort(String type) {
        return statisticsMapper.getCorrectRateSort(type);
    }

    @Override
    public Integer getUserCountSortBySchool(Integer id, String school, String type) {
        return statisticsMapper.getUserCountSortBySchool(id, school, type);
    }

    @Override
    public Integer getUserCorrectSortBySchool(Integer id, String school, String type) {
        return statisticsMapper.getUserCorrectSortBySchool(id, school, type);
    }

    @Override
    public LastRecordingDTO getLastRecordingById(Integer id) {
        return statisticsMapper.getLastRecordingById(id);
    }

    @Override
    public Integer getLastPaperId(Integer id) {
        return statisticsMapper.getLastPaperId(id);
    }

    @Override
    public List<Integer> getTopicsByPaperId(Integer pid) {
        return statisticsMapper.getTopicsByPaperId(pid);
    }

    @Override
    public AnswerDO getAnswer(Integer id, Integer tid) {
        return statisticsMapper.getAnswer(id, tid);
    }
}
