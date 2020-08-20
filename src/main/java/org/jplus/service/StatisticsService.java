package org.jplus.service;

import org.jplus.dto.LastRecordingDTO;
import org.jplus.pojo.AnswerDO;
import org.jplus.pojo.PaperDO;

import java.util.List;

public interface StatisticsService {
    List<Integer> getCountSort(String type);

    List<Integer> getCorrectRateSort(String type);

    Integer getUserCountSortBySchool(Integer id, String school, String type);

    Integer getUserCorrectSortBySchool(Integer id, String school, String type);

    LastRecordingDTO getLastRecordingById(Integer id);

    Integer getLastPaperId(Integer id);

    List<Integer> getTopicsByPaperId(Integer pid);

    AnswerDO getAnswer(Integer id, Integer integer);
}
