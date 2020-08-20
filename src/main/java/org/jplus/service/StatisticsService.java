package org.jplus.service;

import org.jplus.pojo.UserDO;
import org.jplus.translate.LastRecordingDTO;
import org.jplus.pojo.AnswerDO;

import java.util.List;

public interface StatisticsService {
    List<UserDO> getCountSort(String type);

    List<UserDO> getCorrectRateSort(String type);

    Integer getUserCountSortBySchool(Integer id, String school, String type);

    Integer getUserCorrectSortBySchool(Integer id, String school, String type);

    LastRecordingDTO getLastRecordingById(Integer id);

    Integer getLastPaperId(Integer id);

    List<Integer> getTopicsByPaperId(Integer pid);

    AnswerDO getAnswer(Integer id, Integer integer);
}
